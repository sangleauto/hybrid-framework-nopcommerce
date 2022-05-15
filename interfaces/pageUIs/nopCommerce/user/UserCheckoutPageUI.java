package pageUIs.nopCommerce.user;

public class UserCheckoutPageUI {
	public static final String SHIP_SAME_ADDRESS_CHECKBOX = "xpath=//input[@id='ShipToSameAddress']";
	public static final String BILLING_ADDRESS_DROPDOWN = "xpath=//select[@name='billing_address_id']";
	public static final String BILLING_FIRSTNAME_TEXTBOX = "xpath=//input[@id='BillingNewAddress_FirstName']";
	public static final String BILLING_LASTNAME_TEXTBOX = "xpath=//input[@id='BillingNewAddress_LastName']";
	public static final String BILLING_EMAIL_TEXTBOX = "xpath=//input[@id='BillingNewAddress_Email']";
	public static final String BILLING_COUNTRY_DROPDOWN = "xpath=//select[@id='BillingNewAddress_CountryId']";
	public static final String BILLING_STATE_DROPDOWN = "xpath=//select[@id='BillingNewAddress_StateProvinceId']";
	public static final String BILLING_CITY_TEXTBOX = "xpath=//input[@id='BillingNewAddress_City']";
	public static final String BILLING_ADDRESS1_TEXTBOX = "xpath=//input[@id='BillingNewAddress_Address1']";
	public static final String BILLING_ZIPCODE_TEXTBOX = "xpath=//input[@id='BillingNewAddress_ZipPostalCode']";
	public static final String BILLING_PHONE_TEXTBOX = "xpath=//input[@id='BillingNewAddress_PhoneNumber']";
	public static final String BILLING_CONTINUE_BUTTON = "xpath=//div[@id='billing-buttons-container']//button[contains(@class, 'new-address')]";

	public static final String SHIPPING_ADDRESS_DROPDOWN = "xpath=//select[@name='shipping_address_id']";
	public static final String SHIPPING_FIRSTNAME_TEXTBOX = "xpath=//input[@id='ShippingNewAddress_FirstName']";
	public static final String SHIPPING_LASTNAME_TEXTBOX = "xpath=//input[@id='ShippingNewAddress_LastName']";
	public static final String SHIPPING_EMAIL_TEXTBOX = "xpath=//input[@id='ShippingNewAddress_Email']";
	public static final String SHIPPING_COUNTRY_DROPDOWN = "xpath=//select[@id='ShippingNewAddress_CountryId']";
	public static final String SHIPPING_STATE_DROPDOWN = "xpath=//select[@id='ShippingNewAddress_StateProvinceId']";
	public static final String SHIPPING_CITY_TEXTBOX = "xpath=//input[@id='ShippingNewAddress_City']";
	public static final String SHIPPING_ADDRESS1_TEXTBOX = "xpath=//input[@id='ShippingNewAddress_Address1']";
	public static final String SHIPPING_ZIPCODE_TEXTBOX = "xpath=//input[@id='ShippingNewAddress_ZipPostalCode']";
	public static final String SHIPPING_PHONE_TEXTBOX = "xpath=//input[@id='ShippingNewAddress_PhoneNumber']";
	public static final String SHIPPING_CONTINUE_BUTTON = "xpath=//div[@id='shipping-buttons-container']//button[contains(@class, 'new-address')]";
	public static final String SHIPPING_METHOD_RADIO_BY_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String SHIP_METHOD_CONTINUE_BUTTON = "xpath=//button[contains(@class, 'shipping-method')]";
	public static final String PAYMENT_METHOD_RADIO_BY_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "xpath=//button[contains(@class, 'payment-method')]";
	public static final String PAYMENT_INFO_CONTENT = "xpath=(//div[@class='section payment-info']//td//p)[2]";
	public static final String CREDIT_CARD_DROPDOWN = "xpath=//select[@id='CreditCardType']";
	public static final String CARDHOLDER_TEXTBOX = "xpath=//input[@id='CardholderName']";
	public static final String CARDNUMBER_TEXTBOX = "xpath=//input[@id='CardNumber']";
	public static final String EXPIRE_MONTH_DROPDOWN = "xpath=//select[@id='ExpireMonth']";
	public static final String EXPIRE_YEAR_DROPDOWN = "xpath=//select[@id='ExpireYear']";
	public static final String CARDCODE_TEXTBOX = "xpath=//input[@id='CardCode']";
	public static final String PAYMENT_INFO_CONTINUE_BUTTON = "xpath=//button[contains(@class, 'payment-info')]";

	public static final String BILLING_ADDRESS_FULLNAME = "xpath=//div[@class='billing-info']//li[@class='name']";
	public static final String BILLING_ADDRESS_EMAIL = "xpath=//div[@class='billing-info']//li[@class='email']";
	public static final String BILLING_ADDRESS_PHONE = "xpath=//div[@class='billing-info']//li[@class='phone']";
	public static final String BILLING_ADDRESS_ADDRESS1 = "xpath=//div[@class='billing-info']//li[@class='address1']";
	public static final String BILLING_ADDRESS_CITY_STATE_ZIP = "xpath=//div[@class='billing-info']//li[@class='city-state-zip']";
	public static final String BILLING_ADDRESS_COUNTRY = "xpath=//div[@class='billing-info']//li[@class='country']";
	public static final String PAYMENT_METHOD = "xpath=//div[@class='payment-method-info']//span[@class='value']";
	public static final String SHIPPING_ADDRESS_FULLNAME = "xpath=//div[@class='shipping-info']//li[@class='name']";
	public static final String SHIPPING_ADDRESS_EMAIL = "xpath=//div[@class='shipping-info']//li[@class='email']";
	public static final String SHIPPING_ADDRESS_PHONE = "xpath=//div[@class='shipping-info']//li[@class='phone']";
	public static final String SHIPPING_ADDRESS_ADDRESS1 = "xpath=//div[@class='shipping-info']//li[@class='address1']";
	public static final String SHIPPING_ADDRESS_CITY_STATE_ZIP = "xpath=//div[@class='shipping-info']//li[@class='city-state-zip']";
	public static final String SHIPPING_ADDRESS_COUNTRY = "xpath=//div[@class='shipping-info']//li[@class='country']";
	public static final String SHIPPING_METHOD = "xpath=//div[@class='shipping-method-info']//span[@class='value']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[contains(text(), '%s')]/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='cart']//tr[%s]//td[%s]";
	public static final String GIFT_WRAPPING = "xpath=//div[@class='cart-options']/div";
	public static final String SUB_TOTAL = "xpath=//tr[@class='order-subtotal']//span[@class='value-summary']";
	public static final String SHIPPING_FEE = "xpath=//tr[@class='shipping-cost']//span[@class='value-summary']";
	public static final String TAX_VALUE = "xpath=//tr[@class='tax-value']//span[@class='value-summary']";
	public static final String ORDER_TOTAL = "xpath=//tr[@class='order-total']//span[@class='value-summary']";
	public static final String CONFIRM_ORDER_BUTTON = "xpath=//button[contains(@class, 'confirm-order')]";
	public static final String ORDER_SUCCESS_MESSAGE = "xpath=//div[@class='section order-completed']/div[@class='title']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']";
	public static final String LOADING_STATE = "xpath=//span[@id='states-loading-progress']";

}
