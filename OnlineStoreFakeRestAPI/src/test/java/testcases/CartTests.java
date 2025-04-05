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
	
	//@Test
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
	
 	//@Test
    public void testGetCartsByDateRange() {
     
    	 String startDate = configReader.getProperty("startdate");
    	 String endDate = configReader.getProperty("enddate");
    	    
         Response response=given()
             .pathParam("startdate", startDate)
             .pathParam("enddate", endDate)
         .when()
             .get(Routes.GET_CARTS_BY_DATE_RANGE)
         .then()
             .statusCode(200)
             .body("size()", greaterThan(0)) // Validate that the response is not empty
             .extract().response();
        
     // Extract the list of cart dates
        List<String> cartDates = response.jsonPath().getList("date");
   
        assertThat(validateCartDatesWithinRange(cartDates, startDate, endDate), is(true));
        
    }
 	
	//@Test
    public void testGetUserCart() 
	{
        int userId = configReader.getIntProperty("userId");
        
        given()
            .pathParam("userId", userId)
        .when()
            .get(Routes.GET_USER_CART)
        .then()
            .statusCode(200)
            .body("userId", everyItem(equalTo(userId))); // Validate that the response contains the correct user ID
    }
 	
    //@Test
    public void testGetCartsWithLimit() 
    {
        int limit = configReader.getIntProperty("limit");
        given()
            .pathParam("limit", limit)
        .when()
            .get(Routes.GET_CARTS_WITH_LIMIT)
        .then()
            .statusCode(200)
            .body("size()", lessThanOrEqualTo(limit)); // Validate that the response size is within the limit
    }
 	
}
















