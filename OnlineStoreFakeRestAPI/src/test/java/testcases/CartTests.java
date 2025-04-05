package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;
import pojo.Cart;
import routes.Routes;

public class CartTests extends BaseClass{

	//@Test
	public void testGetAllCarts() 
	{
		given()
		
		.when()
			.get(Routes.GET_ALL_CARTS)
		.then()
			.statusCode(200)
			.body("size()", greaterThan(0));
	}
	
	@Test
	public void testGetCartById()
	{
		int cartId = configReader.getIntProperty("cartId");
		
		given()
			.pathParam("id", cartId)
		.when()
			.get(Routes.GET_CART_BY_ID)
		.then()
			.statusCode(200)
			.body("id", equalTo(cartId));
	}
	
	
}
















