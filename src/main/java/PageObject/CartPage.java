package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//click on AP Books
			//driver.findElement(By.id("main-website-nav-item-internal-books")).click();
	
	@FindBy(id="main-website-nav-item-internal-books")
	WebElement APBooks;
	
	@FindBy(css="div[class='px-1'] div[class='mb-3 font-semibold'] span[class='font-en svelte-t3mcl']")
	WebElement addToCartButton;
	
	By addToCartBtn = By.cssSelector("div[class='px-1'] div[class='mb-3 font-semibold'] span[class='font-en svelte-t3mcl']");
	
	By proceedPaymentButton = By.id("main-website-cart-proceed-btn");
	
	@FindBy(xpath="(//span[@class='font-en svelte-t3mcl'][normalize-space()='GO TO CART'])[2]")
	WebElement goToCartButton;
	
	@FindBy(css=".flex.items-center.pr-1")
	WebElement cartIcon;
	
	public void clickOnAPBooks()
	{
		APBooks.click();
	}
	
	public void addBookToCart(String book)
	{
		//String book = "10 धोखे जो सब खाते हैं";
		//String book = "आत्मा + अष्टावक्र गीता";
		
		List<WebElement> books = driver.findElements(By.cssSelector(".items-start.pl-2"));
		for (int i = 0; i < books.size(); i++) 
		{
			String array = books.get(i).getText();
			System.out.println(array);
			if(array.contains(book))
			{
				driver.findElements(By.cssSelector(".items-start.pl-2")).get(i).click();
				System.out.println(book);
				break;
			}
		}
		//waiting for add to cart appear on the page
		waitForElementToAppear(addToCartBtn);
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='px-1'] div[class='mb-3 font-semibold'] span[class='font-en svelte-t3mcl']"))));
		
		//add book to cart
		addToCartButton.click();
		//driver.findElement(By.cssSelector("div[class='px-1'] div[class='mb-3 font-semibold'] span[class='font-en svelte-t3mcl']")).click();
	}
	
	
	public void goToCart()
	{
		//Go to cart page
		goToCartButton.click();
		//driver.findElement(By.xpath("(//span[@class='font-en svelte-t3mcl'][normalize-space()='GO TO CART'])[2]")).click();

	}
	
	public void checkAddedIteminCart(String book)
	{
		//Check items showing in cart
				List<WebElement>cartBooks = driver.findElements(By.cssSelector(".flex.w-full.flex-col.items-start"));
				for (int i = 0; i < cartBooks.size(); i++) 
				{
					String cartArray = cartBooks.get(i).getText();
					System.out.println(cartArray);
					if(cartArray.contains(book))
					{
						System.out.println(book + " book is available in cart");
						break;
					}
				}
	}
	
	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
	
	public void checkBookAvailableinCart(String book)
	{
		waitForElementToAppear(proceedPaymentButton);
		List<WebElement>cartBooksAfterLogin = driver.findElements(By.cssSelector(".flex.w-full.flex-col.items-start"));
		for (int i = 0; i < cartBooksAfterLogin.size(); i++) 
		{
			String cartArray = cartBooksAfterLogin.get(i).getText();
			System.out.println(cartArray);
			if(cartArray.contains(book))
			{
				System.out.println(book + " book is still available in cart after login");
				break;
			}
			else
			{
				System.out.println(book + " book is not available in cart");
			}
		}
	}

}
