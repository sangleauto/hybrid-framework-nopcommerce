package pageUIs.nopCommerce.admin;

public class AdminCustomerInfoPageUI {
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String GENDER_RADIO_BY_NAME = "xpath=//label[contains(text(), '%s')]/preceding-sibling::input";
	public static final String DOB_TEXTBOX = "xpath=//input[@id='DateOfBirth']";
	public static final String COMPANY_NAME_TEXTBOX = "xpath=//input[@id='Company']";
	public static final String REMOVE_DEFAULT_ROLE = "xpath=//span[@aria-label='delete']";
	public static final String DEFAULT_ROLE = "xpath=//span[text()='Registered']";
	public static final String PARENT_ROLE_DROPDOWN = "xpath=//input[@aria-labelledby='SelectedCustomerRoleIds_label']";
	public static final String ACTIVE_CHECKBOX = "xpath=//input[@id='Active']";
	public static final String ADMIN_COMMENT_TEXTAREA = "xpath=//textarea[@class='form-control']";
	public static final String SAVE_CONTINUE_BUTTON = "xpath=//button[@name='save-continue']";
	public static final String SAVE_BUTTON = "xpath=//button[@name='save']";
	public static final String ADD_CUSTOMER_SUCCESS_MSG = "xpath=//div[contains(@class, 'alert-success')]";
	public static final String BACK_TO_CUSTOMER_LIST_LINK = "xpath=//a[text()='back to customer list']";
	public static final String CUSTOMER_ROLE = "xpath=//label[text()='Customer roles']//ancestor::div[@class='col-md-3']//following-sibling::div//div[@class='input-group']";
	public static final String ADDRESS_TAB = "xpath=//div[@id='customer-address']";
	public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//button[contains(text(), 'Add new address')]";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[contains(text(), '%s')]/preceding-sibling::th";
	public static final String TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX = "xpath=//div[@id='customer-addresses-grid_wrapper']//tr[%s]//td[%s]";
	public static final String EDIT_ADDRESS_BUTTON = "xpath=//a[text()='Edit']";
	public static final String DELETE_ADDRESS_BUTTON = "xpath=//a[text()='Delete']";
	public static final String NO_DATA_TABLE_MESSAGE = "xpath=//div[@id='customer-address']//td[@class='dataTables_empty']";
}
