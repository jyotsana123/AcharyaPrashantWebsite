package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Menu']")
	WebElement menu;
	
	@FindBy(xpath="//div/span[text()='Login']")
	WebElement loginLink;
	
	@FindBy(id="main-website-sign-up-btn")
	WebElement signupLink;
	
	@FindBy(xpath="//input[contains(@id,'input-username')]")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(@id,'sign-in-btn')]")
	WebElement signInButton;
	
	@FindBy(xpath="//a[contains(@id,'logout-btn')]")
	WebElement logoutLink;
	
	@FindBy(xpath="//p[contains(@id,'login-failed-text')]")
	WebElement loginFailedText;
	
	By pageAfterLogin = By.xpath("//div/img[@src='https://cimg.acharyaprashant.org/images/img-d3830ac7-d31b-4fc2-9d5d-1fe1978a27ec/30/image.jpg']");

	public void clickOnLoginLink()
	{
		waitForElementToAppear(pageAfterLogin);
		menu.click();
		loginLink.click();
	}
	
	public void clickOnSignupLink()
	{
		signupLink.click();
	}
	
	public void login(String Email, String Password)
	{
		email.sendKeys(Email);
		password.sendKeys(Password);
		signInButton.click();
		waitForElementToAppear(pageAfterLogin);
	}
	
	public void goTo()
	{
		driver.get("https://acharyaprashant.org/");
	}
	
	public void logout()
	{
		menu.click();
		logoutLink.click();
	}
	
	public String loginError()
	{
		System.out.println(loginFailedText.getText());
		return loginFailedText.getText();
	}
	
//	public void waitingForPageAfterLogin()
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/img[@src='https://cimg.acharyaprashant.org/images/img-d3830ac7-d31b-4fc2-9d5d-1fe1978a27ec/30/image.jpg']"))));
//	}
	
	
}