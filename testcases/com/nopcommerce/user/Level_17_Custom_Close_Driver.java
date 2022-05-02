package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Huy";
		lastName = "Le";
		email = "afc" + generateRandomNumber() + "@gmail.com";
		password = "123456";

		log.info("Precondition - Step 01: Open 'Register' page");
		registerPage = homePage.openRegisterPage();

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

		driver = null;
		log.info("Precondition - Step 08: Verify Register Success Message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Precondition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Precondition - Step 10: Open Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Precondition - Step 11: Enter to Email textbox with value is: '" + email + "'");
		loginPage.inputToEmailnameTextbox(email);

		log.info("Precondition - Step 12: Enter to Password textbox with value is: '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Precondition - Step 13: Click to Login button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void Search_01_Name() {

	}

	@Test
	public void Search_02_Address() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

}
