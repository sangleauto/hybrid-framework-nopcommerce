package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass // Multiple browser
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		firstName = "Sang";
		lastName = "Le";
		emailAddress = "afc" + generateRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		// Click Register link => Nhay qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_01 - Step 2: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 3: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		// Click Register link => Nhay qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_02 - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailnameTextbox("123@sangle#456");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02 - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Register_Successfully() {
		System.out.println("Register_03 - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		// Click Register link => Nhay qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_03 - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailnameTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03 - Step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register_03 - Step 5: Click to Logout Link");
		registerPage.clickToLogoutLink();

		// Click Logout thì business sẽ quay về trang Homepage
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		// Click Register link => Nhay qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_04 - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailnameTextbox("existedemail213@gmail.com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Step 4: Verify Error Existing Email Message");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		// Click Register link => Nhay qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_05 - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailnameTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register_05 - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();
		// Click Register link => Nhay qua trang Register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_06 - Step 2: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailnameTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123abc");

		System.out.println("Register_06 - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
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
