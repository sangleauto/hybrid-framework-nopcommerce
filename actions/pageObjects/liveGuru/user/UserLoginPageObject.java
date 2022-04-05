package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerLiveGuru;
import pageUIs.liveGuru.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAccountButton() {
		waitForElementClickable(driver, UserLoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_ACCOUNT_BUTTON);
		return PageGeneratorManagerLiveGuru.getUserRegisterPageObject(driver);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserMyDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagerLiveGuru.getUserMyDashBoardPageObject(driver);
	}

	public boolean showLoginErrorMsg() {
		return isElementDisplayed(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

}
