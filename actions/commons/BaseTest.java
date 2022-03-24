package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver GetBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("98.0.4758.102").setup();
			ChromeOptions option = new ChromeOptions();
			option.setBinary("C:\\Users\\Admin\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(option);
		} else if (browserName.equals("brave")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(option);
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else {
			throw new RuntimeException("Browser name is incorrect !");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
}
