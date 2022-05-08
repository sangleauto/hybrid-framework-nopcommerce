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

public class Level_06_Page_Generator_Manager_III extends BaseTest {

	@Parameters("browser")
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = GetBrowserDriver(browserName);

		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Sang";
		lastName = "Le";
		existingEmail = "afc" + generateRandomNumber() + "@gmail.com";
		invalidEmail = "sang@gmail@testing";
		notFoundEmail = "testing" + generateRandomNumber() + "@mail.vn";
		correctPassword = "123456";
		incorrectPassword = "123abc";

		// 2
		registerPage = homePage.openRegisterPage();

		registerPage.enterToFirstnameTextbox(firstName);
		registerPage.enterToLastnameTextbox(lastName);
		registerPage.enterToEmailTextbox(existingEmail);
		registerPage.enterToPasswordTextbox(correctPassword);
		registerPage.enterToConfirmPasswordTextbox(correctPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// 3
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {

		// 4
		loginPage = homePage.openLoginPage();

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageInEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {

		// 5
		loginPage = homePage.openLoginPage();

		loginPage.enterEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageInEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {

		// 6
		loginPage = homePage.openLoginPage();

		loginPage.enterEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email() {

		// 7
		loginPage = homePage.openLoginPage();

		loginPage.enterEmailTextbox(existingEmail);
		loginPage.enterPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {

		// 8
		loginPage = homePage.openLoginPage();

		loginPage.enterEmailTextbox(existingEmail);
		loginPage.enterPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {

		// 9
		loginPage = homePage.openLoginPage();

		loginPage.enterEmailTextbox(existingEmail);
		loginPage.enterPasswordTextbox(correctPassword);

		// 10
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, existingEmail, invalidEmail, notFoundEmail, correctPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
}
