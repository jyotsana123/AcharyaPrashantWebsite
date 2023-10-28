package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import TestComponent.BaseTest;
import io.qameta.allure.Description;

public class Login extends BaseTest {

	public LoginPage loginpage;

	@Test(priority = 0)
	@Description("TC#1 - Verify that without email and password, Login is not successfull !!")
	public void loginWithoutCreds() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.login(" ", " ");
		Assert.assertEquals(loginpage.loginError(), "Login Failed! Please enter correct email and password");
	}

	@Test(priority = 1)
	@Description("TC#2 - Verify that with invalid email and invalid password, Login is not successfull !!")
	public void loginWithInvalidCreds() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.login("nishu@yopmail.co", "nishu12");
		Assert.assertEquals(loginpage.loginError(), "Login Failed! Please enter correct email and password");
	}

	@Test(priority = 2)
	@Description("TC#3 - Verify that with invalid email and valid password, Login is not successfull !!")
	public void loginWithInvalidEmail() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.login("nishu@yopmail.co", "nishu123");
		Assert.assertEquals(loginpage.loginError(), "Login Failed! Please enter correct email and password");
	}

	@Test(priority = 3)
	@Description("TC#4 - Verify that with valid email and invalid password, Login is not successfull !!")
	public void loginWithInvalidPassword() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.login("nishu@yopmail.com", "nishu12");
		Assert.assertEquals(loginpage.loginError(), "Login Failed! Please enter correct email and password");
	}

	@Test(priority = 4)
	@Description("TC#5 - Verify that with valid email and valid password, Login is successfull !!")
	public void loginWithValidCreds() throws InterruptedException {
		// Get page title after landing on Website OR before login
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		// Login
		loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.login("nishu@yopmail.com", "nishu123");
		/* Verify that after login, the user is redirected to the same page from where
		 he clicked on Login. */
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), pageTitle);
	}

}
