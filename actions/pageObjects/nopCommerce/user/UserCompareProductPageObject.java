package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCompareProductPageUI;

public class UserCompareProductPageObject extends BasePage {
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueInCompareTableAtRowAndColumnIndex(String rowIndex, String columnIndex) {
		waitForElementVisible(driver, UserCompareProductPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
		return getElementText(driver, UserCompareProductPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
	}

	public void clickToClearListButton() {
		waitForElementClickable(driver, UserCompareProductPageUI.CLEAN_LIST_BUTTON);
		clickToElement(driver, UserCompareProductPageUI.CLEAN_LIST_BUTTON);
	}

	public Object getCompareEmptyMessage() {
		waitForElementVisible(driver, UserCompareProductPageUI.COMPARE_EMPTY_MESSAGE);
		return getElementText(driver, UserCompareProductPageUI.COMPARE_EMPTY_MESSAGE);
	}

	public boolean isCompareTableUndisplayed() {
		waitForElementUndisplayed(driver, UserCompareProductPageUI.TABLE_PRODUCT_COMPARISON);
		return isElementUndisplayed(driver, UserCompareProductPageUI.TABLE_PRODUCT_COMPARISON);
	}

}
