package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFile.HomePageObject;
import pageObject.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	String apiFileName = "API.png";
	String appiumFileName = "Appium.png";
	String seleniumFileName = "Selenium.png";

	String[] multiplesFileName = { apiFileName, appiumFileName, seleniumFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 1: load 1 file
		homePage.uploadMultipleFiles(driver, appiumFileName);

		// Step 2: verify file loaded successfully
		Assert.assertTrue(homePage.isFileNameLoaded(appiumFileName));

		// Step 3: Click to start button
		homePage.clickToStartButton();

		// Step 4: Verify file link loaded successfully
		Assert.assertTrue(homePage.isFileNameUploaded(appiumFileName));

		// Step 5: Verify file img loaded successfully
		Assert.assertTrue(homePage.isFileImageUploaded(appiumFileName));

	}

	@Test
	public void Upload_02_Multiple_Files_Per_Time() {
		homePage.refreshCurrentPage(driver);
		// Step 1: load multiple files
		homePage.uploadMultipleFiles(driver, multiplesFileName);

		// Step 2: verify multiple files loaded successfully
		Assert.assertTrue(homePage.isFileNameLoaded(apiFileName));
		Assert.assertTrue(homePage.isFileNameLoaded(appiumFileName));
		Assert.assertTrue(homePage.isFileNameLoaded(seleniumFileName));

		// Step 3: Click to start button
		homePage.clickToStartButton();

		// Step 4: Verify multiple links loaded successfully
		Assert.assertTrue(homePage.isFileNameUploaded(apiFileName));
		Assert.assertTrue(homePage.isFileNameUploaded(appiumFileName));
		Assert.assertTrue(homePage.isFileNameUploaded(seleniumFileName));

		// Step 5: Verify multiple images loaded successfully
		Assert.assertTrue(homePage.isFileImageUploaded(apiFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(appiumFileName));
		Assert.assertTrue(homePage.isFileImageUploaded(seleniumFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	public HomePageObject homePage;

}
