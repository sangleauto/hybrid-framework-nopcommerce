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
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Nopcommerce_00_Template extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = Common_01_Register_End_User.email;
		password = Common_01_Register_End_User.password;
	}

	@Test
	public void Register_01_Empty_Data() {

	}

	@Test
	public void Register_02_Invalid_Email() {

	}

	@Test
	public void Register_03_Register_Successfully() {

	}

	@Test
	public void Register_04_Existed_Email() {

	}

	@Test
	public void Register_05_Password_Less_Than_6_Characters() {

	}

	@Test
	public void Register_06_Confirm_Password_Does_Not_Match() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
