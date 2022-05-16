package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminProductInfoPageUI;
import pageUIs.nopCommerce.admin.BasePageNopCommerceUI;

public class AdminProductInfoPageObject extends BasePage {
	private WebDriver driver;

	public AdminProductInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductName() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		waitForElementVisible(driver, AdminProductInfoPageUI.PRODUCT_NAME_TEXTBOX);
		return getAttributeValue(driver, AdminProductInfoPageUI.PRODUCT_NAME_TEXTBOX, "value");
	}

	public String getFullDescription() {
		waitForElementInvisible(driver, BasePageNopCommerceUI.LOADING_ICON);
		switchToFrameIFrame(driver, AdminProductInfoPageUI.IFRAME_PRODUCT_DESCRIPTION);
		waitForElementVisible(driver, AdminProductInfoPageUI.PRODUCT_DESCRIPTION_TEXTBOX);
		return getElementText(driver, AdminProductInfoPageUI.PRODUCT_DESCRIPTION_TEXTBOX);
	}

	public String getSKU() {

		waitForElementVisible(driver, AdminProductInfoPageUI.PRODUCT_SKU_TEXTBOX);
		return getAttributeValue(driver, AdminProductInfoPageUI.PRODUCT_SKU_TEXTBOX, "value");
	}

	public String getPrice() {
		waitForElementVisible(driver, AdminProductInfoPageUI.PRODUCT_PRICE_TEXTBOX);
		return getAttributeValue(driver, AdminProductInfoPageUI.PRODUCT_PRICE_TEXTBOX, "aria-valuenow");
	}

	public String getStockQuantity() {
		waitForElementVisible(driver, AdminProductInfoPageUI.PRODUCT_STOCK_TEXTBOX);
		return getAttributeValue(driver, AdminProductInfoPageUI.PRODUCT_STOCK_TEXTBOX, "aria-valuenow");
	}

	public void clickToExpandPrices() {
		waitForElementClickable(driver, AdminProductInfoPageUI.EXPAND_PRICES);
		clickToElement(driver, AdminProductInfoPageUI.EXPAND_PRICES);
	}

}
