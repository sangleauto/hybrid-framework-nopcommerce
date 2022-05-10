package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserDesktopPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;

public class Nopcommerce_03_My_Account extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = Common_01_Register_End_User.email;
		password = Common_01_Register_End_User.password;
		firstName = Common_01_Register_End_User.firstName;
		lastName = Common_01_Register_End_User.lastName;
		newFirstName = "Automation";
		newLastname = "FC";
		day = "1";
		month = "January";
		year = "1999";
		newEmail = "automationfc" + generateRandomNumber() + "@gmail.com";
		companyName = "Automation FC";
		country = "Viet Nam";
		stateProvince = "Other";
		city = "Da Nang";
		address1 = "123/04 Le Lai";
		address2 = "234/05 Hai Phong";
		zipCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "09876543231";
		newPassword = "123147";
		reviewTitle = "Review Title " + generateRandomNumber();
		reviewText = "This is Review Text " + generateRandomNumber();
		reviewRating = "4";
		passwordChangedSuccessfullyMsg = "Password was changed";
		menuName = "Computers";
		subMenuName = "Desktops";

		log.info("Precondition - Step 01: Open Log in page");
		loginPage = homePage.clickToLoginLink(driver);

		log.info("Precondition - Step 02: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(email);

		log.info("Precondition - Step 03: Enter Password to Password textbox");
		loginPage.enterPasswordTextbox(password);

		log.info("Precondition - Step 04: Click to LOG IN button");
		homePage = loginPage.clickToLoginButton();

		log.info("Precondition - Step 05: Verify My account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Precondition - Step 06: Open My Account page");
		customerInfoPage = homePage.clickToMyAccountLink(driver);

	}

	@Test
	public void My_Account_01_Update_Customer_Info() {

		log.info("My Account Update Customer Info - Step 02: Verify First name info is correct");
		verifyEquals(customerInfoPage.getValueInFirstNameTextbox(), firstName);

		log.info("My Account Update Customer Info - Step 03: Verify Last name info is correct");
		verifyEquals(customerInfoPage.getValueInLastNameTextbox(), lastName);

		log.info("My Account Update Customer Info - Step 04: Verify Email info is correct");
		verifyEquals(customerInfoPage.getValueInEmailTextbox(), email);

		log.info("My Account Update Customer Info - Step 05: Verify Newsletter checkbox is checked");
		verifyTrue(customerInfoPage.isNewsLetterCheckboxChecked());

		log.info("My Account Update Customer Info - Step 06: Select Gender = Female");
		customerInfoPage.checkToFemaleGenderRadio();

		log.info("My Account Update Customer Info - Step 07: Enter new First name");
		customerInfoPage.enterFirstNameTextbox(newFirstName);

		log.info("My Account Update Customer Info - Step 08: Enter new Last name");
		customerInfoPage.enterLastNameTextbox(newLastname);

		log.info("My Account Update Customer Info - Step 09: Enter Date of birth");
		customerInfoPage.selectDate(day);
		customerInfoPage.selectMonth(month);
		customerInfoPage.selectYear(year);

		log.info("My Account Update Customer Info - Step 10: Enter new Email");
		customerInfoPage.enterEmailTextbox(newEmail);

		log.info("My Account Update Customer Info - Step 11: Enter Company name");
		customerInfoPage.enterCompanyNameTextbox(companyName);

		log.info("My Account Update Customer Info - Step 12: Click to Save button");
		customerInfoPage.clickToSaveButton();

		log.info("My Account Update Customer Info - Step 13: Verify Femail Radio is checked");
		verifyTrue(customerInfoPage.isFemailRadioChecked());

		log.info("My Account Update Customer Info - Step 14: Verify new First name info is correct");
		verifyEquals(customerInfoPage.getValueInFirstNameTextbox(), newFirstName);

		log.info("My Account Update Customer Info - Step 15: Verify new Last name info is correct");
		verifyEquals(customerInfoPage.getValueInLastNameTextbox(), newLastname);

		log.info("My Account Update Customer Info - Step 16: Verify new Email info is correct");
		verifyEquals(customerInfoPage.getValueInEmailTextbox(), newEmail);

		log.info("My Account Update Customer Info - Step 17: Verify DOB info");
		verifyEquals(customerInfoPage.getValueInDayDropdown(), day);
		verifyEquals(customerInfoPage.getValueInMonthDropdown(), month);
		verifyEquals(customerInfoPage.getValueInYearDropdown(), year);

		log.info("My Account Update Customer Info - Step 18: Verify Company Name info is correct");
		verifyEquals(customerInfoPage.getValueInCompanyNameTextbox(), companyName);

		log.info("My Account Update Customer Info - Step 19: Verify Newsletter checkbox is checked");
		verifyTrue(customerInfoPage.isNewsLetterCheckboxChecked());

		log.info("My Account Update Customer Info - Step 20: Click to Log out link");
		homePage = customerInfoPage.clickToLogoutLinkAtUserPage(driver);

		log.info("My Account Update Customer Info - Step 21: Click to Log in link");
		loginPage = homePage.clickToLoginLink(driver);

		log.info("My Account Update Customer Info - Step 22: Enter new Email to Email textbox");
		loginPage.enterEmailTextbox(newEmail);

		log.info("My Account Update Customer Info - Step 23: Enter password to Password textbox");
		loginPage.enterPasswordTextbox(password);

		log.info("My Account Update Customer Info - Step 24: Click to LOG IN button");
		homePage = loginPage.clickToLoginButton();

		log.info("My Account Update Customer Info - Step 25: Verify My account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("My Account Update Customer Info - Step 26: Open My Account page");
		customerInfoPage = homePage.clickToMyAccountLink(driver);
	}

	@Test
	public void My_Account_02_Add_Address() {
		log.info("My Account Add New Address - Step 01: Open Addresses page");
		addressPage = (UserAddressPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Addresses");

		log.info("My Account Add New Address - Step 02: Click to ADD NEW button");
		addressPage.clickToAddNewButton();

		log.info("My Account Add New Address - Step 03: Enter First name textbox");
		addressPage.enterFirstnameTextbox(firstName);

		log.info("My Account Add New Address - Step 04: Enter Last name textbox");
		addressPage.enterLastnameTextbox(lastName);

		log.info("My Account Add New Address - Step 05: Enter Email textbox");
		addressPage.enterEmailTextbox(email);

		log.info("My Account Add New Address - Step 06: Enter Company textbox");
		addressPage.enterCompanyTextbox(companyName);

		log.info("My Account Add New Address - Step 07: Select Country in dropdown");
		addressPage.selectCountryDropdown(country);

		log.info("My Account Add New Address - Step 08: Select State/ province in dropdown");
		addressPage.selectStateProvinceDropdown(stateProvince);
		addressPage.sleepInSecond(3);
		log.info("My Account Add New Address - Step 09: Enter City textbox");
		addressPage.enterCityTextbox(city);

		log.info("My Account Add New Address - Step 10: Enter Address 1 textbox");
		addressPage.enterAddress1(address1);

		log.info("My Account Add New Address - Step 11: Enter Address 2 textbox");
		addressPage.enterAddress2(address2);

		log.info("My Account Add New Address - Step 12: Enter Zip / postal code textbox");
		addressPage.enterZipCodeTextbox(zipCode);

		log.info("My Account Add New Address - Step 13: Enter Phone number textbox");
		addressPage.enterPhoneNumberTextbox(phoneNumber);

		log.info("My Account Add New Address - Step 14: Enter Fax number textbox");
		addressPage.enterFaxNumberTextbox(faxNumber);

		log.info("My Account Add New Address - Step 15: Click to Save button");
		addressPage.clickToSaveButton();

		log.info("My Account Add New Address - Step 16: Verify Full name info");
		verifyEquals(addressPage.getValueFullNameInfo(), firstName + " " + lastName);

		log.info("My Account Add New Address - Step 17: Verify Email name info");
		verifyEquals(addressPage.getValueEmailInfo(), "Email: " + email);

		log.info("My Account Add New Address - Step 18: Verify Phone info");
		verifyEquals(addressPage.getValuePhoneInfo(), "Phone number: " + phoneNumber);

		log.info("My Account Add New Address - Step 19: Verify Fax number info");
		verifyEquals(addressPage.getValueFaxNumberInfo(), "Fax number: " + faxNumber);

		log.info("My Account Add New Address - Step 20: Verify Address1 info");
		verifyEquals(addressPage.getValueAddress1Info(), address1);

		log.info("My Account Add New Address - Step 21: Verify Address2 info");
		verifyEquals(addressPage.getValueAddress2Info(), address2);

		log.info("My Account Add New Address - Step 22: Verify Full name");
		verifyEquals(addressPage.getValueCityStateZipInfo(), city + addressPage.getStateInfo(stateProvince) + ", " + zipCode);

		log.info("My Account Add New Address - Step 23: Verify Country info");
		verifyEquals(addressPage.getCountryInfo(), country);

		log.info("My Account Add New Address - Step 24: Back to Customer info page");
		customerInfoPage = addressPage.clickToMyAccountLink(driver);
	}

	@Test
	public void My_Account_03_Change_Password() {
		log.info("My Account Change Password - Step 01: Open Change Password page");
		changePasswordPage = (UserChangePasswordPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Change password");

		log.info("My Account Change Password - Step 02: Enter Old password to Old password textbox");
		changePasswordPage.enterOldPasswordTextbox(password);

		log.info("My Account Change Password - Step 03: Enter New password to New password textbox");
		changePasswordPage.enterNewPasswordTextbox(newPassword);

		log.info("My Account Change Password - Step 04: Enter New password to Confirm password textbox");
		changePasswordPage.enterConfirmPasswordTextbox(newPassword);

		log.info("My Account Change Password - Step 05: Click to CHANGE PASSWORD button");
		changePasswordPage.clickToChangePasswordButton();

		log.info("My Account Change Password - Step 06: Verify 'Password was changed' message");
		verifyEquals(changePasswordPage.getPasswordChangedSuccessfullyMessage(), passwordChangedSuccessfullyMsg);

		log.info("My Account Change Password - Step 07: Click to Close icon");
		changePasswordPage.clickToCloseIcon();

		log.info("My Account Change Password - Step 08: Click to Log out link");
		homePage = changePasswordPage.clickToLogoutLinkAtUserPage(driver);

		log.info("My Account Change Password - Step 09: Open Log in page");
		loginPage = homePage.clickToLoginLink(driver);

		log.info("My Account Change Password - Step 10: Enter Email to Email textbox");
		loginPage.enterEmailTextbox(newEmail);

		log.info("My Account Change Password - Step 11: Enter Password to Password textbox");
		loginPage.enterPasswordTextbox(newPassword);

		log.info("My Account Change Password - Step 12: Click to LOG IN button");
		homePage = loginPage.clickToLoginButton();

		log.info("My Account Change Password - Step 13: Verify My account link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("My Account Change Password - Step 14: Open My Account page");
		customerInfoPage = homePage.clickToMyAccountLink(driver);

	}

	@Test
	public void My_Account_04_Add_Review_To_My_Product_Reviews() {
		log.info("My Account Add Review - Step 01: Open to Desktops page in Header menu");
		customerInfoPage.openSubMenuHeader(driver, menuName, subMenuName);
		desktopPage = PageGeneratorManager.getUserDesktopPage(driver);

		log.info("My Account Add Review - Step 02: Open Desktop product detail");
		desktopPage.clickToDesktopProduct();

		log.info("My Account Add Review - Step 03: Click to Add your review link");
		myProductReviewPage = desktopPage.clickToAddYourReviewLink();

		log.info("My Account Add Review - Step 04: Add Review title");
		myProductReviewPage.enterTitleToReviewTitleTextbox(reviewTitle);

		log.info("My Account Add Review - Step 05: Add Review text");
		myProductReviewPage.enterTextToReviewTitleTextbox(reviewText);

		log.info("My Account Add Review - Step 06: Rating");
		myProductReviewPage.selectRating(reviewRating);

		log.info("My Account Add Review - Step 07: Click SUBMIT REVIEW button");
		myProductReviewPage.clickSubmitReviewButton();

		log.info("My Account Add Review - Step 08: Verify Review title in Product reviews page");
		verifyEquals(myProductReviewPage.getValueInReviewTitleTextbox(), reviewTitle);

		log.info("My Account Add Review - Step 09: Verify Review text in Product reviews page");
		verifyEquals(myProductReviewPage.getValueInReviewTextTextbox(), reviewText);

		log.info("My Account Add Review - Step 10: Verify Review rating in Product reviews page");
		verifyEquals(myProductReviewPage.getValueReviewRating(), reviewRating);

		log.info("My Account Add Review - Step 11: Open My Account page");
		customerInfoPage = myProductReviewPage.clickToMyAccountLink(driver);

		log.info("My Account Add Review - Step 12: Open My product reviews page");
		myProductReviewPage = (UserMyProductReviewPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "My product reviews");

		log.info("My Account Add Review - Step 13: Verify Review title in My account - My product reviews");
		verifyEquals(myProductReviewPage.getValueInReviewTitleTextbox(), reviewTitle);

		log.info("My Account Add Review - Step 14: Verify Review text in My account - My product reviews");
		verifyEquals(myProductReviewPage.getValueInReviewTextTextbox(), reviewText);

		log.info("My Account Add Review - Step 15: Verify Review rating in My account - My product reviews");
		verifyEquals(myProductReviewPage.getValueReviewRating(), reviewRating);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String email, password, firstName, lastName, newFirstName, newLastname, newEmail, companyName, menuName, subMenuName;
	private String day, month, year;
	private String country, stateProvince, city, address1, address2, zipCode, phoneNumber, faxNumber, newPassword;
	private String reviewTitle, reviewText, reviewRating;
	private String passwordChangedSuccessfullyMsg;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserDesktopPageObject desktopPage;

}
