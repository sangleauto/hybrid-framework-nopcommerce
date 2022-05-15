package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserOrderPageUI;

public class UserOrderPageObject extends BasePage {
	WebDriver driver;

	public UserOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getOrderNumberCheckout() {
		waitForElementVisible(driver, UserOrderPageUI.ORDER_NUMBER);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER);
	}

	public void openDetailsPage() {
		waitForElementClickable(driver, UserOrderPageUI.ORDER_DETAIL_BUTTON);
		clickToElement(driver, UserOrderPageUI.ORDER_DETAIL_BUTTON);
	}

	public boolean isOrderNumberShownAtOrderPage(String orderNumberCheckout) {
		String orderNumber = orderNumberCheckout.toUpperCase().replace("ORDER NUMBER: ", "");
		waitForElementVisible(driver, UserOrderPageUI.ORDER_NUMBER);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER).contains(orderNumber);
	}

	public boolean isOrderNumberShownAtDetailPage(String orderNumberCheckout) {
		String orderNumber = orderNumberCheckout.toUpperCase().replace("ORDER NUMBER: ", "");
		waitForElementVisible(driver, UserOrderPageUI.ORDER_NUMBER_INFO);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER_INFO).contains(orderNumber);
	}

	public String getOrderStatus() {
		waitForElementVisible(driver, UserOrderPageUI.ORDER_STATUS_INFO);
		return getElementText(driver, UserOrderPageUI.ORDER_STATUS_INFO);
	}

	public String getOrderTotal() {
		waitForElementVisible(driver, UserOrderPageUI.ORDER_TOTAL_INFO);
		return getElementText(driver, UserOrderPageUI.ORDER_TOTAL_INFO);
	}

	public String getFullNameBillingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.BILLING_ADDRESS_FULLNAME);
		return getElementText(driver, UserOrderPageUI.BILLING_ADDRESS_FULLNAME);
	}

	public String getEmailBillingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.BILLING_ADDRESS_EMAIL);
		return getElementText(driver, UserOrderPageUI.BILLING_ADDRESS_EMAIL);
	}

	public String getPhoneBillingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.BILLING_ADDRESS_PHONE);
		return getElementText(driver, UserOrderPageUI.BILLING_ADDRESS_PHONE);
	}

	public String getAddress1BillingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.BILLING_ADDRESS_ADDRESS1);
		return getElementText(driver, UserOrderPageUI.BILLING_ADDRESS_ADDRESS1);
	}

	public String getCityStateZipBillingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.BILLING_ADDRESS_CITY_STATE_ZIP);
		return getElementText(driver, UserOrderPageUI.BILLING_ADDRESS_CITY_STATE_ZIP);
	}

	public String getPaymentMethod() {
		waitForElementVisible(driver, UserOrderPageUI.PAYMENT_METHOD);
		return getElementText(driver, UserOrderPageUI.PAYMENT_METHOD);
	}

	public String getPaymentStatus() {
		waitForElementVisible(driver, UserOrderPageUI.PAYMENT_STATUS);
		return getElementText(driver, UserOrderPageUI.PAYMENT_STATUS);
	}

	public String getFullNameShippingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_ADDRESS_FULLNAME);
		return getElementText(driver, UserOrderPageUI.SHIPPING_ADDRESS_FULLNAME);
	}

	public String getEmailShippingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_ADDRESS_EMAIL);
		return getElementText(driver, UserOrderPageUI.SHIPPING_ADDRESS_EMAIL);
	}

	public String getPhoneShippingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_ADDRESS_PHONE);
		return getElementText(driver, UserOrderPageUI.SHIPPING_ADDRESS_PHONE);
	}

	public String getAddress1ShippingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_ADDRESS_ADDRESS1);
		return getElementText(driver, UserOrderPageUI.SHIPPING_ADDRESS_ADDRESS1);
	}

	public String getCityStateZipShippingAddress() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_ADDRESS_CITY_STATE_ZIP);
		return getElementText(driver, UserOrderPageUI.SHIPPING_ADDRESS_CITY_STATE_ZIP);
	}

	public String getShippingMethod() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_METHOD);
		return getElementText(driver, UserOrderPageUI.SHIPPING_METHOD);
	}

	public String getShippingStatus() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_STATUS);
		return getElementText(driver, UserOrderPageUI.SHIPPING_STATUS);
	}

	public String getValueInTableAtRowAndColumnIndex(WebDriver driver, String row, String columnName) {
		int columnIndex = getElementSize(driver, UserOrderPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, UserOrderPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, row, String.valueOf(columnIndex));
		return getElementText(driver, UserOrderPageUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, row, String.valueOf(columnIndex));
	}

	public String getGiftWrappingText() {
		waitForElementVisible(driver, UserOrderPageUI.GIFT_WRAPPING);
		return getElementText(driver, UserOrderPageUI.GIFT_WRAPPING);
	}

	public String getSubTotal() {
		waitForElementVisible(driver, UserOrderPageUI.SUB_TOTAL);
		return getElementText(driver, UserOrderPageUI.SUB_TOTAL);
	}

	public String getShippingFee() {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_FEE);
		return getElementText(driver, UserOrderPageUI.SHIPPING_FEE);
	}

	public String getTaxValue() {
		waitForElementVisible(driver, UserOrderPageUI.TAX_VALUE);
		return getElementText(driver, UserOrderPageUI.TAX_VALUE);
	}

	public String getTotal() {
		waitForElementVisible(driver, UserOrderPageUI.ORDER_TOTAL);
		return getElementText(driver, UserOrderPageUI.ORDER_TOTAL);
	}

	public UserShoppingCartPageObject clickToReOrderButton() {
		waitForElementClickable(driver, UserOrderPageUI.RE_ORDER_BUTTON);
		clickToElement(driver, UserOrderPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

}
