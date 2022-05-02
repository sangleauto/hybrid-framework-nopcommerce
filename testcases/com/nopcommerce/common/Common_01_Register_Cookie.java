package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeTest(description = "Create new common User for all Class Tests")
	public void Register(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Sang";
		lastName = "Le";
		email = "afc" + generateRandomNumber() + "@gmail.com";
		password = "123456";

		log.info("Register - Step 01: Open 'Register' page");
		registerPage = homePage.clickToRegisterLink(driver);

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
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		loggedCookies = registerPage.getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookie at Common class: " + cookie);
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	public static Set<Cookie> loggedCookies;

}
