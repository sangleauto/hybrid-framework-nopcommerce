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
	public static final String PARENT_ROLE_DROPDOWN = "xpath=//input[@aria-labelledby='SelectedCustomerRoleIds_label']";
	public static final String ACTIVE_CHECKBOX = "xpath=//input[@id='Active']";
	public static final String ADMIN_COMMENT_TEXTAREA = "xpath=//textarea[@class='form-control']";
	public static final String SAVE_CONTINUE_BUTTON = "xpath=//button[@name='save-continue']";
	public static final String ADD_CUSTOMER_SUCCESS_MSG = "xpath=//div[contains(@class, 'alert-success')]";
	public static final String BACK_TO_CUSTOMER_LIST_LINK = "xpath=//a[text()='back to customer list']";
}
