package pageUIs.hrm;

public class BasePageHrmUI {
	public static final String MENU_PAGE_BY_NAME = "xpath=//div[@id='mainMenu']//b[text()='%s']";
	public static final String SUB_AND_CHILDSUB_MENU_PAGE_BY_NAME = "xpath=//div[@id='mainMenu']//a[text()='%s']";
	public static final String BUTTON_BY_ID = "xpath=//input[@id='%s']";
	public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String CHECKBOX_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::input";
	public static final String RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
	public static final String COLUMN_INDEX_BY_ID = "xpath=//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//table[@id='%s']//tbody//tr[%s]//td[%s]";

	public static final String WELCOME_LINK = "xpath=//a[@id='welcome']";
	public static final String LOGOUT_LINK = "xpath=//a[text()='Logout']";

}
