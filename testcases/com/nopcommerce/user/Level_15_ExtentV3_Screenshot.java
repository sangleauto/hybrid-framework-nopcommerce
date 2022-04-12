package com.nopcommerce.user;

import java.lang.reflect.Method;

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

public class Level_15_ExtentV3_Screenshot extends BaseTest {

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
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);

		registerPage.inputToLastnameTextbox(lastName);

		registerPage.inputToEmailnameTextbox(email);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completedd");
	}

	@Test
	public void User_02_Login(Method method) {
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailnameTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();

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
