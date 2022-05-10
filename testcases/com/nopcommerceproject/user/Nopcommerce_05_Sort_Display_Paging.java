package com.nopcommerceproject.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserNotebookPageObject;

public class Nopcommerce_05_Sort_Display_Paging extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = GetBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		menuName = "Computers";
		subMenuName = "Notebooks";
		sortNameAZ = "Name: A to Z";
		sortNameZA = "Name: Z to A";
		sortPriceAsc = "Price: Low to High";
		sortPriceDesc = "Price: High to Low";
		display3PerPage = "3";
		display6PerPage = "6";
		display9PerPage = "9";
		firstPage = "1";
		secondPage = "2";

		log.info("Precondition - Step 01: Open Notebook page in Sub Menu");
		homePage.openSubMenuHeader(driver, menuName, subMenuName);
		notebookPage = PageGeneratorManager.getUserNotebookPage(driver);
	}

	@Test
	public void Sort_Display_Paging_01_Sort_Name_Ascending() {
		log.info("Sort Name A to Z - Step 01: Select 'Name: A to Z' in Sort by dropdown");
		notebookPage.selectItemInSortDropdown(sortNameAZ);

		log.info("Sort Name A to Z - Step 02: Verify all product names are sorted with ascending order");
		verifyTrue(notebookPage.areProductNamesSortedAscending());
	}

	@Test
	public void Sort_Display_Paging_02_Sort_Name_Descending() {
		log.info("Sort Name Z to A - Step 01: Select 'Name: Z to A' in Sort by dropdown");
		notebookPage.selectItemInSortDropdown(sortNameZA);

		log.info("Sort Name Z to A - Step 02: Verify all product names are sorted with descending order");
		verifyTrue(notebookPage.areProductNamesSortedAscending());
	}

	@Test
	public void Sort_Display_Paging_03_Sort_Price_Ascending() {
		log.info("Sort Price Low to High - Step 01: Select 'Price: Low to High' in Sort by dropdown");
		notebookPage.selectItemInSortDropdown(sortPriceAsc);

		log.info("Sort Price Low to High - Step 02: Verify all product prices are sorted with ascending order");
		verifyTrue(notebookPage.areProductPricesSortedAscending());

	}

	@Test
	public void Sort_Display_Paging_04_Sort_Price_Descending() {
		log.info("Sort Price Low to High - Step 01: Select 'Price: High to Low' in Sort by dropdown");
		notebookPage.selectItemInSortDropdown(sortPriceDesc);

		log.info("Sort Price Low to High - Step 02: Verify all product prices are sorted with descending order");
		verifyTrue(notebookPage.areProductPricesSortedDescending());

	}

	@Test
	public void Sort_Display_Paging_05_Display_3_Products_Per_Page() {
		log.info("Display 3 products per page - Step 01: Select '3' in Display dropdown");
		notebookPage.selectItemInDisplayDropdown(display3PerPage);

		log.info("Display 3 products per page - Step 02: Verify <= 3 products are shown per page");
		verifyTrue(notebookPage.areNumberOfItemsDisplayedCorrectly(display3PerPage));

		log.info("Display 3 products per page - Step 03: Verify Page 1 Number is activated");
		verifyTrue(notebookPage.isPageNumberActivated(firstPage));

		log.info("Display 3 products per page - Step 04: Verify Next icon is shown when on Page 1");
		verifyTrue(notebookPage.isNextIconDisplayed());

		log.info("Display 3 products per page - Step 05: Click to Page 2 icon");
		notebookPage.openPagingByPageNumber(secondPage);

		log.info("Display 3 products per page - Step 06: Verify Page 2 Number is activated");
		verifyTrue(notebookPage.isPageNumberActivated(secondPage));

		log.info("Display 3 products per page - Step 07: Verify Previous icon is shown when on Page 2");
		verifyTrue(notebookPage.isPreviousIconDisplayed());
	}

	@Test
	public void Sort_Display_Paging_06_Display_6_Products_Per_Page() {
		log.info("Display 6 products per page - Step 01: Select '6' in Display dropdown");
		notebookPage.selectItemInDisplayDropdown(display6PerPage);

		log.info("Display 6 products per page - Step 02: Verify <= 6 products are shown per page");
		verifyTrue(notebookPage.areNumberOfItemsDisplayedCorrectly(display6PerPage));

		log.info("Display 6 products per page - Step 03: Verify Pagination is disappeared");
		verifyTrue(notebookPage.isPaginationUndisplayed());
	}

	@Test
	public void Sort_Display_Paging_07_Display_9_Products_Per_Page() {
		log.info("Display 9 products per page - Step 01: Select '9' in Display dropdown");
		notebookPage.selectItemInDisplayDropdown(display9PerPage);

		log.info("Display 9 products per page - Step 02: Verify <= 9 products are shown per page");
		verifyTrue(notebookPage.areNumberOfItemsDisplayedCorrectly(display9PerPage));

		log.info("Display 9 products per page - Step 03: Verify Pagination is disappeared");
		verifyTrue(notebookPage.isPaginationUndisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String menuName, subMenuName, sortNameAZ, sortNameZA, sortPriceAsc, sortPriceDesc, display3PerPage, display6PerPage, display9PerPage, firstPage, secondPage;
	private UserHomePageObject homePage;
	private UserNotebookPageObject notebookPage;

}