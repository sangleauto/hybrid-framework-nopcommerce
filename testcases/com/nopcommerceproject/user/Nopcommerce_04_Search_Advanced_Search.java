package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;
import com.nopcommerce.data.DataTest_04_Search;

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
		verifyEquals(searchPage.getSearchEmptyErrorMessage(), DataTest_04_Search.searchMessage.SEARCH_EMPTY_DATA_MSG);
	}

	@Test
	public void Search_02_Data_Not_Existed() {
		log.info("Search with Data not existed - Step 01: Enter not existed data to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(DataTest_04_Search.searchInfo.NOT_EXISTED_DATA);

		log.info("Search with Data not existed - Step 02: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Data not existed - Step 03: Verify Search error message (no products were matched criteria)");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), DataTest_04_Search.searchMessage.SEARCH_DATA_NOT_EXISTED_MSG);

	}

	@Test
	public void Search_03_Search_With_Relative_Name() {
		log.info("Search with Relative name - Step 01: Enter Relative name value to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(DataTest_04_Search.searchInfo.RELATIVE_NAME);

		log.info("Search with Relative name- Step 02: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Relative name - Step 03: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 2);

		log.info("Search with Relative name - Step 04: Verify all product names are shown after clicking Search");
		verifyTrue(searchPage.isProductNameDisplayed(DataTest_04_Search.searchInfo.LENOVO_ITEM_NAME_1, DataTest_04_Search.searchInfo.LENOVO_ITEM_NAME_2));
	}

	@Test
	public void Search_04_Search_With_Absolute_Name() {
		log.info("Search with Absolute name - Step 01: Enter Absolute name value to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(DataTest_04_Search.searchInfo.ABSOLUTE_NAME);

		log.info("Search with Absolute data - Step 02: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Absolute data - Step 03: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 1);

		log.info("Search with Absolute data - Step 04: Verify all product names are shown after clicking Search");
		verifyTrue(searchPage.isProductNameDisplayed(DataTest_04_Search.searchInfo.THINKPAD_ITEM_NAME));
	}

	@Test
	public void Search_05_Advanced_Search_Parent_Categories() {
		log.info("Search with Parent Categores - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(DataTest_04_Search.searchInfo.ADVANCED_SEARCH_PRODUCT_NAME);

		log.info("Search with Parent Categores - Step 02: Check to Advanced search checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with Parent Categores - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(DataTest_04_Search.searchInfo.CATEGORY_VALUE);

		log.info("Search with Parent Categores - Step 04: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Parent Categores - Step 05: Verify Search error message (no products were matched criteria)");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), DataTest_04_Search.searchMessage.SEARCH_DATA_NOT_EXISTED_MSG);

	}

	@Test
	public void Search_06_Advanced_Search_Sub_Categories() {
		log.info("Search with Sub Categores - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(DataTest_04_Search.searchInfo.ADVANCED_SEARCH_PRODUCT_NAME);

		log.info("Search with Sub Categores - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with Sub Categores - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(DataTest_04_Search.searchInfo.CATEGORY_VALUE);

		log.info("Search with Sub Categores - Step 04: Check to 'Automatically search sub categories' search checkbox");
		searchPage.checkToSubCategoriesSearchCheckbox();

		log.info("Search with Sub Categores - Step 05: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with Sub Categores - Step 06: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 1);

		log.info("Search with Sub Categores - Step 07: Verify all product names are shown after clicking Search");
		verifyTrue(searchPage.isProductNameDisplayed(DataTest_04_Search.searchInfo.APPLE_ITEM_NAME));

	}

	@Test
	public void Search_07_Advanced_Search_Incorrect_Manufacturer() {
		log.info("Search with incorrect manufacturer - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(DataTest_04_Search.searchInfo.ADVANCED_SEARCH_PRODUCT_NAME);

		log.info("Search with incorrect manufacturer - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with incorrect manufacturer - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(DataTest_04_Search.searchInfo.CATEGORY_VALUE);

		log.info("Search with incorrect manufacturer - Step 04: Check to 'Automatically search sub categories' search checkbox");
		searchPage.checkToSubCategoriesSearchCheckbox();

		log.info("Search with incorrect manufacturer - Step 05: Select Incorrect manufacturer in Manufacturer dropdown");
		searchPage.selectItemInManufacturerDropdown(DataTest_04_Search.searchInfo.INCORRECT_MANUFACTURER);

		log.info("Search with incorrect manufacturer - Step 07: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with incorrect manufacturer - Step 08: Verify Search error message (no products were matched criteria)");
		verifyEquals(searchPage.getSearchNoResultErrorMessage(), DataTest_04_Search.searchMessage.SEARCH_DATA_NOT_EXISTED_MSG);

	}

	@Test
	public void Search_08_Advanced_Search_Correct_Manufacturer() {
		log.info("Search with correct manufacturer - Step 01: Enter Product name to Search keyword textbox");
		searchPage.enterValueToSearchTextbox(DataTest_04_Search.searchInfo.ADVANCED_SEARCH_PRODUCT_NAME);

		log.info("Search with correct manufacturer - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToAdvancedSearchCheckbox();

		log.info("Search with correct manufacturer - Step 03: Select 'Computers' in Category dropdown");
		searchPage.selectItemInCategoryDropdown(DataTest_04_Search.searchInfo.CATEGORY_VALUE);

		log.info("Search with correct manufacturer - Step 04: Check to 'Automatically search sub categories' search checkbox");
		searchPage.checkToSubCategoriesSearchCheckbox();

		log.info("Search with correct manufacturer - Step 05: Select Correct manufacturer in Manufacturer dropdown");
		searchPage.selectItemInManufacturerDropdown(DataTest_04_Search.searchInfo.CORRECT_MANUFACTURER);

		log.info("Search with correct manufacturer - Step 07: Click to Search button");
		searchPage.clickToSearchButton();

		log.info("Search with correct manufacturer - Step 08: Verify number of items are shown after clicking Search");
		verifyEquals(searchPage.getElementSize(driver, UserSearchPageUI.PRODUCT_NAME), 1);

		log.info("Search with correct manufacturer - Step 09: Verify all product names are shown after clicking Search");
		verifyTrue(searchPage.isProductNameDisplayed(DataTest_04_Search.searchInfo.APPLE_ITEM_NAME));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String email, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserSearchPageObject searchPage;

}
