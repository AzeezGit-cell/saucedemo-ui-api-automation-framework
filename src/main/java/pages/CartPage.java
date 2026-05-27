package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

	private final By cartItems = By.className("cart_item");
	private final By cartItemName = By.cssSelector(".cart_item .inventory_item_name");

	private final By checkoutButton = By.id("checkout");

	public CartPage(WebDriver driver) {

		super(driver);
	}

	public int getCartItemCount() {

		return findAll(cartItems).size();
	}

	public String getCartItemName() {

		return getText(cartItemName);
	}

	public CheckoutPage proceedToCheckout() {

		click(checkoutButton);

		return new CheckoutPage(driver);
	}
}