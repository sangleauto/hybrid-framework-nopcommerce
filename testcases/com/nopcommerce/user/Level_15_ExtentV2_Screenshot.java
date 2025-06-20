package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
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

public class Level_15_ExtentV2_Screenshot extends BaseTest {

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
	public void User_01_Register(Method method) {
		// ExtentTestManager.startTest(method.getName(), "User_01_Register");
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Open 'Register' page");
		// registerPage = homePage.openRegisterPage();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is: '" + firstName + "'");
		// registerPage.inputToFirstnameTextbox(firstName);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is: '" + lastName + "'");
		// registerPage.inputToLastnameTextbox(lastName);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is: '" + email + "'");
		// registerPage.inputToEmailnameTextbox(email);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is: '" + password + "'");
		// registerPage.inputToPasswordTextbox(password);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm password textbox with value is: '" + password +
		// "'");
		// registerPage.inputToConfirmPasswordTextbox(password);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
		// registerPage.clickToRegisterButton();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify Register Success Message is displayed");
		// Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completedd");
		// ExtentTestManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		// ExtentTestManager.startTest(method.getName(), "User_02_Login");
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login page");
		// homePage = registerPage.clickToLogoutLink();
		// loginPage = homePage.openLoginPage();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is: '" + email + "'");
		// loginPage.inputToEmailnameTextbox(email);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is: '" + password + "'");
		// loginPage.inputToPasswordTextbox(password);
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to Login button");
		// homePage = loginPage.clickToLoginButton();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify Account link is displayed");
		// Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 06: Open My Account page");
		// customerInfoPage = homePage.openMyAccountPage();
		//
		// ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify Customer Info is displayed");
		// Assert.assertFalse(customerInfoPage.isCustomerInfoDisplayed());
		// ExtentTestManager.endTest();
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
