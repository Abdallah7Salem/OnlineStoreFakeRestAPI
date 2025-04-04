package testcases;

import java.util.List;

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
	

	boolean isSortedDescending(List<Integer> list)
	{
		for(int i = 0; i < list.size()-1; i++)
		{
			if(list.get(i) < list.get(i+1))
			{
				return false;
			}
		}
		return true;
	}
	
	boolean isSortedAscending(List<Integer> list)
	{
		for(int i = 0; i < list.size()-1; i++)
		{
			if(list.get(i) > list.get(i+1))
			{
				return false;
			}
		}
		return true;
	}
	
}
