package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.RegistrationPage;
import TestComponent.BaseTest;

public class Registration extends BaseTest {

//	public LoginPage loginpage;
//	public RegistrationPage rp;

	@Test(dataProvider = "getData")
	public void signupUser(HashMap<String, String> hm) {
		LoginPage loginpage = new LoginPage(driver);
		// Registration process
		loginpage.clickOnLoginLink();
		loginpage.clickOnSignupLink();
		RegistrationPage rp = new RegistrationPage(driver);
		rp.signup(hm.get("name"), hm.get("email"), hm.get("password"), hm.get("cnfpassword"));
		// Logout
		loginpage.logout();
		// Login
		loginpage.login(hm.get("email"), hm.get("password"));
		// Verify that after login, the user is redirected to the same page from where
		// he clicked on Login.
		Assert.assertEquals(driver.getCurrentUrl(), "https://acharyaprashant.org/");
	}

	//Provide data for user registration into the above test
	@DataProvider()
	public Object[][] getData() throws IOException // we are providing this data from json file
	{
		List<HashMap<String, String>> data = getJsonDataToMapSignUp(
				System.getProperty("user.dir") + "//src//test//java//Data//signup.json");
		return new Object[][] { { data.get(0) } };
	}

}
