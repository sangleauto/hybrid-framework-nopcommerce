package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashBoardPageObject extends BasePage {

	private WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.ACCOUT_LINK);
		waitForElementClickable(driver, MyDashboardPageUI.LOG_OUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getPageTitle() {
		waitForAllElementsVisible(driver, MyDashboardPageUI.PAGE_TITLE);
		return getElementText(driver, MyDashboardPageUI.PAGE_TITLE);
	}

}
