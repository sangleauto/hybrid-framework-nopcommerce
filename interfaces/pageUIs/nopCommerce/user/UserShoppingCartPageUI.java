package pageUIs.nopCommerce.user;

public class UserShoppingCartPageUI {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
	public static final String COLUMN_INDEX_BY_NAME_UPDATE_CART = "xpath=//th[contains(text(), '%s')]/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='cart']//tr[%s]//td[%s]";
	public static final String SHOPPING_CART_TABLE = "xpath=//table[@class='cart']";
	public static final String TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='cart']//tr[%s]//td[%s]//input";
	public static final String BUTTON_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='cart']//tr[%s]//td[%s]//button";
	public static final String EDIT_LINK = "xpath=//div[@class='edit-item']//a";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "xpath=//button[@id='updatecart']";
	public static final String EMPTY_CART_MESSAGE = "xpath=//div[@class='no-data']";

}
