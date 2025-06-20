package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getSearchEmptyErrorMessage() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_EMPTY_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.SEARCH_EMPTY_ERROR_MESSAGE);
	}

	public String getSearchNoResultErrorMessage() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_NO_RESULT_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.SEARCH_NO_RESULT_ERROR_MESSAGE);
	}

	public void enterValueToSearchTextbox(String notExistedData) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX, notExistedData);
	}

	public boolean isProductNameDisplayed(String... names) {
		List<WebElement> productElements = getListWebElement(driver, UserSearchPageUI.PRODUCT_NAME);
		List<String> productNames = new ArrayList<String>();
		for (WebElement productElement : productElements) {
			productNames.add(productElement.getText());
		}
		List<String> dataNames = new ArrayList<String>();
		for (String name : names) {
			dataNames.add(name);
		}

		return productNames.equals(dataNames);
	}

	public void checkToAdvancedSearchCheckbox() {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEACH_CHECKBOX);
		checkToDefaultCheckboxOrRadio(driver, UserSearchPageUI.ADVANCED_SEACH_CHECKBOX);

	}

	public void selectItemInCategoryDropdown(String categoryValue) {
		waitForElementClickable(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.CATEGORY_DROPDOWN, categoryValue);

	}

	public void checkToSubCategoriesSearchCheckbox() {
		waitForElementClickable(driver, UserSearchPageUI.SUB_CATEGORIES_SEACH_CHECKBOX);
		checkToDefaultCheckboxOrRadio(driver, UserSearchPageUI.SUB_CATEGORIES_SEACH_CHECKBOX);

	}

	public void selectItemInManufacturerDropdown(String incorrectManufacturer) {
		waitForElementClickable(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN, incorrectManufacturer);

	}

}
