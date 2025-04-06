package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import routes.Routes;

public class SchemaTests extends BaseClass{

	@Test
	public void testProductSchema()
	{
		int productId=configReader.getIntProperty("productId");
		
		given()
			.pathParam("id", productId)
		
		.when()
			.get(Routes.GET_PRODUCT_BY_ID)
		.then()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("productSchema.json"));
	}
	
	@Test
	 public void testCartSchema() {
   	int cartId = configReader.getIntProperty("cartId");
       given()
           .pathParam("id", cartId)
       .when()
           .get(Routes.GET_CART_BY_ID)
       .then()
       		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("cartSchema.json"));
   }
	
	
}














