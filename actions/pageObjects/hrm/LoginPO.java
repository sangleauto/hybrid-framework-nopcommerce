package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPO extends BasePage {
	private WebDriver driver;

	protected LoginPO(WebDriver driver) {
		this.driver = driver;
	}

}
