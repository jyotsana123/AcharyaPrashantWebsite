package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.LoginPage;
import TestComponent.BaseTest;
import io.qameta.allure.Description;

public class Cart extends BaseTest {
	
	
	String book = "आत्मा + अष्टावक्र गीता";
	//public LoginPage loginpage;
	public CartPage cartpage;
	
  //  @Test()
	public void addToCart() throws InterruptedException
	{
		//Login
		//loginpage = new LoginPage(driver);
		loginpage.clickOnLoginLink();
		loginpage.login("nishu@yopmail.com", "nishu123");
		//loginpage.waitingForPageAfterLogin();
		cartpage = new CartPage(driver);
		cartpage.clickOnAPBooks();
		cartpage.addBookToCart(book);
		cartpage.goToCart();
		cartpage.checkAddedIteminCart(book);
	}
    
	
    @Test
    public void checkBookinCartAfterLogin()
    {
    	//loginpage = new LoginPage(driver);
    	loginpage.clickOnLoginLink();
    	loginpage.login("nishu@yopmail.com", "nishu123");
//    	driver.findElement(By.xpath("//input[contains(@id,'input-username')]")).sendKeys("nishu@yopmail.com");
//    	driver.findElement(By.id("password")).sendKeys("nishu123");
//		driver.findElement(By.xpath("//button[contains(@id,'sign-in-btn')]")).click();
	//	driver.findElement(By.cssSelector(".flex.items-center.pr-1")).click();
    	cartpage = new CartPage(driver);
    	cartpage.clickOnCartIcon();
    	cartpage.checkBookAvailableinCart(book);
//		List<WebElement>cartBooksAfterLogin = driver.findElements(By.cssSelector(".flex.w-full.flex-col.items-start"));
//		for (int i = 0; i < cartBooksAfterLogin.size(); i++) 
//		{
//			String cartArray = cartBooksAfterLogin.get(i).getText();
//			System.out.println(cartArray);
//			if(cartArray.contains(book))
//			{
//				System.out.println(book + " book is still available in cart after login");
//				break;
//			}
//		}
    }
	
	
	
	

	
	
	
	

}
