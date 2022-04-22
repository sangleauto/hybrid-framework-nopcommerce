package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.PersonalDetailPageUI;

public class PersonalDetailPO extends BasePage {
	private WebDriver driver;

	protected PersonalDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangeAvatar() {
		waitForElementClickable(driver, PersonalDetailPageUI.AVATAR_IMG);
		clickToElement(driver, PersonalDetailPageUI.AVATAR_IMG);

	}

	public boolean isAvatarUploadSuccessMessageDisplayed() {
		waitForElementVisible(driver, PersonalDetailPageUI.SUCCESS_MSG);
		return isElementDisplayed(driver, PersonalDetailPageUI.SUCCESS_MSG);
	}

	public boolean isNewAvatarDisplayed() {
		waitForElementVisible(driver, PersonalDetailPageUI.AVATAR_IMG);
		int imgWidth = Integer.parseInt(getAttributeValue(driver, PersonalDetailPageUI.AVATAR_IMG, "width"));
		int imgHeight = Integer.parseInt(getAttributeValue(driver, PersonalDetailPageUI.AVATAR_IMG, "height"));

		return (imgWidth != 200 || imgHeight != 200);
	}

}
