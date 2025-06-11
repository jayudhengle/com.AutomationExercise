package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {

	private WebDriver driver;

	String browser = "Chrome";
	String url;
	
	@BeforeTest
	public void getURLDetails() throws IOException
	{
		FileInputStream fis =  new FileInputStream("./src/test/resources/appdetails.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
	}
	
	public WebDriver getDriver() {
		return (driver);

	}

	@BeforeMethod()
	@Parameters("browser")
	public void lauchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
	        options.addArguments("--headless=new");  // Use headless mode
	        options.addArguments("--disable-gpu");
	        options.addArguments("--window-size=1920,1080"); // Optional
			driver = new EdgeDriver(options);


		}

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
