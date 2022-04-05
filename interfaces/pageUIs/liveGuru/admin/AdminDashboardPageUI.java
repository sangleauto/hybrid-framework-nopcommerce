package pageUIs.liveGuru.admin;

public class AdminDashboardPageUI {
	public static final String CLOSE_POPUP_BUTTON = "xpath=//div[@class='message-popup-head']/a";
	public static final String EMAIL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//thead//tr[%s]//th[%s]//input";
	public static final String NAME_AND_EMAIL_INFO = "xpath=//tbody//td[contains(text(), '%s')]//following-sibling::td[contains(text(), '%s')]";
	public static final String SEARCH_BUTTON = "xpath=//button[@title='Search']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//a[@name='%s']/ancestor::th/preceding-sibling::th";
	public static final String DROPDOWN = "xpath=//select[@id='customerGrid_massaction-select']";
	public static final String CHECKBOX = "xpath=//input[@type='checkbox']";
	public static final String SUBMIT_BUTTON = "xpath=//span[text()='Submit']";
	public static final String DELETE_MESSAGE = "xpath=//span[text()='Total of 1 record(s) were deleted.']";

}
