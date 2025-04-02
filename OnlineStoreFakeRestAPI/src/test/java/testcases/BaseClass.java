package testcases;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import routes.Routes;
import utils.ConfigReader;

public class BaseClass {

	ConfigReader configReader;
	
	@BeforeClass
	public void setup()
	{
		// This will avoid redundant calls of base URL in the requests
		// Helps to focus on calling only the end points
		RestAssured.baseURI = Routes.BASE_URL;
		
		configReader = new ConfigReader();
	}
	
}
