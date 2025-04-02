package payloads;

import java.util.Random;
import com.github.javafaker.Faker;
import pojo.Product;

public class Payload {

	private static final Faker faker = new Faker();
	private static final String categories[] = {"electronics", "furniture", "clothing", "books", "beauty"};
	
	Random random = new Random();
	
	// Product Payload
	Product productPayload() {
		String name = faker.commerce().productName();
		Double price = Double.parseDouble(faker.commerce().price());
		String description = faker.lorem().sentence();
		String imageUrl = "https://i.pravatar.cc/100";
		String category = categories[random.nextInt(5)];
	
	}
	
	// Cart Payload
	
	
	// User Payload
	
	
	// Login Payload
	
	
	
}
