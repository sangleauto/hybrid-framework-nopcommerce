package pageObjects.nopCommerce.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminCustomerInfoPageUI;
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
		waitForElementVisible(driver, AdminCustomerInfoPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.PASSWORD_TEXTBOX, password);

	}

	public void enterFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void enterLastNameTextbox(String lastName) {
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
		waitForElementClickable(driver, AdminCustomerInfoPageUI.REMOVE_DEFAULT_ROLE);
		clickToElement(driver, AdminCustomerInfoPageUI.REMOVE_DEFAULT_ROLE);
	}

	public void selectCustomerRoleDropdown(String customerRole) {
		waitForElementVisible(driver, AdminCustomerInfoPageUI.PARENT_ROLE_DROPDOWN);
		sendkeyToElement(driver, AdminCustomerInfoPageUI.PARENT_ROLE_DROPDOWN, customerRole);
		pressKeyToElement(driver, AdminCustomerInfoPageUI.PARENT_ROLE_DROPDOWN, Keys.ENTER);
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

}
