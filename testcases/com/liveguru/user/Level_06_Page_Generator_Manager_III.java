package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManagerLiveGuru;
import pageObjects.liveGuru.user.UserHomePageObject;
import pageObjects.liveGuru.user.UserLoginPageObject;
import pageObjects.liveGuru.user.UserMyDashBoardPageObject;
import pageObjects.liveGuru.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {

	@Parameters("browser")
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = GetBrowserDriver(browserName);

		firstName = "Sang";
		lastName = "Le";
		email = "autotest" + generateRandomNumber() + "@gmail.com";
		password = "123123";

		homePage = PageGeneratorManagerLiveGuru.getUserHomePageObject(driver);
	}

	@Test
	public void User_01_Register_To_System() {
		loginPage = homePage.clickToMyAccountLink();

		registerPage = loginPage.clickToCreateAccountButton();

		registerPage.inputToFirstNameTextbox(firstName);

		registerPage.inputToLastNameTextbox(lastName);

		registerPage.inputToEmailTextbox(email);

		registerPage.inputToPasswordTextbox(password);

		registerPage.inputToConfirmPasswordTextbox(password);

		dashBoardPage = registerPage.clickToRegisterButton();

		homePage = dashBoardPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login_To_System() {
		loginPage = homePage.clickToMyAccountLink();

		loginPage.inputToEmailTextbox(email);

		loginPage.inputToPasswordTextbox(password);

		dashBoardPage = loginPage.clickToLoginButton();

		Assert.assertEquals(dashBoardPage.getPageTitle(), "MY DASHBOARD");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserMyDashBoardPageObject dashBoardPage;
	private UserRegisterPageObject registerPage;
}
