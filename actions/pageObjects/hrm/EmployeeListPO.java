package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmployeeListPO extends BasePage {
	private WebDriver driver;

	protected EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}

}
