package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupLoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy(name= "password")
	WebElement loginPassword;
	
	@FindBy(xpath="//*[text()= 'Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@data-qa='signup-name']")
	WebElement signupName;
	
	@FindBy(xpath="//*[@data-qa='signup-email']")
	WebElement signupEmail;
	
	@FindBy(xpath ="//*[text()= 'Signup']")
	WebElement singupButton;
	
	
	public SignupLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void newUserSignup(String name, String email) throws InterruptedException
	{
		
		signupName.sendKeys(name);
		signupEmail.sendKeys(email);
		singupButton.click();
		Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
