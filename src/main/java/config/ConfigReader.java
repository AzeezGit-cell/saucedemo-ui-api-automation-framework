package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	private static final String path = "src/main/resources/config.properties";

	private ConfigReader() {
	}

	private static void loadProperties() {

		if (properties == null) {

			properties = new Properties();

			try (InputStream input = new FileInputStream(path)) {

				properties.load(input);

			} catch (IOException e) {

				throw new RuntimeException("Failed to load config.properties file from: " + path, e);
			}
		}
	}

	public static String getProperty(String key) {

		loadProperties();

		String value = properties.getProperty(key);

		if (value == null) {

			throw new RuntimeException("Property '" + key + "' not found in config.properties");
		}

		return value;
	}

	// UI Configuration

	public static String getBaseUrl() {

		return getProperty("base.url");
	}

	public static String getUsername() {

		return getProperty("username");
	}

	public static String getPassword() {

		return getProperty("password");
	}

	// Browser Configuration

	public static String getBrowser() {

		return getProperty("browser");
	}

	public static boolean isHeadless() {

		return Boolean.parseBoolean(getProperty("headless"));
	}

	public static int getImplicitWait() {

		return Integer.parseInt(getProperty("implicit.wait"));
	}

	public static int getExplicitWait() {

		return Integer.parseInt(getProperty("explicit.wait"));
	}

	// API Configuration

	public static String getApiBaseUrl() {

		return getProperty("api.base.url");
	}

	public static String getRegisterEndpoint() {

		return getProperty("api.register.endpoint");
	}

	public static String getUserEndpoint() {

		return getProperty("api.user.endpoint");
	}

	public static String getApiKey() {

		return getProperty("api.key");
	}

	public static String getRegisterEmail() {

		return getProperty("api.register.email");
	}

	public static String getRegisterPassword() {

		return getProperty("api.register.password");
	}
}