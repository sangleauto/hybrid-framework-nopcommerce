package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='Reward points']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='Customer info']";
	public static final String CUSTOMER_INFO_HEADER = "xpath=//div[@class='page-title']/h1[text()='My account - Customer info']";
	public static final String LOGOUT_LINK_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_ADMIN = "xpath=//a[text()='Logout']";
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String SEARCH_PAGE_LINK = "xpath=//a[text()='Search']";
	public static final String WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
	public static final String SHOPPING_CART_LINK = "xpath=//a[@class='ico-cart']";
	public static final String RECENT_VIEW_LINK = "xpath=//a[text()='Recently viewed products']";
	public static final String HOME_PAGE_ICON = "xpath=//img[@alt='nopCommerce demo store']";

	// Pattern Object
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class, 'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DYNAMIC_MENU_PAGE_BY_NAME = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(), '%s')]";
	public static final String DYNAMIC_SUB_MENU_PAGE_BY_NAME = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(), '%s')]";

	public static final String SIDEBAR_BY_NAME = "xpath=(//li[contains(@class, 'nav-item has-treeview')]//p[contains(text(), '%s')])[1]";
	public static final String SUB_SIDEBAR_BY_NAME = "xpath=(//ul[@class='nav nav-treeview']//p[(text()='%s')])";

}
