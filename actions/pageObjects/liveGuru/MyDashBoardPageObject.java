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
		clickToElement(driver, MyDashboardPageUI.ACCOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getPageTitle() {
		return getElementText(driver, MyDashboardPageUI.PAGE_TITLE);
	}

}
