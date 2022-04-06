package pageUIs.jquery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVATED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[contains(@class, 'active') and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ALL_PAGINATIONS = "xpath=//ul[@class='qgrd-pagination-ul']//a";
	public static final String ALL_ROWS_PER_PAGE = "xpath=//tbody//tr";
	public static final String ALL_COUNTRIES_PER_PAGE = "xpath=//tbody//td[@data-key='country']";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String LOAD_DATA_BUTTON = "Css=#btnLoad .ui-button-text";
	public static final String CHECKBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String ICON_NAME_BY_ROW_INDEX = "xpath=//tbody/tr[%s]/td[8]/button[@title='%s']";
}
