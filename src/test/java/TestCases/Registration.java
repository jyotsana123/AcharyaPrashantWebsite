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
	
	public LoginPage loginpage;
	public RegistrationPage rp;
	
	@Test(dataProvider = "getData")
	//public void signupUser()
	public void signupUser(HashMap<String, String> hm)
	{
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.clickOnSignupLink();
		rp = new RegistrationPage(driver);
		rp.signup(hm.get("name"), hm.get("email"), hm.get("password"), hm.get("cnfpassword"));
		loginpage.logout();
		loginpage.login(hm.get("email"), hm.get("password"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://acharyaprashant.org/");
		
	}
	
	
	
	
	@DataProvider()
	public Object[][] getData() throws IOException    //we are providing this data from json file
	{
		List<HashMap<String, String>> data = getJsonDataToMapSignUp(System.getProperty("user.dir")+"//src//test//java//Data//signup.json");
		return new Object[][] {{data.get(0)}};
	}

}
