package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	@Parameters("browser")
	public void lauchBrowser(String browser) throws IOException {
		// Load the URL from config.properties
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");

		// Launch the browser
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}

	@AfterMethod
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	@AfterTest
	public void closeAllOpenBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
