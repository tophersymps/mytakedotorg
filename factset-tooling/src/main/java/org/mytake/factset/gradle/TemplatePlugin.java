/*
 * MyTake.org website and tooling.
 * Copyright (C) 2020 MyTake.org, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Additional permission under GNU GPL version 3 section 7
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Eclipse SWT (or a modified version of that library), containing parts
 * covered by the terms of the Eclipse Public License, the licensors of this Program
 * grant you additional permission to convey the resulting work.
 * {Corresponding Source for a non-source form of such a combination shall include the
 * source code for the parts of Eclipse SWT used as well as that of the covered work.}
 *
 * You can contact us at team@mytake.org
 */
package org.mytake.factset.gradle;


import com.diffplug.common.base.Errors;
import com.diffplug.common.base.StringPrinter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.gradle.api.GradleException;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.tasks.TaskProvider;

class TemplatePlugin {
	static final String TASK_APPLY = "templateApply";
	static final String TASK_CHECK = "templateCheck";

	Map<String, List<String>> mustContain = new HashMap<>();

	TemplatePlugin() {}

	public void mustContain(String path, String... toContain) {
		mustContain.put(path, Arrays.asList(toContain));
	}

	public void createTasks(Project project) {
		TaskProvider<?> templateCheck = project.getTasks().register(TASK_CHECK);
		templateCheck.configure(task -> {
			task.setGroup("Build Setup");
			task.setDescription("Ensures that the MyTake.org factset template is properly configured");
			Path rootDir = project.getProjectDir().toPath();
			task.doLast(unused -> check(rootDir));
		});
		project.getTasks().named(JavaBasePlugin.CHECK_TASK_NAME).configure(check -> {
			check.dependsOn(templateCheck);
		});

		project.getTasks().register(TASK_APPLY).configure(task -> {
			task.setGroup("Verification");
			task.setDescription("Initializes the MyTake.org factset template");
			Path rootDir = project.getProjectDir().toPath();
			task.doLast(unused -> apply(rootDir));
		});
	}

	public void check(Path rootDir) {
		for (String p : mustContain.keySet()) {
			Path path = rootDir.resolve(p);
			if (!Files.exists(path)) {
				throw new GradleException("'" + p + "' does not exist, run `" + TASK_APPLY + "` to create it.");
			}
			String content = Errors.rethrow().get(() -> new String(Files.readAllBytes(path), StandardCharsets.UTF_8));
			for (String value : mustContain.get(p)) {
				if (!content.contains(value)) {
					String bar = "+------------------------------\n";
					throw new GradleException("You must add the following to " + p + "\n\n"
							+ bar
							+ Arrays.stream(value.split("\n")).map(str -> "|" + str + "\n").collect(Collectors.joining())
							+ bar);
				}
			}
		}
	}

	private void apply(Path rootDir) {
		for (String p : mustContain.keySet()) {
			Path path = rootDir.resolve(p);
			if (!Files.exists(path)) {
				String content = mustContain.get(p).stream().collect(Collectors.joining("\n")) + "\n";
				Errors.rethrow().run(() -> Files.write(path, content.getBytes(StandardCharsets.UTF_8)));
			}
		}
	}

	static TemplatePlugin forFactset() {
		TemplatePlugin template = new TemplatePlugin();
		template.mustContain(".gitignore",
				".gradle/",
				".DS_Store");
		template.mustContain(".gitattributes",
				"* text eol=lf",
				"*.jar binary");
		template.mustContain(".editorconfig",
				"root = true",
				"end_of_line = lf",
				"insert_final_newline = true",
				"trim_trailing_whitespace = true",
				"charset = utf-8",
				"indent_style = space",
				"indent_size = 2");
		template.mustContain("gradle.properties",
				"org.gradle.caching=true");
		template.mustContain("README.md",
				INCLUSION_CRITERIA,
				NOTES,
				CHANGELOG_HEADER,
				ACKNOWLEDGEMENTS);
		return template;
	}

	private static final String INCLUSION_CRITERIA = "## Inclusion criteria";
	private static final String NOTES = "## Notes";
	private static final String ACKNOWLEDGEMENTS = "<!-- END CHANGELOG -->\n\n# Acknowledgements";
	private static final String CHANGELOG_HEADER = StringPrinter.buildStringFromLines(
			"# Changelog",
			"All changes to this factset are categorized as either:",
			"",
			"- Minor correction: corrected typo in blah",
			"- " + FactsetPlugin.NEW_EVENT + ": a new event took place on date blah",
			"- " + FactsetPlugin.RETRACTION + ": we have removed blah, we made a mistake about blah",
			"- " + FactsetPlugin.INCLUSION_CRITERIA_CHANGE + ": we made the following change to the inclusion criteria",
			"  - ~~removed this~~ this part is the same **this part was added**",
			"  - here is why we made this change",
			"Version number is \"**retractions + inclusion criteria changes**.*new events*.minor corrections\"",
			"",
			"## [Unreleased]");
}
