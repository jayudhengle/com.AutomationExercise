package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider
	public Object[][] registrationData() {

		String title = "Mrs.";
		String password = "Password";
		String dob = "30 April 1987";
		String firstName = "FirstName";
		String lastName = "LastName";
		String address1 = "Address1";
		String country = "India";
		String state = "Maharashtra";
		String city = "Pune";
		String zipCode = "411012";
		String mobileNumber = "8765432101";

		return new Object[][] {
				{ title, password, dob, firstName, lastName, address1, country, state, city, zipCode, mobileNumber } };

	}

}
