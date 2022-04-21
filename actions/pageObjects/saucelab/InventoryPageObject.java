package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.InventoryPageUI;

public class InventoryPageObject extends BasePage {
	WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String value) {
		waitForElementClickable(driver, InventoryPageUI.DROPDOWN_ITEM);
		selectItemInDefaultDropdown(driver, InventoryPageUI.DROPDOWN_ITEM, value);
	}

	public boolean isProductNameSortedAscending() {
		List<WebElement> productNameElements = getListWebElement(driver, InventoryPageUI.PRODUCT_ITEM_NAME);
		List<String> productNames = new ArrayList<String>();
		for (WebElement productElement : productNameElements) {
			productNames.add(productElement.getText());
		}

		List<String> productNamesClone = new ArrayList<String>(productNames);
		Collections.sort(productNamesClone);

		return productNames.equals(productNamesClone);
	}

	public boolean isProductNameSortedDescending() {
		List<WebElement> productElements = getListWebElement(driver, InventoryPageUI.PRODUCT_ITEM_NAME);
		List<String> productNames = new ArrayList<String>();
		for (WebElement productElement : productElements) {
			productNames.add(productElement.getText());
		}

		List<String> productNamesClone = new ArrayList<String>(productNames);
		Collections.sort(productNamesClone);
		Collections.reverse(productNamesClone);

		return productNames.equals(productNamesClone);
	}

	public boolean isProductPriceSortedAscending() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_ITEM_PRICE);
		List<Float> productPrices = new ArrayList<Float>();
		for (WebElement productElement : productPriceElements) {
			productPrices.add(Float.parseFloat(productElement.getText().replace("$", "")));
		}

		List<Float> productPricesClone = new ArrayList<Float>(productPrices);
		Collections.sort(productPricesClone);

		return productPrices.equals(productPricesClone);
	}

	public boolean isProductPriceSortedDescending() {
		List<WebElement> productPriceElements = getListWebElement(driver, InventoryPageUI.PRODUCT_ITEM_PRICE);
		List<Float> productPrices = new ArrayList<Float>();
		for (WebElement productElement : productPriceElements) {
			productPrices.add(Float.parseFloat(productElement.getText().replace("$", "")));
		}

		List<Float> productPricesClone = new ArrayList<Float>(productPrices);
		Collections.sort(productPricesClone);
		Collections.reverse(productPricesClone);

		return productPrices.equals(productPricesClone);
	}

}
