package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import payloads.Payload;
import pojo.Login;
import routes.Routes;


import org.testng.annotations.Test;

public class LoginTests extends BaseClass{

	@Test
	public void testInvalidUserLogin()
	{
		Login newLogin = Payload.loginPayload();
		
		given()
			.contentType(ContentType.JSON)
			.body(newLogin)
		.when()
			.post(Routes.AUTH_LOGIN)
		.then()
			.log().body()
			.statusCode(401) // Expecting 401 for unauthorized access
			.body(equalTo("username or password is incorrect")); // Validate the message response body
	}
	
	
	
}















