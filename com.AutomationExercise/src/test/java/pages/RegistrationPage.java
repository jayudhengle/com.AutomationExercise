package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	WebDriver driver;

	@FindBy(id = "id_gender1")
	WebElement mrRadioBtn;

	@FindBy(id = "id_gender2")
	WebElement mrsRadioBtn;

	@FindBy(id = "name")
	WebElement nameTxtBox;

	@FindBy(id = "email")
	WebElement emailTxtBox;

	@FindBy(id = "password")
	WebElement passwordTxtBox;

	@FindBy(id = "days")
	WebElement dobDaysDrpdwn;

	@FindBy(id = "months")
	WebElement dobMonthDrpdwn;

	@FindBy(id = "years")
	WebElement dobYearsDrpdwn;

	@FindBy(id = "first_name")
	WebElement firstNameTxtBox;

	@FindBy(id = "last_name")
	WebElement lastNameTxtBox;

	@FindBy(id = "address1")
	WebElement address1TxtBox;

	@FindBy(id = "country")
	WebElement countryTxtBox;

	@FindBy(id = "state")
	WebElement stateTxtBox;

	@FindBy(id = "city")
	WebElement cityTxtBox;

	@FindBy(id = "zipcode")
	WebElement zipcodeTxtBox;

	@FindBy(id = "mobile_number")
	WebElement mobileNumberTxtBox;

	@FindBy(xpath = "//button[normalize-space(text()) = 'Create Account']")
	WebElement createAccountBtn;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterRegistrationDetails(String title, String password, String dob, String firstName, String lastName,
			String address1, String country, String state, String city, String zipCode, String mobileNumber)
			throws InterruptedException {

		if (title == "Mr.") {
			mrRadioBtn.click();
		} else {
			mrsRadioBtn.click();
		}

		passwordTxtBox.sendKeys(password);

		firstNameTxtBox.sendKeys(firstName);
		lastNameTxtBox.sendKeys(lastName);
		address1TxtBox.sendKeys(address1);

		Select s = new Select(countryTxtBox);
		s.selectByVisibleText(country);

		stateTxtBox.sendKeys(state);
		cityTxtBox.sendKeys(city);
		zipcodeTxtBox.sendKeys(zipCode);
		mobileNumberTxtBox.sendKeys(mobileNumber);

	}

	public void clickCreateAccountButton() {
		createAccountBtn.click();
	}

	public WebElement getNameElement()
	{
		return (nameTxtBox);
	}
	
	public WebElement getEmailElement()
	{
		return (emailTxtBox);
	}
}
