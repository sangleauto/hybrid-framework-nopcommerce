package pageUIs.nopCommerce.user;

public class UserDesktopPageUI {
	public static final String DESKTOP_PRODUCT_TITLE = "xpath=//div[@class='item-box']//a[contains(text(), 'Digital Storm')]";
	public static final String ADD_REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String PRODUCT_LINK = "xpath=//h2[@class='product-title']//a[text()='%s']";
	public static final String ADD_TO_WISHLIST = "xpath=//button[contains(@id, 'add-to-wishlist-button')]";
	public static final String ADD_TO_COMPARE_LIST = "xpath=//div[@class='overview-buttons']//button[text()='Add to compare list']";
	public static final String ADDED_SUCCESS_MESSAGE = "xpath=//div[@id='bar-notification']//p";
	public static final String WISHLIST_LINK_IN_ADDED_SUCCESS_MESSAGE = "xpath=//div[@id='bar-notification']//a[text()= 'wishlist']";
	public static final String COMPARE_LINK_IN_ADDED_SUCCESS_MESSAGE = "xpath=//div[@id='bar-notification']//a[text()= 'product comparison']";
	public static final String SHOPPING_CART_LINK_IN_ADDED_SUCCESS_MESSAGE = "xpath=//div[@id='bar-notification']//a[text()= 'shopping cart']";
	public static final String CLOSE_ICON = "xpath=//div[@id='bar-notification']//span";
	public static final String PROCESSOR_DROPDOWN = "xpath=//select[@id='product_attribute_1']";
	public static final String RAM_DROPDOWN = "xpath=//select[@id='product_attribute_2']";
	public static final String HDD_RADIO_BY_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String OS_RADIO_BY_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String SOFTWARE_CHECKBOX_BY_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String PRODUCT_PRICE = "xpath=//span[@id='price-value-1']";
	public static final String PRODUCT_QUANTITY = "xpath=//input[@id='product_enteredQuantity_1']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='Add to cart']";
	public static final String UPDATE_BUTTON = "xpath=//button[text()='Update']";

}
