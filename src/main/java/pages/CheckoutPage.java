
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

	private final By firstNameField = By.id("first-name");

	private final By lastNameField = By.id("last-name");

	private final By postalCodeField = By.id("postal-code");

	private final By continueButton = By.id("continue");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public CheckoutPage fillCustomerInfo(String firstName, String lastName, String postalCode) {
		type(firstNameField, firstName);
		type(lastNameField, lastName);
		type(postalCodeField, postalCode);
		return this;
	}

	public CheckoutOverviewPage clickContinue() {
		click(continueButton);
		return new CheckoutOverviewPage(driver);
	}

	public CheckoutOverviewPage fillInfoAndContinue(String firstName, String lastName, String postalCode) {
		fillCustomerInfo(firstName, lastName, postalCode);
		return clickContinue();
	}
}
