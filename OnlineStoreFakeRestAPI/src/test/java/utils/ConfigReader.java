package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties properties;
	private static final String CONFIG_FILE_PATH = ".\\src\\test\\resources\\config.properties";
	
	// Constructor to load the file
	public ConfigReader() {
		properties = new Properties();
		try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file");
		}
	}
	
	// getProperty method read the properties
	// return the value in String format
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	// getIntProperty method read the properties
	// return the value in Int format
	public int getIntProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}
	
}
