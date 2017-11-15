/*
 * MyTake.org
 *
 *  Copyright 2017 by its authors.
 *  Some rights reserved. See LICENSE, https://github.com/mytake/mytake/graphs/contributors
 */
package auth;

import static auth.AuthModule.REDIRECT;

import common.Time;
import common.UrlEncodedPath;
import forms.meta.MetaFormDef;
import forms.meta.MetaFormValidation;
import java.sql.Timestamp;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.jooby.Request;

class EmailConfirmationForm {
	static UrlEncodedPath generateLink(Request req, MetaFormValidation validation, String path) {
		UrlEncodedPath url = UrlEncodedPath.absolutePath(req, path);
		String redirect = validation.parsed(REDIRECT);
		if (!redirect.isEmpty()) {
			url.param(REDIRECT, redirect);
		}
		return url;
	}

	@Nullable
	static <T> MetaFormValidation validate(Class<? extends MetaFormDef> formClazz, Request req, T link, Function<T, Timestamp> expiresAt, Function<T, String> requestorIp) {
		MetaFormValidation validation = MetaFormValidation.empty(formClazz)
				.initAllIfPresent(req);
		Time time = req.require(Time.class);
		if (link == null || time.nowTimestamp().after(expiresAt.apply(link))) {
			validation.errorForForm("This link expired");
			return validation;
		} else if (!req.ip().equals(requestorIp.apply(link))) {
			// localhost workaround for dev - allow anything
			if (req.ip().equals("0:0:0:0:0:0:0:1")) {
				return null;
			}
			validation.errorForForm("Make sure to open the link from the same computer you requested it from");
			return validation;
		} else {
			return null;
		}
	}
}