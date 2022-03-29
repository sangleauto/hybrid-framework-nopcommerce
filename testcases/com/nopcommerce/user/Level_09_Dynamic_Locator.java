package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {

	@Parameters("browser")
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName) {
		driver = GetBrowserDriver(browserName);

		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Sang";
		lastName = "Le";
		email = "afc" + generateRandomNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void User_01_Register_Login() {
		// Register
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailnameTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

		// Login
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailnameTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoDisplayed());
	}

	// @Test
	public void User_02_Switch_Page() {
		// Customer Info -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		// My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		// Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		// My Product Review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);

	}

	// @Test
	public void User_03_Dynamic_Page_01() {
		// Customer Info -> Address
		addressPage = (UserAddressPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Addresses");
		// Address -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPagesAtMyAccountByName(driver, "My product reviews");
		// My Product Review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
		// Reward Point -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
		// Address -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");
		// Reward Point -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
		// My Product Review -> Address
		addressPage = (UserAddressPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Addresses");
	}

	@Test
	public void User_03_Dynamic_Page_02() {
		// Customer Info -> Address
		customerInfoPage.openPagesAtMyAccountByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

		// Address -> My Product Review
		addressPage.openPagesAtMyAccountByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// My Product Review -> Reward Point
		myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		// Reward Point -> Address
		rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

		// Address -> Reward Point
		addressPage.openPagesAtMyAccountByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		// Reward Point -> My Product Review
		rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// My Product Review -> Address
		myProductReviewPage.openPagesAtMyAccountByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

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
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
}
