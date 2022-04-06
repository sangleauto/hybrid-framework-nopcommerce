package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.PageGeneratorManager;

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

	// @Test
	public void Table_03_Get_Each_Row_All_Pages() {
		homePage.getValueEachRowAtAllPage();
	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();

		// homePage.enterToTextboxByColumnNameAtRowNumber("Album", "2", "Auto Testing");
		// homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "1", "Black Pink");
		// homePage.enterToTextboxByColumnNameAtRowNumber("Year", "3", "2022");
		// homePage.enterToDropDownByColumnNameAtRowNumber("Origin", "5", "Korea");
		// homePage.enterToTextboxByColumnNameAtRowNumber("Price", "4", "50000");
		//
		// homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?", "3");
		// homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?", "5");
		// homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "4");
		// homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "2");
		// homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "1");

		homePage.clickToIconByRowNumber("2", "Insert Row Above");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("1", "Move Down");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(2);
	}

	// @AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
