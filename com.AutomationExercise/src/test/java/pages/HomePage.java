package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='logo pull-left']")
	WebElement homePageLogo;

	@FindBy(xpath = "//a[normalize-space(text() )= 'Home']")
	WebElement homeLink;

	@FindBy(xpath = "//a[normalize-space(text() )= 'Signup / Login']")
	WebElement signupLoginLnk;

	public void clickHomePageLogo() {
		homePageLogo.click();
	}

	public void clickHomeLink() {
		homePageLogo.click();
	}

	public void clickSignupLoginLink() {
		signupLoginLnk.click();
	}
}
