package listners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;      
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import base.BaseTest;
import pages.RegistrationPage;

public class TestListners extends BaseTest implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started!!!" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed!!!" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed!!!" + result.getName());
		
		TakesScreenshot ts = (TakesScreenshot) BaseTest.getDriver();
		
		File source = ts.getScreenshotAs(OutputType.FILE);		
		File destination = new File("./target/Screenshots/" + result.getName() + ".png");
		
		
		try {
			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		RegistrationPage registrationPage = new RegistrationPage(BaseTest.getDriver());
		
		File source1 = registrationPage.getEmailElement().getScreenshotAs(OutputType.FILE);
		File destination1 = new File("./target/Screenshots/" + "1" + ".png");
		try {
			Files.copy(source1.toPath(), destination1.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped!!!" + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite started!!!" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite completed!!!" + context.getName());
	}
	

}
