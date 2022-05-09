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
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class Nopcommerce_04_Search_Advanced_Search extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = Common_01_Register_End_User.email;
		password = Common_01_Register_End_User.password;

		notExistedData = "Macbook Pro 2050";
		relativeName = "Lenovo";
		absoluteName = "Thinkpad X1 Carbon";
		lenovoItemName1 = "Lenovo IdeaCentre 600 All-in-One PC";
		lenovoItemName2 = "Lenovo Thinkpad X1 Carbon Laptop";
		thinkpadItemName = "Lenovo Thinkpad X1 Carbon Laptop";
		appleItemName = "Apple MacBook Pro 13-inch";
		advancedSearchProductName = "Apple MacBook Pro";
		categoryValue = "Computers";
		incorrectManufacturer = "HP";
		correctManufacturer = "Apple";

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

		log.info("Precondition - Step 06: Open Search page");
		searchPage = homePage.openSearchPage(driver);

	}

	@Test
	public void Search_01_Empty_Data() {
		log.info("Search with Empty data - Step 01: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Empty data - Step 02: Verify Search error message (minimum 3 chars)");
		verifyEquals(searchPage.getSearchEmptyErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_02_Data_Not_Existed() {
		log.info("Search with Data not existed - Step 01: Enter not existed data to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(notExistedData);

		log.info("Search with Data not existed - Step 02: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Data not existed - Step 03: Verify Search error message (no products were matched criteria)");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_03_Search_With_Relative_Name() {
		log.info("Search with Relative name - Step 01: Enter Relative name value to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(relativeName);

		log.info("Search with Relative name- Step 02: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Relative name - Step 03: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 2);

		log.info("Search with Relative name - Step 04: Verify first item name is shown after clicking Search");
		verifyEquals(searchPage.getFirstProductName(), lenovoItemName1);

		log.info("Search with Relative name - Step 05: Verify second item name is shown after clicking Search");
		verifyEquals(searchPage.getSecondProductName(), lenovoItemName2);

	}

	@Test
	public void Search_04_Search_With_Absolute_Name() {
		log.info("Search with Absolute name - Step 01: Enter Absolute name value to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(absoluteName);

		log.info("Search with Absolute data - Step 02: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Absolute data - Step 03: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 1);

		log.info("Search with Absolute data - Step 04: Verify first item name is shown after clicking Search");
		verifyEquals(searchPage.getFirstProductName(), thinkpadItemName);
	}

	@Test
	public void Search_05_Advanced_Search_Parent_Categories() {
		log.info("Search with Parent Categores - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(advancedSearchProductName);

		log.info("Search with Parent Categores - Step 02: Check to Advanced search checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with Parent Categores - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(categoryValue);

		log.info("Search with Parent Categores - Step 04: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Parent Categores - Step 05: Verify Search error message (no products were matched criteria)");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_06_Advanced_Search_Sub_Categories() {
		log.info("Search with Sub Categores - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(advancedSearchProductName);

		log.info("Search with Sub Categores - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with Sub Categores - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(categoryValue);

		log.info("Search with Sub Categores - Step 04: Check to 'Automatically search sub categories' search checkbox");
		searchPage.checkToSubCategoriesSearchCheckbox();

		log.info("Search with Sub Categores - Step 05: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Sub Categores - Step 06: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 1);

		log.info("Search with Sub Categores - Step 07: Verify first item name is shown after clicking Search");
		verifyEquals(searchPage.getFirstProductName(), appleItemName);
	}

	@Test
	public void Search_07_Advanced_Search_Incorrect_Manufacturer() {
		log.info("Search with incorrect manufacturer - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(advancedSearchProductName);

		log.info("Search with incorrect manufacturer - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with incorrect manufacturer - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(categoryValue);

		log.info("Search with incorrect manufacturer - Step 04: Check to 'Automatically search sub categories' search checkbox");
		searchPage.checkToSubCategoriesSearchCheckbox();

		log.info("Search with incorrect manufacturer - Step 05: Select Incorrect manufacturer in Manufacturer dropdown");
		searchPage.selectItemInManufacturerDropdown(incorrectManufacturer);

		log.info("Search with incorrect manufacturer - Step 07: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with incorrect manufacturer - Step 08: Verify Search error message (no products were matched criteria)");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_08_Advanced_Search_Correct_Manufacturer() {
		log.info("Search with correct manufacturer - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(advancedSearchProductName);

		log.info("Search with correct manufacturer - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with correct manufacturer - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(categoryValue);

		log.info("Search with correct manufacturer - Step 04: Check to 'Automatically search sub categories' search checkbox");
		searchPage.checkToSubCategoriesSearchCheckbox();

		log.info("Search with correct manufacturer - Step 05: Select Correct manufacturer in Manufacturer dropdown");
		searchPage.selectItemInManufacturerDropdown(correctManufacturer);

		log.info("Search with correct manufacturer - Step 07: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with correct manufacturer - Step 08: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 1);

		log.info("Search with correct manufacturer - Step 09: Verify first item name is shown after clicking Search");
		verifyEquals(searchPage.getFirstProductName(), appleItemName);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String email, password;
	private String notExistedData, relativeName, absoluteName, lenovoItemName1, lenovoItemName2, thinkpadItemName, appleItemName, advancedSearchProductName, categoryValue, incorrectManufacturer, correctManufacturer;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserSearchPageObject searchPage;

}
