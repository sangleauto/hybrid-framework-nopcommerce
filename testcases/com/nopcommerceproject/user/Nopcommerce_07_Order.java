package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;
import com.nopcommerce.data.DataTest_07_Order;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserDesktopPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebookPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;

public class Nopcommerce_07_Order extends BaseTest {

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

	}

	@Test
	public void Order_01_Add_To_Cart() {

		log.info("Add to Cart - Step 01: Open Desktop page");
		homePage.openSubMenuHeader(driver, DataTest_07_Order.menuHeaderInfo.MENU_NAME, DataTest_07_Order.menuHeaderInfo.SUB_MENU_NAME_DESKTOP);
		desktopPage = PageGeneratorManager.getUserDesktopPage(driver);

		log.info("Add to Cart - Step 01: Open product detail page");
		desktopPage.openProductDetailPage(DataTest_07_Order.orderInfo.DESKTOP_BUILD_COMPUTER_NAME);

		log.info("Add to Cart - Step 01: Select 'Processor'");
		desktopPage.selectProcessorDropdown(DataTest_07_Order.orderInfo.PROCESSOR);

		log.info("Add to Cart - Step 01: Select 'RAM'");
		desktopPage.selectRAMdropdown(DataTest_07_Order.orderInfo.RAM);

		log.info("Add to Cart - Step 01: Select 'HDD'");
		desktopPage.checkToHDDRadioByName(DataTest_07_Order.orderInfo.HDD);

		log.info("Add to Cart - Step 01: Select 'OS'");
		desktopPage.checkToOSRadioByName(DataTest_07_Order.orderInfo.OS);

		log.info("Add to Cart - Step 01: Check to all 'Software'");
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.orderInfo.SOFTWARE_MICROSOFT);
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.orderInfo.SOFTWARE_ACROBAT);
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.orderInfo.SOFTWARE_COMMANDER);

		log.info("Add to Cart - Step 01: Click to 'ADD TO CART' button");
		desktopPage.clickToAddToCartButton();

		log.info("Add to Cart - Step 01: Verify Add to Cart success message");
		verifyEquals(desktopPage.getAddedToCartSuccessMsg(), DataTest_07_Order.orderMessage.ADD_TO_CART_MSG);

		log.info("Add to Cart - Step 01: Open Shopping Cart page");
		shoppingCartPage = desktopPage.openShoppingCartPage(driver);

		log.info("Add to Cart - Step 01: Verify Product infomations");
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.PROCESSOR));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.RAM));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.HDD));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.OS));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.SOFTWARE_MICROSOFT));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.SOFTWARE_ACROBAT));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.SOFTWARE_COMMANDER));

		log.info("Add to Cart - Step 01: Verify Product price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRICE_COLUMN), DataTest_07_Order.orderInfo.TOTAL_PRICE_CART);

		log.info("Add to Cart - Step 01: Verify Product quantity");
		verifyEquals(shoppingCartPage.getTextboxValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.QUANTITY_COLUMN), DataTest_07_Order.indexValue.INDEX_1);

		log.info("Add to Cart - Step 01: Verify Product Total price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.TOTAL_COLUMN), DataTest_07_Order.orderInfo.TOTAL_PRICE_CART);
	}

	@Test
	public void Order_02_Edit_Product_In_Cart() {
		log.info("Edit product in cart - Step 01: Click to Edit link");
		desktopPage = shoppingCartPage.clickToEditLink();

		log.info("Edit product in cart - Step 01: Select 'Processor'");
		desktopPage.selectProcessorDropdown(DataTest_07_Order.editOrderInfo.EDIT_PROCESSOR);

		log.info("Edit product in cart - Step 01: Select 'RAM'");
		desktopPage.selectRAMdropdown(DataTest_07_Order.editOrderInfo.EDIT_RAM);

		log.info("Edit product in cart - Step 01: Select 'HDD'");
		desktopPage.checkToHDDRadioByName(DataTest_07_Order.editOrderInfo.EDIT_HDD);

		log.info("Edit product in cart - Step 01: Select 'OS'");
		desktopPage.checkToOSRadioByName(DataTest_07_Order.editOrderInfo.EDIT_OS);

		log.info("Edit product in cart - Step 01: Check to Microsoft Software");
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.orderInfo.SOFTWARE_MICROSOFT);
		desktopPage.uncheckToSoftwareCheckbox(DataTest_07_Order.orderInfo.SOFTWARE_ACROBAT);
		desktopPage.uncheckToSoftwareCheckbox(DataTest_07_Order.orderInfo.SOFTWARE_COMMANDER);

		log.info("Edit product in cart - Step 01: Increase number of product to 2");
		desktopPage.enterNumberToProductAmountTextbox(DataTest_07_Order.indexValue.INDEX_2);

		log.info("Edit product in cart - Step 01: Verify new total price");
		verifyEquals(desktopPage.getTotalPrice(), DataTest_07_Order.editOrderInfo.TOTAL_PRICE_AFTER_EDIT);

		log.info("Edit product in cart - Step 01: Click to 'UPDATE' button");
		desktopPage.clickToUpdateButton();

		log.info("Edit product in cart - Step 01: Verify Add to Cart success message");
		verifyEquals(desktopPage.getAddedToCartSuccessMsg(), DataTest_07_Order.orderMessage.ADD_TO_CART_MSG);

		log.info("Edit product in cart - Step 01: Open Shopping Cart page");
		shoppingCartPage = desktopPage.openShoppingCartPage(driver);

		log.info("Edit product in cart - Step 01: Verify Product infomations");
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.editOrderInfo.EDIT_PROCESSOR));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.editOrderInfo.EDIT_RAM));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.editOrderInfo.EDIT_HDD));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.editOrderInfo.EDIT_OS));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.orderInfo.SOFTWARE_MICROSOFT));

		log.info("Edit product in cart - Step 01: Verify Product price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.PRICE_COLUMN), DataTest_07_Order.editOrderInfo.TOTAL_PRICE_AFTER_EDIT);

		log.info("Edit product in cart - Step 01: Verify Product quantity");
		verifyEquals(shoppingCartPage.getTextboxValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.QUANTITY_COLUMN), DataTest_07_Order.indexValue.INDEX_2);

		log.info("Edit product in cart - Step 01: Verify Product Total price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.TOTAL_COLUMN), DataTest_07_Order.editOrderInfo.TOTAL_PRICE_IN_CART_AFTER_EDIT);
	}

	@Test
	public void Order_03_Remove_From_Cart() {
		log.info("Remove from Cart - Step 01: Click to Remove button");
		shoppingCartPage.clickToButtonInCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.REMOVE_COLUMN);

		log.info("Remove from Cart - Step 01: Verify empty shopping cart message");
		verifyEquals(shoppingCartPage.getEmptyCartMsg(), DataTest_07_Order.orderMessage.EMPTY_CART_MSG);

		log.info("Remove from Cart - Step 01: Verify shopping cart table is disappeared");
		verifyTrue(shoppingCartPage.isShoppingCartTableUndisplayed());

	}

	@Test
	public void Order_04_Update_Shopping_Cart() {
		log.info("Update Shopping Cart - Step 01: Open Desktop page");
		shoppingCartPage.openSubMenuHeader(driver, DataTest_07_Order.menuHeaderInfo.MENU_NAME, DataTest_07_Order.menuHeaderInfo.SUB_MENU_NAME_DESKTOP);
		desktopPage = PageGeneratorManager.getUserDesktopPage(driver);

		log.info("Update Shopping Cart - Step 01: Open Product page");
		desktopPage.openProductDetailPage(DataTest_07_Order.orderInfo.DESKTOP_LENOVO_PRODUCT_NAME);

		log.info("Update Shopping Cart - Step 01: Click to 'ADD TO CART' button");
		desktopPage.clickToAddToCartButton();

		log.info("Update Shopping Cart - Step 01: Verify Add to Cart success message");
		verifyEquals(desktopPage.getAddedToCartSuccessMsg(), DataTest_07_Order.orderMessage.ADD_TO_CART_MSG);

		log.info("Update Shopping Cart - Step 01: Open Shopping Cart page");
		shoppingCartPage = desktopPage.openShoppingCartPage(driver);

		log.info("Update Shopping Cart - Step 01: Increase quantity = 5");
		shoppingCartPage.enterToTextboxByNameAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.QUANTITY_COLUMN, DataTest_07_Order.indexValue.INDEX_5);

		log.info("Update Shopping Cart - Step 01: Click to Update cart button");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		log.info("Update Shopping Cart - Step 01: Verify new total price in cart");
		verifyEquals(shoppingCartPage.getValueInUpdateCartAtRowAndColumnIndex(DataTest_07_Order.indexValue.INDEX_1, DataTest_07_Order.orderInfo.TOTAL_COLUMN), DataTest_07_Order.orderInfo.LENOVO_TOTAL_PRICE);
	}

	@Test
	public void Order_05_Checkout_Cheque() {

	}

	@Test
	public void Order_06_() {

	}

	@Test
	public void Order_07_() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String email, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserDesktopPageObject desktopPage;
	private UserNotebookPageObject notebookPage;
	private UserShoppingCartPageObject shoppingCartPage;
}