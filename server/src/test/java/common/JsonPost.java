/*
 * MyTake.org
 *
 *  Copyright 2017 by its authors.
 *  Some rights reserved. See LICENSE, https://github.com/mytakedotorg/mytakedotorg/graphs/contributors
 */
package common;

import com.jsoniter.JsonIterator;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java2ts.Json;
import org.jooby.Status;

public class JsonPost {
	public static ValidatableResponse post(RequestSpecification spec, Json input, String route) {
		return spec
				.contentType(ContentType.JSON)
				.body(input.toJson())
				.post(route)
				.then()
				.statusCode(Status.OK.value());
	}

	/** Posts json content, and returns parsed json content. */
	public static <T> T post(RequestSpecification spec, Json input, String route, Class<T> output) {
		byte[] body = post(spec, input, route).extract().body().asByteArray();
		return JsonIterator.deserialize(body, output);
	}
}
