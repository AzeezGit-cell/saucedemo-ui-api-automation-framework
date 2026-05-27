package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private final By usernameField = By.id("user-name");

	private final By passwordField = By.id("password");

	private final By loginButton = By.id("login-button");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage enterUsername(String username) {
		type(usernameField, username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		type(passwordField, password);
		return this;
	}

	public ProductsPage clickLogin() {
		click(loginButton);
		return new ProductsPage(driver);
	}

	public ProductsPage login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		return clickLogin();
	}
}