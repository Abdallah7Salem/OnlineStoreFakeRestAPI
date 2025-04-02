package payloads;

import java.util.Random;
import com.github.javafaker.Faker;
import pojo.Product;

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
	
	// Cart Payload
	
	
	// User Payload
	
	
	// Login Payload
	
	
	
}
