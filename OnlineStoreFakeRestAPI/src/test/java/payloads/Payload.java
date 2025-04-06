package payloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;

import pojo.Product;
import pojo.Address;
import pojo.Cart;
import pojo.CartProduct;
import pojo.Geolocation;
import pojo.Login;
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
	public static Cart cartPayload (int userId) {
		List<CartProduct> products = new ArrayList<>();
		
		// Adding one random product to the cart
		int productId = random.nextInt(100);
		int quantity = random.nextInt(10) + 1;
		
		products.add(new CartProduct(productId, quantity));
		
		return (new Cart(userId, new Date(), products));
	}
	
	// Login Payload
	public static Login loginPayload()
	{
		String username = faker.name().username();
		String password = faker.internet().password();
		
		return (new Login(username, password));
		
	}
	
	
}
