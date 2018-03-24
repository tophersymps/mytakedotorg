/*
 * MyTake.org
 *
 *  Copyright 2017 by its authors.
 *  Some rights reserved. See LICENSE, https://github.com/mytakedotorg/mytakedotorg/graphs/contributors
 */
package org.mytake.foundation.transcript;

import com.diffplug.common.base.Preconditions;
import com.diffplug.common.collect.ImmutableSet;
import com.diffplug.common.collect.SetMultimap;
import com.diffplug.common.collect.TreeMultimap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java2ts.Foundation;
import org.mytake.foundation.JsonMisc;

/**
 * A folder of transcript data. `all_people.ini` is a list of every
 * person in every transcript, and `all_roles.ini` is a list of every role.
 * 
 * When loading a video, the first file loaded is `name.json`.  The people
 * and roles in that json file are checked against `all_people.ini` and
 * `all_roles.ini`. Next, `name.said` is loaded, which checks that every
 * person named in the transcript is listed in the json file.
 */
public class TranscriptFolder {
	private final File root;
	private final Set<String> people;
	private final Set<String> roles;

	public TranscriptFolder(File root) throws IOException {
		this.root = Objects.requireNonNull(root);
		this.people = SetIni.parse(new File(root, "all_people.ini"));
		this.roles = SetIni.parse(new File(root, "all_roles.ini"));
	}

	public static final ImmutableSet<String> VIDEO_EXTENSIONS = ImmutableSet.of("json", "said", "vtt");

	private SetMultimap<String, String> possibleTitles() {
		SetMultimap<String, String> map = TreeMultimap.create();
		for (File file : root.listFiles()) {
			String fileName = file.getName();
			int dot = fileName.lastIndexOf('.');
			if (dot != -1) {
				String name = fileName.substring(0, dot);
				String ext = fileName.substring(dot + 1);
				if (VIDEO_EXTENSIONS.contains(ext)) {
					map.put(name, ext);
				}
			}
		}
		return map;
	}

	/** Has all the files needed for syncing. */
	public List<String> transcripts() {
		SetMultimap<String, String> map = possibleTitles();
		List<String> result = new ArrayList<>(map.size());
		for (Map.Entry<String, Collection<String>> entry : map.asMap().entrySet()) {
			if (entry.getValue().containsAll(VIDEO_EXTENSIONS)) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

	/** Has some of the files needed for syncing, but others are missing. */
	public List<String> incompleteTranscripts() {
		SetMultimap<String, String> map = possibleTitles();
		List<String> result = new ArrayList<>(map.size());
		for (Map.Entry<String, Collection<String>> entry : map.asMap().entrySet()) {
			if (!entry.getValue().containsAll(VIDEO_EXTENSIONS)) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

	/** Loads the given transcript. */
	public TranscriptMatch loadTranscript(String name) throws IOException {
		// load and validate the json speakers
		Foundation.VideoFactMeta meta = JsonMisc.fromJson(fileMeta(name), Foundation.VideoFactMeta.class);
		for (Foundation.Speaker speaker : meta.speakers) {
			Preconditions.checkArgument(people.contains(speaker.fullName), "Unknown person: %s", speaker.fullName);
			Preconditions.checkArgument(roles.contains(speaker.role), "Unknown role: %s", speaker.role);
		}
		// load the transcripts
		SaidTranscript said = SaidTranscript.parse(meta, fileSaid(name));
		VttTranscript vtt = VttTranscript.parse(fileVtt(name));
		return new TranscriptMatch(meta, said, vtt);
	}

	File fileMeta(String name) {
		return new File(root, name + ".json");
	}

	File fileSaid(String name) {
		return new File(root, name + ".said");
	}

	File fileVtt(String name) {
		return new File(root, name + ".vtt");
	}
}