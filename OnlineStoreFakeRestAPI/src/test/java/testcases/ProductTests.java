package testcases;

import pojo.Product;
import routes.Routes;
import utils.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Payload;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;

public class ProductTests extends BaseClass {

	// 1) Test to retrieve all products
	//@Test
	public void testGetAllProducts()
	{
		given()
		
		.when()
			.get(Routes.GET_ALL_PRODUCTS)
		.then()
			.statusCode(200)
			.body("size()", greaterThan(0));  
	}
	
	// 2) Test to retrieve a single product by ID
	//@Test
	public void testGetSingleProductById()
	{
		int productId = configReader.getIntProperty("productId");
		
		given()
			.pathParam("id", productId)
		.when()
			.get(Routes.GET_PRODUCT_BY_ID)
		.then()
			.statusCode(200);
	}
	
	// 3) Test to retrieve a limited number of products
	//@Test
	public void testGetLimitedProducts()
	{
		given()
			.pathParam("limit", 3)
		.when()
			.get(Routes.GET_PRODUCTS_WITH_LIMIT)
		.then()
			.statusCode(200)
			.body("size()", equalTo(3));
	}
	
	// 4) Test to retrieve products sorted in descending order
	@Test
	public void testGetSortedProducts()
	{
		
		Response response =given()
			.pathParam("order", "desc")
		.when()
			.get(Routes.GET_PRODUCTS_SORTED)
		.then()
			.statusCode(200)
			.extract().response();
		
		List<Integer> productsIds = response.jsonPath().getList("id", Integer.class);
		assertThat(isSortedDescending(productsIds), is(true));
	}

	
}















