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

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "main-website-nav-item-internal-books")
	WebElement APBooks;

	@FindBy(css = "div[class='px-1'] div[class='mb-3 font-semibold'] span[class='font-en svelte-t3mcl']")
	WebElement addToCartButton;

	By addToCartBtn = By
			.cssSelector("div[class='px-1'] div[class='mb-3 font-semibold'] span[class='font-en svelte-t3mcl']");

	By proceedPaymentButton = By.id("main-website-cart-proceed-btn");

	@FindBy(xpath = "(//span[@class='font-en svelte-t3mcl'][normalize-space()='GO TO CART'])[2]")
	WebElement goToCartButton;

	@FindBy(css = ".flex.items-center.pr-1")
	WebElement cartIcon;

	@FindBy(css = ".items-start.pl-2")
	List<WebElement> booksList;

	@FindBy(css = ".flex.w-full.flex-col.items-start")
	List<WebElement> listOfBooksInCart;

	public void clickOnAPBooks() {
		APBooks.click();
	}

	public void addBookToCart(String book) {
		for (int i = 0; i < booksList.size(); i++) {
			String array = booksList.get(i).getText();
			System.out.println(array);
			if (array.contains(book)) {
				booksList.get(i).click();
				System.out.println(book);
				break;
			}
		}
		// waiting for add to cart appear on the page
		waitForElementToAppear(addToCartBtn);

		// add book to cart
		addToCartButton.click();
	}

	public void goToCart() {
		// Go to cart page
		goToCartButton.click();
	}

	public void checkAddedIteminCart(String book) {
		for (int i = 0; i < listOfBooksInCart.size(); i++) {
			String cartArray = listOfBooksInCart.get(i).getText();
			System.out.println(cartArray);
			if (cartArray.contains(book)) {
				System.out.println(book + " book is available in cart");
				break;
			}
		}
	}

	public void clickOnCartIcon() {
		cartIcon.click();
	}

	public void checkBookAvailableinCart(String book) {
		waitForElementToAppear(proceedPaymentButton);
		for (int i = 0; i < listOfBooksInCart.size(); i++) {
			String cartArray = listOfBooksInCart.get(i).getText();
			System.out.println(cartArray);
			if (cartArray.contains(book)) {
				System.out.println(book + " book is still available in cart after login");
				break;
			} else {
				System.out.println(book + " book is not available in cart");
			}
		}
	}

}
