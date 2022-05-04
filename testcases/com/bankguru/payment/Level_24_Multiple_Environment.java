package com.bankguru.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import environment.config.Environment;

public class Level_24_Multiple_Environment extends BaseTest {
	Environment environment;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String env) {
		ConfigFactory.setProperty("env", env);

		environment = ConfigFactory.create(Environment.class);
		driver = GetBrowserDriver(browserName, environment.appUrl());

		System.out.println(environment.appUsername());
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void Employee_01_Add_New_Employee() {

	}

	@Test
	public void Employee_02_Upload_Avatar() {

	}

	@Test
	public void Employee_03_Personal_Details() {

	}

	@Test
	public void Employee_04_Contact_Details() {

	}

	@Test
	public void Employee_05_Emergency_Detail() {

	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Job() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
}
