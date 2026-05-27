package tests;

import config.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class UITest extends BaseTest {

	@Test(description = "Verify complete purchase flow")

	public void verifyCompletePurchaseFlow() {

		// Login
		LoginPage loginPage = new LoginPage(driver);

		ProductsPage productsPage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

		// Capture selected product name dynamically
		String selectedProduct = productsPage.getProductName();

		// Add product to cart
		productsPage.addBackpackToCart();

		// Navigate to cart
		CartPage cartPage = productsPage.goToCart();

		// Verify product added successfully
		Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart item count mismatch");

		Assert.assertEquals(cartPage.getCartItemName(), selectedProduct, "Incorrect product added to cart");

		// Proceed to checkout
		CheckoutPage checkoutPage = cartPage.proceedToCheckout();

		// Fill checkout information
		CheckoutOverviewPage overviewPage = checkoutPage.fillInfoAndContinue("John", "Doe", "12345");

		// Verify checkout overview page displayed
		Assert.assertTrue(overviewPage.isPageDisplayed(), "Checkout Overview page is not displayed");
	}
}