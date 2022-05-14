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

	public void selectProcessorDropdown(String dropdownValue) {
		waitForElementClickable(driver, UserDesktopPageUI.PROCESSOR_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserDesktopPageUI.PROCESSOR_DROPDOWN, dropdownValue);
	}

	public void selectRAMdropdown(String dropdownValue) {
		waitForElementClickable(driver, UserDesktopPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserDesktopPageUI.RAM_DROPDOWN, dropdownValue);

	}

	public void checkToHDDRadioByName(String name) {
		waitForElementClickable(driver, UserDesktopPageUI.HDD_RADIO_BY_NAME, name);
		checkToDefaultCheckboxOrRadio(driver, UserDesktopPageUI.HDD_RADIO_BY_NAME, name);
	}

	public void checkToOSRadioByName(String name) {
		waitForElementClickable(driver, UserDesktopPageUI.OS_RADIO_BY_NAME, name);
		checkToDefaultCheckboxOrRadio(driver, UserDesktopPageUI.OS_RADIO_BY_NAME, name);

	}

	public void checkToSoftwareCheckboxByName(String name) {
		waitForElementClickable(driver, UserDesktopPageUI.SOFTWARE_CHECKBOX_BY_NAME, name);
		checkToDefaultCheckboxOrRadio(driver, UserDesktopPageUI.SOFTWARE_CHECKBOX_BY_NAME, name);

	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, UserDesktopPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserDesktopPageUI.ADD_TO_CART_BUTTON);
	}

	public String getAddedToCartSuccessMsg() {
		waitForElementVisible(driver, UserDesktopPageUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserDesktopPageUI.ADDED_SUCCESS_MESSAGE);
	}

	public void clickToCloseIcon() {
		waitForElementClickable(driver, UserDesktopPageUI.CLOSE_ICON);
		clickToElement(driver, UserDesktopPageUI.CLOSE_ICON);
		waitForElementUndisplayed(driver, UserDesktopPageUI.ADDED_SUCCESS_MESSAGE);
	}

	public void uncheckToSoftwareCheckbox(String name) {
		waitForElementClickable(driver, UserDesktopPageUI.SOFTWARE_CHECKBOX_BY_NAME, name);
		uncheckToDefaultCheckbox(driver, UserDesktopPageUI.SOFTWARE_CHECKBOX_BY_NAME, name);
	}

	public void enterNumberToProductAmountTextbox(String value) {
		waitForElementVisible(driver, UserDesktopPageUI.PRODUCT_QUANTITY);
		sendkeyToElement(driver, UserDesktopPageUI.PRODUCT_QUANTITY, value);
	}

	public String getTotalPrice() {
		waitForElementVisible(driver, UserDesktopPageUI.PRODUCT_PRICE);
		return getElementText(driver, UserDesktopPageUI.PRODUCT_PRICE);
	}

	public void clickToUpdateButton() {
		waitForElementClickable(driver, UserDesktopPageUI.UPDATE_BUTTON);
		clickToElement(driver, UserDesktopPageUI.UPDATE_BUTTON);
	}
}
