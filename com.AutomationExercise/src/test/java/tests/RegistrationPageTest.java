package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignupLoginPage;

public class RegistrationPageTest extends BaseTest {

	RegistrationPage registrationPage;
	HomePage homePage;
	SignupLoginPage signUp;

	@Test(dataProvider = "registrationData", dataProviderClass = dataproviders.DataProviderClass.class)
	public void testRegistrationPage(String title, String password, String dob, String firstName, String lastName,
			String address1, String country, String state, String city, String zipCode, String mobileNumber) {
		homePage = new HomePage(getDriver());
		homePage.clickSignupLoginLink();

		signUp = new SignupLoginPage(getDriver());
		signUp.newUserSignup("TestName", "123459Test@gmail.com");

		registrationPage = new RegistrationPage(getDriver());

		registrationPage.enterRegistrationDetails(title, password, dob, firstName, lastName, address1, country, state,
				city, zipCode, mobileNumber);

		registrationPage.clickCreateAccountButton();
	}
}
