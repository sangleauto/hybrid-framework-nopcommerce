package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, UserAddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressPageUI.ADD_NEW_BUTTON);
	}

	public void enterFirstnameTextbox(String firstNameValue) {
		waitForElementVisible(driver, UserAddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.FIRST_NAME_TEXTBOX, firstNameValue);

	}

	public void enterLastnameTextbox(String lastNameValue) {
		waitForElementVisible(driver, UserAddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.LAST_NAME_TEXTBOX, lastNameValue);

	}

	public void enterEmailTextbox(String emailValue) {
		waitForElementVisible(driver, UserAddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void enterCompanyTextbox(String companyValue) {
		waitForElementVisible(driver, UserAddressPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.COMPANY_NAME_TEXTBOX, companyValue);

	}

	public void selectCountryDropdown(String countryValue) {
		waitForElementClickable(driver, UserAddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserAddressPageUI.COUNTRY_DROPDOWN, countryValue);

	}

	public void selectStateProvinceDropdown(String stateProvinceValue) {
		waitForElementClickable(driver, UserAddressPageUI.STATE_PROVINCE_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserAddressPageUI.STATE_PROVINCE_DROPDOWN, stateProvinceValue);

	}

	public void enterCityTextbox(String cityValue) {
		waitForElementVisible(driver, UserAddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.CITY_TEXTBOX, cityValue);

	}

	public void enterAddress1(String address1Value) {
		waitForElementVisible(driver, UserAddressPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.ADDRESS1_TEXTBOX, address1Value);

	}

	public void enterAddress2(String address2Value) {
		waitForElementVisible(driver, UserAddressPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.ADDRESS2_TEXTBOX, address2Value);

	}

	public void enterZipCodeTextbox(String zipCodeValule) {
		waitForElementVisible(driver, UserAddressPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.ZIPCODE_TEXTBOX, zipCodeValule);

	}

	public void enterPhoneNumberTextbox(String phoneValue) {
		waitForElementVisible(driver, UserAddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.PHONE_NUMBER_TEXTBOX, phoneValue);

	}

	public void enterFaxNumberTextbox(String faxValue) {
		waitForElementVisible(driver, UserAddressPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.FAX_NUMBER_TEXTBOX, faxValue);

	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserAddressPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressPageUI.SAVE_BUTTON);
	}

	public String getValueFullNameInfo() {
		waitForElementVisible(driver, UserAddressPageUI.FULLNAME_INFO);
		return getElementText(driver, UserAddressPageUI.FULLNAME_INFO);
	}

	public String getValueEmailInfo() {
		waitForElementVisible(driver, UserAddressPageUI.EMAIL_INFO);
		return getElementText(driver, UserAddressPageUI.EMAIL_INFO);
	}

	public String getValuePhoneInfo() {
		waitForElementVisible(driver, UserAddressPageUI.PHONE_INFO);
		return getElementText(driver, UserAddressPageUI.PHONE_INFO);
	}

	public String getValueFaxNumberInfo() {
		waitForElementVisible(driver, UserAddressPageUI.FAX_INFO);
		return getElementText(driver, UserAddressPageUI.FAX_INFO);
	}

	public String getValueAddress1Info() {
		waitForElementVisible(driver, UserAddressPageUI.ADDRESS1_INFO);
		return getElementText(driver, UserAddressPageUI.ADDRESS1_INFO);
	}

	public String getValueAddress2Info() {
		waitForElementVisible(driver, UserAddressPageUI.ADDRESS2_INFO);
		return getElementText(driver, UserAddressPageUI.ADDRESS2_INFO);
	}

	public String getValueCityStateZipInfo() {
		waitForElementVisible(driver, UserAddressPageUI.CITY_STATE_ZIP_INFO);
		return getElementText(driver, UserAddressPageUI.CITY_STATE_ZIP_INFO);
	}

	public String getStateInfo(String stateValue) {
		String state = "";
		if (!stateValue.equals("Other")) {
			state = ", " + stateValue;
		}
		return state;
	}

	public String getCountryInfo() {
		waitForElementVisible(driver, UserAddressPageUI.COUNTRY_INFO);
		return getElementText(driver, UserAddressPageUI.COUNTRY_INFO);
	}

}
