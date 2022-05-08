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
}
