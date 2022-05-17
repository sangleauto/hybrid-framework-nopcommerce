package pageObjects.nopCommerce.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminCustomerInfoPageUI;
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
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
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
		waitForElementVisible(driver, AdminCustomerInfoPageUI.DEFAULT_ROLE);
		waitForElementClickable(driver, AdminDashboardPageUI.REMOVE_DEFAULT_ROLE);
		clickToElement(driver, AdminDashboardPageUI.REMOVE_DEFAULT_ROLE);

	}

	public void selectCustomerRoleDropdown(String customerRole) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.ROLE_DROPDOWN_LOADING);
		waitForElementVisible(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN);
		sendkeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, customerRole);
		pressKeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, Keys.ENTER);
		pressKeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, Keys.ESCAPE);

		if (getElementText(driver, BasePageNopCommerceUI.ROLE_SPAN).equals("Registered")) {
			removeDefaultCustomerRole();
			sendkeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, customerRole);
			pressKeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, Keys.ENTER);
			pressKeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, Keys.ESCAPE);
		}

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

	public void enterEmailTextbox(String email) {
		waitForElementInvisible(driver, AdminDashboardPageUI.LOADING_ICON);
		waitForElementVisible(driver, AdminDashboardPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminDashboardPageUI.EMAIL_TEXTBOX, email);

	}

	public void enterFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AdminDashboardPageUI.FIRSTNAME_TEXTBOX);

		sendkeyToElement(driver, AdminDashboardPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AdminDashboardPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminDashboardPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void enterCompanyTextbox(String companyName) {
		waitForElementVisible(driver, AdminDashboardPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AdminDashboardPageUI.COMPANY_TEXTBOX, companyName);

	}

	public void selectMonthDropdown(String dobMonth) {
		waitForElementClickable(driver, AdminDashboardPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminDashboardPageUI.MONTH_DROPDOWN, dobMonth);
	}

	public void selectDayDropdown(String dobDay) {
		waitForElementClickable(driver, AdminDashboardPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminDashboardPageUI.DAY_DROPDOWN, dobDay);

	}

	public AdminCustomerInfoPageObject clickToEditButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.EDIT_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.EDIT_BUTTON);
		return PageGeneratorManager.getAdminCustomerInfoPage(driver);
	}

	public String getEditSuccessMessage() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminDashboardPageUI.EDIT_CUSTOMER_SUCCESS_MSG);
		return getElementText(driver, AdminDashboardPageUI.EDIT_CUSTOMER_SUCCESS_MSG);
	}

}
