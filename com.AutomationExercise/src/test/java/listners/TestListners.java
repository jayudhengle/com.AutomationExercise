package listners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import io.qameta.allure.Attachment;

public class TestListners implements ITestListener {

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
        System.out.println("❌ Test Failed: " + result.getName());

        WebDriver driver = BaseTest.getDriver();
        if (driver != null) {
            captureScreenshot(driver);
        }
        
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + System.currentTimeMillis() + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
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
