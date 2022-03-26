package javaBasic;

public class Topic_14_String_Format {
	public static final String ADDRESS_LINK = "xpath=//div[@class='footer-block my-account']//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//a[text()='Reward points']";

	// 1 bien dung chung cho tat ca locator cua sidebar
	public static final String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//div[contains(@class, 'account-navigation')]//a[text()='%s']";

	// 1 bien dung chung cho tat ca page
	public static final String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class, '%s')]//a[text()='%s']";

	public static void main(String[] args) {
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Addresses");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "My product reviews");
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Reward points");

		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "address_2");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "login_2");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "search_2");
	}

	// 1 tham số động
	private static void clickToLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("Locator: " + locator);
	}

	// 2 tham số động
	// private static void clickToLink(String dynamicLocator, String areaName, String pageName) {
	// String locator = String.format(dynamicLocator, areaName, pageName);
	// System.out.println("Locator: " + locator);
	// }

	// 1-n tham số động
	private static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Locator: " + locator);
	}
}
