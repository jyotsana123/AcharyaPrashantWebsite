package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import TestComponent.BaseTest;
import io.qameta.allure.Description;

public class Logout extends BaseTest {

	public LoginPage loginpage;

	@Test
	@Description("TC#1 - Verify that user is logout successfully, And after logout redirected on Login page !!")
	public void logout() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.login("nishu@yopmail.com", "nishu123");
		loginpage.logout();
		// Verify that the user is redirected to the login page after logging out
		Assert.assertEquals(driver.getTitle(), "Login");
	}
}
