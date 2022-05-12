package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueInShoppingCartTableAtRowAndColumnIndex(String rowIndex1, String productColumn) {
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, productColumn) + 1;
		waitForElementVisible(driver, UserShoppingCartPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
		return getElementText(driver, UserShoppingCartPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
	}

	public boolean isShoppingCartTableDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.SHOPPING_CART_TABLE);
		return isElementDisplayed(driver, UserShoppingCartPageUI.SHOPPING_CART_TABLE);
	}

}
