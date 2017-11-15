/*
 * MyTake.org
 *
 *  Copyright 2017 by its authors.
 *  Some rights reserved. See LICENSE, https://github.com/mytake/mytake/graphs/contributors
 */
package common;

import com.fizzed.rocker.runtime.RockerRuntime;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Binder;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jooby.Env;
import org.jooby.Jooby;
import org.jooby.assets.AssetCompiler;
import org.jooby.rocker.Rockerby;

public class CustomAssets implements Jooby.Module {
	public static void initTemplates(Jooby jooby) {
		// disable hot reloading on CI, to make sure tests work in the prod environment
		jooby.use(new Jooby.Module() {
			@Override
			public void configure(Env env, Config conf, Binder binder) throws Throwable {
				if (env.name().equals("dev") && !System.getenv().containsKey("CI")) {
					RockerRuntime.getInstance().setReloading(true);
				}
			}
		});
		// sets variables that the templates need
		jooby.use(new CustomAssets());
		// makes rocker templates work
		jooby.use(new Rockerby());
	}

	private CustomAssets() {}

	static final String _STYLES = "_styles";
	static final String _SCRIPTS = "_scripts";

	@Override
	public void configure(Env env, Config conf, Binder binder) throws Throwable {
		Config config = ConfigFactory.parseResources("assets.conf");
		AssetCompiler compiler = new AssetCompiler(config);
		Function<String, String> url;
		if (env.name().equals("dev")) {
			url = raw -> "/assets-dev" + raw;
			env.router().assets("/assets-dev/**");
			env.router().assets("/assets/**");
		} else {
			String manifest = Resources.toString(CustomAssets.class.getResource(
					"/assets/manifest.json"), StandardCharsets.UTF_8);
			Map<String, String> map = new Gson().fromJson(manifest, new TypeToken<HashMap<String, String>>() {}.getType());
			url = raw -> "/assets/" + Objects.requireNonNull(map.get(raw.substring(1)), "No fingerprinted version of " + raw);
			env.router().assets("/assets/**");
		}
		// key, style, key, script
		List<String> keyValue = new ArrayList<>(4 * compiler.fileset().size());
		for (String fileset : compiler.fileset()) {
			keyValue.add(fileset + CustomAssets._STYLES);
			keyValue.add(styles(url, compiler, fileset));
			keyValue.add(fileset + CustomAssets._SCRIPTS);
			keyValue.add(scripts(url, compiler, fileset));
		}
		env.router().before((req, rsp) -> {
			for (int i = 0; i < keyValue.size() / 2; ++i) {
				String key = keyValue.get(2 * i);
				String value = keyValue.get(2 * i + 1);
				req.set(key, value);
			}
		});
	}

	private static String styles(Function<String, String> urlMapper, AssetCompiler compiler, String fileset) {
		return compiler.styles(fileset).stream()
				.map(url -> url.startsWith("/https://") ? url.substring(1) : urlMapper.apply(url))
				.map(script -> "<link rel=\"stylesheet\" href=\"" + script + "\">")
				.collect(Collectors.joining("\n"));
	}

	private static String scripts(Function<String, String> urlMapper, AssetCompiler compiler, String fileset) {
		return compiler.scripts(fileset).stream()
				.map(url -> url.startsWith("/https://") ? url.substring(1) : urlMapper.apply(url))
				.map(script -> "<script type=\"text/javascript\" src=\"" + script + "\"></script>")
				.collect(Collectors.joining("\n"));
	}
}