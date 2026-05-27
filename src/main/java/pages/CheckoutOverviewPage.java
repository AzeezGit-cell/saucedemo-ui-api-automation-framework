package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

	private final By pageTitle = By.className("title");

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	public boolean isPageDisplayed() {
		return getText(pageTitle).equalsIgnoreCase("Checkout: Overview");
	}
}