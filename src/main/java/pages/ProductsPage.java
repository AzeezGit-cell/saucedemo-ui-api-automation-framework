package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

	private final By productName = By.cssSelector(".inventory_item_name");

	private final By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
	private final By shoppingCartLink = By.className("shopping_cart_link");

	public ProductsPage(WebDriver driver) {

		super(driver);
	}

	public String getProductName() {
		return getText(productName);
	}

	public ProductsPage addBackpackToCart() {
		click(addBackpackToCartButton);
		return this;
	}

	public CartPage goToCart() {
		click(shoppingCartLink);
		return new CartPage(driver);
	}
}