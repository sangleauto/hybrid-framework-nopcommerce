package pageUIs.nopCommerce.user;

public class UserOrderPageUI {
	public static final String ORDER_NUMBER = "xpath=(//strong[contains(text(), 'Number')])[1]";
	public static final String ORDER_DETAIL_BUTTON = "xpath=(//button[@class='button-2 order-details-button'])[1]";
	public static final String ORDER_NUMBER_INFO = "xpath=//div[@class='order-number']//strong";
	public static final String ORDER_STATUS_INFO = "xpath=//li[@class='order-status']";
	public static final String ORDER_TOTAL_INFO = "xpath=//li[@class='order-total']//strong";

	public static final String BILLING_ADDRESS_FULLNAME = "xpath=//div[@class='billing-info']//li[@class='name']";
	public static final String BILLING_ADDRESS_EMAIL = "xpath=//div[@class='billing-info']//li[@class='email']";
	public static final String BILLING_ADDRESS_PHONE = "xpath=//div[@class='billing-info']//li[@class='phone']";
	public static final String BILLING_ADDRESS_ADDRESS1 = "xpath=//div[@class='billing-info']//li[@class='address1']";
	public static final String BILLING_ADDRESS_CITY_STATE_ZIP = "xpath=//div[@class='billing-info']//li[@class='city-state-zip']";
	public static final String BILLING_ADDRESS_COUNTRY = "xpath=//div[@class='billing-info']//li[@class='country']";
	public static final String PAYMENT_METHOD = "xpath=//li[@class='payment-method']//span[@class='value']";
	public static final String PAYMENT_STATUS = "xpath=//li[@class='payment-method-status']//span[@class='value']";
	public static final String SHIPPING_ADDRESS_FULLNAME = "xpath=//div[@class='shipping-info']//li[@class='name']";
	public static final String SHIPPING_ADDRESS_EMAIL = "xpath=//div[@class='shipping-info']//li[@class='email']";
	public static final String SHIPPING_ADDRESS_PHONE = "xpath=//div[@class='shipping-info']//li[@class='phone']";
	public static final String SHIPPING_ADDRESS_ADDRESS1 = "xpath=//div[@class='shipping-info']//li[@class='address1']";
	public static final String SHIPPING_ADDRESS_CITY_STATE_ZIP = "xpath=//div[@class='shipping-info']//li[@class='city-state-zip']";
	public static final String SHIPPING_ADDRESS_COUNTRY = "xpath=//div[@class='shipping-info']//li[@class='country']";
	public static final String SHIPPING_METHOD = "xpath=//li[@class='shipping-method']//span[@class='value']";
	public static final String SHIPPING_STATUS = "xpath=//li[@class='shipping-status']//span[@class='value']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[contains(text(), '%s')]/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='data-table']//tr[%s]//td[%s]";
	public static final String GIFT_WRAPPING = "xpath=//div[@class='section options']/div";
	public static final String SUB_TOTAL = "xpath=(//td[@class='cart-total-right']//span)[1]";
	public static final String SHIPPING_FEE = "xpath=(//td[@class='cart-total-right']//span)[2]";
	public static final String TAX_VALUE = "xpath=(//td[@class='cart-total-right']//span)[3]";
	public static final String ORDER_TOTAL = "xpath=(//td[@class='cart-total-right']//span)[4]";
	public static final String RE_ORDER_BUTTON = "xpath=//button[text()='Re-order']";
}
