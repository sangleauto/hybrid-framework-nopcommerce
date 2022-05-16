package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataTest_08_Admin;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminCustomerInfoPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductInfoPageObject;

public class Nopcommerce_08_Admin extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Precondition - Step 01: Login with Admin account");
		adminDashboardPage = adminLoginPage.loginAsAdmin(DataTest_08_Admin.LoginInfo.EMAIL_ADMIN, DataTest_08_Admin.LoginInfo.PASSWORD_ADMIN);

		log.info("Precondition - Step 02: Verify Dashboard page is displayed");
		verifyTrue(adminDashboardPage.isDashboardHeaderDisplayed());

	}

	// @Test
	public void Admin_01_Search_With_Product_name() {
		log.info("Search with Product name - Step 01: Open Catalog > Product in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CATALOG, DataTest_08_Admin.SidebarInfo.PRODUCTS);

		log.info("Search with Product name - Step 02: Enter Lenovo product to Product name textbox");
		adminDashboardPage.enterToProductNameTextbox(DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);

		log.info("Search with Product name - Step 03: Click to 'Search' button");
		adminDashboardPage.clickToSearchProductButton();

		log.info("Search with Product name - Step 04: Verify infos in product table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_NAME_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_SKU_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_SKU);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_PRICE_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_PRICE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_STOCK_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_STOCK);
		verifyEquals(adminDashboardPage.getAttributeInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_PUBLISHED_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_CHECKED_ICON);

	}

	// @Test
	public void Admin_02_Search_With_Product_Name_Category_Unchecked() {
		log.info("Search with Product name + Category + Unchecked - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo();

		log.info("Search with Product name + Category + Unchecked - Step 02: Open Catalog > Product in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CATALOG, DataTest_08_Admin.SidebarInfo.PRODUCTS);

		log.info("Search with Product name + Category + Unchecked - Step 03: Enter Lenovo product to Product name textbox");
		adminDashboardPage.enterToProductNameTextbox(DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);

		log.info("Search with Product name + Category + Unchecked - Step 04: Select 'Computers' in Category Dropdown");
		adminDashboardPage.selectCategoryDropdown(DataTest_08_Admin.ProductInfo.CATEGORY_COMPUTERS);

		log.info("Search with Product name + Category + Unchecked - Step 05: Uncheck to 'Search subcategories' checkbox");
		adminDashboardPage.uncheckToSearchSubCheckbox();

		log.info("Search with Product name + Category + Unchecked - Step 06: Click to 'Search' button");
		adminDashboardPage.clickToSearchProductButton();

		log.info("Search with Product name + Category + Unchecked - Step 07: Verify no data is displayed in table");
		verifyEquals(adminDashboardPage.getNoDataMessageInTable(), DataTest_08_Admin.Message.NO_DATA_MSG);
	}

	// @Test
	public void Admin_03_Search_With_Product_Name_Category_Checked() {
		log.info("Search with Product name + Category + Checked - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo();

		log.info("Search with Product name + Category + Checked - Step 02: Open Catalog > Product in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CATALOG, DataTest_08_Admin.SidebarInfo.PRODUCTS);

		log.info("Search with Product name + Category + Checked - Step 03: Enter Lenovo product to Product name textbox");
		adminDashboardPage.enterToProductNameTextbox(DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);

		log.info("Search with Product name + Category + Checked - Step 04: Select 'Computers' in Category Dropdown");
		adminDashboardPage.selectCategoryDropdown(DataTest_08_Admin.ProductInfo.CATEGORY_COMPUTERS);

		log.info("Search with Product name + Category + Checked - Step 05: Check to 'Search subcategories' checkbox");
		adminDashboardPage.checkToSearchSubCheckbox();

		log.info("Search with Product name + Category + Checked - Step 06: Click to 'Search' button");
		adminDashboardPage.clickToSearchProductButton();

		log.info("Search with Product name - Step 04: Verify infos in product table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_NAME_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_SKU_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_SKU);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_PRICE_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_PRICE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_STOCK_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_STOCK);
		verifyEquals(adminDashboardPage.getAttributeInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_PUBLISHED_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_CHECKED_ICON);

	}

	// @Test
	public void Admin_04_Search_Product_Name_Child_Category() {
		log.info("Search with Product name + Child Category - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo();

		log.info("Search with Product name + Child Category - Step 02: Open Catalog > Product in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CATALOG, DataTest_08_Admin.SidebarInfo.PRODUCTS);

		log.info("Search with Product name + Child Category - Step 03: Enter Lenovo product to Product name textbox");
		adminDashboardPage.enterToProductNameTextbox(DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);

		log.info("Search with Product name + Child Category - Step 04: Select 'Computers >> Desktops' in Category Dropdown");
		adminDashboardPage.selectCategoryDropdown(DataTest_08_Admin.ProductInfo.CATEGORY_COMPUTERS_DESKTOPS);

		log.info("Search with Product name + Child Category - Step 05: Uncheck to 'Search subcategories' checkbox");
		adminDashboardPage.uncheckToSearchSubCheckbox();

		log.info("Search with Product name + Child Category - Step 04: Select 'Computers >> Desktops' in Category Dropdown");
		adminDashboardPage.selectCategoryDropdown(DataTest_08_Admin.ProductInfo.CATEGORY_COMPUTERS_DESKTOPS);

		log.info("Search with Product name + Child Category - Step 06: Click to 'Search' button");
		adminDashboardPage.clickToSearchProductButton();

		log.info("Search with Product name - Step 04: Verify infos in product table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_NAME_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_SKU_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_SKU);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_PRICE_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_PRICE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_STOCK_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_STOCK);
		verifyEquals(adminDashboardPage.getAttributeInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.ProductInfo.TABLE_PUBLISHED_COLUMN), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_CHECKED_ICON);
	}

	// @Test
	public void Admin_05_Search_Product_Name_Manufacturer() {
		log.info("Search with Product name + Manufacturer - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo();

		log.info("Search with Product name + Manufacturer - Step 02: Open Catalog > Product in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CATALOG, DataTest_08_Admin.SidebarInfo.PRODUCTS);

		log.info("Search with Product name + Manufacturer - Step 03: Enter Lenovo product to Product name textbox");
		adminDashboardPage.enterToProductNameTextbox(DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);

		log.info("Search with Product name + Manufacturer - Step 04: Select 'All' in Category Dropdown");
		adminDashboardPage.selectCategoryDropdown(DataTest_08_Admin.ProductInfo.CATEGORY_ALL);

		log.info("Search with Product name + Manufacturer - Step 05: Uncheck to 'Search subcategories' checkbox");
		adminDashboardPage.uncheckToSearchSubCheckbox();

		log.info("Search with Product name + Manufacturer - Step 06: Select 'Apple' in Manufacturer Dropdown");
		adminDashboardPage.selectManufacturerDropdown(DataTest_08_Admin.ProductInfo.MANUFACTURER_APPLE);

		log.info("Search with Product name + Manufacturer - Step 07: Click to 'Search' button");
		adminDashboardPage.clickToSearchProductButton();

		log.info("Search with Product name + Manufacturer - Step 08: Verify no data is displayed in table");
		verifyEquals(adminDashboardPage.getNoDataMessageInTable(), DataTest_08_Admin.Message.NO_DATA_MSG);
	}

	// @Test
	public void Admin_06_Go_Direct_To_Product_SKU() {
		log.info("Go directly to product SKU - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo();

		log.info("Go directly to product SKU - Step 02: Open Catalog > Product in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CATALOG, DataTest_08_Admin.SidebarInfo.PRODUCTS);

		log.info("Go directly to product SKU - Step 03: Enter SKU value to product SKU textbox");
		adminDashboardPage.enterGoToProductSKUTextbox(DataTest_08_Admin.ProductInfo.SKU_LENOVO);

		log.info("Go directly to product SKU - Step 04: Click to Go button");
		adminProductInfoPage = adminDashboardPage.clickToGoButton();

		log.info("Go directly to product SKU - Step 05: Verify Product name");
		verifyEquals(adminProductInfoPage.getProductName(), DataTest_08_Admin.ProductInfo.PRODUCT_LENOVO_NAME);

		log.info("Go directly to product SKU - Step 06: Verify Full description");
		verifyEquals(adminProductInfoPage.getFullDescription(), DataTest_08_Admin.ProductInfo.DESCRIPTION_LENOVO);
		adminProductInfoPage.switchToDefaultContent(driver);

		log.info("Go directly to product SKU - Step 07: Verify Full description");
		verifyEquals(adminProductInfoPage.getSKU(), DataTest_08_Admin.ProductInfo.SKU_LENOVO);

		log.info("Go directly to product SKU - Step 08: Verify Full description");
		adminProductInfoPage.clickToExpandPrices();
		verifyEquals(adminProductInfoPage.getPrice(), DataTest_08_Admin.ProductInfo.PRICE_LENOVO);

		log.info("Go directly to product SKU - Step 09: Verify Full description");
		verifyEquals(adminProductInfoPage.getStockQuantity(), DataTest_08_Admin.ProductInfo.STOCK_LENOVO);
	}

	@Test
	public void Admin_07_Create_New_Customer() {
		log.info("Create New Customer - Step 01: Verify Full description");
		adminDashboardPage.clickToNopLogo();

		log.info("Create New Customer - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Create New Customer - Step 03: Click to 'Add new' button");
		adminCustomerInfoPage = adminDashboardPage.clickToAddNewButton();

		log.info("Create New Customer - Step 04: Enter to Email textbox");
		adminCustomerInfoPage.enterEmailTextbox(DataTest_08_Admin.CustomerInfo.EMAIL);

		log.info("Create New Customer - Step 05: Enter to Password textbox");
		adminCustomerInfoPage.enterPasswordTextbox(DataTest_08_Admin.CustomerInfo.PASSWORD);

		log.info("Create New Customer - Step 06: Enter to First name textbox");
		adminCustomerInfoPage.enterFirstNameTextbox(DataTest_08_Admin.CustomerInfo.FIRST_NAME);

		log.info("Create New Customer - Step 07: Enter to Last name textbox");
		adminCustomerInfoPage.enterLastNameTextbox(DataTest_08_Admin.CustomerInfo.LAST_NAME);

		log.info("Create New Customer - Step 08: Select Gender radio button");
		adminCustomerInfoPage.checkToGenderRadio(DataTest_08_Admin.CustomerInfo.GENDER);

		log.info("Create New Customer - Step 09: Enter to DOB textbox");
		adminCustomerInfoPage.enterDOBTextbox(DataTest_08_Admin.CustomerInfo.DOB);

		log.info("Create New Customer - Step 10: Enter to Company textbox");
		adminCustomerInfoPage.enterCompanyTextbox(DataTest_08_Admin.CustomerInfo.COMPANY_NAME);

		log.info("Create New Customer - Step 11: Remove Default Customer Role");
		adminCustomerInfoPage.removeDefaultCustomerRole();

		log.info("Create New Customer - Step 12: Select new Customer Role");
		adminCustomerInfoPage.selectCustomerRoleDropdown(DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Create New Customer - Step 13: Check to Active checkbox");
		adminCustomerInfoPage.checkToActiveCheckbox();

		log.info("Create New Customer - Step 14: Check to Active checkbox");
		adminCustomerInfoPage.enterAdminCommentTextarea(DataTest_08_Admin.CustomerInfo.ADMIN_COMMENT);

		log.info("Create New Customer - Step 15: Click to 'Save and Continue Edit' button");
		adminCustomerInfoPage.clickToSaveAndContinueButton();

		log.info("Create New Customer - Step 16: Verify Add Customer Success Message");
		verifyEquals(adminCustomerInfoPage.getAddCustomerSuccessMsg(), DataTest_08_Admin.Message.ADD_CUSTOMER_SUCCESS_MSG);

		log.info("Create New Customer - Step 17: Click to back to customer list link");
		adminDashboardPage = adminCustomerInfoPage.clickToBackToCustomerListLink();

		log.info("Create New Customer - Step 18: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Create New Customer - Step 19: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Create New Customer - Step 20: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Create New Customer - Step 21: Verify Customer is shown with registered Full name");
		verifyTrue(adminDashboardPage.isFullNameShownInTable(DataTest_08_Admin.CustomerInfo.FULL_NAME));
	}

	@Test
	public void Admin_08_() {

	}

	@Test
	public void Admin_09_() {

	}

	@Test
	public void Admin_10_() {

	}

	@Test
	public void Admin_11_() {

	}

	@Test
	public void Admin_12_() {

	}

	@Test
	public void Admin_13_() {

	}

	@Test
	public void Admin_14_() {

	}

	@Test
	public void Admin_15_() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminProductInfoPageObject adminProductInfoPage;
	private AdminCustomerInfoPageObject adminCustomerInfoPage;
}