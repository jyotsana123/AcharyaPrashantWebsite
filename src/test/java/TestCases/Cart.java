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
	String email = "nishu@yopmail.com";
	String password = "nishu123";
	public CartPage cartpage;

	@Test(priority = 0)
	@Description("TC#1 - Verify that user is able to add book in cart, Add to cart is successfull !!")
	public void addToCart() throws InterruptedException {
		loginpage.clickOnLoginLink();
		loginpage.login(email, password);
		Thread.sleep(2000);
		cartpage = new CartPage(driver);
		cartpage.clickOnAPBooks();
		cartpage.addBookToCart(book);
		cartpage.goToCart();
		cartpage.checkAddedIteminCart(book);
	}

	@Test(priority = 1)
	@Description("TC#2 - Verify that user is able to check added book in cart, When the user returns to the website later !!")
	public void checkBookinCartAfterLogin() {

		loginpage.clickOnLoginLink();
		loginpage.login(email, password);
		cartpage = new CartPage(driver);
		cartpage.clickOnCartIcon();
		cartpage.checkBookAvailableinCart(book);
	}

}
