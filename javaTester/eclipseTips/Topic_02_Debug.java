package eclipseTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Topic_02_Debug {
	WebDriver driver;

	public void TC_01() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		String title = driver.findElement(By.xpath("//img[@alt='Facebook']/parent::div/following-sibling::h2")).getText();
		Assert.assertEquals(title, "Facebook helps you connect and share with the people in your life.");

		boolean isLoginDisplayed = driver.findElement(By.name("login")).isDisplayed();
		Assert.assertTrue(isLoginDisplayed);

		driver.quit();
	}

}
