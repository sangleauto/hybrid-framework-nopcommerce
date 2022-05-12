package pageUIs.nopCommerce.user;

public class UserWishlistPageUI {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='cart']//tr[%s]//td[%s]";
	public static final String WISHLIST_OF_NAME = "xpath=//div[@class='page-title']//h1";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[@name='addtocartbutton']";
	public static final String CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='cart']//tr[%s]//td[%s]/input";
	public static final String BUTTON_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='cart']//tr[%s]//td[%s]/button";
	public static final String WISHLIST_EMPTY_MESSAGE = "xpath=//div[@class='no-data']";
	public static final String TABLE_PRODUCT_WISHLIST = "xpath=//table[@class='cart']";
	public static final String WISHLIST_URL = "xpath=//a[contains(@href, 'wishlist/')]";

}
