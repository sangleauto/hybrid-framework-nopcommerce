package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import ultilities.DataUtil;

public class Common_01_Register_End_User extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeTest(description = "Create new common User for all Class Tests")
	public void Register(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		faker = DataUtil.getData();

		firstName = faker.getFirstName();
		lastName = faker.getLastName();
		fullName = firstName + " " + lastName;
		email = faker.getEmailAddress();
		password = "123456";

		log.info("Precondition - Step 01: Open 'Register' page");
		registerPage = homePage.clickToRegisterLink(driver);

		log.info("Precondition - Step 02: Enter to Firstname textbox with value is: '" + firstName + "'");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Precondition - Step 03: Enter to Lastname textbox with value is: '" + lastName + "'");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Precondition - Step 04: Enter to Email textbox with value is: '" + email + "'");
		registerPage.enterToEmailTextbox(email);

		log.info("Precondition - Step 05: Enter to Password textbox with value is: '" + password + "'");
		registerPage.enterToPasswordTextbox(password);

		log.info("Precondition - Step 06: Enter to Confirm password textbox with value is: '" + password + "'");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Precondition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Precondition - Step 08: Verify Register Success Message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		driver.quit();
	}

	private WebDriver driver;
	private DataUtil faker;
	public static String firstName, lastName, fullName;
	public static String email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
