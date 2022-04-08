package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(commons.MethodListener.class)
public class Topic_17_Assert extends BaseTest {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01() {
		System.out.println("Assert 01");
		verifyEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

		System.out.println("Assert 02");
		verifyEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");

		System.out.println("Assert 03 - Failed");
		verifyEquals(driver.getTitle(), "Facebook - Đăng nhập");

		System.out.println("Assert 04 - Failed");
		verifyTrue(driver.findElement(By.xpath("//input[@name='login_source']")).isDisplayed());

		System.out.println("Assert 05");
		verifyTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
