package pageUIs.jquery;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVATED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[contains(@class, 'active') and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ALL_PAGINATIONS = "xpath=//ul[@class='qgrd-pagination-ul']//a";
	public static final String ALL_ROWS_PER_PAGE = "xpath=//tbody//tr";
	public static final String ALL_COUNTRIES_PER_PAGE = "xpath=//tbody//td[@data-key='country']";

}
