package testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import routes.Routes;
import utils.ConfigReader;

public class BaseClass {

	ConfigReader configReader;
	
	RequestLoggingFilter requestLoggingFilter;
	ResponseLoggingFilter responseLoggingFilter;
	
	@BeforeClass
	public void setup() throws FileNotFoundException
	{
		// This will avoid redundant calls of base URL in the requests
		// Helps to focus on calling only the end points
		RestAssured.baseURI = Routes.BASE_URL;
		
		// Setup filters for logging
		FileOutputStream fos = new FileOutputStream(".\\logs\\test_logging.txt");
		PrintStream log = new PrintStream(fos, true);
		requestLoggingFilter = new RequestLoggingFilter(log);
		responseLoggingFilter = new ResponseLoggingFilter(log);
		
		RestAssured.filters(requestLoggingFilter, responseLoggingFilter);
		
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
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
	public boolean validateCartDatesWithinRange(List<String> cartDates, String startDate, String endDate) 
	{       
		LocalDate start = LocalDate.parse(startDate, FORMATTER);   	
	    LocalDate end = LocalDate.parse(endDate, FORMATTER);

	    for (String dateTime : cartDates) 
	    {
	        LocalDate cartDate = LocalDate.parse(dateTime.substring(0, 10), FORMATTER);
	        if (cartDate.isBefore(start) || cartDate.isAfter(end)) 
	        {
	            return false; // Immediately return false if any cart date is out of range
	        }
	    }
	    
	    return true; // All dates are within range
	}
	
	
}
