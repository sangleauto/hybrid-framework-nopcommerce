package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataTest_08_Admin;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminAddresssPageObject;
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

	@Test
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

	@Test
	public void Admin_02_Search_With_Product_Name_Category_Unchecked() {
		log.info("Search with Product name + Category + Unchecked - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

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

	@Test
	public void Admin_03_Search_With_Product_Name_Category_Checked() {
		log.info("Search with Product name + Category + Checked - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

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

	@Test
	public void Admin_04_Search_Product_Name_Child_Category() {
		log.info("Search with Product name + Child Category - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

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

	@Test
	public void Admin_05_Search_Product_Name_Manufacturer() {
		log.info("Search with Product name + Manufacturer - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

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

	@Test
	public void Admin_06_Go_Direct_To_Product_SKU() {
		log.info("Go directly to product SKU - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

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

		log.info("Go directly to product SKU - Step 07: Verify SKU");
		verifyEquals(adminProductInfoPage.getSKU(), DataTest_08_Admin.ProductInfo.SKU_LENOVO);

		log.info("Go directly to product SKU - Step 08: Verify Price");
		adminProductInfoPage.clickToExpandPrices();
		verifyEquals(adminProductInfoPage.getPrice(), DataTest_08_Admin.ProductInfo.PRICE_LENOVO);

		log.info("Go directly to product SKU - Step 09: Verify Stock number");
		verifyEquals(adminProductInfoPage.getStockQuantity(), DataTest_08_Admin.ProductInfo.STOCK_LENOVO);
	}

	@Test
	public void Admin_07_Create_New_Customer() {
		log.info("Create New Customer - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

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

		log.info("Create New Customer - Step 14: Input content to Admin comment");
		adminCustomerInfoPage.enterAdminCommentTextarea(DataTest_08_Admin.CustomerInfo.ADMIN_COMMENT);

		log.info("Create New Customer - Step 15: Click to 'Save and Continue Edit' button");
		adminCustomerInfoPage.clickToSaveAndContinueButton();

		log.info("Create New Customer - Step 16: Verify Add Customer Success Message");
		verifyEquals(adminCustomerInfoPage.getAddCustomerSuccessMsg(), DataTest_08_Admin.Message.ADD_CUSTOMER_SUCCESS_MSG);

		log.info("Create New Customer - Step 17: Verify created Email");
		verifyEquals(adminCustomerInfoPage.getEmail(), DataTest_08_Admin.CustomerInfo.EMAIL);

		log.info("Create New Customer - Step 18: Verify created First name");
		verifyEquals(adminCustomerInfoPage.getFirstName(), DataTest_08_Admin.CustomerInfo.FIRST_NAME);

		log.info("Create New Customer - Step 19: Verify created Last name");
		verifyEquals(adminCustomerInfoPage.getLastName(), DataTest_08_Admin.CustomerInfo.LAST_NAME);

		log.info("Create New Customer - Step 20: Verify Gender radio checkbox");
		verifyTrue(adminCustomerInfoPage.isGenderRadioChecked(DataTest_08_Admin.CustomerInfo.GENDER));

		log.info("Create New Customer - Step 21: Verify created DOB");
		verifyEquals(adminCustomerInfoPage.getDOB(), DataTest_08_Admin.CustomerInfo.DOB);

		log.info("Create New Customer - Step 22: Verify created Company name");
		verifyEquals(adminCustomerInfoPage.getCompanyName(), DataTest_08_Admin.CustomerInfo.COMPANY_NAME);

		log.info("Create New Customer - Step 23: Verify created Customer Role");
		verifyEquals(adminCustomerInfoPage.getCustomerRole(), DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Create New Customer - Step 24: Verify Active checkbox is checked");
		verifyTrue(adminCustomerInfoPage.isActiveCheckboxChecked());

		log.info("Create New Customer - Step 25: Verify Admin comment content");
		verifyEquals(adminCustomerInfoPage.getAdminComment(), DataTest_08_Admin.CustomerInfo.ADMIN_COMMENT);

		log.info("Create New Customer - Step 26: Click to back to customer list link");
		adminDashboardPage = adminCustomerInfoPage.clickToBackToCustomerListLink();

		log.info("Create New Customer - Step 27: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Create New Customer - Step 28: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Create New Customer - Step 29: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Create New Customer - Step 30: Verify Customer is shown with registered Full name");
		verifyTrue(adminDashboardPage.isFullNameShownInTable(DataTest_08_Admin.CustomerInfo.FULL_NAME));
	}

	@Test
	public void Admin_08_Search_Customer_With_Email() {
		log.info("Search Customer with Email - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

		log.info("Search Customer with Email - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Search Customer with Email - Step 03: Enter Email textbox");
		adminDashboardPage.enterEmailTextbox(DataTest_08_Admin.CustomerInfo.EMAIL);

		log.info("Search Customer with Email - Step 04: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Search Customer with Email - Step 05: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Search Customer with Email - Step 06: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Search Customer with Email - Step 07: Verify info in table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.NAME_COLUMN), DataTest_08_Admin.CustomerInfo.FULL_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.ROLE_COLUMN), DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.COMPANY_COLUMN), DataTest_08_Admin.CustomerInfo.COMPANY_NAME);

	}

	@Test
	public void Admin_09_Search_Customer_With_Firstname_Lastname() {
		log.info("Search Customer with First and Last name - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

		log.info("Search Customer with First and Last name - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Search Customer with First and Last name - Step 03: Enter First name textbox");
		adminDashboardPage.enterFirstNameTextbox(DataTest_08_Admin.CustomerInfo.FIRST_NAME);

		log.info("Search Customer with First and Last name - Step 04: Enter Last name textbox");
		adminDashboardPage.enterLastNameTextbox(DataTest_08_Admin.CustomerInfo.LAST_NAME);

		log.info("Search Customer with First and Last name - Step 05: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Search Customer with First and Last name - Step 06: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Search Customer with First and Last name - Step 07: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Search Customer with First and Last name - Step 08: Verify info in table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.NAME_COLUMN), DataTest_08_Admin.CustomerInfo.FULL_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.ROLE_COLUMN), DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.COMPANY_COLUMN), DataTest_08_Admin.CustomerInfo.COMPANY_NAME);
	}

	@Test
	public void Admin_10_Search_Customer_With_Company() {
		log.info("Search Customer with Company - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

		log.info("Search Customer with Company - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Search Customer with Company - Step 03: Enter Company textbox");
		adminDashboardPage.enterCompanyTextbox(DataTest_08_Admin.CustomerInfo.COMPANY_NAME);

		log.info("Search Customer with Company - Step 04: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Search Customer with Company - Step 05: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Search Customer with Company - Step 06: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Search Customer with Company - Step 07: Verify info in table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.NAME_COLUMN), DataTest_08_Admin.CustomerInfo.FULL_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.ROLE_COLUMN), DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.COMPANY_COLUMN), DataTest_08_Admin.CustomerInfo.COMPANY_NAME);
	}

	@Test
	public void Admin_11_Search_Customer_Full_Data() {
		log.info("Search Customer with Full Data - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

		log.info("Search Customer with Full Data - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Search Customer with Full Data - Step 03: Enter Email textbox");
		adminDashboardPage.enterEmailTextbox(DataTest_08_Admin.CustomerInfo.EMAIL);

		log.info("Search Customer with Full Data - Step 04: Enter First name textbox");
		adminDashboardPage.enterFirstNameTextbox(DataTest_08_Admin.CustomerInfo.FIRST_NAME);

		log.info("Search Customer with Full Data - Step 05: Enter Last name textbox");
		adminDashboardPage.enterLastNameTextbox(DataTest_08_Admin.CustomerInfo.LAST_NAME);

		log.info("Search Customer with Full Data - Step 06: Select Month DOB dropdown");
		adminDashboardPage.selectMonthDropdown(DataTest_08_Admin.CustomerInfo.DOB_MONTH);

		log.info("Search Customer with Full Data - Step 07: Enter Day DOB dropdown");
		adminDashboardPage.selectDayDropdown(DataTest_08_Admin.CustomerInfo.DOB_DAY);

		log.info("Search Customer with Full Data - Step 08: Enter Company textbox");
		adminDashboardPage.enterCompanyTextbox(DataTest_08_Admin.CustomerInfo.COMPANY_NAME);

		log.info("Search Customer with Full Data - Step 09: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Search Customer with Full Data - Step 10: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);

		log.info("Search Customer with Full Data - Step 11: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Search Customer with Full Data - Step 12: Verify info in table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.NAME_COLUMN), DataTest_08_Admin.CustomerInfo.FULL_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.ROLE_COLUMN), DataTest_08_Admin.CustomerInfo.CUSTOMER_ROLE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.COMPANY_COLUMN), DataTest_08_Admin.CustomerInfo.COMPANY_NAME);
	}

	@Test
	public void Admin_12_Edit_Customer() {
		log.info("Edit Customer - Step 01: Click to 'Edit' button");
		adminCustomerInfoPage = adminDashboardPage.clickToEditButton();

		log.info("Edit Customer - Step 02: Enter new value to Email textbox");
		adminCustomerInfoPage.enterEmailTextbox(DataTest_08_Admin.EditCustomerInfo.EMAIL);

		log.info("Edit Customer - Step 03: Enter new value to First name textbox");
		adminCustomerInfoPage.enterFirstNameTextbox(DataTest_08_Admin.EditCustomerInfo.FIRST_NAME);

		log.info("Edit Customer - Step 04: Enter new value to Last name textbox");
		adminCustomerInfoPage.enterLastNameTextbox(DataTest_08_Admin.EditCustomerInfo.LAST_NAME);

		log.info("Edit Customer - Step 05: Enter new value to DOB textbox");
		adminCustomerInfoPage.enterDOBTextbox(DataTest_08_Admin.EditCustomerInfo.DOB);

		log.info("Edit Customer - Step 06: Enter new value to Company textbox");
		adminCustomerInfoPage.enterCompanyTextbox(DataTest_08_Admin.EditCustomerInfo.COMPANY_NAME);

		log.info("Edit Customer - Step 07: Input content to Admin comment");
		adminCustomerInfoPage.enterAdminCommentTextarea(DataTest_08_Admin.EditCustomerInfo.ADMIN_COMMENT);

		log.info("Edit Customer - Step 08: Click to 'Save' button");
		adminDashboardPage = adminCustomerInfoPage.clickToSaveButton();

		log.info("Edit Customer - Step 09: Verify Updated Success Message");
		verifyEquals(adminDashboardPage.getEditSuccessMessage(), DataTest_08_Admin.Message.EDIT_CUSTOMER_SUCCESS_MSG);

		log.info("Edit Customer - Step 10: Enter Email textbox");
		adminDashboardPage.enterEmailTextbox(DataTest_08_Admin.EditCustomerInfo.EMAIL);

		log.info("Edit Customer - Step 11: Enter First name textbox");
		adminDashboardPage.enterFirstNameTextbox(DataTest_08_Admin.EditCustomerInfo.FIRST_NAME);

		log.info("Edit Customer - Step 12: Enter Last name textbox");
		adminDashboardPage.enterLastNameTextbox(DataTest_08_Admin.EditCustomerInfo.LAST_NAME);

		log.info("Edit Customer - Step 13: Select Month DOB dropdown");
		adminDashboardPage.selectMonthDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_MONTH);

		log.info("Edit Customer - Step 14: Enter Day DOB dropdown");
		adminDashboardPage.selectDayDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_DAY);

		log.info("Edit Customer - Step 15: Enter Company textbox");
		adminDashboardPage.enterCompanyTextbox(DataTest_08_Admin.EditCustomerInfo.COMPANY_NAME);

		log.info("Edit Customer - Step 16: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Edit Customer - Step 17: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.EditCustomerInfo.CUSTOMER_ROLE);

		log.info("Edit Customer - Step 18: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Edit Customer - Step 19: Verify info in table");
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.NAME_COLUMN), DataTest_08_Admin.EditCustomerInfo.FULL_NAME);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.ROLE_COLUMN), DataTest_08_Admin.EditCustomerInfo.CUSTOMER_ROLE);
		verifyEquals(adminDashboardPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.CustomerInfo.COMPANY_COLUMN), DataTest_08_Admin.EditCustomerInfo.COMPANY_NAME);

	}

	@Test
	public void Admin_13_Add_New_Address() {
		log.info("Add New Address - Step 01: Back to Home page");
		adminDashboardPage.clickToNopLogo(driver);

		log.info("Add New Address - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Add New Address - Step 03: Enter Email textbox");
		adminDashboardPage.enterEmailTextbox(DataTest_08_Admin.EditCustomerInfo.EMAIL);

		log.info("Add New Address - Step 04: Enter First name textbox");
		adminDashboardPage.enterFirstNameTextbox(DataTest_08_Admin.EditCustomerInfo.FIRST_NAME);

		log.info("Add New Address - Step 05: Enter Last name textbox");
		adminDashboardPage.enterLastNameTextbox(DataTest_08_Admin.EditCustomerInfo.LAST_NAME);

		log.info("Add New Address - Step 06: Select Month DOB dropdown");
		adminDashboardPage.selectMonthDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_MONTH);

		log.info("Add New Address - Step 07: Enter Day DOB dropdown");
		adminDashboardPage.selectDayDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_DAY);

		log.info("Add New Address - Step 08: Enter Company textbox");
		adminDashboardPage.enterCompanyTextbox(DataTest_08_Admin.EditCustomerInfo.COMPANY_NAME);

		log.info("Add New Address - Step 09: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Add New Address - Step 10: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.EditCustomerInfo.CUSTOMER_ROLE);

		log.info("Add New Address - Step 11: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Add New Address - Step 12: Click to 'Edit' button");
		adminCustomerInfoPage = adminDashboardPage.clickToEditButton();

		log.info("Add New Address - Step 13: Expand Address Tab");
		adminCustomerInfoPage.clickToAddressTab();

		log.info("Add New Address - Step 14: Click to 'Add new address' button");
		adminAddressPage = adminCustomerInfoPage.clickToAddNewAddressButton();

		log.info("Add New Address - Step 15: Enter First name textbox");
		adminAddressPage.enterFirstNameTextbox(DataTest_08_Admin.AddressInfo.FIRST_NAME);

		log.info("Add New Address - Step 16: Enter Last name textbox");
		adminAddressPage.enterLastNameTextbox(DataTest_08_Admin.AddressInfo.LAST_NAME);

		log.info("Add New Address - Step 17: Enter Email textbox");
		adminAddressPage.enterEmailTextbox(DataTest_08_Admin.AddressInfo.EMAIL);

		log.info("Add New Address - Step 18: Enter Company textbox");
		adminAddressPage.enterCompanyTextbox(DataTest_08_Admin.AddressInfo.COMPANY_NAME);

		log.info("Add New Address - Step 19: Select Country dropdown");
		adminAddressPage.selectCountryDropdown(DataTest_08_Admin.AddressInfo.COUNTRY);

		log.info("Add New Address - Step 20: Select State dropdown");
		adminAddressPage.selectStateDropdown(DataTest_08_Admin.AddressInfo.STATE);

		log.info("Add New Address - Step 21: Enter City textbox");
		adminAddressPage.enterCityTextbox(DataTest_08_Admin.AddressInfo.CITY);

		log.info("Add New Address - Step 22: Enter Address1 textbox");
		adminAddressPage.enterAddress1Textbox(DataTest_08_Admin.AddressInfo.ADDRESS1);

		log.info("Add New Address - Step 23: Enter Zip code textbox");
		adminAddressPage.enterZipCodeTextbox(DataTest_08_Admin.AddressInfo.ZIP_CODE);

		log.info("Add New Address - Step 24: Enter Phone number textbox");
		adminAddressPage.enterPhoneNumberTextbox(DataTest_08_Admin.AddressInfo.PHONE_NUMBER);

		log.info("Add New Address - Step 25: Click to Save button");
		adminAddressPage.clickToSaveButton();

		log.info("Add New Address - Step 26: Verify Add Address Success Message");
		verifyEquals(adminAddressPage.getAddAddressSuccessMsg(), DataTest_08_Admin.Message.ADD_ADDRESS_SUCCESS_MSG);

		log.info("Add New Address - Step 27: Verify First name textbox");
		verifyEquals(adminAddressPage.getFirstName(), DataTest_08_Admin.AddressInfo.FIRST_NAME);

		log.info("Add New Address - Step 28: Verify Last name textbox");
		verifyEquals(adminAddressPage.getLastName(), DataTest_08_Admin.AddressInfo.LAST_NAME);

		log.info("Add New Address - Step 29: Verify Email textbox");
		verifyEquals(adminAddressPage.getEmail(), DataTest_08_Admin.AddressInfo.EMAIL);

		log.info("Add New Address - Step 30: Verify Company textbox");
		verifyEquals(adminAddressPage.getCompanyName(), DataTest_08_Admin.AddressInfo.COMPANY_NAME);

		log.info("Add New Address - Step 31: Verify Country dropdown");
		verifyEquals(adminAddressPage.getCountryInDropdown(), DataTest_08_Admin.AddressInfo.COUNTRY);

		log.info("Add New Address - Step 32: Verify State/ province dropdown");
		verifyEquals(adminAddressPage.getStateInDropdown(), DataTest_08_Admin.AddressInfo.STATE);

		log.info("Add New Address - Step 33: Verify City textbox");
		verifyEquals(adminAddressPage.getCity(), DataTest_08_Admin.AddressInfo.CITY);

		log.info("Add New Address - Step 34: Verify Address1 textbox");
		verifyEquals(adminAddressPage.getAddress1(), DataTest_08_Admin.AddressInfo.ADDRESS1);

		log.info("Add New Address - Step 35: Verify Zip code textbox");
		verifyEquals(adminAddressPage.getZipCode(), DataTest_08_Admin.AddressInfo.ZIP_CODE);

		log.info("Add New Address - Step 36: Verify Phone number textbox");
		verifyEquals(adminAddressPage.getPhoneNumber(), DataTest_08_Admin.AddressInfo.PHONE_NUMBER);

		log.info("Add New Address - Step 37: Click to 'back to customer details' link");
		adminCustomerInfoPage = adminAddressPage.clickToBackToCustomerLink();

		log.info("Add New Address - Step 38: Verify info in Addresses table");
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.FIRST_NAME_COLUMN), DataTest_08_Admin.AddressInfo.FIRST_NAME);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.LAST_NAME_COLUMN), DataTest_08_Admin.AddressInfo.LAST_NAME);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.EMAIL_COLUMN), DataTest_08_Admin.AddressInfo.EMAIL);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.PHONE_COLUMN), DataTest_08_Admin.AddressInfo.PHONE_NUMBER);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.ADDRESS_COLUMN), DataTest_08_Admin.AddressInfo.ADDRESS_CONTENT_TABLE);

	}

	@Test
	public void Admin_14_Edit_Address_In_Customer_Detail() {
		log.info("Edit Address In Customer Detail - Step 01: Back to Home page");
		adminCustomerInfoPage.clickToNopLogo(driver);
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);

		log.info("Edit Address In Customer Detail - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Edit Address In Customer Detail - Step 03: Enter Email textbox");
		adminDashboardPage.enterEmailTextbox(DataTest_08_Admin.EditCustomerInfo.EMAIL);

		log.info("Edit Address In Customer Detail - Step 04: Enter First name textbox");
		adminDashboardPage.enterFirstNameTextbox(DataTest_08_Admin.EditCustomerInfo.FIRST_NAME);

		log.info("Edit Address In Customer Detail - Step 05: Enter Last name textbox");
		adminDashboardPage.enterLastNameTextbox(DataTest_08_Admin.EditCustomerInfo.LAST_NAME);

		log.info("Edit Address In Customer Detail - Step 06: Select Month DOB dropdown");
		adminDashboardPage.selectMonthDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_MONTH);

		log.info("Edit Address In Customer Detail - Step 07: Enter Day DOB dropdown");
		adminDashboardPage.selectDayDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_DAY);

		log.info("Edit Address In Customer Detail - Step 08: Enter Company textbox");
		adminDashboardPage.enterCompanyTextbox(DataTest_08_Admin.EditCustomerInfo.COMPANY_NAME);

		log.info("Edit Address In Customer Detail - Step 09: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Edit Address In Customer Detail - Step 10: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.EditCustomerInfo.CUSTOMER_ROLE);

		log.info("Edit Address In Customer Detail - Step 11: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Edit Address In Customer Detail - Step 12: Click to 'Edit' button");
		adminCustomerInfoPage = adminDashboardPage.clickToEditButton();

		log.info("Edit Address In Customer Detail - Step 14: Expand Address Tab");
		adminCustomerInfoPage.clickToAddressTab();

		log.info("Edit Address In Customer Detail - Step 15: Click to Edit Address button");
		adminAddressPage = adminCustomerInfoPage.clickToEditAddressButton();

		log.info("Edit Address In Customer Detail - Step 16: Edit First name textbox");
		adminAddressPage.enterFirstNameTextbox(DataTest_08_Admin.EditAddressInfo.FIRST_NAME);

		log.info("Edit Address In Customer Detail - Step 17: Edit Last name textbox");
		adminAddressPage.enterLastNameTextbox(DataTest_08_Admin.EditAddressInfo.LAST_NAME);

		log.info("Edit Address In Customer Detail - Step 18: Edit Email textbox");
		adminAddressPage.enterEmailTextbox(DataTest_08_Admin.EditAddressInfo.EMAIL);

		log.info("Edit Address In Customer Detail - Step 19: Edit Company textbox");
		adminAddressPage.enterCompanyTextbox(DataTest_08_Admin.EditAddressInfo.COMPANY_NAME);

		log.info("Edit Address In Customer Detail - Step 20: Select new Country dropdown");
		adminAddressPage.selectCountryDropdown(DataTest_08_Admin.EditAddressInfo.COUNTRY);

		log.info("Edit Address In Customer Detail - Step 21: Select new State dropdown");
		adminAddressPage.selectStateDropdown(DataTest_08_Admin.EditAddressInfo.STATE);

		log.info("Edit Address In Customer Detail - Step 22: Edit City textbox");
		adminAddressPage.enterCityTextbox(DataTest_08_Admin.EditAddressInfo.CITY);

		log.info("Edit Address In Customer Detail - Step 23: Edit Address1 textbox");
		adminAddressPage.enterAddress1Textbox(DataTest_08_Admin.EditAddressInfo.ADDRESS1);

		log.info("Edit Address In Customer Detail - Step 24: Edit Zip code textbox");
		adminAddressPage.enterZipCodeTextbox(DataTest_08_Admin.EditAddressInfo.ZIP_CODE);

		log.info("Edit Address In Customer Detail - Step 25: Edit Phone number textbox");
		adminAddressPage.enterPhoneNumberTextbox(DataTest_08_Admin.EditAddressInfo.PHONE_NUMBER);

		log.info("Edit Address In Customer Detail - Step 26: Click to Save button");
		adminAddressPage.clickToSaveButtonInEditAddress();

		log.info("Edit Address In Customer Detail - Step 27: Verify Edit Address Success Message");
		verifyEquals(adminAddressPage.getAddAddressSuccessMsg(), DataTest_08_Admin.Message.UPDATE_ADDRESS_SUCCESS_MSG);

		log.info("Edit Address In Customer Detail - Step 28: Verify Edited First name textbox");
		verifyEquals(adminAddressPage.getFirstName(), DataTest_08_Admin.EditAddressInfo.FIRST_NAME);

		log.info("Edit Address In Customer Detail - Step 29: Verify Edited Last name textbox");
		verifyEquals(adminAddressPage.getLastName(), DataTest_08_Admin.EditAddressInfo.LAST_NAME);

		log.info("Edit Address In Customer Detail - Step 30: Verify Edited Email textbox");
		verifyEquals(adminAddressPage.getEmail(), DataTest_08_Admin.EditAddressInfo.EMAIL);

		log.info("Edit Address In Customer Detail - Step 31: Verify EditedCompany textbox");
		verifyEquals(adminAddressPage.getCompanyName(), DataTest_08_Admin.EditAddressInfo.COMPANY_NAME);

		log.info("Edit Address In Customer Detail - Step 32: Verify Edited Country dropdown");
		verifyEquals(adminAddressPage.getCountryInDropdown(), DataTest_08_Admin.EditAddressInfo.COUNTRY);

		log.info("Edit Address In Customer Detail - Step 33: Verify Edited State/ province dropdown");
		verifyEquals(adminAddressPage.getStateInDropdown(), DataTest_08_Admin.EditAddressInfo.STATE);

		log.info("Edit Address In Customer Detail - Step 34: Verify Edited City textbox");
		verifyEquals(adminAddressPage.getCity(), DataTest_08_Admin.EditAddressInfo.CITY);

		log.info("Edit Address In Customer Detail - Step 35: Verify Edited Address1 textbox");
		verifyEquals(adminAddressPage.getAddress1(), DataTest_08_Admin.EditAddressInfo.ADDRESS1);

		log.info("Edit Address In Customer Detail - Step 36: Verify Edited Zip code textbox");
		verifyEquals(adminAddressPage.getZipCode(), DataTest_08_Admin.EditAddressInfo.ZIP_CODE);

		log.info("Edit Address In Customer Detail - Step 37: Verify Edited Phone number textbox");
		verifyEquals(adminAddressPage.getPhoneNumber(), DataTest_08_Admin.EditAddressInfo.PHONE_NUMBER);

		log.info("Edit Address In Customer Detail - Step 38: Click to 'back to customer details' link");
		adminCustomerInfoPage = adminAddressPage.clickToBackToCustomerLink();

		log.info("Edit Address In Customer Detail - Step 39: Verify info in Addresses table");
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.FIRST_NAME_COLUMN), DataTest_08_Admin.EditAddressInfo.FIRST_NAME);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.LAST_NAME_COLUMN), DataTest_08_Admin.EditAddressInfo.LAST_NAME);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.EMAIL_COLUMN), DataTest_08_Admin.EditAddressInfo.EMAIL);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.PHONE_COLUMN), DataTest_08_Admin.EditAddressInfo.PHONE_NUMBER);
		verifyEquals(adminCustomerInfoPage.getValueInTableAtRowAndColumnIndex(DataTest_08_Admin.ProductInfo.INDEX_1, DataTest_08_Admin.AddressInfo.ADDRESS_COLUMN), DataTest_08_Admin.EditAddressInfo.ADDRESS_CONTENT_TABLE);

	}

	@Test
	public void Admin_15_Delete_Address_In_Customer_Detail() {
		log.info("Delete Address In Customer Detail - Step 01: Back to Home page");
		adminCustomerInfoPage.clickToNopLogo(driver);
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);

		log.info("Delete Address In Customer Detail - Step 02: Open Customers > Customers in Sidebar");
		adminDashboardPage.openSidebarAdmin(driver, DataTest_08_Admin.SidebarInfo.CUSTOMERS, DataTest_08_Admin.SidebarInfo.CUSTOMERS_SUB);

		log.info("Delete Address In Customer Detail - Step 03: Enter Email textbox");
		adminDashboardPage.enterEmailTextbox(DataTest_08_Admin.EditCustomerInfo.EMAIL);

		log.info("Delete Address In Customer Detail - Step 04: Enter First name textbox");
		adminDashboardPage.enterFirstNameTextbox(DataTest_08_Admin.EditCustomerInfo.FIRST_NAME);

		log.info("Delete Address In Customer Detail - Step 05: Enter Last name textbox");
		adminDashboardPage.enterLastNameTextbox(DataTest_08_Admin.EditCustomerInfo.LAST_NAME);

		log.info("Delete Address In Customer Detail - Step 06: Select Month DOB dropdown");
		adminDashboardPage.selectMonthDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_MONTH);

		log.info("Delete Address In Customer Detail - Step 07: Enter Day DOB dropdown");
		adminDashboardPage.selectDayDropdown(DataTest_08_Admin.EditCustomerInfo.DOB_DAY);

		log.info("Delete Address In Customer Detail - Step 08: Enter Company textbox");
		adminDashboardPage.enterCompanyTextbox(DataTest_08_Admin.EditCustomerInfo.COMPANY_NAME);

		log.info("Delete Address In Customer Detail - Step 09: Remove Default Customer Role");
		adminDashboardPage.removeDefaultCustomerRole();

		log.info("Delete Address In Customer Detail - Step 10: Select Customer Role = Guests");
		adminDashboardPage.selectCustomerRoleDropdown(DataTest_08_Admin.EditCustomerInfo.CUSTOMER_ROLE);

		log.info("Delete Address In Customer Detail - Step 11: Click to Search button");
		adminDashboardPage.clickToSearchCustomerButton();

		log.info("Delete Address In Customer Detail - Step 12: Click to 'Edit' button");
		adminCustomerInfoPage = adminDashboardPage.clickToEditButton();

		log.info("Delete Address In Customer Detail - Step 13: Expand Address Tab");
		adminCustomerInfoPage.clickToAddressTab();

		log.info("Delete Address In Customer Detail - Step 14: Click to Delete Address button");
		adminCustomerInfoPage.clickToDeleteAddressButton();

		log.info("Delete Address In Customer Detail - Step 15: Accept Delete Alert");
		adminCustomerInfoPage.acceptDeleteAlert();

		log.info("Delete Address In Customer Detail - Step 16: Verify data is empty after deleted");
		verifyEquals(adminCustomerInfoPage.getNoDataMessageInTable(), DataTest_08_Admin.Message.NO_DATA_MSG);
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
	private AdminAddresssPageObject adminAddressPage;
}