package payloads;

import java.util.Random;

import com.github.javafaker.Faker;
import pojo.Product;
import pojo.Address;
import pojo.Geolocation;
import pojo.User;
import pojo.Name;

public class Payload {

	private static final Faker faker = new Faker();
	private static final String categories[] = {"electronics", "furniture", "clothing", "books", "beauty"};
	
	private static final Random random = new Random();
	
	// Product Payload
	public static Product productPayload() {
		String name = faker.commerce().productName();
		Double price = Double.parseDouble(faker.commerce().price());
		String description = faker.lorem().sentence();
		String imageUrl = "https://i.pravatar.cc/100";
		
		// Utilizing random class object to select random category
		String category = categories[random.nextInt(categories.length)];
	
		return new Product(name, price, description, imageUrl, category);
	}
	
	// User Payload
	public static User userPayload()
	{
		// Name
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		Name name = new Name(firstname, lastname);
		
		// Address
		String city = faker.address().city();
		String street = faker.address().streetName();
		int number = random.nextInt(100);
		String zipcode = faker.address().zipCode();
		
		String lat = faker.address().latitude();
		String lng = faker.address().longitude();
		Geolocation geolocation = new Geolocation(lat, lng);
		
		Address address = new Address(city, street, number, zipcode, geolocation);
		
		// Email
		String email = faker.internet().emailAddress();
		String username = faker.name().username();
		String password = faker.internet().password();
		
		// Phone number
		String phonenumber = faker.phoneNumber().cellPhone();
		
		return (new User(email, username, password, name, address, phonenumber));
	}
	
	
	// Cart Payload
	
	
	// Login Payload
	
	
	
}
