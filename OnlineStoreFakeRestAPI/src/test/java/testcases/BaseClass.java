package testcases;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import routes.Routes;

public class BaseClass {

	@BeforeClass
	public void setup()
	{
		// This will avoid redundant calls of base URL in the requests
		// Helps to focus on calling only the end points
		RestAssured.baseURI = Routes.BASE_URL;
	}
	
}
