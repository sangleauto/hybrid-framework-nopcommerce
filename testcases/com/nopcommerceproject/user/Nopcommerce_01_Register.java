package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import ultilities.DataUtil;

public class Nopcommerce_01_Register extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		faker = DataUtil.getData();

		firstName = faker.getFirstName();
		lastName = faker.getLastName();
		email = faker.getEmailAddress();
		secondEmail = faker.getEmailAddress();
		password = faker.getPassword();
		invalidEmail = "john@cena@123";
		passwordLessThanSixChars = "12345";
		invalidConfirmPassword = "123abc";

		log.info("Precondition - Step 01: Open Register page");
		registerPage = homePage.clickToRegisterLink(driver);

	}

	@Test
	public void Register_01_Empty_Data() {

		log.info("Register Empty Data - Step 01: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register Empty Data - Step 02: Verify error message in First Name textbox");
		verifyEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");

		log.info("Register Empty Data - Step 03: Verify error message in Last Name textbox");
		verifyEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");

		log.info("Register Empty Data - Step 04: Verify error message in Email textbox");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");

		log.info("Register Empty Data - Step 05: Verify error message in Password textbox");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");

		log.info("Register Empty Data - Step 06: Verify error message in Confirm Password textbox");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {

		log.info("Register Invalid Email - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Register Invalid Email - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Register Invalid Email - Step 03: Enter invalid email to Email textbox");
		registerPage.enterToEmailTextbox(invalidEmail);

		log.info("Register Invalid Email - Step 04: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);

		log.info("Register Invalid Email - Step 05: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register Invalid Email - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register Invalid Email - Step 07: Verify error message in Email textbox");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Register_Successfully() {

		log.info("Register Successfully - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Register Successfully - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Register Successfully - Step 03: Enter to Email textbox");
		registerPage.enterToEmailTextbox(email);

		log.info("Register Successfully - Step 04: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);

		log.info("Register Successfully - Step 05: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register Successfully - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register Successfully - Step 07: Verify Register success message");
		verifyEquals(registerPage.getVerifySuccessMessage(), "Your registration completed");

		log.info("Register Successfully - Step 08: Click to Logout link");
		homePage = registerPage.clickToLogoutLinkAtUserPage(driver);

	}

	@Test
	public void Register_04_Existed_Email() {
		log.info("Register With Existed Email - Step 01: Open Register page");
		registerPage = homePage.clickToRegisterLink(driver);

		log.info("Register With Existed Email - Step 02: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Register With Existed Email - Step 03: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Register With Existed Email- Step 04: Enter existed Email to Email textbox");
		registerPage.enterToEmailTextbox(email);

		log.info("Register With Existed Email- Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);

		log.info("Register With Existed Email- Step 06: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register With Existed Email - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register With Existed Email - Step 08: Verify Error message after clicking Register button");
		verifyEquals(registerPage.getRegisterErrorMessage(), "The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Characters() {

		log.info("Register With Less Than 6 Characters Password - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Register With Less Than 6 Characters Password - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Register With Less Than 6 Characters Password - Step 03: Enter to Email textbox");
		registerPage.enterToEmailTextbox(secondEmail);

		log.info("Register With Less Than 6 Characters Password - Step 04: Enter invalid Password to Password textbox");
		registerPage.enterToPasswordTextbox(passwordLessThanSixChars);

		log.info("Register With Less Than 6 Characters Password - Step 05: Enter to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(passwordLessThanSixChars);

		log.info("Register With Less Than 6 Characters Password - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register With Less Than 6 Characters Password - Step 07: Verify Error message in Password textbox");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Confirm_Password_Does_Not_Match() {

		log.info("Register With Not Matched Confirm Password - Step 01: Enter to First name textbox");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Register With Not Matched Confirm Password - Step 02: Enter to Last name textbox");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Register With Not Matched Confirm Password - Step 03: Enter to Email textbox");
		registerPage.enterToEmailTextbox(secondEmail);

		log.info("Register With Not Matched Confirm Password - Step 04: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);

		log.info("Register With Not Matched Confirm Password - Step 05: Enter invalid Confirm password to Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox(invalidConfirmPassword);

		log.info("Register With Not Matched Confirm Password - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register With Not Matched Confirm Password - Step 07: Verify Error message in Confirm password textbox");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private DataUtil faker;
	private String firstName, lastName, email, secondEmail, password, invalidEmail, passwordLessThanSixChars, invalidConfirmPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
