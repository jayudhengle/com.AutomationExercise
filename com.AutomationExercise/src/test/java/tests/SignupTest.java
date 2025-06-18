package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listners.TestListners;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignupLoginPage;

@Listeners(TestListners.class)
public class SignupTest extends BaseTest {

	SignupLoginPage signUp;
	HomePage homePage;
	RegistrationPage registrationPage;

	@Test
	public void singupToApplication() throws InterruptedException, IOException {
		homePage = new HomePage(getDriver());
		homePage.clickSignupLoginLink();

		signUp = new SignupLoginPage(getDriver());
		signUp.newUserSignup("TestName", "1233Test@gmail.com");

		registrationPage = new RegistrationPage(getDriver());

		Assert.assertEquals(registrationPage.getNameElement().getAttribute("value"), "TestName");

		Assert.assertEquals(registrationPage.getEmailElement().getAttribute("value"), "123Test@gmail.com");
		
	}

	@Test(groups = { "smoke" })
	public void smokeTest() {
		System.out.println("This is smoke test!!");
	}

	@Test(groups = { "regression" })
	public void regressionTest1() {
		System.out.println("This is regression test1!!");
		Assert.assertEquals(1, 1);
	}

	@Test(groups = { "regression" }, dependsOnMethods = "regressionTest1")
	public void regressionTest2() {
		System.out.println("This is regression test2!!");
	}

	@Test(groups = { "system" })
	public void systemTest() {
		System.out.println("This is system test");
	}

	@Test(groups = { "system", "smoke" })
	public void systemSmokeTest() {
		System.out.println("This is system as well as smoke test");
	}
}
