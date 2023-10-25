package PageObject;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[contains(@id,'name-field')]")
	WebElement nameField;
	
	@FindBy(xpath="//input[contains(@id,'email-field')]")
	WebElement emailField;
	
	@FindBy(xpath="//input[contains(@id,'password-field')]")
	WebElement passwordField;
	
	@FindBy(xpath="//input[contains(@id,'confirm-password-field')]")
	WebElement cnfPasswordField;
	
	@FindBy(xpath="//button[contains(@id,'submit-button')]")
	WebElement submitButton;
	
	@FindBy(xpath="//span[text()='Menu']")
	WebElement menu;
	
	

	
	public void signup(String Name, String Email, String Password, String CnfPassword)
	{
		nameField.sendKeys(Name);
		emailField.sendKeys(Email);
		passwordField.sendKeys(Password);
		cnfPasswordField.sendKeys(CnfPassword);
		input("Please solve the CAPTCHA and press Enter to continue...");
		submitButton.click();
	}
	
	private static void input(String string) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Press Enter to continue...");
        
        // Wait for the user to press Enter
        scanner.nextLine();
        
        System.out.println("You pressed Enter. Program continues.");
        
        // Close the scanner when you're done
        scanner.close();
		
	}

}
