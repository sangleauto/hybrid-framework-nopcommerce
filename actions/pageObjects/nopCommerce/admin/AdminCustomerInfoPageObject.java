package pageObjects.nopCommerce.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminCustomerInfoPageUI;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;
import pageUIs.nopCommerce.admin.BasePageNopCommerceUI;

public class AdminCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public AdminCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailTextbox(String email) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.EMAIL_TEXTBOX, email);

	}

	public void enterPasswordTextbox(String password) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminCustomerInfoPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.PASSWORD_TEXTBOX, password);

	}

	public void enterFirstNameTextbox(String firstName) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void enterLastNameTextbox(String lastName) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminCustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void checkToGenderRadio(String gender) {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.GENDER_RADIO_BY_NAME, gender);
		checkToDefaultCheckboxOrRadio(driver, AdminCustomerInfoPageUI.GENDER_RADIO_BY_NAME, gender);

	}

	public void enterDOBTextbox(String dob) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.DOB_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.DOB_TEXTBOX, dob);

	}

	public void enterCompanyTextbox(String companyName) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);

	}

	public void removeDefaultCustomerRole() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.DEFAULT_ROLE);
		waitForElementClickable(driver, AdminCustomerInfoPageUI.REMOVE_DEFAULT_ROLE);
		clickToElement(driver, AdminCustomerInfoPageUI.REMOVE_DEFAULT_ROLE);
	}

	public void selectCustomerRoleDropdown(String customerRole) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.ROLE_DROPDOWN_LOADING);
		waitForElementVisible(driver, AdminCustomerInfoPageUI.PARENT_ROLE_DROPDOWN);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.PARENT_ROLE_DROPDOWN, customerRole);
		pressKeyToElement(driver, AdminCustomerInfoPageUI.PARENT_ROLE_DROPDOWN, Keys.ENTER);

		if (getElementText(driver, BasePageNopCommerceUI.ROLE_SPAN).equals("Registered")) {
			removeDefaultCustomerRole();
			sendkeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, customerRole);
			pressKeyToElement(driver, AdminDashboardPageUI.PARENT_ROLE_DROPDOWN, Keys.ENTER);
		}
	}

	public void checkToActiveCheckbox() {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.ACTIVE_CHECKBOX);
		checkToDefaultCheckboxOrRadio(driver, AdminCustomerInfoPageUI.ACTIVE_CHECKBOX);

	}

	public void enterAdminCommentTextarea(String adminComment) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.ADMIN_COMMENT_TEXTAREA);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.ADMIN_COMMENT_TEXTAREA, adminComment);
	}

	public void clickToSaveAndContinueButton() {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.SAVE_CONTINUE_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.SAVE_CONTINUE_BUTTON);
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
	}

	public String getAddCustomerSuccessMsg() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.ADD_CUSTOMER_SUCCESS_MSG);
		return getElementText(driver, AdminCustomerInfoPageUI.ADD_CUSTOMER_SUCCESS_MSG);
	}

	public AdminDashboardPageObject clickToBackToCustomerListLink() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementClickable(driver, AdminCustomerInfoPageUI.BACK_TO_CUSTOMER_LIST_LINK);
		clickToElement(driver, AdminCustomerInfoPageUI.BACK_TO_CUSTOMER_LIST_LINK);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public String getEmail() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, AdminCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getFirstName() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, AdminCustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastName() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, AdminCustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public boolean isGenderRadioChecked(String gender) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.GENDER_RADIO_BY_NAME, gender);
		return isElementSelected(driver, AdminCustomerInfoPageUI.GENDER_RADIO_BY_NAME, gender);
	}

	public String getDOB() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.DOB_TEXTBOX);
		return getAttributeValue(driver, AdminCustomerInfoPageUI.DOB_TEXTBOX, "value");
	}

	public String getCompanyName() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getAttributeValue(driver, AdminCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public String getCustomerRole() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.CUSTOMER_ROLE);
		return getElementText(driver, AdminCustomerInfoPageUI.CUSTOMER_ROLE);
	}

	public boolean isActiveCheckboxChecked() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.ACTIVE_CHECKBOX);
		return isElementSelected(driver, AdminCustomerInfoPageUI.ACTIVE_CHECKBOX);
	}

	public String getAdminComment() {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.ADMIN_COMMENT_TEXTAREA);
		return getElementText(driver, AdminCustomerInfoPageUI.ADMIN_COMMENT_TEXTAREA);
	}

	public AdminDashboardPageObject clickToSaveButton() {
		waitForElementClickable(driver, AdminCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public void clickToAddressTab() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		if (isElementUndisplayed(driver, AdminCustomerInfoPageUI.ADD_NEW_ADDRESS_BUTTON)) {
			waitForElementClickable(driver, AdminCustomerInfoPageUI.ADDRESS_TAB);
			clickToElement(driver, AdminCustomerInfoPageUI.ADDRESS_TAB);
		}
	}

	public AdminAddresssPageObject clickToAddNewAddressButton() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementClickable(driver, AdminCustomerInfoPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.ADD_NEW_ADDRESS_BUTTON);
		return PageGeneratorManager.getAdminAddresssPage(driver);

	}

	public String getValueInTableAtRowAndColumnIndex(String rowIndex, String columnName) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		int columnIndex = getElementSize(driver, AdminCustomerInfoPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminCustomerInfoPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, AdminCustomerInfoPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}

	public AdminAddresssPageObject clickToEditAddressButton() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementClickable(driver, AdminCustomerInfoPageUI.EDIT_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.EDIT_ADDRESS_BUTTON);
		return PageGeneratorManager.getAdminAddresssPage(driver);
	}

	public void clickToDeleteAddressButton() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementClickable(driver, AdminCustomerInfoPageUI.DELETE_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerInfoPageUI.DELETE_ADDRESS_BUTTON);
	}

	public void acceptDeleteAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}

	public String getNoDataMessageInTable() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminCustomerInfoPageUI.NO_DATA_TABLE_MESSAGE);
		return getElementText(driver, AdminCustomerInfoPageUI.NO_DATA_TABLE_MESSAGE);
	}

}
