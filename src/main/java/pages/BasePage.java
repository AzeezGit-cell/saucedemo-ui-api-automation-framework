package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

import java.util.List;

public abstract class BasePage {

	protected final WebDriver driver;
	protected final WaitHelper waitHelper;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.waitHelper = new WaitHelper(driver);
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	protected String getText(By locator) {
		return waitHelper.waitForVisibility(find(locator)).getText();
	}

	protected void click(By locator) {
		waitHelper.waitForClickable(find(locator)).click();
	}

	protected void type(By locator, String text) {
		WebElement element = waitHelper.waitForVisibility(find(locator));
		element.clear();
		element.sendKeys(text);
	}

	protected boolean isDisplayed(By locator) {
		try {
			return waitHelper.waitForVisibility(find(locator)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}