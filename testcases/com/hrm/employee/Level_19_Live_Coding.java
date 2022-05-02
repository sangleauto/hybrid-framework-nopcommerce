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
import pageObjects.hrm.MyInfoPO;
import pageObjects.hrm.PageGeneratorManagerHRM;
import ultilities.DataUtil;

public class Level_19_Live_Coding extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browser
	public void beforeClass(String browserName, String appUrl) {
		verifyTrue(false);
		log.info("Precondition - Step 01: Open '" + browserName + "' browser and navigate to '" + appUrl + "'");
		driver = GetBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManagerHRM.getLoginPage(driver);
		faker = DataUtil.getData();

		adminUserName = "Admin";
		adminPassword = "admin123";

		statusValue = "Enabled";
		empFirstName = faker.getFirstName();
		empLastName = faker.getLastName();
		empFullName = empFirstName + " " + empLastName;
		empUserName = faker.getUsername();
		empPassword = faker.getPassword();

		editEmpFirstName = faker.getFirstName();
		editEmpLastName = faker.getLastName();
		editEmpGender = "Male";
		editEmpMarital = "Single";
		editEmpNationality = "American";

		contactAddress1 = faker.getAddress();
		contactCity = faker.getCity();
		contactCountry = "Japan";
		contactMobile = faker.getPhoneNumber();
		contactWorkEmail = faker.getEmailAddress();

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
		myInfoPage = PageGeneratorManagerHRM.getMyInfoPage(driver);

		log.info("Add_New_Employee - Step 12: Open 'Employee List' page");
		// verifyTrue(personalDetailPage.areJQueryAndJSLoadedSuccess(driver));
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGeneratorManagerHRM.getEmployeeListPage(driver);

		log.info("Add_New_Employee - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(myInfoPage.areJQueryAndJSLoadedSuccess(driver));

		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", empFullName);
		verifyTrue(myInfoPage.areJQueryAndJSLoadedSuccess(driver));

		log.info("Add_New_Employee - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		verifyTrue(myInfoPage.areJQueryAndJSLoadedSuccess(driver));

		log.info("Add_New_Employee - Step 15: Verify Employee Infomation at 'Result Table'");
		verifyEquals(employeeListPage.getValueTextInTableByIDAtRowAndColumnIndex(driver, "resultTable", "1", "Id"), employeeID);
		verifyEquals(employeeListPage.getValueTextInTableByIDAtRowAndColumnIndex(driver, "resultTable", "1", "Last Name"), empLastName);
	}

	// @Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar - Step 01: Login with Employee role");
		loginPage = employeeListPage.logoutToSystem(driver);
		dashboardPage = loginPage.loginToSystem(empUserName, empPassword);

		log.info("Upload_Avatar - Step 02: Click to Personal Detail Page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGeneratorManagerHRM.getMyInfoPage(driver);

		log.info("Upload_Avatar - Step 03: Click to change Avatar IMG");
		myInfoPage.clickToChangeAvatar();

		log.info("Upload_Avatar - Step 04: Upload Avatar IMG");
		myInfoPage.uploadMultipleFiles(driver, "Appium.png");

		log.info("Upload_Avatar - Step 05: Click to Upload button");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Upload_Avatar - Step 06: Verify Success Message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Uploaded"));

		log.info("Upload_Avatar - Step 06: Verify new Avatar IMG is displayed");
		verifyTrue(myInfoPage.isNewAvatarDisplayed());
	}

	// @Test
	public void Employee_03_Personal_Details() {
		log.info("Personal_Details - Step 01: Open 'Personal Details' tab at the Sidebar");
		myInfoPage.openTabAtSideBarByName("Personal Details");
		log.info("Personal_Details - Step 02: Verify all fields are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtLicenNo"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtSINNo"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_DOB"));

		log.info("Personal_Details - Step 03: Click to 'Edit' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		log.info("Personal_Details - Step 04: Verify 'Employee ID' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtEmployeeId"));

		log.info("Personal_Details - Step 05: Verify 'Driver's License Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtLicenNo"));

		log.info("Personal_Details - Step 06: Verify 'SSN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtNICNo"));

		log.info("Personal_Details - Step 07: Verify 'SIN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_txtSINNo"));

		log.info("Personal_Details - Step 08: Verify 'Date of Birth' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "personal_DOB"));

		log.info("Personal_Details - Step 09: Enter new value to 'First Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);

		log.info("Personal_Details - Step 10: Enter new value to 'Last Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpLastName", editEmpLastName);

		log.info("Personal_Details - Step 11: Enter new value to 'Gender' radio");
		myInfoPage.checkToRadioButtonByLabelName(driver, editEmpGender);

		log.info("Personal_Details - Step 12: Enter new value to 'Marital Status' dropdown");
		myInfoPage.selectDropdownByID(driver, "personal_cmbMarital", editEmpMarital);

		log.info("Personal_Details - Step 13: Enter new value to 'Nationality' dropdown");
		myInfoPage.selectDropdownByID(driver, "personal_cmbNation", editEmpNationality);

		log.info("Personal_Details - Step 14: Click to 'Save' button at 'Personal Details' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Personal_Details - Step 15: Verify Success Message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));
		myInfoPage.sleepInSecond(5);
		log.info("Personal_Details - Step 16: Verify 'First Name' textbox is updated successfully");
		verifyEquals(myInfoPage.getAttributeInTextboxByID(driver, "personal_txtEmpFirstName", "value"), editEmpFirstName);
		log.info("Personal_Details - Step 17: Verify 'Last Name' textbox is updated successfully");
		verifyEquals(myInfoPage.getAttributeInTextboxByID(driver, "personal_txtEmpLastName", "value"), editEmpLastName);

		log.info("Personal_Details - Step 18: Verify 'Gender' radio is updated successfully");
		verifyTrue(myInfoPage.isRadioCheckedByLabelName(driver, editEmpGender));

		log.info("Personal_Details - Step 19: Verify 'Marital Status' dropdown is updated successfully");
		verifyEquals(myInfoPage.getSelectedItemInDropdownByID(driver, "personal_cmbMarital"), editEmpMarital);

		log.info("Personal_Details - Step 20: Verify 'Nationality' dropdown is updated successfully");
		verifyEquals(myInfoPage.getSelectedItemInDropdownByID(driver, "personal_cmbNation"), editEmpNationality);

		System.out.println("Employee ID: " + employeeID);
		log.info("Personal_Details - Step 21: Verify 'Employee ID' textbox is correct");
		verifyEquals(myInfoPage.getAttributeInTextboxByID(driver, "personal_txtEmployeeId", "value"), employeeID);
	}

	// @Test
	public void Employee_04_Contact_Details() {
		log.info("Contact Details - Step 01: Open 'Contact Details' tab at the Sidebar");
		myInfoPage.openTabAtSideBarByName("Contact Details");
		log.info("Contact Details - Step 02: Verify all fields are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_street1"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_street2"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_city"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_province"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_zipcode"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_country"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_hm_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_mobile"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_work_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_work_email"));
		verifyFalse(myInfoPage.isFieldEnabledByID(driver, "contact_emp_oth_email"));

		log.info("Contact Details - Step 03: Click to 'Edit' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Contact Details - Step 04: Enter new value to 'Address Street 1' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_street1", contactAddress1);

		log.info("Contact Details - Step 04: Enter new value to 'City' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_city", contactCity);

		log.info("Contact Details - Step 05: Choose new value in 'Country' dropdown");
		myInfoPage.selectDropdownByID(driver, "contact_country", contactCountry);

		log.info("Contact Details - Step 06: Enter new value to 'Mobile' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_mobile", contactMobile);

		log.info("Contact Details - Step 07: Enter new value to 'Work Email' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_work_email", contactWorkEmail);

		log.info("Contact Details - Step 08: Click to 'Save' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Contact Details - Step 09: Verify 'Address Street 1' is updated");
		verifyEquals(myInfoPage.getAttributeInTextboxByID(driver, "contact_street1", "value"), contactAddress1);

		log.info("Contact Details - Step 10: Verify 'City' is updated");
		verifyEquals(myInfoPage.getAttributeInTextboxByID(driver, "contact_city", "value"), contactCity);

		log.info("Contact Details - Step 11: Verify 'Country' is updated");
		verifyEquals(myInfoPage.getSelectedItemInDropdownByID(driver, "contact_country"), contactCountry);

		log.info("Contact Details - Step 12: Verify 'Mobile' is updated");
		verifyEquals(myInfoPage.getAttributeInTextboxByID(driver, "contact_emp_mobile", "value"), contactMobile);

		log.info("Contact Details - Step 13: Verify 'Work Email' is updated");
		verifyEquals(myInfoPage.getAttributeInTextboxByID(driver, "contact_emp_work_email", "value"), contactWorkEmail);

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
	private DataUtil faker;
	private String empFirstName, empLastName, employeeID, statusValue, empUserName, empPassword, empFullName;
	private String adminUserName, adminPassword;
	private String editEmpFirstName, editEmpLastName, editEmpGender, editEmpMarital, editEmpNationality;
	private String contactAddress1, contactCity, contactCountry, contactMobile, contactWorkEmail;

	private LoginPO loginPage;
	private DashboardPO dashboardPage;
	private EmployeeListPO employeeListPage;
	private AddEmployeePO addEmployeePage;
	private MyInfoPO myInfoPage;

}
