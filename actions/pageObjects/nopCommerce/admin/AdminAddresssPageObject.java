package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminAddresssPageUI;
import pageUIs.nopCommerce.admin.BasePageNopCommerceUI;

public class AdminAddresssPageObject extends BasePage {
	private WebDriver driver;

	public AdminAddresssPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstNameTextbox(String firstName) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminAddresssPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AdminAddresssPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void enterEmailTextbox(String email) {
		waitForElementVisible(driver, AdminAddresssPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.EMAIL_TEXTBOX, email);

	}

	public void enterCompanyTextbox(String companyName) {
		waitForElementVisible(driver, AdminAddresssPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.COMPANY_TEXTBOX, companyName);

	}

	public void selectCountryDropdown(String country) {
		waitForElementClickable(driver, AdminAddresssPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminAddresssPageUI.COUNTRY_DROPDOWN, country);

	}

	public void selectStateDropdown(String state) {
		waitForElementClickable(driver, AdminAddresssPageUI.STATE_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminAddresssPageUI.STATE_DROPDOWN, state);

	}

	public void enterCityTextbox(String city) {
		waitForElementVisible(driver, AdminAddresssPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.CITY_TEXTBOX, city);

	}

	public void enterAddress1Textbox(String address1) {
		waitForElementVisible(driver, AdminAddresssPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.ADDRESS1_TEXTBOX, address1);

	}

	public void enterZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, AdminAddresssPageUI.ZIP_CODE_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.ZIP_CODE_TEXTBOX, zipCode);
	}

	public void enterPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AdminAddresssPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AdminAddresssPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);

	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AdminAddresssPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminAddresssPageUI.SAVE_BUTTON);
	}

	public String getAddAddressSuccessMsg() {
		waitForElementVisible(driver, AdminAddresssPageUI.ADD_ADDRESS_SUCCESS_MSG);
		return getElementText(driver, AdminAddresssPageUI.ADD_ADDRESS_SUCCESS_MSG);
	}

	public String getFirstName() {
		waitForElementVisible(driver, AdminAddresssPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastName() {
		waitForElementVisible(driver, AdminAddresssPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmail() {
		waitForElementVisible(driver, AdminAddresssPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyName() {
		waitForElementVisible(driver, AdminAddresssPageUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getCountryInDropdown() {
		waitForElementVisible(driver, AdminAddresssPageUI.COUNTRY_DROPDOWN);
		return getSelectedItemInDefaultDropdown(driver, AdminAddresssPageUI.COUNTRY_DROPDOWN);
	}

	public String getStateInDropdown() {
		waitForElementVisible(driver, AdminAddresssPageUI.STATE_DROPDOWN);
		return getSelectedItemInDefaultDropdown(driver, AdminAddresssPageUI.STATE_DROPDOWN);
	}

	public String getCity() {
		waitForElementVisible(driver, AdminAddresssPageUI.CITY_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.CITY_TEXTBOX, "value");
	}

	public String getAddress1() {
		waitForElementVisible(driver, AdminAddresssPageUI.ADDRESS1_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.ADDRESS1_TEXTBOX, "value");
	}

	public String getZipCode() {
		waitForElementVisible(driver, AdminAddresssPageUI.ZIP_CODE_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.ZIP_CODE_TEXTBOX, "value");
	}

	public String getPhoneNumber() {
		waitForElementVisible(driver, AdminAddresssPageUI.PHONE_NUMBER_TEXTBOX);
		return getAttributeValue(driver, AdminAddresssPageUI.PHONE_NUMBER_TEXTBOX, "value");
	}

	public AdminCustomerInfoPageObject clickToBackToCustomerLink() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementClickable(driver, AdminAddresssPageUI.BACK_TO_CUSTOMER_LINK);
		clickToElement(driver, AdminAddresssPageUI.BACK_TO_CUSTOMER_LINK);
		return PageGeneratorManager.getAdminCustomerInfoPage(driver);
	}

	public void clickToSaveButtonInEditAddress() {
		waitForElementClickable(driver, AdminAddresssPageUI.SAVE_BUTTON_IN_EDIT_ADDRESS);
		clickToElement(driver, AdminAddresssPageUI.SAVE_BUTTON_IN_EDIT_ADDRESS);

	}
}
