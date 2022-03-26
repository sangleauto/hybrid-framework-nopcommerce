package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static CustomerInfoPageObject getMyAccountPageObject(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static AddressPageObject getAddressPageObject(WebDriver driver) {
		return new AddressPageObject(driver);
	}

	public static MyProductReviewPageObject getMyProductReviewPageObject(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	public static RewardPointPageObject getRewardPointPageObject(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
}
