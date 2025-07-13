package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listners.TestListners;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignupLoginPage;

@Listeners(TestListners.class)

@Epic("Signup Feature")
@Feature("Signup Tests")
public class SignupTest extends BaseTest {

	SignupLoginPage signUp;
	HomePage homePage;
	RegistrationPage registrationPage;

	@Test(description = "Valid Signup Test")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid Signup with correct username and password")
    @Description("Test Description: Signup test with valid credentials")
	public void singupToApplication() {
		homePage = new HomePage(getDriver());
		homePage.clickSignupLoginLink();
		signUp = new SignupLoginPage(getDriver());
		signUp.newUserSignup("TestName", "1240Test@gmail.com");
		registrationPage = new RegistrationPage(getDriver());
		Assert.assertEquals(registrationPage.getNameElement().getAttribute("value"), "TestName");
		Assert.assertEquals(registrationPage.getEmailElement().getAttribute("value"), "1240Test@gmail.com");
	}

//	@Test(groups = { "smoke" })
//	public void smokeTest() {
//		System.out.println("This is smoke test!!");
//	}
//
//	@Test(groups = { "regression" })
//	public void regressionTest1() {
//		System.out.println("This is regression test1!!");
//		Assert.assertEquals(1, 1);
//	}
//
//	@Test(groups = { "regression" }, dependsOnMethods = "regressionTest1")
//	public void regressionTest2() {
//		System.out.println("This is regression test2!!");
//	}
//
//	@Test(groups = { "system" })
//	public void systemTest() {
//		System.out.println("This is system test");
//	}
//
//	@Test(groups = { "system", "smoke" })
//	public void systemSmokeTest() {
//		System.out.println("This is system as well as smoke test");
//	}
}
