package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);

	}

	public void sendKeyToEmailTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);

	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.EMAIL_CONFIRM_TEXTBOX);
	}

	public void clickToCloseIconAtRegisterPage() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON_AT_REGISTER_PAGE);
		clickToElement(driver, LoginPageUI.CLOSE_ICON_AT_REGISTER_PAGE);
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		// 5s
		waitForElementUndisplayed(driver, LoginPageUI.EMAIL_CONFIRM_TEXTBOX);
		// 5s
		return isElementUndisplayed(driver, LoginPageUI.EMAIL_CONFIRM_TEXTBOX);
	}
}
