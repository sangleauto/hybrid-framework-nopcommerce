package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGeneratorManagerLiveGuru;
import pageObjects.liveGuru.admin.AdminDashboardPageObject;
import pageObjects.liveGuru.admin.AdminLoginPageObject;
import pageObjects.liveGuru.user.UserHomePageObject;
import pageObjects.liveGuru.user.UserLoginPageObject;
import pageObjects.liveGuru.user.UserMyDashBoardPageObject;
import pageObjects.liveGuru.user.UserRegisterPageObject;

public class Data_Table_Data_Grid extends BaseTest {

	@Parameters("browser")
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = GetBrowserDriver(browserName, GlobalConstant.USER_PAGE_URL_LIVEGURU);

		firstName = "Huy";
		lastName = "Le";
		fullName = firstName + " " + lastName;
		email = "autotest" + generateRandomNumber() + "@gmail.com";
		passwordUser = "123123";
		userNameAdmin = "user01";
		passwordAdmin = "guru99com";

		userHomePage = PageGeneratorManagerLiveGuru.getUserHomePageObject(driver);
	}

	@Test
	public void User_01_RegisterTo_System() {
		userLoginPage = userHomePage.clickToMyAccountLink();

		userRegisterPage = userLoginPage.clickToCreateAccountButton();

		userRegisterPage.inputToFirstNameTextbox(firstName);

		userRegisterPage.inputToLastNameTextbox(lastName);

		userRegisterPage.inputToEmailTextbox(email);

		userRegisterPage.inputToPasswordTextbox(passwordUser);

		userRegisterPage.inputToConfirmPasswordTextbox(passwordUser);

		userDashBoardPage = userRegisterPage.clickToRegisterButton();

		userHomePage = userDashBoardPage.clickToLogoutLink();

		// userLoginPage = userHomePage.clickToMyAccountLink();
		//
		// userLoginPage.inputToEmailTextbox(email);
		//
		// userLoginPage.inputToPasswordTextbox(password);
		//
		// userDashBoardPage = userLoginPage.clickToLoginButton();
		//
		// Assert.assertEquals(userDashBoardPage.getPageTitle(), "MY DASHBOARD");

	}

	@Test
	public void User_02_Login_To_System() {
		userHomePage.openPageURL(driver, GlobalConstant.ADMIN_PAGE_URL_LIVEGURU);
		adminLoginPage = PageGeneratorManagerLiveGuru.getAdminLoginPageObject(driver);

		adminLoginPage.inputToUserNameTextbox(userNameAdmin);
		adminLoginPage.inputToPasswordTextbox(passwordAdmin);
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void User_03_Verify_Data_Table() {
		adminDashboardPage.closePopupButton();
		adminDashboardPage.inputToEmail("email", "2", email);
		adminDashboardPage.clickToSearchButton();

		Assert.assertTrue(adminDashboardPage.showInfo(fullName, email));

		adminDashboardPage.selectDeleteInfo("Delete");

		adminDashboardPage.checkToCheckBoxAndSubmit();

		Assert.assertTrue(adminDashboardPage.isCustomerDeleted());
	}

	@Test
	public void User_04_Verify_Can_Not_Login_After_Deleted() {
		adminDashboardPage.openPageURL(driver, GlobalConstant.USER_PAGE_URL_LIVEGURU);
		userHomePage = PageGeneratorManagerLiveGuru.getUserHomePageObject(driver);
		userLoginPage = userHomePage.clickToMyAccountLink();

		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(passwordUser);
		userLoginPage.clickToLoginButton();

		Assert.assertTrue(userLoginPage.showLoginErrorMsg());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, fullName, email, passwordUser, userNameAdmin, passwordAdmin;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserMyDashBoardPageObject userDashBoardPage;
	private UserRegisterPageObject userRegisterPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
}
