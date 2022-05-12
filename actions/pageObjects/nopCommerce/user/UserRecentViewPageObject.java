package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserRecentViewPageUI;

public class UserRecentViewPageObject extends BasePage {
	WebDriver driver;

	public UserRecentViewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRecentViewPageOnlyShow3Products(String... arrayNotebookProduct) {
		waitForAllElementsVisible(driver, UserRecentViewPageUI.ALL_PRODUCT_TITLES);
		List<WebElement> productRecentViewElements = getListWebElement(driver, UserRecentViewPageUI.ALL_PRODUCT_TITLES);
		List<String> productRecentViewNames = new ArrayList<String>();
		for (WebElement productElement : productRecentViewElements) {
			productRecentViewNames.add(productElement.getText());
		}
		List<String> productNames = new ArrayList<String>();
		for (String product : arrayNotebookProduct) {
			productNames.add(product);
		}
		productNames = productNames.subList(productNames.size() - 3, productNames.size());
		Collections.reverse(productNames);
		System.out.println(productNames);
		System.out.println(productRecentViewNames);
		return productRecentViewNames.equals(productNames);
	}

}
