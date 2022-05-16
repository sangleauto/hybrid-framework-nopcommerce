package pageObjects.nopCommerce.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;
import pageUIs.nopCommerce.admin.BasePageNopCommerceUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplayed() {
		waitForAllElementsVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

	public void enterToProductNameTextbox(String productLenovoName) {
		waitForAllElementsVisible(driver, AdminDashboardPageUI.LOADING_ICON);
		waitForElementVisible(driver, AdminDashboardPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminDashboardPageUI.PRODUCT_NAME_TEXTBOX, productLenovoName);
	}

	public void clickToSearchProductButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.SEARCH_PRODUCT_BUTTON);
		waitForElementInvisible(driver, AdminDashboardPageUI.LOADING_ICON);

	}

	public void clickToSearchCustomerButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.SEARCH_CUSTOMER_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.SEARCH_CUSTOMER_BUTTON);
		waitForElementInvisible(driver, AdminDashboardPageUI.LOADING_ICON);

	}

	public String getValueInTableAtRowAndColumnIndex(String rowIndex, String columnName) {
		int columnIndex = getElementSize(driver, AdminDashboardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminDashboardPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, AdminDashboardPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}

	public String getAttributeInTableAtRowAndColumnIndex(String rowIndex, String columnName) {
		int columnIndex = getElementSize(driver, AdminDashboardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminDashboardPageUI.ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		return getAttributeValue(driver, AdminDashboardPageUI.ICON_BY_ROW_AND_COLUMN_INDEX, "class", rowIndex, String.valueOf(columnIndex));
	}

	public void clickToNopLogo() {
		waitForElementInvisible(driver, AdminDashboardPageUI.LOADING_ICON);
		waitForElementClickable(driver, AdminDashboardPageUI.HOME_LOGO);
		clickToElement(driver, AdminDashboardPageUI.HOME_LOGO);
	}

	public void selectCategoryDropdown(String categoryValue) {
		waitForElementClickable(driver, AdminDashboardPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminDashboardPageUI.CATEGORY_DROPDOWN, categoryValue);

	}

	public void uncheckToSearchSubCheckbox() {
		waitForElementClickable(driver, AdminDashboardPageUI.SEARCH_SUB_CHECKBOX);
		uncheckToDefaultCheckbox(driver, AdminDashboardPageUI.SEARCH_SUB_CHECKBOX);
	}

	public String getNoDataMessageInTable() {
		waitForElementVisible(driver, AdminDashboardPageUI.NO_DATA_TABLE_MESSAGE);
		return getElementText(driver, AdminDashboardPageUI.NO_DATA_TABLE_MESSAGE);
	}

	public void checkToSearchSubCheckbox() {
		waitForElementClickable(driver, AdminDashboardPageUI.SEARCH_SUB_CHECKBOX);
		checkToDefaultCheckboxOrRadio(driver, AdminDashboardPageUI.SEARCH_SUB_CHECKBOX);

	}

	public void selectManufacturerDropdown(String manufacturerValue) {
		waitForElementClickable(driver, AdminDashboardPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminDashboardPageUI.MANUFACTURER_DROPDOWN, manufacturerValue);
	}

	public void enterGoToProductSKUTextbox(String skuValue) {
		waitForAllElementsVisible(driver, AdminDashboardPageUI.ALL_ROW_TABLE);
		waitForElementVisible(driver, AdminDashboardPageUI.GO_SKU_TEXTBOX);
		sendkeyToElement(driver, AdminDashboardPageUI.GO_SKU_TEXTBOX, skuValue);
	}

	public AdminProductInfoPageObject clickToGoButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.GO_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.GO_BUTTON);
		return PageGeneratorManager.getAdminProductInfoPage(driver);
	}

	public AdminCustomerInfoPageObject clickToAddNewButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminCustomerInfoPage(driver);
	}

	public void removeDefaultCustomerRole() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementClickable(driver, AdminDashboardPageUI.REMOVE_DEFAULT_ROLE);
		clickToElement(driver, AdminDashboardPageUI.REMOVE_DEFAULT_ROLE);

	}

	public void selectCustomerRoleDropdown(String customerRole) {
		waitForElementVisible(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN);
		sendkeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, customerRole);
		pressKeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, Keys.ENTER);
		pressKeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, Keys.ESCAPE);

	}

	public boolean isFullNameShownInTable(String fullName) {
		boolean flag = false;
		int totalRow = getElementSize(driver, AdminDashboardPageUI.ALL_ROW);
		for (int i = 0; i < totalRow; i++) {
			if (getValueInTableAtRowAndColumnIndex(String.valueOf(i + 1), "Name").equals(fullName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
