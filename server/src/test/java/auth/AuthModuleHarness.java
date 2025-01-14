/*
 * MyTake.org website and tooling.
 * Copyright (C) 2017-2020 MyTake.org, Inc.
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
 * You can contact us at team@mytake.org
 */
package auth;

import static db.Tables.ACCOUNT;
import static io.restassured.RestAssured.given;

import common.DbMisc;
import common.JoobyDevRule;
import db.tables.records.AccountRecord;
import io.restassured.specification.RequestSpecification;
import org.jooby.Jooby;

public class AuthModuleHarness {
	public static RequestSpecification givenUser(Jooby app, AccountRecord account) {
		return given().cookie(AuthUser.LOGIN_COOKIE, AuthUser.jwtToken(app, account));
	}

	public static String authTokenValue(JoobyDevRule dev, String username) {
		return AuthUser.jwtToken(dev.app(), DbMisc.fetchOne(dev.dsl(), ACCOUNT.USERNAME, username));
	}
}
