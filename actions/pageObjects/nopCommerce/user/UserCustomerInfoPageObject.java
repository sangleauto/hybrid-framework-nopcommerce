package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

	public boolean isNewsLetterCheckboxChecked() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}

	public void checkToFemaleGenderRadio() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.FEMALE_RADIO);
		checkToDefaultCheckboxOrRadio(driver, UserCustomerInfoPageUI.FEMALE_RADIO);

	}

	public void enterFirstNameTextbox(String value) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, value);
	}

	public void enterLastNameTextbox(String value) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, value);

	}

	public void selectDate(String value) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN, value);
	}

	public void selectMonth(String value) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN, value);

	}

	public void selectYear(String value) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN, value);

	}

	public void enterEmailTextbox(String value) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, value);

	}

	public void enterCompanyNameTextbox(String value) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, value);

	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);

	}

	public boolean isFemailRadioChecked() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FEMALE_RADIO);
		return isElementSelected(driver, UserCustomerInfoPageUI.FEMALE_RADIO);
	}

	public String getValueInFirstNameTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getValueInLastNameTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getValueInEmailTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getValueInDayDropdown() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
	}

	public Object getValueInMonthDropdown() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public Object getValueInYearDropdown() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public Object getValueInCompanyNameTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
	}

}
