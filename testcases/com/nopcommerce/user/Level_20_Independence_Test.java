package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_20_Independence_Test extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, invalidEmail, notFoundEmail, correctPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);

		homePage = new UserHomePageObject(driver);
		firstName = "Sang";
		lastName = "Le";
		existingEmail = "afc" + generateRandomNumber() + "@gmail.com";
		invalidEmail = "sang@gmail@testing";
		notFoundEmail = "testing" + generateRandomNumber() + "@mail.vn";
		correctPassword = "123456";
		incorrectPassword = "123abc";

		homePage.openRegisterPage();
		// Click Register link => Nhay qua trang Register
		registerPage = new UserRegisterPageObject(driver);

		registerPage.enterToFirstnameTextbox(firstName);
		registerPage.enterToLastnameTextbox(lastName);
		registerPage.enterToEmailTextbox(existingEmail);
		registerPage.enterToPasswordTextbox(correctPassword);
		registerPage.enterToConfirmPasswordTextbox(correctPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

		driver.quit();
	}

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void BeforeMethod(String browserName, String url) {
		driver = GetBrowserDriver(browserName, url);

		homePage = new UserHomePageObject(driver);

		loginPage = homePage.openLoginPage();
	}

	@Test
	public void Login_01_Empty_Data() {

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageInEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {

		loginPage.enterEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageInEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {

		loginPage.enterEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email() {

		loginPage.enterEmailTextbox(existingEmail);
		loginPage.enterPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {

		loginPage.enterEmailTextbox(existingEmail);
		loginPage.enterPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {

		loginPage.enterEmailTextbox(existingEmail);
		loginPage.enterPasswordTextbox(correctPassword);

		loginPage.clickToLoginButton();

		// Tu trang Login => Login thanh cong => Qua trang HomePage
		homePage = new UserHomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
