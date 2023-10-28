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
import io.qameta.allure.Description;

public class Registration extends BaseTest {

	@Test(dataProvider = "getData")
	@Description("TC#1 - Verify that a registered user can login with valid credentials, Login is Successfull !!")
	public void signupUser(HashMap<String, String> hm) throws InterruptedException {
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
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Acharya Prashant");
	}

	// Provide data for user registration into the above test
	@DataProvider()
	public Object[][] getData() throws IOException // we are providing this data from json file
	{
		List<HashMap<String, String>> data = getJsonDataToMapSignUp(
				System.getProperty("user.dir") + "//src//test//java//Data//signup.json");
		return new Object[][] { { data.get(0) } };
	}

}
