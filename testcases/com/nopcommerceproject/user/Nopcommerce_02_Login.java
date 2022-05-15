package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataTest_02_Login;

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

		log.info("Precondition - Step 01: Open Log in page");
		loginPage = homePage.clickToLoginLink(driver);
	}

	@Test
	public void Login_01_Empty_Data() {

		log.info("Login With Empty Data - Step 01: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Empty Data - Step 02: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageInEmailTextbox(), DataTest_02_Login.LoginMessage.LOGIN_EMPTY_DATA_MSG);
	}

	@Test
	public void Login_02_Invalid_Email() {

		log.info("Login With Invalid Email - Step 01: Enter Invalid Email to Email textbox");
		loginPage.enterEmailTextbox(DataTest_02_Login.LoginInfo.WRONG_EMAIL);

		log.info("Login With Invalid Email - Step 02: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Invalid Email - Step 03: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageInEmailTextbox(), DataTest_02_Login.LoginMessage.LOGIN_INVALID_EMAIL_MSG);

	}

	@Test
	public void Login_03_Unregistered_Email() {

		log.info("Login With Unregistered Email - Step 01: Enter Unregistered Email to Email textbox");
		loginPage.enterEmailTextbox(DataTest_02_Login.LoginInfo.UNREGISTERED_EMAIL);

		log.info("Login With Unregistered Email - Step 02: Enter Password to Password textbox");
		loginPage.enterPasswordTextbox(DataTest_02_Login.LoginInfo.PASSWORD);

		log.info("Login With Unregistered Email - Step 03: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Unregistered Email - Step 04: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), DataTest_02_Login.LoginMessage.LOGIN_UNREGISTERED_EMAIL_MSG);
	}

	@Test
	public void Login_04_Empty_Password() {

		log.info("Login With Empty Password - Step 01: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(DataTest_02_Login.LoginInfo.EMAIL);

		log.info("Login With Empty Password - Step 02: Enter Empty Password to Password textbox");
		loginPage.enterPasswordTextbox("");

		log.info("Login With Empty Password - Step 03: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Empty Password - Step 04: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), DataTest_02_Login.LoginMessage.LOGIN_INVALID_PASSWORD_MSG);
	}

	@Test
	public void Login_05_Wrong_Password() {

		log.info("Login With Wrong Password - Step 01: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(DataTest_02_Login.LoginInfo.EMAIL);

		log.info("Login With Wrong Password - Step 02: Enter Wrong Password to Password textbox");
		loginPage.enterPasswordTextbox(DataTest_02_Login.LoginInfo.WRONG_PASSWORD);

		log.info("Login With Wrong Password - Step 03: Click to LOG IN button");
		loginPage.clickToLoginButton();

		log.info("Login With Wrong Password - Step 04: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), DataTest_02_Login.LoginMessage.LOGIN_INVALID_PASSWORD_MSG);
	}

	@Test
	public void Login_06_Correct_Info() {

		log.info("Login With Wrong Password - Step 01: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(DataTest_02_Login.LoginInfo.EMAIL);

		log.info("Login With Wrong Password - Step 02: Enter Password to Password textbox");
		loginPage.enterPasswordTextbox(DataTest_02_Login.LoginInfo.PASSWORD);

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
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

}
