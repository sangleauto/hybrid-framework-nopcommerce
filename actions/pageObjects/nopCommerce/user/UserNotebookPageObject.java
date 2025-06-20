package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserNotebookPageUI;

public class UserNotebookPageObject extends BasePage {
	WebDriver driver;

	public UserNotebookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String sortValue) {
		waitForElementClickable(driver, UserNotebookPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserNotebookPageUI.SORT_DROPDOWN, sortValue);
		waitForElementInvisible(driver, UserNotebookPageUI.LOADING_PRODUCT);
	}

	public boolean areProductNamesSortedAscending() {
		List<WebElement> productElements = getListWebElement(driver, UserNotebookPageUI.PRODUCT_NAME);
		List<String> productNames = new ArrayList<String>();
		for (WebElement productElement : productElements) {
			productNames.add(productElement.getText());
		}

		List<String> productNamesClone = new ArrayList<String>(productNames);
		Collections.sort(productNamesClone);

		return productNames.equals(productNamesClone);
	}

	public boolean areProductNamesSortedDescending() {
		List<WebElement> productElements = getListWebElement(driver, UserNotebookPageUI.PRODUCT_NAME);
		List<String> productNames = new ArrayList<String>();
		for (WebElement productElement : productElements) {
			productNames.add(productElement.getText());
		}

		List<String> productNamesClone = new ArrayList<String>(productNames);
		Collections.sort(productNamesClone);
		Collections.reverse(productNamesClone);

		return productNames.equals(productNamesClone);
	}

	public boolean areProductPricesSortedAscending() {
		List<WebElement> productElements = getListWebElement(driver, UserNotebookPageUI.PRODUCT_PRICE);
		List<Float> productPrices = new ArrayList<Float>();
		for (WebElement productElement : productElements) {
			productPrices.add(Float.parseFloat(productElement.getText().replace("$", "").replace(",", "")));
		}
		List<Float> productPricesClone = new ArrayList<Float>(productPrices);
		Collections.sort(productPricesClone);

		return productPrices.equals(productPricesClone);
	}

	public boolean areProductPricesSortedDescending() {
		List<WebElement> productElements = getListWebElement(driver, UserNotebookPageUI.PRODUCT_PRICE);
		List<Float> productPrices = new ArrayList<Float>();
		for (WebElement productElement : productElements) {
			productPrices.add(Float.parseFloat(productElement.getText().replace("$", "").replace(",", "")));
		}

		List<Float> productPricesClone = new ArrayList<Float>(productPrices);
		Collections.sort(productPricesClone);
		Collections.reverse(productPricesClone);

		return productPrices.equals(productPricesClone);
	}

	public void selectItemInDisplayDropdown(String displayValue) {
		waitForElementClickable(driver, UserNotebookPageUI.DISPLAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserNotebookPageUI.DISPLAY_DROPDOWN, displayValue);
		waitForElementInvisible(driver, UserNotebookPageUI.LOADING_PRODUCT);

	}

	public boolean areNumberOfItemsDisplayedCorrectly(String displayValue) {
		System.out.println("Test: " + Integer.parseInt(displayValue));
		System.out.println("Test 2: " + getElementSize(driver, UserNotebookPageUI.PRODUCT_NAME));
		boolean flag;
		if (getElementSize(driver, UserNotebookPageUI.PRODUCT_NAME) <= Integer.parseInt(displayValue)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean isPageNumberActivated(String pagingValue) {
		waitForElementVisible(driver, UserNotebookPageUI.PAGINATION_PAGE_ACTIVATED_BY_NUMBER, pagingValue);
		return isElementDisplayed(driver, UserNotebookPageUI.PAGINATION_PAGE_ACTIVATED_BY_NUMBER, pagingValue);
	}

	public boolean isNextIconDisplayed() {
		waitForElementVisible(driver, UserNotebookPageUI.PAGINATION_NEXT_PAGE_ICON);
		return isElementDisplayed(driver, UserNotebookPageUI.PAGINATION_NEXT_PAGE_ICON);
	}

	public boolean isPreviousIconDisplayed() {
		waitForElementVisible(driver, UserNotebookPageUI.PAGINATION_PREVIOUS_PAGE_ICON);
		return isElementDisplayed(driver, UserNotebookPageUI.PAGINATION_PREVIOUS_PAGE_ICON);
	}

	public void openPagingByPageNumber(String pagingValue) {
		waitForElementClickable(driver, UserNotebookPageUI.PAGINATION_PAGE_BY_NUMBER, pagingValue);
		clickToElement(driver, UserNotebookPageUI.PAGINATION_PAGE_BY_NUMBER, pagingValue);

	}

	public boolean isPaginationUndisplayed() {
		waitForElementUndisplayed(driver, UserNotebookPageUI.PAGINATION);
		return isElementUndisplayed(driver, UserNotebookPageUI.PAGINATION);
	}

	public void openProductDetailPage(String productName) {
		waitForElementClickable(driver, UserNotebookPageUI.PRODUCT_LINK, productName);
		clickToElement(driver, UserNotebookPageUI.PRODUCT_LINK, productName);
	}

	public void clickToAddToCompareListButton() {
		waitForElementClickable(driver, UserNotebookPageUI.ADD_TO_COMPARE_LIST);
		clickToElement(driver, UserNotebookPageUI.ADD_TO_COMPARE_LIST);
	}

	public String getAddedComparisonMessage() {
		waitForElementVisible(driver, UserNotebookPageUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserNotebookPageUI.ADDED_SUCCESS_MESSAGE);
	}

	public UserCompareProductPageObject clickToComparisonLinkInAddedMsg() {
		waitForElementClickable(driver, UserNotebookPageUI.COMPARE_LINK_IN_ADDED_SUCCESS_MESSAGE);
		clickToElement(driver, UserNotebookPageUI.COMPARE_LINK_IN_ADDED_SUCCESS_MESSAGE);
		return PageGeneratorManager.getUserCompareProductPage(driver);
	}

	public void clickToCloseIconAtAddedMessage() {
		waitForElementClickable(driver, UserNotebookPageUI.CLOSE_ICON);
		clickToElement(driver, UserNotebookPageUI.CLOSE_ICON);

	}

	public void viewDetail5Products(String... products) {

		for (int i = 0; i < products.length; i++) {
			waitForElementClickable(driver, UserNotebookPageUI.PRODUCT_LINK, products[i]);
			clickToElement(driver, UserNotebookPageUI.PRODUCT_LINK, products[i]);
			backToPage(driver);
		}

	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, UserNotebookPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserNotebookPageUI.ADD_TO_CART_BUTTON);
	}

	public String getAddedToCartSuccessMsg() {
		waitForElementVisible(driver, UserNotebookPageUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserNotebookPageUI.ADDED_SUCCESS_MESSAGE);
	}

}
