package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerLiveGuru;
import pageUIs.liveGuru.user.UserMyDashboardPageUI;

public class UserMyDashBoardPageObject extends BasePage {

	private WebDriver driver;

	public UserMyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserMyDashboardPageUI.ACCOUT_LINK);
		clickToElement(driver, UserMyDashboardPageUI.ACCOUT_LINK);
		waitForElementClickable(driver, UserMyDashboardPageUI.LOG_OUT_LINK);
		clickToElement(driver, UserMyDashboardPageUI.LOG_OUT_LINK);
		return PageGeneratorManagerLiveGuru.getUserHomePageObject(driver);
	}

	public String getPageTitle() {
		waitForAllElementsVisible(driver, UserMyDashboardPageUI.PAGE_TITLE);
		return getElementText(driver, UserMyDashboardPageUI.PAGE_TITLE);
	}

}
