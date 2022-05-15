package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.nopCommerce.user.UserCheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
	WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uncheckToShipSameAddressCheckbox() {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIP_SAME_ADDRESS_CHECKBOX);
		uncheckToDefaultCheckbox(driver, UserCheckoutPageUI.SHIP_SAME_ADDRESS_CHECKBOX);
	}

	public void selectAddressDropdownBilling(String address) {
		overrideImplicitTimeout(driver, shortTimeout);
		if (isElementDisplayed(driver, UserCheckoutPageUI.BILLING_ADDRESS_DROPDOWN)) {
			waitForElementClickable(driver, UserCheckoutPageUI.BILLING_ADDRESS_DROPDOWN);
			selectItemInDefaultDropdown(driver, UserCheckoutPageUI.BILLING_ADDRESS_DROPDOWN, address);
		}
		overrideImplicitTimeout(driver, longTimeout);
	}

	public void enterFirstNameTextboxBilling(String firstName) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterLastNameTextboxBilling(String lastName) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_LASTNAME_TEXTBOX, lastName);

	}

	public void enterEmailTextboxBilling(String email) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_EMAIL_TEXTBOX, email);

	}

	public void selectCountryDropdownBilling(String country) {
		waitForElementClickable(driver, UserCheckoutPageUI.BILLING_COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.BILLING_COUNTRY_DROPDOWN, country);
	}

	public void selectStateDropdownBilling(String stateProvince) {
		waitForElementUndisplayed(driver, UserCheckoutPageUI.LOADING_STATE);
		waitForElementClickable(driver, UserCheckoutPageUI.BILLING_STATE_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.BILLING_STATE_DROPDOWN, stateProvince);
	}

	public void enterCityTextboxBilling(String city) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_CITY_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_CITY_TEXTBOX, city);

	}

	public void enterAddress1TextboxBilling(String address1) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_ADDRESS1_TEXTBOX, address1);

	}

	public void enterZipCodeTextboxBilling(String zipCode) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_ZIPCODE_TEXTBOX, zipCode);

	}

	public void enterPhoneTextboxBilling(String phone) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_PHONE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.BILLING_PHONE_TEXTBOX, phone);

	}

	public void clickToContinueButtonBilling() {
		waitForElementClickable(driver, UserCheckoutPageUI.BILLING_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.BILLING_CONTINUE_BUTTON);
	}

	public void selectAddressDropdownShipping(String address) {
		if (isElementDisplayed(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_DROPDOWN)) {
			waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_DROPDOWN);
			selectItemInDefaultDropdown(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_DROPDOWN, address);
		}

	}

	public void enterFirstNameTextboxShipping(String firstName) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.SHIPPING_FIRSTNAME_TEXTBOX, firstName);

	}

	public void enterLastNameTextboxShipping(String lastName) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.SHIPPING_LASTNAME_TEXTBOX, lastName);

	}

	public void enterEmailTextboxShipping(String email) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.SHIPPING_EMAIL_TEXTBOX, email);

	}

	public void selectCountryDropdownShipping(String country) {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.SHIPPING_COUNTRY_DROPDOWN, country);

	}

	public void selectStateDropdownShipping(String stateProvince) {
		waitForElementUndisplayed(driver, UserCheckoutPageUI.LOADING_STATE);
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_STATE_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.SHIPPING_STATE_DROPDOWN, stateProvince);

	}

	public void enterCityTextboxShipping(String city) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_CITY_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.SHIPPING_CITY_TEXTBOX, city);

	}

	public void enterAddress1TextboxShipping(String address1) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.SHIPPING_ADDRESS1_TEXTBOX, address1);

	}

	public void enterZipCodeTextboxShipping(String zipCode) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.SHIPPING_ZIPCODE_TEXTBOX, zipCode);

	}

	public void enterPhoneTextboxShipping(String phoneNumber) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_PHONE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.SHIPPING_PHONE_TEXTBOX, phoneNumber);

	}

	public void clickToContinueButtonShipping() {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
	}

	public void checkToShippingMethodRadio(String shippingMethod) {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_METHOD_RADIO_BY_NAME, shippingMethod);
		checkToDefaultCheckboxOrRadio(driver, UserCheckoutPageUI.SHIPPING_METHOD_RADIO_BY_NAME, shippingMethod);
	}

	public void clickToContinueButtonShipMethod() {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIP_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.SHIP_METHOD_CONTINUE_BUTTON);

	}

	public void checkToPaymentMethodRadio(String paymentMethod) {
		waitForElementClickable(driver, UserCheckoutPageUI.PAYMENT_METHOD_RADIO_BY_NAME, paymentMethod);
		checkToDefaultCheckboxOrRadio(driver, UserCheckoutPageUI.PAYMENT_METHOD_RADIO_BY_NAME, paymentMethod);

	}

	public void clickToContinueButtonPaymentMethod() {
		waitForElementClickable(driver, UserCheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
	}

	public String getPaymentInfo() {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTENT);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTENT);
	}

	public void clickToContinueButtonPaymentInfo() {
		waitForElementClickable(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
	}

	public String getFullNameBillingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_FULLNAME);
		return getElementText(driver, UserCheckoutPageUI.BILLING_ADDRESS_FULLNAME);
	}

	public String getEmailBillingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_EMAIL);
		return getElementText(driver, UserCheckoutPageUI.BILLING_ADDRESS_EMAIL);
	}

	public String getPhoneBillingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_PHONE);
		return getElementText(driver, UserCheckoutPageUI.BILLING_ADDRESS_PHONE);
	}

	public String getAddress1BillingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_ADDRESS1);
		return getElementText(driver, UserCheckoutPageUI.BILLING_ADDRESS_ADDRESS1);
	}

	public String getCityStateZipBillingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_CITY_STATE_ZIP);
		return getElementText(driver, UserCheckoutPageUI.BILLING_ADDRESS_CITY_STATE_ZIP);
	}

	public String getPaymentMethod() {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_METHOD);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_METHOD);
	}

	public String getFullNameShippingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_FULLNAME);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_FULLNAME);
	}

	public String getEmailShippingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_EMAIL);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_EMAIL);
	}

	public String getPhoneShippingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_PHONE);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_PHONE);
	}

	public String getAddress1ShippingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_ADDRESS1);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_ADDRESS1);
	}

	public String getCityStateZipShippingAddress() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_CITY_STATE_ZIP);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_CITY_STATE_ZIP);
	}

	public String getShippingMethod() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_METHOD);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_METHOD);
	}

	public String getValueInTableAtRowAndColumnIndex(WebDriver driver, String row, String columnName) {
		int columnIndex = getElementSize(driver, UserCheckoutPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, UserCheckoutPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, row, String.valueOf(columnIndex));
		return getElementText(driver, UserCheckoutPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, row, String.valueOf(columnIndex));
	}

	public String getGiftWrappingText() {
		waitForElementVisible(driver, UserCheckoutPageUI.GIFT_WRAPPING);
		return getElementText(driver, UserCheckoutPageUI.GIFT_WRAPPING);
	}

	public String getSubTotal() {
		waitForElementVisible(driver, UserCheckoutPageUI.SUB_TOTAL);
		return getElementText(driver, UserCheckoutPageUI.SUB_TOTAL);
	}

	public String getShippingFee() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_FEE);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_FEE);
	}

	public String getTaxValue() {
		waitForElementVisible(driver, UserCheckoutPageUI.TAX_VALUE);
		return getElementText(driver, UserCheckoutPageUI.TAX_VALUE);
	}

	public String getTotal() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_TOTAL);
		return getElementText(driver, UserCheckoutPageUI.ORDER_TOTAL);
	}

	public void clickToContinueButtonConfirmOrder() {
		waitForElementClickable(driver, UserCheckoutPageUI.CONFIRM_ORDER_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.CONFIRM_ORDER_BUTTON);
	}

	public String getOrderSuccessMsg() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
		return getElementText(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
	}

	public String getOrderNumber() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}

	public void selectCreditCardDropdown(String creditCardType) {
		waitForElementClickable(driver, UserCheckoutPageUI.CREDIT_CARD_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.CREDIT_CARD_DROPDOWN, creditCardType);

	}

	public void enterCardHolderNameTextbox(String cardHolderName) {
		waitForElementVisible(driver, UserCheckoutPageUI.CARDHOLDER_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.CARDHOLDER_TEXTBOX, cardHolderName);
	}

	public void enterCardNumberTextbox(String cardNumber) {
		waitForElementVisible(driver, UserCheckoutPageUI.CARDNUMBER_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.CARDNUMBER_TEXTBOX, cardNumber);

	}

	public void selectExpireMonthDropdown(String expireMonth) {
		waitForElementClickable(driver, UserCheckoutPageUI.EXPIRE_MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.EXPIRE_MONTH_DROPDOWN, expireMonth);
	}

	public void selectExpireYearDropdown(String expireYear) {
		waitForElementClickable(driver, UserCheckoutPageUI.EXPIRE_YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.EXPIRE_YEAR_DROPDOWN, expireYear);
	}

	public void enterCardCodeTextbox(String cardCode) {
		waitForElementVisible(driver, UserCheckoutPageUI.CARDCODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.CARDCODE_TEXTBOX, cardCode);
	}

	private long longTimeout = GlobalConstants.LONG_TIME_OUT;
	private long shortTimeout = GlobalConstants.SHORT_TIME_OUT;

}
