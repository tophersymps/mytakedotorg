/*
 * MyTake.org
 *
 *  Copyright 2017 by its authors.
 *  Some rights reserved. See LICENSE, https://github.com/mytakedotorg/mytakedotorg/graphs/contributors
 */
package org.mytake.foundation.transcript;

import com.diffplug.common.collect.ImmutableMap;
import com.google.auto.value.AutoValue;
import java.util.Objects;
import java.util.function.Consumer;

@AutoValue
public abstract class Speaker {
	public abstract String name();

	public abstract boolean isPolitician();

	public static Speaker candidate(String name) {
		return new AutoValue_Speaker(name, true);
	}

	public static Speaker moderator(String name, String position) {
		return new AutoValue_Speaker(name, false);
	}

	public static Speaker audience(String name) {
		return new AutoValue_Speaker(name, false);
	}

	private static final ImmutableMap<String, Speaker> speakers;

	static {
		ImmutableMap.Builder<String, Speaker> builder = ImmutableMap.builder();
		Consumer<Speaker> add = speaker -> {
			builder.put(speaker.name(), speaker);
		};
		// unnamed announcer
		add.accept(Speaker.moderator("Announcer", "Unknown offscreen announcer"));
		//// 1960
		add.accept(Speaker.candidate("John F Kennedy"));
		add.accept(Speaker.candidate("Richard M Nixon"));
		// 1960-09-26
		add.accept(Speaker.moderator("Howard K Smith", "CBS"));
		add.accept(Speaker.moderator("Sander Vanocur", "NBC"));
		add.accept(Speaker.moderator("Charles Warren", ""));
		add.accept(Speaker.moderator("Bob H Fleming", ""));
		add.accept(Speaker.moderator("Stuart Novins", ""));
		//// 1976
		add.accept(Speaker.candidate("Jimmy E Carter"));
		add.accept(Speaker.candidate("Gerald R Ford"));
		// 1976-10-06
		add.accept(Speaker.moderator("Pauline Frederick", "NPR"));
		add.accept(Speaker.moderator("Max Frankel", "associate editor of the New York Times"));
		add.accept(Speaker.moderator("Henry L Trewhitt", "diplomatic correspondent of the Baltimore Sun"));
		add.accept(Speaker.moderator("Richard Valeriani", "diplomatic correspondent of NBC News"));
		//// 2016
		add.accept(Speaker.candidate("Hillary R Clinton"));
		add.accept(Speaker.candidate("Donald J Trump"));
		// 2016-10-09
		add.accept(Speaker.moderator("Anderson H Cooper", "CNN"));
		add.accept(Speaker.moderator("Martha Raddatz", "ABC"));
		add.accept(Speaker.audience("Patrice Brock"));
		add.accept(Speaker.audience("Ken Karpowicz"));
		add.accept(Speaker.audience("Gorbah Hamed"));
		add.accept(Speaker.audience("James Carter"));
		add.accept(Speaker.audience("Karl Becker"));
		add.accept(Speaker.audience("Ken Bone"));
		add.accept(Speaker.audience("Spencer Moss"));
		add.accept(Speaker.audience("Beth Miller"));
		// that's all we got for now!
		speakers = builder.build();
	}

	public static Speaker forName(String name) {
		return Objects.requireNonNull(speakers.get(name), "No such name " + name);
	}
}
