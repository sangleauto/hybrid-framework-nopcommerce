package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToCreateAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public MyDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashBoardPageObject(driver);
	}

}
