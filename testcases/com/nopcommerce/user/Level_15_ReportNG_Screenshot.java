package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_15_ReportNG_Screenshot extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);

		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Sang";
		lastName = "Le";
		email = "afc" + generateRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Open 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Enter to Firstname textbox with value is: '" + firstName + "'");
		registerPage.enterToFirstnameTextbox(firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is: '" + lastName + "'");
		registerPage.enterToLastnameTextbox(lastName);

		log.info("Register - Step 04: Enter to Email textbox with value is: '" + email + "'");
		registerPage.enterToEmailTextbox(email);

		log.info("Register - Step 05: Enter to Password textbox with value is: '" + password + "'");
		registerPage.enterToPasswordTextbox(password);

		log.info("Register - Step 06: Enter to Confirm password textbox with value is: '" + password + "'");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify Register Success Message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completedd");

	}

	@Test
	public void User_02_Login() {

		log.info("Login - Step 01: Navigate to Login page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is: '" + email + "'");
		loginPage.enterToEmailTextbox(email);

		log.info("Login - Step 03: Enter to Password textbox with value is: '" + password + "'");
		loginPage.enterToPasswordTextbox(password);

		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify Account link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Open My Account page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("Login - Step 07: Verify Customer Info is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

}
