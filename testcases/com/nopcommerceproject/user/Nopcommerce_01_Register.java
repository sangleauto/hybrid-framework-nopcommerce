package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataTest_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Nopcommerce_01_Register extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Precondition - Step 01: Open Register page");
		registerPage = homePage.clickToRegisterLink(driver);

	}

	@Test
	public void Register_01_Empty_Data() {

		log.info("Register Empty Data - Step 01: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register Empty Data - Step 02: Verify error message in First Name textbox");
		verifyEquals(registerPage.getErrorMessageAtFirstNameTextbox(), DataTest_01_Register.RegisterMessage.FIRST_NAME_ERROR_MSG);

		log.info("Register Empty Data - Step 03: Verify error message in Last Name textbox");
		verifyEquals(registerPage.getErrorMessageAtLastNameTextbox(), DataTest_01_Register.RegisterMessage.LAST_NAME_ERROR_MSG);

		log.info("Register Empty Data - Step 04: Verify error message in Email textbox");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), DataTest_01_Register.RegisterMessage.EMAIL_ERROR_MSG);

		log.info("Register Empty Data - Step 05: Verify error message in Password textbox");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), DataTest_01_Register.RegisterMessage.PASSWORD_ERROR_MSG);

		log.info("Register Empty Data - Step 06: Verify error message in Confirm Password textbox");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), DataTest_01_Register.RegisterMessage.PASSWORD_ERROR_MSG);

	}

	@Test
	public void Register_02_Invalid_Email() {

		log.info("Register Invalid Email - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(DataTest_01_Register.RegisterInfo.FIRSTNAME);

		log.info("Register Invalid Email - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(DataTest_01_Register.RegisterInfo.LASTNAME);

		log.info("Register Invalid Email - Step 03: Enter invalid email to Email textbox");
		registerPage.enterToEmailTextbox(DataTest_01_Register.RegisterInfo.INVALID_EMAIL);

		log.info("Register Invalid Email - Step 04: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD);

		log.info("Register Invalid Email - Step 05: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD);

		log.info("Register Invalid Email - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register Invalid Email - Step 07: Verify error message in Email textbox");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), DataTest_01_Register.RegisterMessage.INVALID_EMAIL_ERROR_MSG);
	}

	@Test
	public void Register_03_Register_Successfully() {

		log.info("Register Successfully - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(DataTest_01_Register.RegisterInfo.FIRSTNAME);

		log.info("Register Successfully - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(DataTest_01_Register.RegisterInfo.LASTNAME);

		log.info("Register Successfully - Step 03: Enter to Email textbox");
		registerPage.enterToEmailTextbox(DataTest_01_Register.RegisterInfo.EMAIL);

		log.info("Register Successfully - Step 04: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD);

		log.info("Register Successfully - Step 05: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD);

		log.info("Register Successfully - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register Successfully - Step 07: Verify Register success message");
		verifyEquals(registerPage.getVerifySuccessMessage(), DataTest_01_Register.RegisterMessage.REGISTER_SUCCESS_MSG);

		log.info("Register Successfully - Step 08: Click to Logout link");
		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);

	}

	@Test
	public void Register_04_Existed_Email() {
		log.info("Register With Existed Email - Step 01: Open Register page");
		registerPage = homePage.clickToRegisterLink(driver);

		log.info("Register With Existed Email - Step 02: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(DataTest_01_Register.RegisterInfo.FIRSTNAME);

		log.info("Register With Existed Email - Step 03: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(DataTest_01_Register.RegisterInfo.LASTNAME);

		log.info("Register With Existed Email- Step 04: Enter existed Email to Email textbox");
		registerPage.enterToEmailTextbox(DataTest_01_Register.RegisterInfo.EMAIL);

		log.info("Register With Existed Email- Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD);

		log.info("Register With Existed Email- Step 06: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD);

		log.info("Register With Existed Email - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register With Existed Email - Step 08: Verify Error message after clicking Register button");
		verifyEquals(registerPage.getRegisterErrorMessage(), DataTest_01_Register.RegisterMessage.EXISTED_EMAIL_ERROR_MSG);

	}

	@Test
	public void Register_05_Password_Less_Than_6_Characters() {

		log.info("Register With Less Than 6 Characters Password - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(DataTest_01_Register.RegisterInfo.FIRSTNAME);

		log.info("Register With Less Than 6 Characters Password - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(DataTest_01_Register.RegisterInfo.LASTNAME);

		log.info("Register With Less Than 6 Characters Password - Step 03: Enter to Email textbox");
		registerPage.enterToEmailTextbox(DataTest_01_Register.RegisterInfo.SECOND_EMAIL);

		log.info("Register With Less Than 6 Characters Password - Step 04: Enter invalid Password to Password textbox");
		registerPage.enterToPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD_LESS_THAN_6_CHARS);

		log.info("Register With Less Than 6 Characters Password - Step 05: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD_LESS_THAN_6_CHARS);

		log.info("Register With Less Than 6 Characters Password - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register With Less Than 6 Characters Password - Step 07: Verify Error message in Password textbox");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), DataTest_01_Register.RegisterMessage.PASSWORD_LESS_THAN_6_Chars_ERROR_MSG);
	}

	@Test
	public void Register_06_Confirm_Password_Does_Not_Match() {

		log.info("Register With Not Matched Confirm Password - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(DataTest_01_Register.RegisterInfo.FIRSTNAME);

		log.info("Register With Not Matched Confirm Password - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(DataTest_01_Register.RegisterInfo.LASTNAME);

		log.info("Register With Not Matched Confirm Password - Step 03: Enter to Email textbox");
		registerPage.enterToEmailTextbox(DataTest_01_Register.RegisterInfo.SECOND_EMAIL);

		log.info("Register With Not Matched Confirm Password - Step 04: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(DataTest_01_Register.RegisterInfo.PASSWORD);

		log.info("Register With Not Matched Confirm Password - Step 05: Enter invalid Confirm password to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(DataTest_01_Register.RegisterInfo.INVALID_CONFIRM_PASSWORD);

		log.info("Register With Not Matched Confirm Password - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register With Not Matched Confirm Password - Step 07: Verify Error message in Confirm password textbox");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), DataTest_01_Register.RegisterMessage.CONFIRM_PASSWORD_NOT_MATCHED_ERROR_MSG);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
