package testCases;

import org.testng.annotations.Test;

import pages.Base;
import pages.SignupLoginPage;

public class SigupTest extends Base {

	SignupLoginPage signUp;

	@Test
	public void singupToApplication() throws InterruptedException {
		signUp = new SignupLoginPage(getDriver());
		signUp.newUserSignup("TestName", "123Test@gmail.com");
	}
}
