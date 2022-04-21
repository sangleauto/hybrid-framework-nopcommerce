package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGeneratorManager;
import pageObjects.hrm.PersonalDetailPO;

public class Level_19_Live_Coding extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName, String appUrl) {
		log.info("Precondition - Step 01: Open '" + browserName + "' browser and navigate to '" + appUrl + "'");
		driver = GetBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		firstName = "Huy";
		lastName = "Aliciaaa";
		statusValue = "Enabled";
		userName = "sangfire123";
		password = "admin123";

		log.info("Precondition - Step 02: Login with Admin role");
		loginPage.enterToTextboxByID(driver, "txtUsername", "Admin");
		loginPage.enterToTextboxByID(driver, "txtPassword", "admin123");
		loginPage.clickToButtonByID(driver, "btnLogin");
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_Employee - Step 01: Open 'Employee List' page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add_New_Employee - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGeneratorManager.getAddEmployeePage(driver);

		log.info("Add_New_Employee - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "firstName", firstName);

		log.info("Add_New_Employee - Step 04: Enter valid info 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "lastName", lastName);

		log.info("Add_New_Employee - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getAttributeInTextboxByID(driver, "employeeId", "value");

		log.info("Add_New_Employee - Step 06: Check to 'Create Login Details' checkbox");
		addEmployeePage.checkToCheckboxByID(driver, "Create Login Details");

		log.info("Add_New_Employee - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_name", userName);

		log.info("Add_New_Employee - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_password", password);

		log.info("Add_New_Employee - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "re_password", password);

		log.info("Add_New_Employee - Step 10: Select '" + statusValue + " ' value in 'Status' dropdown");
		addEmployeePage.selectDropdownByID(driver, "status", statusValue);

		log.info("Add_New_Employee - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);

		log.info("Add_New_Employee - Step 12: Open 'Employee List' page");
		personalDetailPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add_New_Employee - Step 13: Enter valid info to 'Employee Name' textbox");
		employeeListPage.sleepInSecond(3);
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", lastName);
		employeeListPage.sleepInSecond(3);

		log.info("Add_New_Employee - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		employeeListPage.sleepInSecond(3);

		log.info("Add_New_Employee - Step 15: Verify Employee Infomation at 'Result Table'");
		verifyEquals(employeeListPage.getValueTextInTableByIDAtRowAndColumnIndex(driver, "resultTable", "1", "Id"), employeeID);
		verifyEquals(employeeListPage.getValueTextInTableByIDAtRowAndColumnIndex(driver, "resultTable", "1", "Last Name"), lastName);
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
	public void Employee_05_Add_New_Employee() {

	}

	@Test
	public void Employee_06_Emergency_Detail() {

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
	private String firstName, lastName, employeeID, statusValue, userName, password;

	private LoginPO loginPage;
	private DashboardPO dashboardPage;
	private EmployeeListPO employeeListPage;
	private AddEmployeePO addEmployeePage;
	private PersonalDetailPO personalDetailPage;

}
