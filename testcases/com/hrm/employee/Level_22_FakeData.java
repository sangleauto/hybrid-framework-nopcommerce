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
import pageObjects.hrm.PageGeneratorManagerHRM;
import pageObjects.hrm.MyInfoPO;
import ultilities.DataUtil;

public class Level_22_FakeData extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName, String appUrl) {
		log.info("Precondition - Step 01: Open '" + browserName + "' browser and navigate to '" + appUrl + "'");
		driver = GetBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManagerHRM.getLoginPage(driver);
		faker = DataUtil.getData();

		adminUserName = "admin";
		adminPassword = "supachoke";

		statusValue = "Enabled";
		empFirstName = faker.getFirstName();
		empLastName = faker.getLastName();
		empFullName = empFirstName + " " + empLastName;
		empUserName = faker.getUsername();
		empPassword = faker.getPassword();

		log.info("Precondition - Step 02: Login with Admin role");
		loginPage.enterToTextboxByID(driver, "txtUsername", adminUserName);
		loginPage.enterToTextboxByID(driver, "txtPassword", adminPassword);
		loginPage.clickToButtonByID(driver, "btnLogin");
		dashboardPage = PageGeneratorManagerHRM.getDashboardPage(driver);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_Employee - Step 01: Open 'Employee List' page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManagerHRM.getEmployeeListPage(driver);

		log.info("Add_New_Employee - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGeneratorManagerHRM.getAddEmployeePage(driver);

		log.info("Add_New_Employee - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "firstName", empFirstName);

		log.info("Add_New_Employee - Step 04: Enter valid info 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "lastName", empLastName);

		log.info("Add_New_Employee - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getAttributeInTextboxByID(driver, "employeeId", "value");

		log.info("Add_New_Employee - Step 06: Check to 'Create Login Details' checkbox");
		addEmployeePage.checkToCheckboxByLabelName(driver, "Create Login Details");

		log.info("Add_New_Employee - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_name", empUserName);

		log.info("Add_New_Employee - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_password", empPassword);

		log.info("Add_New_Employee - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "re_password", empPassword);

		log.info("Add_New_Employee - Step 10: Select '" + statusValue + " ' value in 'Status' dropdown");
		addEmployeePage.selectDropdownByID(driver, "status", statusValue);

		log.info("Add_New_Employee - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		personalDetailPage = PageGeneratorManagerHRM.getMyInfoPage(driver);

		log.info("Add_New_Employee - Step 12: Open 'Employee List' page");
		personalDetailPage.sleepInSecond(3);
		personalDetailPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManagerHRM.getEmployeeListPage(driver);

		log.info("Add_New_Employee - Step 13: Enter valid info to 'Employee Name' textbox");
		employeeListPage.sleepInSecond(3);
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", empFullName);
		employeeListPage.sleepInSecond(3);

		log.info("Add_New_Employee - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		employeeListPage.sleepInSecond(3);

		log.info("Add_New_Employee - Step 15: Verify Employee Infomation at 'Result Table'");
		verifyEquals(employeeListPage.getValueTextInTableByIDAtRowAndColumnIndex(driver, "resultTable", "1", "Id"), employeeID);
		verifyEquals(employeeListPage.getValueTextInTableByIDAtRowAndColumnIndex(driver, "resultTable", "1", "Last Name"), empLastName);
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
	private DataUtil faker;
	private String empFirstName, empLastName, employeeID, statusValue, empUserName, empPassword, empFullName, adminUserName, adminPassword;

	private LoginPO loginPage;
	private DashboardPO dashboardPage;
	private EmployeeListPO employeeListPage;
	private AddEmployeePO addEmployeePage;
	private MyInfoPO personalDetailPage;

}
