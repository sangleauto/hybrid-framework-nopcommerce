package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;
import com.nopcommerce.data.DataTest_06_Wishlist;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCompareProductPageObject;
import pageObjects.nopCommerce.user.UserDesktopPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebookPageObject;
import pageObjects.nopCommerce.user.UserRecentViewPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;

public class Nopcommerce_06_Wishlist_Compare_RecentView extends BaseTest {

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

		log.info("Precondition - Step 06: Open Desktop page in Sub Menu");
		homePage.openSubMenuHeader(driver, DataTest_06_Wishlist.MenuHeaderInfo.MENU_NAME, DataTest_06_Wishlist.MenuHeaderInfo.SUB_MENU_NAME_DESKTOP);
		desktopPage = PageGeneratorManager.getUserDesktopPage(driver);

	}

	@Test
	public void Wishlist_01_Add_To_Wishlist() {
		log.info("Add to Wishlist - Step 01: Click to product");
		desktopPage.openProductDetailPage(DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_NAME);

		log.info("Add to Wishlist - Step 02: Click to 'Add to wishlist' button");
		desktopPage.clickToAddToWishlistButton();

		log.info("Add to Wishlist - Step 03: Verify added to wishlist message");
		verifyEquals(desktopPage.getAddedWishlistMessage(), DataTest_06_Wishlist.WishlistMessage.ADDED_WISHLIST_MESSAGE);

		log.info("Add to Wishlist - Step 04: Click to 'wishlist' link");
		wishlistPage = desktopPage.clickToWishlistLinkInAddedMsg();

		log.info("Add to Wishlist - Step 05: Verify product is added successfully");
		verifyEquals(wishlistPage.getValueInWishlistTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRODUCT_COLUMN), DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_NAME);
		verifyEquals(wishlistPage.getValueInWishlistTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRICE_COLUMN), DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_PRICE);

		log.info("Add to Wishlist - Step 06: Click to wishlist sharing URL");
		wishlistPage.clickToWishlistURL();

		log.info("Add to Wishlist - Step 07: Verify Full name info in 'Wishlist of ...' title");
		verifyTrue(wishlistPage.isWishlistTitleContainsFullname(DataTest_06_Wishlist.WishlistInfo.FULL_NAME));

		log.info("Add to Wishlist - Step 08: Verify product is added successfully");
		verifyEquals(wishlistPage.getValueInWishlistTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRODUCT_COLUMN), DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_NAME);
		verifyEquals(wishlistPage.getValueInWishlistTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRICE_COLUMN), DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_PRICE);
	}

	@Test
	public void Wishlist_02_Add_Product_From_Wishlist_To_Cart() {
		log.info("Add from Wishlist to Cart - Step 01: Back to Home page");
		homePage = wishlistPage.backToHomePage(driver);

		log.info("Add from Wishlist to Cart - Step 02: Open Wishlist page");
		wishlistPage = homePage.openWishlistPage(driver);

		log.info("Add from Wishlist to Cart - Step 03: Check to checkbox");
		wishlistPage.checkToCheckboxInWishlistTable(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.ADD_TO_CART_COLUMN);

		log.info("Add from Wishlist to Cart - Step 04: Click to 'ADD TO CART' button");
		shoppingcartPage = wishlistPage.clickToAddToCartButton();

		log.info("Add from Wishlist to Cart - Step 05: Verify Shopping cart table is displayed");
		verifyTrue(shoppingcartPage.isShoppingCartTableDisplayed());
		shoppingcartPage.sleepInSecond(5);

		log.info("Add from Wishlist to Cart - Step 06: Open Wishlist page");
		wishlistPage = shoppingcartPage.openWishlistPage(driver);

		log.info("Add from Wishlist to Cart - Step 07: Verify the wishlist is empty");
		verifyEquals(wishlistPage.getWishlistEmptyMessage(), DataTest_06_Wishlist.WishlistMessage.WISHLIST_EMPTY_MESSAGE);

		log.info("Add from Wishlist to Cart - Step 08: Click to 'Shopping cart' link");
		shoppingcartPage = wishlistPage.openShoppingCartPage(driver);

		log.info("Add from Wishlist to Cart - Step 09: Verify product info (Name + Price)");
		verifyEquals(shoppingcartPage.getValueInCartAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRODUCT_COLUMN),
				DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_NAME);
		verifyEquals(shoppingcartPage.getValueInCartAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRICE_COLUMN),
				DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_PRICE);

	}

	@Test
	public void Wishlist_03_Remove_Product_In_Wishlist_Page() {
		log.info("Remove product in Wishlist page - Step 01: Open Desktop page in Sub Menu");
		shoppingcartPage.openSubMenuHeader(driver, DataTest_06_Wishlist.MenuHeaderInfo.MENU_NAME, DataTest_06_Wishlist.MenuHeaderInfo.SUB_MENU_NAME_DESKTOP);
		desktopPage = PageGeneratorManager.getUserDesktopPage(driver);

		log.info("Remove product in Wishlist page - Step 02: Click to product");
		desktopPage.openProductDetailPage(DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_NAME);

		log.info("Remove product in Wishlist page - Step 03: Click to 'Add to wishlist' button");
		desktopPage.clickToAddToWishlistButton();

		log.info("Remove product in Wishlist page - Step 04: Verify added to wishlist message");
		verifyEquals(desktopPage.getAddedWishlistMessage(), DataTest_06_Wishlist.WishlistMessage.ADDED_WISHLIST_MESSAGE);

		log.info("Remove product in Wishlist page - Step 05: Click to 'wishlist' link");
		wishlistPage = desktopPage.clickToWishlistLinkInAddedMsg();

		log.info("Remove product in Wishlist page - Step 06: Verify product is added successfully");
		verifyEquals(wishlistPage.getValueInWishlistTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRODUCT_COLUMN), DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_NAME);
		verifyEquals(wishlistPage.getValueInWishlistTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.PRICE_COLUMN), DataTest_06_Wishlist.WishlistInfo.DESKTOP_LENOVO_PRODUCT_PRICE);

		log.info("Remove product in Wishlist page - Step 07: Click to 'Remove' icon");
		wishlistPage.clickToRemoveIconInWishlistTable(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_1, DataTest_06_Wishlist.WishlistInfo.REMOVE_COLUMN);

		log.info("Remove product in Wishlist page - Step 08: Verify the wishlist is empty");
		verifyEquals(wishlistPage.getWishlistEmptyMessage(), DataTest_06_Wishlist.WishlistMessage.WISHLIST_EMPTY_MESSAGE);

		log.info("Remove product in Wishlist page - Step 09: Verify the product is not shown on Wishlist page");
		verifyTrue(wishlistPage.isWishlistTableUndisplayed());
	}

	@Test
	public void Wishlist_04_Compare_Product() {
		log.info("Add product to compare - Step 01: Open Notebook page in Sub Menu");
		wishlistPage.openSubMenuHeader(driver, DataTest_06_Wishlist.MenuHeaderInfo.MENU_NAME, DataTest_06_Wishlist.MenuHeaderInfo.SUB_MENU_NAME_NOTEBOOK);
		notebookPage = PageGeneratorManager.getUserNotebookPage(driver);
		log.info("Add product to compare - Step 02: Click to first product");
		notebookPage.openProductDetailPage(DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_APPLE_NAME);

		log.info("Add product to compare - Step 03: Click to 'Add to compare list' button");
		notebookPage.clickToAddToCompareListButton();

		log.info("Add product to compare - Step 04: Verify added succesfully message");
		verifyEquals(notebookPage.getAddedComparisonMessage(), DataTest_06_Wishlist.WishlistMessage.ADDED_COMPARISON_MESSAGE);

		log.info("Add product to compare - Step 05: Click to close icon");
		notebookPage.clickToCloseIconAtAddedMessage();

		log.info("Add product to compare - Step 06: Open Notebook page in Sub Menu");
		notebookPage.openSubMenuHeader(driver, DataTest_06_Wishlist.MenuHeaderInfo.MENU_NAME, DataTest_06_Wishlist.MenuHeaderInfo.SUB_MENU_NAME_NOTEBOOK);

		log.info("Add product to compare - Step 07: Click to second product");
		notebookPage.openProductDetailPage(DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_ASUS_NAME);

		log.info("Add product to compare - Step 08: Click to 'Add to compare list' button");
		notebookPage.clickToAddToCompareListButton();

		log.info("Add product to compare - Step 09: Verify added succesfully message");
		verifyEquals(notebookPage.getAddedComparisonMessage(), DataTest_06_Wishlist.WishlistMessage.ADDED_COMPARISON_MESSAGE);

		log.info("Add product to compare - Step 10: Click to 'product comparision' link");
		compareProductPage = notebookPage.clickToComparisonLinkInAddedMsg();

		log.info("Add product to compare - Step 11: Verify info of 2 added products (Name + Price)");
		verifyEquals(compareProductPage.getValueInCompareTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_3, DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_2), DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_ASUS_NAME);
		verifyEquals(compareProductPage.getValueInCompareTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_4, DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_2), DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_ASUS_PRICE);

		verifyEquals(compareProductPage.getValueInCompareTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_3, DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_3), DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_APPLE_NAME);
		verifyEquals(compareProductPage.getValueInCompareTableAtRowAndColumnIndex(DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_4, DataTest_06_Wishlist.WishlistInfo.TABLE_INDEX_3), DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_APPLE_PRICE);

		log.info("Add product to compare - Step 12: Click to 'CLEAR LIST' button");
		compareProductPage.clickToClearListButton();

		log.info("Add product to compare - Step 13: Verify no items to compare message");
		verifyEquals(compareProductPage.getCompareEmptyMessage(), DataTest_06_Wishlist.WishlistMessage.COMPARE_EMPTY_MESSAGE);

		log.info("Add product to compare - Step 14: Verify all item infomations are disappeared");
		verifyTrue(compareProductPage.isCompareTableUndisplayed());
	}

	@Test
	public void Wishlist_05_Recently_Viewed_Products() {
		log.info("Recently Viewed Products - Step 01: Open Notebook page");
		compareProductPage.openSubMenuHeader(driver, DataTest_06_Wishlist.MenuHeaderInfo.MENU_NAME, DataTest_06_Wishlist.MenuHeaderInfo.SUB_MENU_NAME_NOTEBOOK);
		notebookPage = PageGeneratorManager.getUserNotebookPage(driver);

		log.info("Recently Viewed Products - Step 02: View details of 5 products");
		notebookPage.viewDetail5Products(DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_APPLE_NAME, DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_ASUS_NAME, DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_HP_NAME,
				DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_LENOVO_NAME, DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_SAMSUNG_NAME);

		log.info("Recently Viewed Products - Step 03: Open 'Recently viewed products' page");
		recentViewPage = notebookPage.openRecentViewPage(driver);

		log.info("Recently Viewed Products - Step 04: Verify only show last 3 products viewed recently");
		verifyTrue(recentViewPage.isRecentViewPageOnlyShow3Products(DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_APPLE_NAME, DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_ASUS_NAME, DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_HP_NAME,
				DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_LENOVO_NAME, DataTest_06_Wishlist.WishlistInfo.NOTEBOOK_SAMSUNG_NAME));

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
	private UserWishlistPageObject wishlistPage;
	private UserShoppingCartPageObject shoppingcartPage;
	private UserCompareProductPageObject compareProductPage;
	private UserRecentViewPageObject recentViewPage;

}