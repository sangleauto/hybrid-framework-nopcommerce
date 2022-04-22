package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.LoginPageUI;

public class LoginPO extends BasePage {
	private WebDriver driver;

	protected LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public DashboardPO loginToSystem(String username, String password) {
		waitForElementVisible(driver, LoginPageUI.LOGIN_USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.LOGIN_USERNAME_TEXTBOX, username);

		waitForElementVisible(driver, LoginPageUI.LOGIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.LOGIN_PASSWORD_TEXTBOX, password);

		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

		return PageGeneratorManagerHRM.getDashboardPage(driver);
	}

}
