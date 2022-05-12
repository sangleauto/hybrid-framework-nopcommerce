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

}
