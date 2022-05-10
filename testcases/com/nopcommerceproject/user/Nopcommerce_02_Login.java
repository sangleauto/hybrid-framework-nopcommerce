package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Nopcommerce_02_Login extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = Common_01_Register_End_User.email;
		password = Common_01_Register_End_User.password;
		wrongEmail = "abc123";
		wrongPassword = "pass123";
		unregisteredEmail = "autotesting@gmail.com";
		loginEmptyDataMsg = "Please enter your email";
		loginInvalidEmailMsg = "Wrong email";
		loginUnregisteredEmailMsg = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
		loginInvalidPasswordMsg = "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect";

		log.info("Precondition - Step 01: Open Log in page");
		loginPage = homePage.clickToLoginLink(driver);
	}

	@Test
	public void Login_01_Empty_Data() {

		log.info("Login With Empty Data - Step 01: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Empty Data - Step 02: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageInEmailTextbox(), loginEmptyDataMsg);
	}

	@Test
	public void Login_02_Invalid_Email() {

		log.info("Login With Invalid Email - Step 01: Enter Invalid Email to Email textbox");
		loginPage.enterEmailTextbox(wrongEmail);

		log.info("Login With Invalid Email - Step 02: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Invalid Email - Step 03: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageInEmailTextbox(), loginInvalidEmailMsg);

	}

	@Test
	public void Login_03_Unregistered_Email() {

		log.info("Login With Unregistered Email - Step 01: Enter Unregistered Email to Email textbox");
		loginPage.enterEmailTextbox(unregisteredEmail);

		log.info("Login With Unregistered Email - Step 02: Enter Password to Password textbox");
		loginPage.enterPasswordTextbox(password);

		log.info("Login With Unregistered Email - Step 03: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Unregistered Email - Step 04: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), loginUnregisteredEmailMsg);
	}

	@Test
	public void Login_04_Empty_Password() {

		log.info("Login With Empty Password - Step 01: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(email);

		log.info("Login With Empty Password - Step 02: Enter Empty Password to Password textbox");
		loginPage.enterPasswordTextbox("");

		log.info("Login With Empty Password - Step 03: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Empty Password - Step 04: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), loginInvalidPasswordMsg);
	}

	@Test
	public void Login_05_Wrong_Password() {

		log.info("Login With Wrong Password - Step 01: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(email);

		log.info("Login With Wrong Password - Step 02: Enter Wrong Password to Password textbox");
		loginPage.enterPasswordTextbox(wrongPassword);

		log.info("Login With Wrong Password - Step 03: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Wrong Password - Step 04: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Correct_Info() {

		log.info("Login With Wrong Password - Step 01: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(email);

		log.info("Login With Wrong Password - Step 02: Enter Password to Password textbox");
		loginPage.enterPasswordTextbox(password);

		log.info("Login With Wrong Password - Step 03: Click to LOG IN button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login With Wrong Password - Step 04: Verify My account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String email, password, wrongEmail, unregisteredEmail, wrongPassword;
	private String loginEmptyDataMsg, loginInvalidEmailMsg, loginUnregisteredEmailMsg, loginInvalidPasswordMsg;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

}
