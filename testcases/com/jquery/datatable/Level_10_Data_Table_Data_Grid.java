package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jquery.HomePageObject;
import pageObject.jquery.PageGeneratorManager;

public class Level_10_Data_Table_Data_Grid extends BaseTest {
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActivated("10"));
		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("15");
		Assert.assertTrue(homePage.isPageNumberActivated("15"));
		homePage.sleepInSecond(1);

		homePage.openPagingByPageNumber("3");
		Assert.assertTrue(homePage.isPageNumberActivated("3"));
		homePage.sleepInSecond(1);

	}

	// @Test
	public void Table_02_Enter_To_Header_Textbox() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "England");
		homePage.enterToHeaderTextboxByLabel("Females", "434343");
		homePage.enterToHeaderTextboxByLabel("Males", "534534");
		homePage.enterToHeaderTextboxByLabel("Total", "64564564");
		homePage.sleepInSecond(1);

		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "654645");
		homePage.enterToHeaderTextboxByLabel("Males", "4234324");
		homePage.enterToHeaderTextboxByLabel("Total", "53465464");
		homePage.sleepInSecond(1);

	}

	@Test
	public void Table_03_Get_Each_Row_All_Pages() {
		homePage.getValueEachRowAtAllPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
