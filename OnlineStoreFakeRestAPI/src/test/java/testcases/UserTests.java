package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;
import pojo.User;
import routes.Routes;

public class UserTests extends BaseClass{

	// 1) Fetch all the users
	@Test
	public void testGetAllUsers()
	{
		given()
		
		.when()
			.get(Routes.GET_ALL_USERS)
		.then()
			.statusCode(200)
			.log().body()
			.contentType(ContentType.JSON)
			.body("size()", greaterThan(0)); 
	}
	
	
}


















