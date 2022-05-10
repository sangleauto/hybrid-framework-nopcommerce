package pageUIs.nopCommerce.user;

public class UserNotebookPageUI {
	public static final String SORT_DROPDOWN = "xpath=//select[@id='products-orderby']";
	public static final String DISPLAY_DROPDOWN = "xpath=//select[@id='products-pagesize']";
	public static final String PRODUCT_NAME = "xpath=//div[@class='products-container']//h2[@class='product-title']";
	public static final String PRODUCT_PRICE = "xpath=//div[@class='products-container']//div[@class='prices']//span";
	public static final String PAGINATION = "xpath=//div[@class='pager']";
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//div[@class='pager']//a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVATED_BY_NUMBER = "xpath=//div[@class='pager']//li[@class='current-page']/span[text()='%s']";
	public static final String PAGINATION_PREVIOUS_PAGE_ICON = "xpath=//div[@class='pager']//li[@class='previous-page']";
	public static final String PAGINATION_NEXT_PAGE_ICON = "xpath=//div[@class='pager']//li[@class='next-page']";
	public static final String LOADING_PRODUCT = "xpath=//div[@class='ajax-products-busy']";

}
