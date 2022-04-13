package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeTest(description = "Create new common User for all Class Tests")
	public void Register(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Sang";
		lastName = "Le";
		email = "afc" + generateRandomNumber() + "@gmail.com";
		password = "123456";

		log.info("Precondition - Step 01: Open 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Precondition - Step 02: Enter to Firstname textbox with value is: '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Precondition - Step 03: Enter to Lastname textbox with value is: '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Precondition - Step 04: Enter to Email textbox with value is: '" + email + "'");
		registerPage.inputToEmailnameTextbox(email);

		log.info("Precondition - Step 05: Enter to Password textbox with value is: '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Precondition - Step 06: Enter to Confirm password textbox with value is: '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Precondition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Precondition - Step 08: Verify Register Success Message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName;
	public static String email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
