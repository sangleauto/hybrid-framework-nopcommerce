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
import pageObjects.nopCommerce.user.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserDesktopPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebookPageObject;
import pageObjects.nopCommerce.user.UserOrderPageObject;
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
		homePage.openSubMenuHeader(driver, DataTest_07_Order.MenuHeaderInfo.MENU_NAME, DataTest_07_Order.MenuHeaderInfo.SUB_MENU_NAME_DESKTOP);
		desktopPage = PageGeneratorManager.getUserDesktopPage(driver);

		log.info("Add to Cart - Step 02: Open product detail page");
		desktopPage.openProductDetailPage(DataTest_07_Order.OrderInfo.DESKTOP_BUILD_COMPUTER_NAME);

		log.info("Add to Cart - Step 03: Select 'Processor'");
		desktopPage.selectProcessorDropdown(DataTest_07_Order.OrderInfo.PROCESSOR);

		log.info("Add to Cart - Step 04: Select 'RAM'");
		desktopPage.selectRAMdropdown(DataTest_07_Order.OrderInfo.RAM);

		log.info("Add to Cart - Step 05: Select 'HDD'");
		desktopPage.checkToHDDRadioByName(DataTest_07_Order.OrderInfo.HDD);

		log.info("Add to Cart - Step 06: Select 'OS'");
		desktopPage.checkToOSRadioByName(DataTest_07_Order.OrderInfo.OS);

		log.info("Add to Cart - Step 07: Check to all 'Software'");
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.OrderInfo.SOFTWARE_MICROSOFT);
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.OrderInfo.SOFTWARE_ACROBAT);
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.OrderInfo.SOFTWARE_COMMANDER);

		log.info("Add to Cart - Step 08: Click to 'ADD TO CART' button");
		desktopPage.clickToAddToCartButton();

		log.info("Add to Cart - Step 09: Verify Add to Cart success message");
		verifyEquals(desktopPage.getAddedToCartSuccessMsg(), DataTest_07_Order.OrderMessage.ADD_TO_CART_MSG);

		log.info("Add to Cart - Step 10: Open Shopping Cart page");
		shoppingCartPage = desktopPage.openShoppingCartPage(driver);

		log.info("Add to Cart - Step 11: Verify Product infomations");
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.PROCESSOR));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.RAM));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.HDD));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.OS));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.SOFTWARE_MICROSOFT));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.SOFTWARE_ACROBAT));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.SOFTWARE_COMMANDER));

		log.info("Add to Cart - Step 12: Verify Product price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN), DataTest_07_Order.OrderInfo.TOTAL_PRICE_CART);

		log.info("Add to Cart - Step 13: Verify Product quantity");
		verifyEquals(shoppingCartPage.getTextboxValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN), DataTest_07_Order.IndexValue.INDEX_1);

		log.info("Add to Cart - Step 14: Verify Product Total price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN), DataTest_07_Order.OrderInfo.TOTAL_PRICE_CART);
	}

	@Test
	public void Order_02_Edit_Product_In_Cart() {
		log.info("Edit product in cart - Step 01: Click to Edit link");
		desktopPage = shoppingCartPage.clickToEditLink();

		log.info("Edit product in cart - Step 02: Select 'Processor'");
		desktopPage.selectProcessorDropdown(DataTest_07_Order.EditOrderInfo.EDIT_PROCESSOR);

		log.info("Edit product in cart - Step 03: Select 'RAM'");
		desktopPage.selectRAMdropdown(DataTest_07_Order.EditOrderInfo.EDIT_RAM);

		log.info("Edit product in cart - Step 04: Select 'HDD'");
		desktopPage.checkToHDDRadioByName(DataTest_07_Order.EditOrderInfo.EDIT_HDD);

		log.info("Edit product in cart - Step 05: Select 'OS'");
		desktopPage.checkToOSRadioByName(DataTest_07_Order.EditOrderInfo.EDIT_OS);

		log.info("Edit product in cart - Step 06: Check to Microsoft Software");
		desktopPage.checkToSoftwareCheckboxByName(DataTest_07_Order.OrderInfo.SOFTWARE_MICROSOFT);
		desktopPage.uncheckToSoftwareCheckbox(DataTest_07_Order.OrderInfo.SOFTWARE_ACROBAT);
		desktopPage.uncheckToSoftwareCheckbox(DataTest_07_Order.OrderInfo.SOFTWARE_COMMANDER);

		log.info("Edit product in cart - Step 07: Increase number of product to 2");
		desktopPage.enterNumberToProductAmountTextbox(DataTest_07_Order.IndexValue.INDEX_2);

		log.info("Edit product in cart - Step 08: Verify new total price");
		verifyEquals(desktopPage.getTotalPrice(), DataTest_07_Order.EditOrderInfo.TOTAL_PRICE_AFTER_EDIT);

		log.info("Edit product in cart - Step 09: Click to 'UPDATE' button");
		desktopPage.clickToUpdateButton();

		log.info("Edit product in cart - Step 10: Verify Add to Cart success message");
		verifyEquals(desktopPage.getAddedToCartSuccessMsg(), DataTest_07_Order.OrderMessage.ADD_TO_CART_MSG);

		log.info("Edit product in cart - Step 11: Open Shopping Cart page");
		shoppingCartPage = desktopPage.openShoppingCartPage(driver);

		log.info("Edit product in cart - Step 12: Verify Product infomations");
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.EditOrderInfo.EDIT_PROCESSOR));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.EditOrderInfo.EDIT_RAM));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.EditOrderInfo.EDIT_HDD));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.EditOrderInfo.EDIT_OS));
		verifyTrue(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN).contains(DataTest_07_Order.OrderInfo.SOFTWARE_MICROSOFT));

		log.info("Edit product in cart - Step 13: Verify Product price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN), DataTest_07_Order.EditOrderInfo.TOTAL_PRICE_AFTER_EDIT);

		log.info("Edit product in cart - Step 14: Verify Product quantity");
		verifyEquals(shoppingCartPage.getTextboxValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN), DataTest_07_Order.IndexValue.INDEX_2);

		log.info("Edit product in cart - Step 15: Verify Product Total price");
		verifyEquals(shoppingCartPage.getValueInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN), DataTest_07_Order.EditOrderInfo.TOTAL_PRICE_IN_CART_AFTER_EDIT);
	}

	@Test
	public void Order_03_Remove_From_Cart() {
		log.info("Remove from Cart - Step 01: Click to Remove button");
		shoppingCartPage.clickToButtonInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.REMOVE_COLUMN);

		log.info("Remove from Cart - Step 02: Verify empty shopping cart message");
		verifyEquals(shoppingCartPage.getEmptyCartMsg(), DataTest_07_Order.OrderMessage.EMPTY_CART_MSG);

		log.info("Remove from Cart - Step 03: Verify shopping cart table is disappeared");
		verifyTrue(shoppingCartPage.isShoppingCartTableUndisplayed());

	}

	@Test
	public void Order_04_Update_Shopping_Cart() {
		log.info("Update Shopping Cart - Step 01: Open Desktop page");
		shoppingCartPage.openSubMenuHeader(driver, DataTest_07_Order.MenuHeaderInfo.MENU_NAME, DataTest_07_Order.MenuHeaderInfo.SUB_MENU_NAME_DESKTOP);
		desktopPage = PageGeneratorManager.getUserDesktopPage(driver);

		log.info("Update Shopping Cart - Step 02: Open Product page");
		desktopPage.openProductDetailPage(DataTest_07_Order.OrderInfo.DESKTOP_LENOVO_PRODUCT_NAME);

		log.info("Update Shopping Cart - Step 03: Click to 'ADD TO CART' button");
		desktopPage.clickToAddToCartButton();

		log.info("Update Shopping Cart - Step 04: Verify Add to Cart success message");
		verifyEquals(desktopPage.getAddedToCartSuccessMsg(), DataTest_07_Order.OrderMessage.ADD_TO_CART_MSG);

		log.info("Update Shopping Cart - Step 05: Open Shopping Cart page");
		shoppingCartPage = desktopPage.openShoppingCartPage(driver);

		log.info("Update Shopping Cart - Step 06: Increase quantity = 5");
		shoppingCartPage.enterToTextboxAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN, DataTest_07_Order.IndexValue.INDEX_5);

		log.info("Update Shopping Cart - Step 07: Click to Update cart button");
		shoppingCartPage.clickToUpdateShoppingCartButton();

		log.info("Update Shopping Cart - Step 08: Verify new total price in cart");
		verifyEquals(shoppingCartPage.getValueInUpdateCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN), DataTest_07_Order.OrderInfo.LENOVO_TOTAL_PRICE);

		log.info("Update Shopping Cart - Step 09: Remove item");
		shoppingCartPage.clickToButtonInCartAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.REMOVE_COLUMN);

	}

	@Test
	public void Order_05_Checkout_Cheque() {
		log.info("Checkout with Cheque payment - Step 01: Open Notebook page");
		shoppingCartPage.openSubMenuHeader(driver, DataTest_07_Order.MenuHeaderInfo.MENU_NAME, DataTest_07_Order.MenuHeaderInfo.SUB_MENU_NAME_NOTEBOOK);
		notebookPage = PageGeneratorManager.getUserNotebookPage(driver);

		log.info("Update Shopping Cart - Step 01: Open Product page");
		notebookPage.openProductDetailPage(DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Checkout with Cheque payment - Step 01: Click to 'ADD TO CART' button");
		notebookPage.clickToAddToCartButton();

		log.info("Checkout with Cheque payment - Step 01: Verify Add to Cart success message");
		verifyEquals(notebookPage.getAddedToCartSuccessMsg(), DataTest_07_Order.OrderMessage.ADD_TO_CART_MSG);

		log.info("Checkout with Cheque payment - Step 01: Open Shopping Cart page");
		shoppingCartPage = notebookPage.openShoppingCartPage(driver);

		log.info("Checkout with Cheque payment - Step 01: Check to Agree checkbox");
		shoppingCartPage.checkToAgreeCheckbox();

		log.info("Checkout with Cheque payment - Step 01: Click to Checkout button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();

		log.info("Checkout with Cheque payment - Step 01: Uncheck to 'Ship to the same address' checkbox in Billing address");
		checkoutPage.uncheckToShipSameAddressCheckbox();

		log.info("Checkout with Cheque payment - Step 01: Select 'New Address' in address dropdown if the dropdown is shown in Billing address");
		checkoutPage.selectAddressDropdownBilling(DataTest_07_Order.BillingAddress.ADDRESS_DROPDOWN);

		log.info("Checkout with Cheque payment - Step 01: Enter 'First name' textbox in Billing address");
		checkoutPage.enterFirstNameTextboxBilling(DataTest_07_Order.BillingAddress.FIRST_NAME);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Last name' textbox in Billing address");
		checkoutPage.enterLastNameTextboxBilling(DataTest_07_Order.BillingAddress.LAST_NAME);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Email' textbox in Billing address");
		checkoutPage.enterEmailTextboxBilling(DataTest_07_Order.BillingAddress.EMAIL);

		log.info("Checkout with Cheque payment - Step 01: Select 'Country' in dropdown in Billing address");
		checkoutPage.selectCountryDropdownBilling(DataTest_07_Order.BillingAddress.COUNTRY);

		log.info("Checkout with Cheque payment - Step 01: Select 'State/ province' in dropdown in Billing address");
		checkoutPage.selectStateDropdownBilling(DataTest_07_Order.BillingAddress.STATE_PROVINCE);

		log.info("Checkout with Cheque payment - Step 01: Enter 'City' textbox in Billing address");
		checkoutPage.enterCityTextboxBilling(DataTest_07_Order.BillingAddress.CITY);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Address1' textbox in Billing address");
		checkoutPage.enterAddress1TextboxBilling(DataTest_07_Order.BillingAddress.ADDRESS1);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Zip code' textbox in Billing address");
		checkoutPage.enterZipCodeTextboxBilling(DataTest_07_Order.BillingAddress.ZIP_CODE);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Phone number' textbox in Billing address");
		checkoutPage.enterPhoneTextboxBilling(DataTest_07_Order.BillingAddress.PHONE_NUMBER);

		log.info("Checkout with Cheque payment - Step 01: Click to 'CONTINUE' button in Billing address");
		checkoutPage.clickToContinueButtonBilling();

		log.info("Checkout with Cheque payment - Step 01: Select 'New Address' in address dropdown if the dropdown is shown in Shipping address");
		checkoutPage.selectAddressDropdownShipping(DataTest_07_Order.ShippingAddress.ADDRESS_DROPDOWN);

		log.info("Checkout with Cheque payment - Step 01: Enter 'First name' textbox in Shipping address");
		checkoutPage.enterFirstNameTextboxShipping(DataTest_07_Order.ShippingAddress.FIRST_NAME);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Last name' textbox in Shipping address");
		checkoutPage.enterLastNameTextboxShipping(DataTest_07_Order.ShippingAddress.LAST_NAME);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Email' textbox in Shipping address");
		checkoutPage.enterEmailTextboxShipping(DataTest_07_Order.ShippingAddress.EMAIL);

		log.info("Checkout with Cheque payment - Step 01: Select 'Country' in dropdown in Shipping address");
		checkoutPage.selectCountryDropdownShipping(DataTest_07_Order.ShippingAddress.COUNTRY);

		log.info("Checkout with Cheque payment - Step 01: Select 'State/ province' in dropdown in Shipping address");
		checkoutPage.sleepInSecond(5);
		checkoutPage.selectStateDropdownShipping(DataTest_07_Order.ShippingAddress.STATE_PROVINCE);

		log.info("Checkout with Cheque payment - Step 01: Enter 'City' textbox in Shipping address");
		checkoutPage.enterCityTextboxShipping(DataTest_07_Order.ShippingAddress.CITY);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Address1' textbox in Shipping address");
		checkoutPage.enterAddress1TextboxShipping(DataTest_07_Order.ShippingAddress.ADDRESS1);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Zip code' textbox in Shipping address");
		checkoutPage.enterZipCodeTextboxShipping(DataTest_07_Order.ShippingAddress.ZIP_CODE);

		log.info("Checkout with Cheque payment - Step 01: Enter 'Phone number' textbox in Shipping address");
		checkoutPage.enterPhoneTextboxShipping(DataTest_07_Order.ShippingAddress.PHONE_NUMBER);

		log.info("Checkout with Cheque payment - Step 01: Click to 'CONTINUE' button in Shipping address");
		checkoutPage.clickToContinueButtonShipping();

		log.info("Checkout with Cheque payment - Step 01: Choose Shipping method");
		checkoutPage.checkToShippingMethodRadio(DataTest_07_Order.CheckoutInfo.SHIPPING_METHOD_GROUND);

		log.info("Checkout with Cheque payment - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonShipMethod();

		log.info("Checkout with Cheque payment - Step 01: Choose Payment method = Check / Money Order");
		checkoutPage.checkToPaymentMethodRadio(DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CHEQUE);

		log.info("Checkout with Cheque payment - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonPaymentMethod();

		log.info("Checkout with Cheque payment - Step 01: Verify Payment info");
		verifyEquals(checkoutPage.getPaymentInfo(), DataTest_07_Order.CheckoutInfo.PAYMENT_INFO);

		log.info("Checkout with Cheque payment - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonPaymentInfo();

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Billing Address'");
		verifyEquals(checkoutPage.getFullNameBillingAddress(), DataTest_07_Order.BillingAddress.FULL_NAME);
		verifyEquals(checkoutPage.getEmailBillingAddress(), "Email: " + DataTest_07_Order.BillingAddress.EMAIL);
		verifyEquals(checkoutPage.getPhoneBillingAddress(), "Phone: " + DataTest_07_Order.BillingAddress.PHONE_NUMBER);
		verifyEquals(checkoutPage.getAddress1BillingAddress(), DataTest_07_Order.BillingAddress.ADDRESS1);
		verifyEquals(checkoutPage.getCityStateZipBillingAddress(), DataTest_07_Order.BillingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Payment'");
		verifyEquals(checkoutPage.getPaymentMethod(), DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CHEQUE);

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Shipping Address'");
		verifyEquals(checkoutPage.getFullNameShippingAddress(), DataTest_07_Order.ShippingAddress.FULL_NAME);
		verifyEquals(checkoutPage.getEmailShippingAddress(), "Email: " + DataTest_07_Order.ShippingAddress.EMAIL);
		verifyEquals(checkoutPage.getPhoneShippingAddress(), "Phone: " + DataTest_07_Order.ShippingAddress.PHONE_NUMBER);
		verifyEquals(checkoutPage.getAddress1ShippingAddress(), DataTest_07_Order.ShippingAddress.ADDRESS1);
		verifyEquals(checkoutPage.getCityStateZipShippingAddress(), DataTest_07_Order.ShippingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Shipping'");
		verifyEquals(checkoutPage.getShippingMethod(), DataTest_07_Order.CheckoutInfo.CONFIRM_SHIPPING_GROUND);

		log.info("Checkout with Cheque payment - Step 01: Verify Product name in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Checkout with Cheque payment - Step 01: Verify Product price in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE);

		log.info("Checkout with Cheque payment - Step 01: Verify Product quantity in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN), DataTest_07_Order.IndexValue.INDEX_2);

		log.info("Checkout with Cheque payment - Step 01: Verify Product Total price in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Cheque payment - Step 01: Verify Gift wrapping status");
		verifyEquals(checkoutPage.getGiftWrappingText(), DataTest_07_Order.OrderInfo.GIFT_WRAPPING_STATUS);

		log.info("Checkout with Cheque payment - Step 01: Verify Sub-Total:");
		verifyEquals(checkoutPage.getSubTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Cheque payment - Step 01: Verify Shipping: (Ground) fee:");
		verifyEquals(checkoutPage.getShippingFee(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Cheque payment - Step 01: Verify Tax value:");
		verifyEquals(checkoutPage.getTaxValue(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Cheque payment - Step 01: Verify Total:");
		verifyEquals(checkoutPage.getTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Cheque payment - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonConfirmOrder();

		log.info("Checkout with Cheque payment - Step 01: Verify Order success message");
		verifyEquals(checkoutPage.getOrderSuccessMsg(), DataTest_07_Order.OrderMessage.ORDER_SUCCESS_MSG);

		log.info("Checkout with Cheque payment - Step 01: Get Order Number");
		orderNumberCheckout = checkoutPage.getOrderNumber();

		log.info("Checkout with Cheque payment - Step 01: Open My account page");
		customerInfoPage = checkoutPage.clickToMyAccountLink(driver);

		log.info("Checkout with Cheque payment - Step 01: Open Orders page");
		orderPage = (UserOrderPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Orders");

		log.info("Checkout with Cheque payment - Step 01: Verify Order Number");
		verifyTrue(orderPage.isOrderNumberShownAtOrderPage(orderNumberCheckout));

		log.info("Checkout with Cheque payment - Step 01: Open 'Details' page");
		orderPage.openDetailsPage();

		log.info("Checkout with Cheque payment - Step 01: Verify Order #number");
		verifyTrue(orderPage.isOrderNumberShownAtDetailPage(orderNumberCheckout));

		log.info("Checkout with Cheque payment - Step 01: Verify Order Status");
		verifyEquals(orderPage.getOrderStatus(), DataTest_07_Order.OrderInfo.ORDER_PENDIND_STATUS);

		log.info("Checkout with Cheque payment - Step 01: Verify Order Total");
		verifyEquals(orderPage.getOrderTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Billing Address'");
		verifyEquals(orderPage.getFullNameBillingAddress(), DataTest_07_Order.BillingAddress.FULL_NAME);
		verifyEquals(orderPage.getEmailBillingAddress(), "Email: " + DataTest_07_Order.BillingAddress.EMAIL);
		verifyEquals(orderPage.getPhoneBillingAddress(), "Phone: " + DataTest_07_Order.BillingAddress.PHONE_NUMBER);
		verifyEquals(orderPage.getAddress1BillingAddress(), DataTest_07_Order.BillingAddress.ADDRESS1);
		verifyEquals(orderPage.getCityStateZipBillingAddress(), DataTest_07_Order.BillingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Payment'");
		verifyEquals(orderPage.getPaymentMethod(), DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CHEQUE);
		verifyEquals(orderPage.getPaymentStatus(), DataTest_07_Order.OrderInfo.PENDIND_STATUS);

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Shipping Address'");
		verifyEquals(orderPage.getFullNameShippingAddress(), DataTest_07_Order.ShippingAddress.FULL_NAME);
		verifyEquals(orderPage.getEmailShippingAddress(), "Email: " + DataTest_07_Order.ShippingAddress.EMAIL);
		verifyEquals(orderPage.getPhoneShippingAddress(), "Phone: " + DataTest_07_Order.ShippingAddress.PHONE_NUMBER);
		verifyEquals(orderPage.getAddress1ShippingAddress(), DataTest_07_Order.ShippingAddress.ADDRESS1);
		verifyEquals(orderPage.getCityStateZipShippingAddress(), DataTest_07_Order.ShippingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Cheque payment - Step 01: Verify info in 'Shipping'");
		verifyEquals(orderPage.getShippingMethod(), DataTest_07_Order.CheckoutInfo.CONFIRM_SHIPPING_GROUND);
		verifyEquals(orderPage.getShippingStatus(), DataTest_07_Order.OrderInfo.NOT_SHIPPED_STATUS);

		log.info("Checkout with Cheque payment - Step 01: Verify Product name in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Checkout with Cheque payment - Step 01: Verify Product price in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE);

		log.info("Checkout with Cheque payment - Step 01: Verify Product quantity in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN_ORDER_DETAIL), DataTest_07_Order.IndexValue.INDEX_2);

		log.info("Checkout with Cheque payment - Step 01: Verify Product Total price in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Cheque payment - Step 01: Verify Gift wrapping status");
		verifyEquals(orderPage.getGiftWrappingText(), DataTest_07_Order.OrderInfo.GIFT_WRAPPING_STATUS);

		log.info("Checkout with Cheque payment - Step 01: Verify Sub-Total:");
		verifyEquals(orderPage.getSubTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Cheque payment - Step 01: Verify Shipping fee:");
		verifyEquals(orderPage.getShippingFee(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Cheque payment - Step 01: Verify Tax value:");
		verifyEquals(orderPage.getTaxValue(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Cheque payment - Step 01: Verify Order total:");
		verifyEquals(orderPage.getTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

	}

	@Test
	public void Order_06_Checkout_Card() {
		log.info("Checkout with Card payment - Step 01: Open Notebook page");
		orderPage.openSubMenuHeader(driver, DataTest_07_Order.MenuHeaderInfo.MENU_NAME, DataTest_07_Order.MenuHeaderInfo.SUB_MENU_NAME_NOTEBOOK);
		notebookPage = PageGeneratorManager.getUserNotebookPage(driver);

		log.info("Update Shopping Cart - Step 01: Open Product page");
		notebookPage.openProductDetailPage(DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Checkout with Card payment - Step 01: Click to 'ADD TO CART' button");
		notebookPage.clickToAddToCartButton();

		log.info("Checkout with Card payment - Step 01: Verify Add to Cart success message");
		verifyEquals(notebookPage.getAddedToCartSuccessMsg(), DataTest_07_Order.OrderMessage.ADD_TO_CART_MSG);

		log.info("Checkout with Card payment - Step 01: Open Shopping Cart page");
		shoppingCartPage = notebookPage.openShoppingCartPage(driver);

		log.info("Checkout with Card payment - Step 01: Check to Agree checkbox");
		shoppingCartPage.checkToAgreeCheckbox();

		log.info("Checkout with Card payment - Step 01: Click to Checkout button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();

		log.info("Checkout with Card payment - Step 01: Uncheck to 'Ship to the same address' checkbox in Billing address");
		checkoutPage.uncheckToShipSameAddressCheckbox();

		log.info("Checkout with Card payment - Step 01: Select 'New Address' in address dropdown if the dropdown is shown in Billing address");
		checkoutPage.selectAddressDropdownBilling(DataTest_07_Order.BillingAddress.ADDRESS_DROPDOWN);

		log.info("Checkout with Card payment - Step 01: Enter 'First name' textbox in Billing address");
		checkoutPage.enterFirstNameTextboxBilling(DataTest_07_Order.BillingAddress.FIRST_NAME);

		log.info("Checkout with Card payment - Step 01: Enter 'Last name' textbox in Billing address");
		checkoutPage.enterLastNameTextboxBilling(DataTest_07_Order.BillingAddress.LAST_NAME);

		log.info("Checkout with Card payment - Step 01: Enter 'Email' textbox in Billing address");
		checkoutPage.enterEmailTextboxBilling(DataTest_07_Order.BillingAddress.EMAIL);

		log.info("Checkout with Card payment - Step 01: Select 'Country' in dropdown in Billing address");
		checkoutPage.selectCountryDropdownBilling(DataTest_07_Order.BillingAddress.COUNTRY);

		log.info("Checkout with Card payment - Step 01: Select 'State/ province' in dropdown in Billing address");
		checkoutPage.selectStateDropdownBilling(DataTest_07_Order.BillingAddress.STATE_PROVINCE);

		log.info("Checkout with Card payment - Step 01: Enter 'City' textbox in Billing address");
		checkoutPage.enterCityTextboxBilling(DataTest_07_Order.BillingAddress.CITY);

		log.info("Checkout with Card payment - Step 01: Enter 'Address1' textbox in Billing address");
		checkoutPage.enterAddress1TextboxBilling(DataTest_07_Order.BillingAddress.ADDRESS1);

		log.info("Checkout with Card payment - Step 01: Enter 'Zip code' textbox in Billing address");
		checkoutPage.enterZipCodeTextboxBilling(DataTest_07_Order.BillingAddress.ZIP_CODE);

		log.info("Checkout with Card payment - Step 01: Enter 'Phone number' textbox in Billing address");
		checkoutPage.enterPhoneTextboxBilling(DataTest_07_Order.BillingAddress.PHONE_NUMBER);

		log.info("Checkout with Card payment - Step 01: Click to 'CONTINUE' button in Billing address");
		checkoutPage.clickToContinueButtonBilling();

		log.info("Checkout with Card payment - Step 01: Select 'New Address' in address dropdown if the dropdown is shown in Shipping address");
		checkoutPage.selectAddressDropdownShipping(DataTest_07_Order.ShippingAddress.ADDRESS_DROPDOWN);

		log.info("Checkout with Card payment - Step 01: Enter 'First name' textbox in Shipping address");
		checkoutPage.enterFirstNameTextboxShipping(DataTest_07_Order.ShippingAddress.FIRST_NAME);

		log.info("Checkout with Card payment - Step 01: Enter 'Last name' textbox in Shipping address");
		checkoutPage.enterLastNameTextboxShipping(DataTest_07_Order.ShippingAddress.LAST_NAME);

		log.info("Checkout with Card payment - Step 01: Enter 'Email' textbox in Shipping address");
		checkoutPage.enterEmailTextboxShipping(DataTest_07_Order.ShippingAddress.EMAIL);

		log.info("Checkout with Card payment - Step 01: Select 'Country' in dropdown in Shipping address");
		checkoutPage.selectCountryDropdownShipping(DataTest_07_Order.ShippingAddress.COUNTRY);

		log.info("Checkout with Card payment - Step 01: Select 'State/ province' in dropdown in Shipping address");
		checkoutPage.sleepInSecond(5);
		checkoutPage.selectStateDropdownShipping(DataTest_07_Order.ShippingAddress.STATE_PROVINCE);

		log.info("Checkout with Card payment - Step 01: Enter 'City' textbox in Shipping address");
		checkoutPage.enterCityTextboxShipping(DataTest_07_Order.ShippingAddress.CITY);

		log.info("Checkout with Card payment - Step 01: Enter 'Address1' textbox in Shipping address");
		checkoutPage.enterAddress1TextboxShipping(DataTest_07_Order.ShippingAddress.ADDRESS1);

		log.info("Checkout with Card payment - Step 01: Enter 'Zip code' textbox in Shipping address");
		checkoutPage.enterZipCodeTextboxShipping(DataTest_07_Order.ShippingAddress.ZIP_CODE);

		log.info("Checkout with Card payment - Step 01: Enter 'Phone number' textbox in Shipping address");
		checkoutPage.enterPhoneTextboxShipping(DataTest_07_Order.ShippingAddress.PHONE_NUMBER);

		log.info("Checkout with Card payment - Step 01: Click to 'CONTINUE' button in Shipping address");
		checkoutPage.clickToContinueButtonShipping();

		log.info("Checkout with Card payment - Step 01: Choose Shipping method");
		checkoutPage.checkToShippingMethodRadio(DataTest_07_Order.CheckoutInfo.SHIPPING_METHOD_GROUND);

		log.info("Checkout with Card payment - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonShipMethod();

		log.info("Checkout with Card payment - Step 01: Choose Payment method = Credit Card");
		checkoutPage.checkToPaymentMethodRadio(DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CARD);

		log.info("Checkout with Card payment - Step 01: Choose Payment method = Credit Card");
		checkoutPage.clickToContinueButtonPaymentMethod();

		log.info("Checkout with Card payment - Step 01: Select credit card");
		checkoutPage.selectCreditCardDropdown(DataTest_07_Order.CheckoutInfo.CREDIT_CARD_TYPE);

		log.info("Checkout with Card payment - Step 01: Enter Cardholder name");
		checkoutPage.enterCardHolderNameTextbox(DataTest_07_Order.CheckoutInfo.CARD_HOLDER_NAME);

		log.info("Checkout with Card payment - Step 01: Enter Card number");
		checkoutPage.enterCardNumberTextbox(DataTest_07_Order.CheckoutInfo.CARD_NUMBER);

		log.info("Checkout with Card payment - Step 01: Select expiration month dropdown");
		checkoutPage.selectExpireMonthDropdown(DataTest_07_Order.CheckoutInfo.EXPIRE_MONTH);

		log.info("Checkout with Card payment - Step 01: Select expiration month dropdown");
		checkoutPage.selectExpireYearDropdown(DataTest_07_Order.CheckoutInfo.EXPIRE_YEAR);

		log.info("Checkout with Card payment - Step 01: Enter Card code");
		checkoutPage.enterCardCodeTextbox(DataTest_07_Order.CheckoutInfo.CARD_CODE);

		log.info("Checkout with Card payment - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonPaymentInfo();

		log.info("Checkout with Card payment - Step 01: Verify info in 'Billing Address'");
		verifyEquals(checkoutPage.getFullNameBillingAddress(), DataTest_07_Order.BillingAddress.FULL_NAME);
		verifyEquals(checkoutPage.getEmailBillingAddress(), "Email: " + DataTest_07_Order.BillingAddress.EMAIL);
		verifyEquals(checkoutPage.getPhoneBillingAddress(), "Phone: " + DataTest_07_Order.BillingAddress.PHONE_NUMBER);
		verifyEquals(checkoutPage.getAddress1BillingAddress(), DataTest_07_Order.BillingAddress.ADDRESS1);
		verifyEquals(checkoutPage.getCityStateZipBillingAddress(), DataTest_07_Order.BillingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Card payment - Step 01: Verify info in 'Payment'");
		verifyEquals(checkoutPage.getPaymentMethod(), DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CARD);

		log.info("Checkout with Card payment - Step 01: Verify info in 'Shipping Address'");
		verifyEquals(checkoutPage.getFullNameShippingAddress(), DataTest_07_Order.ShippingAddress.FULL_NAME);
		verifyEquals(checkoutPage.getEmailShippingAddress(), "Email: " + DataTest_07_Order.ShippingAddress.EMAIL);
		verifyEquals(checkoutPage.getPhoneShippingAddress(), "Phone: " + DataTest_07_Order.ShippingAddress.PHONE_NUMBER);
		verifyEquals(checkoutPage.getAddress1ShippingAddress(), DataTest_07_Order.ShippingAddress.ADDRESS1);
		verifyEquals(checkoutPage.getCityStateZipShippingAddress(), DataTest_07_Order.ShippingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Card payment - Step 01: Verify info in 'Shipping'");
		verifyEquals(checkoutPage.getShippingMethod(), DataTest_07_Order.CheckoutInfo.CONFIRM_SHIPPING_GROUND);

		log.info("Checkout with Card payment - Step 01: Verify Product name in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Checkout with Card payment - Step 01: Verify Product price in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE);

		log.info("Checkout with Card payment - Step 01: Verify Product quantity in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN), DataTest_07_Order.IndexValue.INDEX_2);

		log.info("Checkout with Card payment - Step 01: Verify Product Total price in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Card payment - Step 01: Verify Gift wrapping status");
		verifyEquals(checkoutPage.getGiftWrappingText(), DataTest_07_Order.OrderInfo.GIFT_WRAPPING_STATUS);

		log.info("Checkout with Card payment - Step 01: Verify Sub-Total:");
		verifyEquals(checkoutPage.getSubTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Card payment - Step 01: Verify Shipping: (Ground) fee:");
		verifyEquals(checkoutPage.getShippingFee(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Card payment - Step 01: Verify Tax value:");
		verifyEquals(checkoutPage.getTaxValue(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Card payment - Step 01: Verify Total:");
		verifyEquals(checkoutPage.getTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Card payment - Step 01: Click to 'CONTINUE' button");
		checkoutPage.sleepInSecond(15);
		checkoutPage.clickToContinueButtonConfirmOrder();

		log.info("Checkout with Card payment - Step 01: Verify Order success message");
		verifyEquals(checkoutPage.getOrderSuccessMsg(), DataTest_07_Order.OrderMessage.ORDER_SUCCESS_MSG);

		log.info("Checkout with Card payment - Step 01: Get Order Number");
		orderNumberCheckout = checkoutPage.getOrderNumber();

		log.info("Checkout with Card payment - Step 01: Open My account page");
		customerInfoPage = checkoutPage.clickToMyAccountLink(driver);

		log.info("Checkout with Card payment - Step 01: Open Orders page");
		orderPage = (UserOrderPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Orders");

		log.info("Checkout with Card payment - Step 01: Verify Order Number");
		verifyTrue(orderPage.isOrderNumberShownAtOrderPage(orderNumberCheckout));

		log.info("Checkout with Card payment - Step 01: Open 'Details' page");
		orderPage.openDetailsPage();

		log.info("Checkout with Card payment - Step 01: Verify Order #number");
		verifyTrue(orderPage.isOrderNumberShownAtDetailPage(orderNumberCheckout));

		log.info("Checkout with Card payment - Step 01: Verify Order Status");
		verifyEquals(orderPage.getOrderStatus(), DataTest_07_Order.OrderInfo.ORDER_PENDIND_STATUS);

		log.info("Checkout with Card payment - Step 01: Verify Order Total");
		verifyEquals(orderPage.getOrderTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Card payment - Step 01: Verify info in 'Billing Address'");
		verifyEquals(orderPage.getFullNameBillingAddress(), DataTest_07_Order.BillingAddress.FULL_NAME);
		verifyEquals(orderPage.getEmailBillingAddress(), "Email: " + DataTest_07_Order.BillingAddress.EMAIL);
		verifyEquals(orderPage.getPhoneBillingAddress(), "Phone: " + DataTest_07_Order.BillingAddress.PHONE_NUMBER);
		verifyEquals(orderPage.getAddress1BillingAddress(), DataTest_07_Order.BillingAddress.ADDRESS1);
		verifyEquals(orderPage.getCityStateZipBillingAddress(), DataTest_07_Order.BillingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Card payment - Step 01: Verify info in 'Payment'");
		verifyEquals(orderPage.getPaymentMethod(), DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CARD);
		verifyEquals(orderPage.getPaymentStatus(), DataTest_07_Order.OrderInfo.PENDIND_STATUS);

		log.info("Checkout with Card payment - Step 01: Verify info in 'Shipping Address'");
		verifyEquals(orderPage.getFullNameShippingAddress(), DataTest_07_Order.ShippingAddress.FULL_NAME);
		verifyEquals(orderPage.getEmailShippingAddress(), "Email: " + DataTest_07_Order.ShippingAddress.EMAIL);
		verifyEquals(orderPage.getPhoneShippingAddress(), "Phone: " + DataTest_07_Order.ShippingAddress.PHONE_NUMBER);
		verifyEquals(orderPage.getAddress1ShippingAddress(), DataTest_07_Order.ShippingAddress.ADDRESS1);
		verifyEquals(orderPage.getCityStateZipShippingAddress(), DataTest_07_Order.ShippingAddress.CITY_STATE_ZIP);

		log.info("Checkout with Card payment - Step 01: Verify info in 'Shipping'");
		verifyEquals(orderPage.getShippingMethod(), DataTest_07_Order.CheckoutInfo.CONFIRM_SHIPPING_GROUND);
		verifyEquals(orderPage.getShippingStatus(), DataTest_07_Order.OrderInfo.NOT_SHIPPED_STATUS);

		log.info("Checkout with Card payment - Step 01: Verify Product name in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Checkout with Card payment - Step 01: Verify Product price in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE);

		log.info("Checkout with Card payment - Step 01: Verify Product quantity in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN_ORDER_DETAIL), DataTest_07_Order.IndexValue.INDEX_2);

		log.info("Checkout with Card payment - Step 01: Verify Product Total price in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Card payment - Step 01: Verify Gift wrapping status");
		verifyEquals(orderPage.getGiftWrappingText(), DataTest_07_Order.OrderInfo.GIFT_WRAPPING_STATUS);

		log.info("Checkout with Card payment - Step 01: Verify Sub-Total:");
		verifyEquals(orderPage.getSubTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

		log.info("Checkout with Card payment - Step 01: Verify Shipping fee:");
		verifyEquals(orderPage.getShippingFee(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Card payment - Step 01: Verify Tax value:");
		verifyEquals(orderPage.getTaxValue(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Checkout with Card payment - Step 01: Verify Order total:");
		verifyEquals(orderPage.getOrderTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_TOTAL);

	}

	@Test
	public void Order_07_Re_Order() {
		log.info("Re-order - Step 01: Open My account page");
		customerInfoPage = orderPage.clickToMyAccountLink(driver);

		log.info("Re-order - Step 01: Open Orders page");
		orderPage = (UserOrderPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Orders");

		log.info("Re-order - Step 01: Open 'Details' page");
		orderPage.openDetailsPage();

		log.info("Re-order - Step 01: Click 'Re-Order' button");
		shoppingCartPage = orderPage.clickToReOrderButton();

		log.info("Re-order - Step 01: Update quantity = 10");
		shoppingCartPage.enterToTextboxAtRowAndColumnIndex(DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN, DataTest_07_Order.IndexValue.INDEX_10);

		log.info("Re-order - Step 01: Click to Update shopping cart");
		shoppingCartPage.clickToUpdateShoppingCartButton();

		log.info("Re-order - Step 01: Check to Agree checkbox");
		shoppingCartPage.checkToAgreeCheckbox();

		log.info("Re-order - Step 01: Click to Checkout button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();

		log.info("Re-order - Step 01: Uncheck to 'Ship to the same address' checkbox in Billing address");
		checkoutPage.uncheckToShipSameAddressCheckbox();

		log.info("Re-order - Step 01: Select 'New Address' in address dropdown if the dropdown is shown in Billing address");
		checkoutPage.selectAddressDropdownBilling(DataTest_07_Order.NewBillingAddress.ADDRESS_DROPDOWN);

		log.info("Re-order - Step 01: Enter 'First name' textbox in Billing address");
		checkoutPage.enterFirstNameTextboxBilling(DataTest_07_Order.NewBillingAddress.FIRST_NAME);

		log.info("Re-order - Step 01: Enter 'Last name' textbox in Billing address");
		checkoutPage.enterLastNameTextboxBilling(DataTest_07_Order.NewBillingAddress.LAST_NAME);

		log.info("Re-order - Step 01: Enter 'Email' textbox in Billing address");
		checkoutPage.enterEmailTextboxBilling(DataTest_07_Order.NewBillingAddress.EMAIL);

		log.info("Re-order - Step 01: Select 'Country' in dropdown in Billing address");
		checkoutPage.selectCountryDropdownBilling(DataTest_07_Order.NewBillingAddress.COUNTRY);

		log.info("Re-order - Step 01: Select 'State/ province' in dropdown in Billing address");
		checkoutPage.selectStateDropdownBilling(DataTest_07_Order.NewBillingAddress.STATE_PROVINCE);

		log.info("Re-order - Step 01: Enter 'City' textbox in Billing address");
		checkoutPage.enterCityTextboxBilling(DataTest_07_Order.NewBillingAddress.CITY);

		log.info("Re-order - Step 01: Enter 'Address1' textbox in Billing address");
		checkoutPage.enterAddress1TextboxBilling(DataTest_07_Order.NewBillingAddress.ADDRESS1);

		log.info("Re-order - Step 01: Enter 'Zip code' textbox in Billing address");
		checkoutPage.enterZipCodeTextboxBilling(DataTest_07_Order.NewBillingAddress.ZIP_CODE);

		log.info("Re-order - Step 01: Enter 'Phone number' textbox in Billing address");
		checkoutPage.enterPhoneTextboxBilling(DataTest_07_Order.NewBillingAddress.PHONE_NUMBER);

		log.info("Re-order - Step 01: Click to 'CONTINUE' button in Billing address");
		checkoutPage.clickToContinueButtonBilling();

		log.info("Re-order - Step 01: Select 'New Address' in address dropdown if the dropdown is shown in Shipping address");
		checkoutPage.selectAddressDropdownShipping(DataTest_07_Order.NewShippingAddress.ADDRESS_DROPDOWN);

		log.info("Re-order - Step 01: Enter 'First name' textbox in Shipping address");
		checkoutPage.enterFirstNameTextboxShipping(DataTest_07_Order.NewShippingAddress.FIRST_NAME);

		log.info("Re-order - Step 01: Enter 'Last name' textbox in Shipping address");
		checkoutPage.enterLastNameTextboxShipping(DataTest_07_Order.NewShippingAddress.LAST_NAME);

		log.info("Re-order - Step 01: Enter 'Email' textbox in Shipping address");
		checkoutPage.enterEmailTextboxShipping(DataTest_07_Order.NewShippingAddress.EMAIL);

		log.info("Re-order - Step 01: Select 'Country' in dropdown in Shipping address");
		checkoutPage.selectCountryDropdownShipping(DataTest_07_Order.NewShippingAddress.COUNTRY);

		log.info("Re-order - Step 01: Select 'State/ province' in dropdown in Shipping address");
		checkoutPage.sleepInSecond(5);
		checkoutPage.selectStateDropdownShipping(DataTest_07_Order.NewShippingAddress.STATE_PROVINCE);

		log.info("Re-order - Step 01: Enter 'City' textbox in Shipping address");
		checkoutPage.enterCityTextboxShipping(DataTest_07_Order.NewShippingAddress.CITY);

		log.info("Re-order - Step 01: Enter 'Address1' textbox in Shipping address");
		checkoutPage.enterAddress1TextboxShipping(DataTest_07_Order.NewShippingAddress.ADDRESS1);

		log.info("Re-order - Step 01: Enter 'Zip code' textbox in Shipping address");
		checkoutPage.enterZipCodeTextboxShipping(DataTest_07_Order.NewShippingAddress.ZIP_CODE);

		log.info("Re-order - Step 01: Enter 'Phone number' textbox in Shipping address");
		checkoutPage.enterPhoneTextboxShipping(DataTest_07_Order.NewShippingAddress.PHONE_NUMBER);

		log.info("Re-order - Step 01: Click to 'CONTINUE' button in Shipping address");
		checkoutPage.clickToContinueButtonShipping();

		log.info("Re-order - Step 01: Choose Shipping method = Next Air Day");
		checkoutPage.checkToShippingMethodRadio(DataTest_07_Order.CheckoutInfo.SHIPPING_METHOD_AIR);

		log.info("Re-order - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonShipMethod();

		log.info("Re-order - Step 01: Choose Payment method = Check / Money Order");
		checkoutPage.checkToPaymentMethodRadio(DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CHEQUE);

		log.info("Re-order - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonPaymentMethod();

		log.info("Re-order - Step 01: Verify Payment info");
		verifyEquals(checkoutPage.getPaymentInfo(), DataTest_07_Order.CheckoutInfo.PAYMENT_INFO);

		log.info("Re-order - Step 01: Click to 'CONTINUE' button");
		checkoutPage.clickToContinueButtonPaymentInfo();

		log.info("Re-order - Step 01: Verify info in 'Billing Address'");
		verifyEquals(checkoutPage.getFullNameBillingAddress(), DataTest_07_Order.NewBillingAddress.FULL_NAME);
		verifyEquals(checkoutPage.getEmailBillingAddress(), "Email: " + DataTest_07_Order.NewBillingAddress.EMAIL);
		verifyEquals(checkoutPage.getPhoneBillingAddress(), "Phone: " + DataTest_07_Order.NewBillingAddress.PHONE_NUMBER);
		verifyEquals(checkoutPage.getAddress1BillingAddress(), DataTest_07_Order.NewBillingAddress.ADDRESS1);
		verifyEquals(checkoutPage.getCityStateZipBillingAddress(), DataTest_07_Order.NewBillingAddress.CITY_STATE_ZIP);

		log.info("Re-order - Step 01: Verify info in 'Payment'");
		verifyEquals(checkoutPage.getPaymentMethod(), DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CHEQUE);

		log.info("Re-order - Step 01: Verify info in 'Shipping Address'");
		verifyEquals(checkoutPage.getFullNameShippingAddress(), DataTest_07_Order.NewShippingAddress.FULL_NAME);
		verifyEquals(checkoutPage.getEmailShippingAddress(), "Email: " + DataTest_07_Order.NewShippingAddress.EMAIL);
		verifyEquals(checkoutPage.getPhoneShippingAddress(), "Phone: " + DataTest_07_Order.NewShippingAddress.PHONE_NUMBER);
		verifyEquals(checkoutPage.getAddress1ShippingAddress(), DataTest_07_Order.NewShippingAddress.ADDRESS1);
		verifyEquals(checkoutPage.getCityStateZipShippingAddress(), DataTest_07_Order.NewShippingAddress.CITY_STATE_ZIP);

		log.info("Re-order - Step 01: Verify info in 'Shipping'");
		verifyEquals(checkoutPage.getShippingMethod(), DataTest_07_Order.CheckoutInfo.CONFIRM_SHIPPING_AIR);

		log.info("Re-order - Step 01: Verify Product name in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Re-order - Step 01: Verify Product price in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE);

		log.info("Re-order - Step 01: Verify Product quantity in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN), DataTest_07_Order.IndexValue.INDEX_10);

		log.info("Re-order - Step 01: Verify Product Total price in table");
		verifyEquals(checkoutPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_RE_ORDER);

		log.info("Re-order - Step 01: Verify Gift wrapping status");
		verifyEquals(checkoutPage.getGiftWrappingText(), DataTest_07_Order.OrderInfo.GIFT_WRAPPING_STATUS);

		log.info("Re-order - Step 01: Verify Sub-Total:");
		verifyEquals(checkoutPage.getSubTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_RE_ORDER);

		log.info("Re-order - Step 01: Verify Shipping: (Ground) fee:");
		verifyEquals(checkoutPage.getShippingFee(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Re-order - Step 01: Verify Tax value:");
		verifyEquals(checkoutPage.getTaxValue(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Re-order - Step 01: Verify Total:");
		verifyEquals(checkoutPage.getTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_RE_ORDER);

		log.info("Re-order - Step 01: Click to 'CONTINUE' button");
		checkoutPage.sleepInSecond(15);
		checkoutPage.clickToContinueButtonConfirmOrder();

		log.info("Re-order - Step 01: Verify Order success message");
		verifyEquals(checkoutPage.getOrderSuccessMsg(), DataTest_07_Order.OrderMessage.ORDER_SUCCESS_MSG);

		log.info("Re-order - Step 01: Get Order Number");
		orderNumberCheckout = checkoutPage.getOrderNumber();

		log.info("Re-order - Step 01: Open My account page");
		customerInfoPage = checkoutPage.clickToMyAccountLink(driver);

		log.info("Re-order - Step 01: Open Orders page");
		orderPage = (UserOrderPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Orders");

		log.info("Re-order - Step 01: Verify Order Number");
		verifyTrue(orderPage.isOrderNumberShownAtOrderPage(orderNumberCheckout));

		log.info("Re-order - Step 01: Open 'Details' page");
		orderPage.openDetailsPage();

		log.info("Re-order - Step 01: Verify Order #number");
		verifyTrue(orderPage.isOrderNumberShownAtDetailPage(orderNumberCheckout));

		log.info("Re-order - Step 01: Verify Order Status");
		verifyEquals(orderPage.getOrderStatus(), DataTest_07_Order.OrderInfo.ORDER_PENDIND_STATUS);

		log.info("Re-order - Step 01: Verify Order Total");
		verifyEquals(orderPage.getOrderTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_RE_ORDER);

		log.info("Re-order - Step 01: Verify info in 'Billing Address'");
		verifyEquals(orderPage.getFullNameBillingAddress(), DataTest_07_Order.NewBillingAddress.FULL_NAME);
		verifyEquals(orderPage.getEmailBillingAddress(), "Email: " + DataTest_07_Order.NewBillingAddress.EMAIL);
		verifyEquals(orderPage.getPhoneBillingAddress(), "Phone: " + DataTest_07_Order.NewBillingAddress.PHONE_NUMBER);
		verifyEquals(orderPage.getAddress1BillingAddress(), DataTest_07_Order.NewBillingAddress.ADDRESS1);
		verifyEquals(orderPage.getCityStateZipBillingAddress(), DataTest_07_Order.NewBillingAddress.CITY_STATE_ZIP);

		log.info("Re-order - Step 01: Verify info in 'Payment'");
		verifyEquals(orderPage.getPaymentMethod(), DataTest_07_Order.CheckoutInfo.PAYMENT_METHOD_CHEQUE);
		verifyEquals(orderPage.getPaymentStatus(), DataTest_07_Order.OrderInfo.PENDIND_STATUS);

		log.info("Re-order - Step 01: Verify info in 'Shipping Address'");
		verifyEquals(orderPage.getFullNameShippingAddress(), DataTest_07_Order.NewShippingAddress.FULL_NAME);
		verifyEquals(orderPage.getEmailShippingAddress(), "Email: " + DataTest_07_Order.NewShippingAddress.EMAIL);
		verifyEquals(orderPage.getPhoneShippingAddress(), "Phone: " + DataTest_07_Order.NewShippingAddress.PHONE_NUMBER);
		verifyEquals(orderPage.getAddress1ShippingAddress(), DataTest_07_Order.NewShippingAddress.ADDRESS1);
		verifyEquals(orderPage.getCityStateZipShippingAddress(), DataTest_07_Order.NewShippingAddress.CITY_STATE_ZIP);

		log.info("Re-order - Step 01: Verify info in 'Shipping'");
		verifyEquals(orderPage.getShippingMethod(), DataTest_07_Order.CheckoutInfo.CONFIRM_SHIPPING_AIR);
		verifyEquals(orderPage.getShippingStatus(), DataTest_07_Order.OrderInfo.NOT_SHIPPED_STATUS);

		log.info("Re-order - Step 01: Verify Product name in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRODUCT_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRODUCT_NAME);

		log.info("Re-order - Step 01: Verify Product price in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.PRICE_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE);

		log.info("Re-order - Step 01: Verify Product quantity in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.QUANTITY_COLUMN_ORDER_DETAIL), DataTest_07_Order.IndexValue.INDEX_10);

		log.info("Re-order - Step 01: Verify Product Total price in table");
		verifyEquals(orderPage.getValueInTableAtRowAndColumnIndex(driver, DataTest_07_Order.IndexValue.INDEX_1, DataTest_07_Order.OrderInfo.TOTAL_COLUMN_ORDER_DETAIL), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_RE_ORDER);

		log.info("Re-order - Step 01: Verify Gift wrapping status");
		verifyEquals(orderPage.getGiftWrappingText(), DataTest_07_Order.OrderInfo.GIFT_WRAPPING_STATUS);

		log.info("Re-order - Step 01: Verify Sub-Total:");
		verifyEquals(orderPage.getSubTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_RE_ORDER);

		log.info("Re-order - Step 01: Verify Shipping fee:");
		verifyEquals(orderPage.getShippingFee(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Re-order - Step 01: Verify Tax value:");
		verifyEquals(orderPage.getTaxValue(), DataTest_07_Order.OrderInfo.PRICE_0_$);

		log.info("Re-order - Step 01: Verify Order total:");
		verifyEquals(orderPage.getOrderTotal(), DataTest_07_Order.OrderInfo.NOTEBOOK_APPLE_PRICE_RE_ORDER);

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
	private UserCheckoutPageObject checkoutPage;
	private UserOrderPageObject orderPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String orderNumberCheckout;
}