package pageObject.jquery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pagingValue) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pagingValue);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pagingValue);
	}

	public boolean isPageNumberActivated(String pagingValue) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVATED_BY_NUMBER, pagingValue);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVATED_BY_NUMBER, pagingValue);

	}

	public void enterToHeaderTextboxByLabel(String labelValue, String textboxValue) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, labelValue);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, textboxValue, labelValue);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, labelValue);

	}

	public void getValueEachRowAtAllPage() {
		int totalPaginations = getElementSize(driver, HomePageUI.ALL_PAGINATIONS);
		// List<String> allRowsValueAllPages = new ArrayList<String>();
		Set<String> allRowsValueAllPages = new HashSet<String>();
		for (int i = 1; i <= totalPaginations; i++) {
			waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(i));
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(i));
			List<WebElement> allCountriesValueEachPage = getListWebElement(driver, HomePageUI.ALL_COUNTRIES_PER_PAGE);
			for (WebElement eachRow : allCountriesValueEachPage) {
				allRowsValueAllPages.add(eachRow.getText());
			}
		}
		for (String value : allRowsValueAllPages) {
			System.out.println(value);
		}

	}

}
