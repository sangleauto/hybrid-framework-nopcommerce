package com.nopcommerce.user;

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

public class Level_16_Share_Data_A extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		email = Common_01_Register_End_User.email;
		password = Common_01_Register_End_User.password;

		log.info("Precondition - Step 01: Open Login page");
		loginPage = homePage.openLoginPage();

		log.info("Precondition - Step 02: Enter to Email textbox with value is: '" + email + "'");
		loginPage.enterEmailTextbox(email);

		log.info("Precondition - Step 03: Enter to Password textbox with value is: '" + password + "'");
		loginPage.enterPasswordTextbox(password);

		log.info("Precondition - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Relative_Product_Name() {

	}

	@Test
	public void Search_03_Absolute_Product_Name() {

	}

	@Test
	public void Search_04_Parent_Categories() {

	}

	@Test
	public void Search_05_Incorrect_Manufacturer() {

	}

	@Test
	public void Search_06_Correct_Manufacturer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String email, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

}
