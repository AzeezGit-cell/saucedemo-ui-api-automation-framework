package utils;

import config.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

	private static WebDriver driver;

	private DriverManager() {
	}

	public static WebDriver getDriver() {

		if (driver == null) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			if (ConfigReader.isHeadless()) {

				options.addArguments("--headless=new");
			}

			options.addArguments("--incognito");

			options.addArguments("--disable-notifications");

			options.addArguments("--window-size=1920,1080");

			Map<String, Object> prefs = new HashMap<>();

			prefs.put("credentials_enable_service", false);

			prefs.put("profile.password_manager_enabled", false);

			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));

			driver.manage().window().maximize();
		}

		return driver;
	}

	public static void quitDriver() {

		if (driver != null) {

			driver.quit();

			driver = null;
		}
	}
}