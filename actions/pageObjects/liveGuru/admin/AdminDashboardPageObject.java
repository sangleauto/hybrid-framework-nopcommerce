package pageObjects.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {

	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopupButton() {
		if (isElementDisplayed(driver, AdminDashboardPageUI.CLOSE_POPUP_BUTTON)) {
			waitForElementClickable(driver, AdminDashboardPageUI.CLOSE_POPUP_BUTTON);
			clickToElement(driver, AdminDashboardPageUI.CLOSE_POPUP_BUTTON);
		}
	}

	public void inputToEmail(String columnName, String rowIndex, String value) {
		int columnIndex = getElementSize(driver, AdminDashboardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminDashboardPageUI.EMAIL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
		sendkeyToElement(driver, AdminDashboardPageUI.EMAIL_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));

	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminDashboardPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.SEARCH_BUTTON);
		waitForElementInvisible(driver, "xpath=//div[@id='loading-mask']");
	}

	public boolean showInfo(String name, String email) {
		return isElementDisplayed(driver, AdminDashboardPageUI.NAME_AND_EMAIL_INFO, name, email);
	}

	public void selectDeleteInfo(String value) {
		waitForElementClickable(driver, AdminDashboardPageUI.DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminDashboardPageUI.DROPDOWN, value);
	}

	public void checkToCheckBoxAndSubmit() {
		waitForElementClickable(driver, AdminDashboardPageUI.CHECKBOX);
		clickToElement(driver, AdminDashboardPageUI.CHECKBOX);
		waitForElementClickable(driver, AdminDashboardPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AdminDashboardPageUI.SUBMIT_BUTTON);
		acceptAlert(driver);

	}

	public boolean isCustomerDeleted() {
		waitForElementVisible(driver, AdminDashboardPageUI.DELETE_MESSAGE);
		return isElementDisplayed(driver, AdminDashboardPageUI.DELETE_MESSAGE);
	}

}
