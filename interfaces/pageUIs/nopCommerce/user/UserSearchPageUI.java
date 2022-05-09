package pageUIs.nopCommerce.user;

public class UserSearchPageUI {
	public static final String SEARCH_BUTTON = "xpath=//button[@class='button-1 search-button']";
	public static final String SEARCH_KEYWORD_TEXTBOX = "xpath=//input[@class='search-text']";
	public static final String SEARCH_EMPTY_ERROR_MESSAGE = "xpath=//div[@class='search-results']//div[@class='warning']";
	public static final String SEARCH_NO_RESULT_ERROR_MESSAGE = "xpath=//div[@class='no-result']";
	public static final String PRODUCT_NAME = "xpath=//h2[@class='product-title']";
	public static final String ADVANCED_SEACH_CHECKBOX = "xpath=//label[text()='Advanced search']/preceding-sibling::input";
	public static final String CATEGORY_DROPDOWN = "xpath=//label[text()='Category:']/following-sibling::select";
	public static final String MANUFACTURER_DROPDOWN = "xpath=//label[text()='Manufacturer:']/following-sibling::select";
	public static final String SUB_CATEGORIES_SEACH_CHECKBOX = "xpath=//label[contains(text(), 'categories')]/preceding-sibling::input";

}
