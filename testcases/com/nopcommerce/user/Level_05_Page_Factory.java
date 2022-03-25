package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

public class Level_05_Page_Factory extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, invalidEmail, notFoundEmail, correctPassword, incorrectPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = GetBrowserDriver(browserName);

		homePage = new HomePageObject(driver);

		firstName = "Sang";
		lastName = "Le";
		existingEmail = "afc" + generateRandomNumber() + "@gmail.com";
		invalidEmail = "sang@gmail@testing";
		notFoundEmail = "testing" + generateRandomNumber() + "@mail.vn";
		correctPassword = "123456";
		incorrectPassword = "123abc";

		homePage.clickToRegisterLink();
		// Click Register link => Nhay qua trang Register
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailnameTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(correctPassword);
		registerPage.inputToConfirmPasswordTextbox(correctPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.clickToLogoutLink();

		// Click vao link => Nhay qua trang HomePage
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailnameTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailnameTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email() {
		homePage.clickToLoginLink();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailnameTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailnameTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailnameTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(correctPassword);

		loginPage.clickToLoginButton();

		// Tu trang Login => Login thanh cong => Qua trang HomePage
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
