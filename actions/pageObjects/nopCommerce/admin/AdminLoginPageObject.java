package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailnameTextbox(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminLoginPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		inputToEmailnameTextbox(email);
		inputToPasswordTextbox(password);
		clickToLoginButton();

		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

}
