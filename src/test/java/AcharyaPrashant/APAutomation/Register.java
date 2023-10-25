package AcharyaPrashant.APAutomation;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://acharyaprashant.org/");
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//div/span[text()='Login']")).click();
		driver.findElement(By.id("main-website-sign-up-btn")).click();
		driver.findElement(By.xpath("//input[contains(@id,'name-field')]")).sendKeys("nishu");
		driver.findElement(By.xpath("//input[contains(@id,'email-field')]")).sendKeys("nishu@yopmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'password-field')]")).sendKeys("nishu123");
		driver.findElement(By.xpath("//input[contains(@id,'confirm-password-field')]")).sendKeys("nishu123");
		Thread.sleep(2000);
		input("Please solve the CAPTCHA and press Enter to continue...");
		driver.findElement(By.xpath("//button[contains(@id,'submit-button')]")).click();
		
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//div/span[text()='Login']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'input-username')]")).sendKeys("nishu@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("nishu123");
		driver.findElement(By.xpath("//button[contains(@id,'sign-in-btn')]")).click();

		
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
