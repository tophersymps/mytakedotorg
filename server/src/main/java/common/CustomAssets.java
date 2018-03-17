/*
 * MyTake.org
 *
 *  Copyright 2017 by its authors.
 *  Some rights reserved. See LICENSE, https://github.com/mytakedotorg/mytakedotorg/graphs/contributors
 */
package common;

import com.fizzed.rocker.runtime.RockerRuntime;
import com.google.common.io.Resources;
import com.google.inject.Binder;
import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
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
		env.router().assets("/favicon.ico", "/assets/permanent/favicon-6022c3e42d.ico");

		Config config = ConfigFactory.parseResources("assets.conf");
		AssetCompiler compiler = new AssetCompiler(config);
		BiFunction<String, String, String> url;
		if (env.name().equals("dev")) {
			url = (type, raw) -> "/assets-dev/" + type + raw;
			env.router().assets("/assets-dev/**");
			env.router().assets("/assets/**");
		} else {
			byte[] manifest = Resources.toByteArray(CustomAssets.class.getResource("/assets/manifest.json"));
			Map<String, Any> map = JsonIterator.deserialize(manifest).asMap();
			url = (type, raw) -> "/assets/" + type + "/" + Objects.requireNonNull(map.get(raw.substring(1)), "No fingerprinted version of " + raw + ", only has: " + map.keySet());
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

	private static final String SLASH_SHA_384 = "/sha384-";

	private static String styles(BiFunction<String, String, String> urlMapper, AssetCompiler compiler, String fileset) {
		return compiler.styles(fileset).stream()
				.map(url -> url.startsWith(SLASH_SHA_384) ? url : urlMapper.apply("styles", url))
				.map(CustomAssets::subresourceIntegrityStyle)
				.collect(Collectors.joining("\n"));
	}

	private static String scripts(BiFunction<String, String, String> urlMapper, AssetCompiler compiler, String fileset) {
		return compiler.scripts(fileset).stream()
				.map(url -> url.startsWith(SLASH_SHA_384) ? url : urlMapper.apply("scripts", url))
				.map(CustomAssets::subresourceIntegrityScript)
				.collect(Collectors.joining("\n"));
	}

	private static String subresourceIntegrityStyle(String input) {
		if (input.startsWith(SLASH_SHA_384)) {
			int barIdx = input.indexOf('|');
			String integrity = input.substring(1, barIdx); // 1=remove slash
			String url = input.substring(barIdx + 1);
			return "<link rel=\"stylesheet\" href=\"" + url + "\" integrity=\"" + integrity + "\" crossorigin=\"anonymous\">";
		} else {
			return "<link rel=\"stylesheet\" href=\"" + input + "\">";
		}
	}

	private static String subresourceIntegrityScript(String input) {
		if (input.startsWith(SLASH_SHA_384)) {
			int barIdx = input.indexOf('|');
			String integrity = input.substring(1, barIdx); // 1=remove slash
			String url = input.substring(barIdx + 1);
			return "<script type=\"text/javascript\" src=\"" + url + "\" integrity=\"" + integrity + "\" crossorigin=\"anonymous\"></script>";
		} else {
			return "<script type=\"text/javascript\" src=\"" + input + "\"></script>";
		}
	}
}
