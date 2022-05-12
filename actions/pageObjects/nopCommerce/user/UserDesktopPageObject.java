package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserDesktopPageUI;

public class UserDesktopPageObject extends BasePage {
	WebDriver driver;

	public UserDesktopPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToDesktopProduct() {
		waitForElementClickable(driver, UserDesktopPageUI.DESKTOP_PRODUCT_TITLE);
		clickToElement(driver, UserDesktopPageUI.DESKTOP_PRODUCT_TITLE);
	}

	public UserMyProductReviewPageObject clickToAddYourReviewLink() {
		waitForElementClickable(driver, UserDesktopPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserDesktopPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public void openProductDetailPage(String productName) {
		waitForElementClickable(driver, UserDesktopPageUI.PRODUCT_LINK, productName);
		clickToElement(driver, UserDesktopPageUI.PRODUCT_LINK, productName);
	}

	public void clickToAddToWishlistButton() {
		waitForElementClickable(driver, UserDesktopPageUI.ADD_TO_WISHLIST);
		clickToElement(driver, UserDesktopPageUI.ADD_TO_WISHLIST);

	}

	public String getAddedWishlistMessage() {
		waitForElementVisible(driver, UserDesktopPageUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserDesktopPageUI.ADDED_SUCCESS_MESSAGE);
	}

	public UserWishlistPageObject clickToWishlistLinkInAddedMsg() {
		waitForElementClickable(driver, UserDesktopPageUI.WISHLIST_LINK_IN_ADDED_SUCCESS_MESSAGE);
		clickToElement(driver, UserDesktopPageUI.WISHLIST_LINK_IN_ADDED_SUCCESS_MESSAGE);
		return PageGeneratorManager.getUserWishlistPage(driver);
	}
}
