package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DashboardPO extends BasePage {
	private WebDriver driver;

	protected DashboardPO(WebDriver driver) {
		this.driver = driver;
	}
}
