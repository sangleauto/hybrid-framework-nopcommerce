package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueInCartAtRowAndColumnIndex(String rowIndex1, String productColumn) {
		int columnIndex = getElementSize(driver, UserShoppingCartPageUI.COLUMN_INDEX_BY_NAME, productColumn) + 1;
		waitForElementVisible(driver, UserShoppingCartPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
		return getElementText(driver, UserShoppingCartPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
	}

	public String getValueInUpdateCartAtRowAndColumnIndex(String rowIndex1, String productColumn) {
		int columnIndex = getElementSize(driver, UserShoppingCartPageUI.COLUMN_INDEX_BY_NAME_UPDATE_CART, productColumn) + 1;
		waitForElementVisible(driver, UserShoppingCartPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
		return getElementText(driver, UserShoppingCartPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex1, String.valueOf(columnIndex));
	}

	public boolean isShoppingCartTableDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.SHOPPING_CART_TABLE);
		return isElementDisplayed(driver, UserShoppingCartPageUI.SHOPPING_CART_TABLE);
	}

	public String getTotalPriceInCart(String price, String amount) {
		String priceStr = price.replace("$", "").replace(".00", "").replace(",", "");
		System.out.println("Test 1: " + priceStr);
		int cartPrice = Integer.parseInt(priceStr);
		int cartAmount = Integer.parseInt(amount);
		System.out.println("Test 2: " + cartPrice + cartAmount);
		System.out.println("Test 3: " + String.valueOf(cartPrice * cartAmount));
		return String.valueOf(cartPrice * cartAmount);
	}

	public String getTextboxValueInCartAtRowAndColumnIndex(String rowIndex, String columnName) {
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, UserShoppingCartPageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		return getAttributeValue(driver, UserShoppingCartPageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, "value", rowIndex, String.valueOf(columnIndex));
	}

	public UserDesktopPageObject clickToEditLink() {
		waitForElementClickable(driver, UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK);
		return PageGeneratorManager.getUserDesktopPage(driver);
	}

	public void clickToButtonInCartAtRowAndColumnIndex(String rowIndex, String columnName) {
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, UserShoppingCartPageUI.BUTTON_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		clickToElement(driver, UserShoppingCartPageUI.BUTTON_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}

	public String getEmptyCartMsg() {
		waitForElementVisible(driver, UserShoppingCartPageUI.EMPTY_CART_MESSAGE);
		return getElementText(driver, UserShoppingCartPageUI.EMPTY_CART_MESSAGE);
	}

	public boolean isShoppingCartTableUndisplayed() {
		waitForElementUndisplayed(driver, UserShoppingCartPageUI.SHOPPING_CART_TABLE);
		return isElementUndisplayed(driver, UserShoppingCartPageUI.SHOPPING_CART_TABLE);
	}

	public void enterToTextboxByNameAtRowAndColumnIndex(String rowIndex, String columnName, String value) {
		int columnIndex = getElementSize(driver, UserWishlistPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, UserShoppingCartPageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		sendkeyToElement(driver, UserShoppingCartPageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, value, rowIndex, String.valueOf(columnIndex));

	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

}
