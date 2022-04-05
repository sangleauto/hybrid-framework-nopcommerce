package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.liveGuru.admin.AdminDashboardPageObject;
import pageObjects.liveGuru.admin.AdminLoginPageObject;
import pageObjects.liveGuru.user.UserHomePageObject;
import pageObjects.liveGuru.user.UserLoginPageObject;
import pageObjects.liveGuru.user.UserMyDashBoardPageObject;
import pageObjects.liveGuru.user.UserRegisterPageObject;

public class PageGeneratorManagerLiveGuru {

	public static UserHomePageObject getUserHomePageObject(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPageObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserMyDashBoardPageObject getUserMyDashBoardPageObject(WebDriver driver) {
		return new UserMyDashBoardPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
}
