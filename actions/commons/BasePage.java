package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGeneratorManagerHRM;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRecentViewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;
import pageUIs.hrm.BasePageHrmUI;
import pageUIs.jquery.uploadFile.BasePagejQueryUploadUI;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.UserDesktopPageUI;

// Common class
/**
 * @author Admin
 *
 */
public class BasePage {

	// Selenium Web Browser Function
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} // isAlertPresent()

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToTabByID(WebDriver driver, String expectedID) {
		Set<String> allTabIDs = driver.getWindowHandles();
		for (String id : allTabIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToTabByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allTabIDs = driver.getWindowHandles();
		for (String id : allTabIDs) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllTabsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	// Selenium Web Element Function
	public By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id") || locatorType.startsWith("Id") || locatorType.startsWith("ID")) {
			by = By.id(locatorType.substring(3));
		}

		else if (locatorType.startsWith("class") || locatorType.startsWith("Class") || locatorType.startsWith("CLASS")) {
			by = By.className(locatorType.substring(6));
		}

		else if (locatorType.startsWith("name") || locatorType.startsWith("Name") || locatorType.startsWith("NAME")) {
			by = By.name(locatorType.substring(5));
		}

		else if (locatorType.startsWith("xpath") || locatorType.startsWith("Xpath") || locatorType.startsWith("XPATH")) {
			by = By.xpath(locatorType.substring(6));
		}

		else if (locatorType.startsWith("css") || locatorType.startsWith("Css") || locatorType.startsWith("CSS")) {
			by = By.cssSelector(locatorType.substring(4));
		}

		else
			throw new RuntimeException("Locator type is not supported !!!");
		return by;
	}

	public String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath") || locatorType.startsWith("Xpath") || locatorType.startsWith("XPATH")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}

		return locatorType;

	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		if (driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, locatorType);
			sleepInSecond(2);
		} else {
			getWebElement(driver, locatorType).click();
		}
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText().trim();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemInDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemInDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> childItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));

		for (WebElement tempElement : childItems) {
			if (tempElement.getText().trim().equals(expectedValue)) {
				if (tempElement.isDisplayed()) {
					tempElement.click();
					sleepInSecond(1);
				} else {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tempElement);
					jsExecutor.executeScript("arguments[0].click()", tempElement);
					sleepInSecond(1);
				}
				break;
			}
		}
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getAttributeValue(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getAttributeValue(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	public String getCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	// Case 2 + 3 (Verify Element Undisplayed)
	public void overrideImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideImplicitTimeout(driver, longTimeout);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();
	}

	public void switchToFrameIFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void highlightElement(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public String getElementValueWithXpathByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val();");
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public boolean isJqueyAjaxLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		//
		// ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		// @Override
		// public Boolean apply(WebDriver driver) {
		// return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
		// }
		// };
		// return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
		return explicitWait.until(jQueryLoad);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		return status;
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementsVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementsVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	/*
	 * Wait for element undisplayed in DOM/ not in DOM and override implicit time
	 */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, longTimeout);
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementsInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	public void waitForAllElementsInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName += filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		sendkeyToElement(driver, BasePagejQueryUploadUI.UPLOAD_FILE_INPUT, fullFileName);
	}

	// Tối ưu ở bài Level_07_Switch_Page
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageNopCommerceUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageNopCommerceUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPageObject(driver);

	}

	// Tối ưu ở bài Level_09_Dynamic_Locator (dung 1 trong 2)
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer Info":
			return PageGeneratorManager.getUserCustomerInfoPageObject(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
		case "Orders":
			return PageGeneratorManager.getUserOrderPage(driver);
		default:
			throw new RuntimeException("Page name is not correct !");
		}
	}

	public void openSubMenuHeader(WebDriver driver, String menuPage, String subMenuPage) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPage);
		hoverMouseToElement(driver, BasePageNopCommerceUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPage);

		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_SUB_MENU_PAGE_BY_NAME, subMenuPage);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_SUB_MENU_PAGE_BY_NAME, subMenuPage);
	}

	public UserSearchPageObject openSearchPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.SEARCH_PAGE_LINK);
		clickToElement(driver, BasePageNopCommerceUI.SEARCH_PAGE_LINK);
		return PageGeneratorManager.getUserSearchPage(driver);
	}

	public UserWishlistPageObject openWishlistPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.WISHLIST_LINK);
		clickToElement(driver, BasePageNopCommerceUI.WISHLIST_LINK);
		return PageGeneratorManager.getUserWishlistPage(driver);
	}

	public UserShoppingCartPageObject openShoppingCartPage(WebDriver driver) {
		waitForElementClickable(driver, UserDesktopPageUI.SHOPPING_CART_LINK_IN_ADDED_SUCCESS_MESSAGE);
		clickToElement(driver, UserDesktopPageUI.SHOPPING_CART_LINK_IN_ADDED_SUCCESS_MESSAGE);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public UserRecentViewPageObject openRecentViewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.RECENT_VIEW_LINK);
		clickToElement(driver, BasePageNopCommerceUI.RECENT_VIEW_LINK);
		return PageGeneratorManager.getUserRecentViewPage(driver);
	}

	public UserHomePageObject backToHomePage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.HOME_PAGE_ICON);
		clickToElement(driver, BasePageNopCommerceUI.HOME_PAGE_ICON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	// Pattern Object

	/*
	 * public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) { waitForElementClickable(driver,
	 * BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName); clickToElement(driver,
	 * BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName); }
	 * 
	 *//**
		 * Enter to Dynamic Textbox by ID
		 * 
		 * @param driver
		 * @param TextboxID
		 * @param value
		 */
	/*
	 * 
	 * public void inputToTextboxByID(WebDriver driver, String textboxID, String value) { waitForElementVisible(driver,
	 * BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID); sendkeyToElement(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, value,
	 * textboxID); }
	 * 
	 *//**
		 * Click to dynamic Button by Text
		 * 
		 * @param driver
		 * @param buttonText
		 */
	/*
	 * 
	 * public void clickToButtonByText(WebDriver driver, String buttonText) { waitForElementClickable(driver,
	 * BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText); clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT,
	 * buttonText); }
	 * 
	 *//**
		 * Click to dynamic Radio by Label name
		 * 
		 * @param driver
		 * @param radioLabelName
		 */
	/*
	 * 
	 * public void clickToRadioByLabel(WebDriver driver, String radioLabelName) { waitForElementClickable(driver,
	 * BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioLabelName); checkToDefaultCheckboxOrRadio(driver,
	 * BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioLabelName); }
	 * 
	 *//**
		 * Select dynamic Dropdown by Name with value
		 * 
		 * @param driver
		 * @param dropdownAttributeName
		 * @param value
		 */

	/*
	 * 
	 * public void selectDropdownByNameAttribute(WebDriver driver, String dropdownAttributeName, String value) { waitForElementClickable(driver,
	 * BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName); selectItemInDefaultDropdown(driver,
	 * BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, value, dropdownAttributeName);
	 * 
	 * }
	 * 
	 *//**
		 * Click to dynamic Checkbox by Label name
		 * 
		 * @param driver
		 * @param checkboxLabelName
		 *//*
			 * public void clickToCheckboxByLabel(WebDriver driver, String checkboxLabelName) { waitForElementClickable(driver,
			 * BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName); checkToDefaultCheckboxOrRadio(driver,
			 * BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName); }
			 * 
			 * public boolean getCheckboxCheckedStatusByLabel(WebDriver driver, String checkboxLabelName) { waitForElementVisible(driver,
			 * BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName); return isElementSelected(driver,
			 * BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName); }
			 * 
			 * public boolean getRadioCheckedStatusByLabel(WebDriver driver, String radioLabelName) { waitForElementVisible(driver,
			 * BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioLabelName); return isElementSelected(driver,
			 * BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioLabelName); }
			 * 
			 * public String getTextboxValueByID(WebDriver driver, String textboxID) { waitForElementVisible(driver,
			 * BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID); return getAttributeValue(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID,
			 * "value", textboxID); }
			 * 
			 * public String getDropdownValueByNameAttribute(WebDriver driver, String dropdownAttributeName) { waitForElementVisible(driver,
			 * BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName); return getSelectedItemInDefaultDropdown(driver,
			 * BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName); }
			 */

	// Level_08_Switch_Role

	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_USER);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_LINK_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_ADMIN);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_LINK_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public UserRegisterPageObject clickToRegisterLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.REGISTER_LINK);
		clickToElement(driver, BasePageNopCommerceUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGIN_LINK);
		clickToElement(driver, BasePageNopCommerceUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserCustomerInfoPageObject clickToMyAccountLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		clickToElement(driver, BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPageObject(driver);
	}

	// HRM Orange Page
	// Menu
	public void openMenuPage(WebDriver driver, String menuPageName) {
		waitForElementClickable(driver, BasePageHrmUI.MENU_PAGE_BY_NAME, menuPageName);
		clickToElement(driver, BasePageHrmUI.MENU_PAGE_BY_NAME, menuPageName);
	}

	// Sub Menu
	public void openSubMenuPage(WebDriver driver, String menuPageName, String subMenuPage) {
		waitForElementClickable(driver, BasePageHrmUI.MENU_PAGE_BY_NAME, menuPageName);
		clickToElement(driver, BasePageHrmUI.MENU_PAGE_BY_NAME, menuPageName);

		waitForElementClickable(driver, BasePageHrmUI.SUB_AND_CHILDSUB_MENU_PAGE_BY_NAME, subMenuPage);
		clickToElement(driver, BasePageHrmUI.SUB_AND_CHILDSUB_MENU_PAGE_BY_NAME, subMenuPage);

	}

	// Child Sub Menu
	public void openChildSubMenuPage(WebDriver driver, String menuPageName, String subMenuPage, String childSubMenuPage) {
		waitForElementClickable(driver, BasePageHrmUI.MENU_PAGE_BY_NAME, menuPageName);
		clickToElement(driver, BasePageHrmUI.MENU_PAGE_BY_NAME, menuPageName);

		waitForElementVisible(driver, BasePageHrmUI.SUB_AND_CHILDSUB_MENU_PAGE_BY_NAME, subMenuPage);
		hoverMouseToElement(driver, BasePageHrmUI.SUB_AND_CHILDSUB_MENU_PAGE_BY_NAME, subMenuPage);

		waitForElementClickable(driver, BasePageHrmUI.SUB_AND_CHILDSUB_MENU_PAGE_BY_NAME, childSubMenuPage);
		clickToElement(driver, BasePageHrmUI.SUB_AND_CHILDSUB_MENU_PAGE_BY_NAME, childSubMenuPage);

	}

	// Click to Button
	public void clickToButtonByID(WebDriver driver, String buttonID) {
		waitForElementClickable(driver, BasePageHrmUI.BUTTON_BY_ID, buttonID);
		clickToElement(driver, BasePageHrmUI.BUTTON_BY_ID, buttonID);
	}

	// Enter to Textbox
	public void enterToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, BasePageHrmUI.TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageHrmUI.TEXTBOX_BY_ID, value, textboxID);
	}

	// Get value in Textbox
	public String getValueInTextboxByID(WebDriver driver, String textboxID) {
		waitForElementVisible(driver, BasePageHrmUI.TEXTBOX_BY_ID, textboxID);
		return getElementText(driver, BasePageHrmUI.TEXTBOX_BY_ID, textboxID);
	}

	// Get attribute value in Textbox
	public String getAttributeInTextboxByID(WebDriver driver, String textboxID, String attrValue) {
		waitForElementVisible(driver, BasePageHrmUI.TEXTBOX_BY_ID, textboxID);
		return getAttributeValue(driver, BasePageHrmUI.TEXTBOX_BY_ID, attrValue, textboxID);
	}

	// Check to Checkbox
	public void checkToCheckboxByLabelName(WebDriver driver, String checkboxLableName) {
		waitForElementClickable(driver, BasePageHrmUI.CHECKBOX_BY_LABEL, checkboxLableName);
		checkToDefaultCheckboxOrRadio(driver, BasePageHrmUI.CHECKBOX_BY_LABEL, checkboxLableName);
	}

	// Check to Radio button
	public void checkToRadioButtonByLabelName(WebDriver driver, String radioLableName) {
		waitForElementClickable(driver, BasePageHrmUI.RADIO_BY_LABEL, radioLableName);
		checkToDefaultCheckboxOrRadio(driver, BasePageHrmUI.RADIO_BY_LABEL, radioLableName);
	}

	// Check Radio is checked or not
	public boolean isRadioCheckedByLabelName(WebDriver driver, String radioLableName) {
		waitForElementVisible(driver, BasePageHrmUI.RADIO_BY_LABEL, radioLableName);
		return isElementSelected(driver, BasePageHrmUI.RADIO_BY_LABEL, radioLableName);
	}

	// Select item in default dropdown
	public void selectDropdownByID(WebDriver driver, String dropdownID, String value) {
		waitForElementClickable(driver, BasePageHrmUI.DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(driver, BasePageHrmUI.DROPDOWN_BY_ID, value, dropdownID);
	}

	// Get selected item in default dropdown
	public String getSelectedItemInDropdownByID(WebDriver driver, String dropdownID) {
		waitForElementVisible(driver, BasePageHrmUI.DROPDOWN_BY_ID, dropdownID);
		return getSelectedItemInDefaultDropdown(driver, BasePageHrmUI.DROPDOWN_BY_ID, dropdownID);
	}

	// Verify value in Result Table
	public String getValueTextInTableByIDAtRowAndColumnIndex(WebDriver driver, String tableID, String rowIndex, String columnName) {
		int columnIndex = getElementSize(driver, BasePageHrmUI.COLUMN_INDEX_BY_ID, tableID, columnName) + 1;
		waitForElementVisible(driver, BasePageHrmUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, BasePageHrmUI.TABLE_VALUE_BY_ROW_AND_COLUMN_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
	}

	public LoginPO logoutToSystem(WebDriver driver) {
		waitForElementClickable(driver, BasePageHrmUI.WELCOME_LINK);
		clickToElement(driver, BasePageHrmUI.WELCOME_LINK);

		waitForElementClickable(driver, BasePageHrmUI.LOGOUT_LINK);
		clickToElement(driver, BasePageHrmUI.LOGOUT_LINK);

		return PageGeneratorManagerHRM.getLoginPage(driver);
	}

	public boolean isSuccessMessageDisplayed(WebDriver driver, String msgContent) {
		waitForElementVisible(driver, BasePageHrmUI.SUCCESS_MSG, msgContent);
		return isElementDisplayed(driver, BasePageHrmUI.SUCCESS_MSG, msgContent);
	}

	public boolean isFieldEnabledByID(WebDriver driver, String fieldID) {
		waitForElementVisible(driver, BasePageHrmUI.ANY_FIELD_BY_ID, fieldID);
		return isElementEnabled(driver, BasePageHrmUI.ANY_FIELD_BY_ID, fieldID);
	}

	private long longTimeout = GlobalConstants.LONG_TIME_OUT;
	private long shortTimeout = GlobalConstants.SHORT_TIME_OUT;

}
