package AcharyaPrashant.APAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://acharyaprashant.org/");
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//div/span[text()='Login']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'input-username')]")).sendKeys("nishu@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("nishu123");
		driver.findElement(By.xpath("//button[contains(@id,'sign-in-btn')]")).click();
		
		//logout
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//a[@id='main-website-logout-btn']")).click();
		//Assert.assertEquals("login", driver.getCurrentUrl().contains("login"));
		Assert.assertEquals(driver.getTitle(), "Login");
	}

}
