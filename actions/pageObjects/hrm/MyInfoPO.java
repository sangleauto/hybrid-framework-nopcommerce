package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.MyInfoPageUI;

public class MyInfoPO extends BasePage {
	private WebDriver driver;

	protected MyInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangeAvatar() {
		waitForElementClickable(driver, MyInfoPageUI.AVATAR_IMG);
		clickToElement(driver, MyInfoPageUI.AVATAR_IMG);

	}

	public boolean isNewAvatarDisplayed() {
		waitForElementVisible(driver, MyInfoPageUI.AVATAR_IMG);
		int imgWidth = Integer.parseInt(getAttributeValue(driver, MyInfoPageUI.AVATAR_IMG, "width"));
		int imgHeight = Integer.parseInt(getAttributeValue(driver, MyInfoPageUI.AVATAR_IMG, "height"));

		return (imgWidth != 200 || imgHeight != 200);
	}

	public void openTabAtSideBarByName(String tabName) {
		waitForElementClickable(driver, MyInfoPageUI.TAB_AT_SIDEBAR_BY_NAME, tabName);
		clickToElement(driver, MyInfoPageUI.TAB_AT_SIDEBAR_BY_NAME, tabName);

	}

}
