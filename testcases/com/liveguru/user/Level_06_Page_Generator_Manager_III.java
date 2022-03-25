package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashBoardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {

	@Parameters("browser")
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = GetBrowserDriver(browserName);

		firstName = "Sang";
		lastName = "Le";
		email = "autotest" + generateRandomNumber() + "@gmail.com";
		password = "123123";

		homePage = PageGeneratorManager.getHomePageObject(driver);
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
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private MyDashBoardPageObject dashBoardPage;
	private RegisterPageObject registerPage;
}
