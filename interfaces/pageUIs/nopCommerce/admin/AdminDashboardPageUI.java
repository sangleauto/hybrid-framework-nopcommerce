package pageUIs.nopCommerce.admin;

public class AdminDashboardPageUI {
	public static final String ALL_ROW_TABLE = "xpath=//table[contains(@class, 'table')]//tbody//tr";
	public static final String LOADING_ICON = "xpath=//div[@id='ajaxBusy']";
	public static final String DASHBOARD_HEADER = "xpath=//div[@class='content-header']/h1[contains(text(), 'Dashboard')]";
	public static final String PRODUCT_NAME_TEXTBOX = "xpath=//input[@id='SearchProductName']";
	public static final String SEARCH_PRODUCT_BUTTON = "xpath=//button[@id='search-products']";
	public static final String SEARCH_CUSTOMER_BUTTON = "xpath=//button[@id='search-customers']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[contains(text(), '%s')]/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[contains(@class, 'table')]//tr[%s]//td[%s]";
	public static final String ICON_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[contains(@class, 'table')]//tr[%s]//td[%s]//i";
	public static final String HOME_LOGO = "xpath=//img[@class='brand-image-xl logo-xl']";
	public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='SearchCategoryId']";
	public static final String MANUFACTURER_DROPDOWN = "xpath=//select[@id='SearchManufacturerId']";
	public static final String SEARCH_SUB_CHECKBOX = "xpath=//input[@id='SearchIncludeSubCategories']";
	public static final String NO_DATA_TABLE_MESSAGE = "xpath=//tbody//tr[@class='odd']";
	public static final String GO_SKU_TEXTBOX = "xpath=//input[@id='GoDirectlyToSku']";
	public static final String GO_BUTTON = "xpath=//button[@id='go-to-product-by-sku']";
	public static final String ADD_NEW_BUTTON = "xpath=//a[contains(@href, 'Create')]";
	public static final String PARENT_ROLE_DROPDOWN = "xpath=//input[@aria-labelledby='SelectedCustomerRoleIds_label']";
	public static final String PARENT_ROLE_DROPDOWN_TEST = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']";
	public static final String CHILD_ROLE_DROPDOWN_TEST = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li";

	public static final String REMOVE_DEFAULT_ROLE = "xpath=//span[@aria-label='delete']";
	public static final String ALL_ROW = "xpath=//tbody//tr";

}
