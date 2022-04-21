package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_18_Pattern_Object extends BaseTest {

	/*
	 * @Parameters({ "browser", "url" })
	 * 
	 * @BeforeClass // Multiple browser public void beforeClass(String browserName, String appUrl) { driver = GetBrowserDriver(browserName,
	 * appUrl); homePage = PageGeneratorManager.getUserHomePage(driver);
	 * 
	 * firstName = "Sang"; lastName = "Le"; email = "afc" + generateRandomNumber() + "@gmail.com"; password = "123456"; day = "27"; month =
	 * "July"; year = "2000"; }
	 * 
	 * @Test public void User_01_Register() { log.info("Register - Step 01: Open 'Register' page"); registerPage = homePage.openRegisterPage();
	 * 
	 * registerPage.clickToRadioByLabel(driver, "Female");
	 * 
	 * log.info("Register - Step 02: Enter to Firstname textbox with value is: '" + firstName + "'"); registerPage.inputToTextboxByID(driver,
	 * "FirstName", firstName);
	 * 
	 * log.info("Register - Step 03: Enter to Lastname textbox with value is: '" + lastName + "'"); registerPage.inputToTextboxByID(driver,
	 * "LastName", lastName);
	 * 
	 * registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthDay", day); registerPage.selectDropdownByNameAttribute(driver,
	 * "DateOfBirthMonth", month); registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthYear", year);
	 * 
	 * log.info("Register - Step 04: Enter to Email textbox with value is: '" + email + "'"); registerPage.inputToTextboxByID(driver, "Email",
	 * email);
	 * 
	 * registerPage.clickToCheckboxByLabel(driver, "Newsletter");
	 * 
	 * log.info("Register - Step 05: Enter to Password textbox with value is: '" + password + "'"); registerPage.inputToTextboxByID(driver,
	 * "Password", password);
	 * 
	 * log.info("Register - Step 06: Enter to Confirm password textbox with value is: '" + password + "'");
	 * registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
	 * 
	 * log.info("Register - Step 07: Click to 'Register' button"); registerPage.clickToButtonByText(driver, "Register");
	 * 
	 * log.info("Register - Step 08: Verify Register Success Message is displayed"); verifyEquals(registerPage.getRegisterSuccessMessage(),
	 * "Your registration completed");
	 * 
	 * }
	 * 
	 * @Test public void User_02_Login() {
	 * 
	 * log.info("Login - Step 01: Navigate to Login page"); homePage = registerPage.clickToLogoutLink(); loginPage = homePage.openLoginPage();
	 * 
	 * log.info("Login - Step 02: Enter to Email textbox with value is: '" + email + "'"); loginPage.inputToTextboxByID(driver, "Email", email);
	 * 
	 * log.info("Login - Step 03: Enter to Password textbox with value is: '" + password + "'"); loginPage.inputToTextboxByID(driver,
	 * "Password", password);
	 * 
	 * log.info("Login - Step 04: Click to Login button"); loginPage.clickToButtonByText(driver, "Log in"); homePage =
	 * PageGeneratorManager.getUserHomePage(driver);
	 * 
	 * log.info("Login - Step 05: Verify Account link is displayed"); verifyTrue(homePage.isMyAccountLinkDisplayed());
	 * 
	 * }
	 * 
	 * @Test public void User_03_My_Account() { log.info("My Account - Step 01: Open My Account page"); customerInfoPage =
	 * homePage.openMyAccountPage();
	 * 
	 * log.info("My Account - Step 02: Verify Customer Info is displayed"); verifyTrue(customerInfoPage.isCustomerInfoDisplayed());
	 * 
	 * log.info("My Account - Step 03: Verify Gender Info is checked"); verifyTrue(customerInfoPage.getRadioCheckedStatusByLabel(driver,
	 * "Female"));
	 * 
	 * log.info("My Account - Step 04: Verify First name Info is displayed"); verifyEquals(customerInfoPage.getTextboxValueByID(driver,
	 * "FirstName"), firstName);
	 * 
	 * log.info("My Account - Step 05: Verify Last name Info is displayed"); verifyEquals(customerInfoPage.getTextboxValueByID(driver,
	 * "LastName"), lastName);
	 * 
	 * log.info("My Account - Step 06: Verify Day Info is displayed"); verifyEquals(customerInfoPage.getDropdownValueByNameAttribute(driver,
	 * "DateOfBirthDay"), day);
	 * 
	 * log.info("My Account - Step 07: Verify Month Info is displayed"); verifyEquals(customerInfoPage.getDropdownValueByNameAttribute(driver,
	 * "DateOfBirthMonth"), month);
	 * 
	 * log.info("My Account - Step 08: Verify Year Info is displayed"); verifyEquals(customerInfoPage.getDropdownValueByNameAttribute(driver,
	 * "DateOfBirthYear"), year);
	 * 
	 * log.info("My Account - Step 09: Verify Email Info is displayed"); verifyEquals(customerInfoPage.getTextboxValueByID(driver, "Email"),
	 * email);
	 * 
	 * log.info("My Account - Step 10: Verify Newsletter Info is checked"); verifyTrue(customerInfoPage.getCheckboxCheckedStatusByLabel(driver,
	 * "Newsletter"));
	 * 
	 * }
	 * 
	 * @AfterClass(alwaysRun = true) public void afterClass() { closeBrowserAndDriver(); }
	 */
	private WebDriver driver;
	private String firstName, lastName, email, password, day, month, year;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;

}
