package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterOldPasswordTextbox(String password) {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);

	}

	public void enterNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);

	}

	public void enterConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);

	}

	public String getPasswordChangedSuccessfullyMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.PASSWORD_CHANGED_MESSAGE);
		return getElementText(driver, UserChangePasswordPageUI.PASSWORD_CHANGED_MESSAGE);
	}

	public void clickToCloseIcon() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CLOSE_ICON);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_ICON);
		waitForElementUndisplayed(driver, UserChangePasswordPageUI.PASSWORD_CHANGED_MESSAGE);
	}

}
