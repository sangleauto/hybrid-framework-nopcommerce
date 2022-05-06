package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_02_Login {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, invalidEmail, notFoundEmail, correctPassword, incorrectPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass // Multiple browser
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		// Click vao link => Nhay qua trang HomePage
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

		registerPage.clickToLogoutLink();

		// Click vao link => Nhay qua trang HomePage
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.openLoginPage();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageInEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.enterToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageInEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.openLoginPage();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.enterToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email() {
		homePage.openLoginPage();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.enterToEmailTextbox(existingEmail);
		loginPage.enterToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.openLoginPage();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.enterToEmailTextbox(existingEmail);
		loginPage.enterToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageLoginWasUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.openLoginPage();

		// Tu trang Home => Click Login link => Qua trang Login
		loginPage = new UserLoginPageObject(driver);

		loginPage.enterToEmailTextbox(existingEmail);
		loginPage.enterToPasswordTextbox(correctPassword);

		loginPage.clickToLoginButton();

		// Tu trang Login => Login thanh cong => Qua trang HomePage
		homePage = new UserHomePageObject(driver);
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
