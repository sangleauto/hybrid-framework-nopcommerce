package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {

	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTitleToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void enterTextToReviewTitleTextbox(String reviewText) {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, UserMyProductReviewPageUI.REVIEW_TEXT_TEXTBOX, reviewText);

	}

	public void selectRating(String ratingScore) {
		waitForElementClickable(driver, UserMyProductReviewPageUI.DYNAMIC_REVIEW_RATING, ratingScore);
		checkToDefaultCheckboxOrRadio(driver, UserMyProductReviewPageUI.DYNAMIC_REVIEW_RATING, ratingScore);
	}

	public void clickSubmitReviewButton() {
		waitForElementClickable(driver, UserMyProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserMyProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getValueInReviewTitleTextbox() {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TITLE);
	}

	public String getValueInReviewTextTextbox() {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
	}

	public String getValueReviewRating() {
		waitForElementVisible(driver, UserMyProductReviewPageUI.REVIEW_RATING);
		String ratingAttrValue = getAttributeValue(driver, UserMyProductReviewPageUI.REVIEW_RATING, "style");
		String rating = null;
		if (ratingAttrValue.contains("20%")) {
			rating = "1";
		}

		else if (ratingAttrValue.contains("40%")) {
			rating = "2";
		}

		else if (ratingAttrValue.contains("60%")) {
			rating = "3";
		}

		else if (ratingAttrValue.contains("80%")) {
			rating = "4";
		}

		else if (ratingAttrValue.contains("100%")) {
			rating = "5";
		}
		return rating;
	}

}
