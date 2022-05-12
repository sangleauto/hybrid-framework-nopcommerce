package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage {
	WebDriver driver;

	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueInWishlistTableAtRowAndColumnIndex(String rowIndex1, String productColumn) {
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, productColumn) + 1;
		waitForElementVisible(driver, UserWishlistPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
		return getElementText(driver, UserWishlistPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
	}

	public void clickToWishlistURL() {
		waitForElementClickable(driver, UserWishlistPageUI.WISHLIST_URL);
		clickToElement(driver, UserWishlistPageUI.WISHLIST_URL);
	}

	public boolean isWishlistTitleContainsFullname(String fullName) {
		waitForElementVisible(driver, UserWishlistPageUI.WISHLIST_OF_NAME);
		return getElementText(driver, UserWishlistPageUI.WISHLIST_OF_NAME).contains(fullName);
	}

	public void checkToCheckboxInWishlistTable(String rowIndex1, String checkboxColumn) {
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, checkboxColumn) + 1;
		waitForElementClickable(driver, UserWishlistPageUI.CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, UserWishlistPageUI.CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));

	}

	public UserShoppingCartPageObject clickToAddToCartButton() {
		waitForElementClickable(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public Object getWishlistEmptyMessage() {
		waitForElementVisible(driver, UserWishlistPageUI.WISHLIST_EMPTY_MESSAGE);
		return getElementText(driver, UserWishlistPageUI.WISHLIST_EMPTY_MESSAGE);
	}

	public void clickToRemoveIconInWishlistTable(String rowIndex1, String checkboxColumn) {
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, checkboxColumn) + 1;
		waitForElementClickable(driver, UserWishlistPageUI.BUTTON_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
		clickToElement(driver, UserWishlistPageUI.BUTTON_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));

	}

	public boolean isWishlistTableUndisplayed() {
		waitForElementUndisplayed(driver, UserWishlistPageUI.TABLE_PRODUCT_WISHLIST);
		return isElementUndisplayed(driver, UserWishlistPageUI.TABLE_PRODUCT_WISHLIST);
	}

}
