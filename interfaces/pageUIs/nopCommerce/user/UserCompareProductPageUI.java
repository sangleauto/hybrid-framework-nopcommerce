package pageUIs.nopCommerce.user;

public class UserCompareProductPageUI {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@class='compare-products-table']//tr[%s]//td[%s]";
	public static final String CLEAN_LIST_BUTTON = "xpath=//a[@class='clear-list']";
	public static final String COMPARE_EMPTY_MESSAGE = "xpath=//div[@class='no-data']";
	public static final String TABLE_PRODUCT_COMPARISON = "xpath=//table[@class='compare-products-table']";

}
