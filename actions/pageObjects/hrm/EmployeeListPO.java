package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmployeeListPO extends BasePage {
	private WebDriver driver;

	protected EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}

	public AddEmployeePO clickToAddButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public void enterToEmployeeNameTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void clickToSearchButton() {
		// TODO Auto-generated method stub

	}

	public boolean isEmployeeInfoIsDisplayedAtTable(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}

}
