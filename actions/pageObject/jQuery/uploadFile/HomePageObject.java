package pageObject.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileNameLoaded(String appiumFileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, appiumFileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, appiumFileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTONS);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	public boolean isFileNameUploaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
	}

	public boolean isFileImageUploaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_UPLOADED, fileName);
		return isImageLoaded(driver, HomePageUI.IMAGE_UPLOADED, fileName);

	}

}
