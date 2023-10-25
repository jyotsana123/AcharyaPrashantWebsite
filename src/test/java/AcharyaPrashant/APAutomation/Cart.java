package AcharyaPrashant.APAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/img[@src='https://cimg.acharyaprashant.org/images/img-d3830ac7-d31b-4fc2-9d5d-1fe1978a27ec/30/image.jpg']"))));
	    //click on AP Books
		driver.findElement(By.id("main-website-nav-item-internal-books")).click();
		//driver.findElement(By.xpath("//img[contains(@src,'https://cimg.acharyaprashant.org/images/img-2d0a2d03-f39e-4302-aa7b-c088eb715bb8/0/image.jpg')]")).click();
		//driver.findElement(By.xpath("//*[@id=\"svelte\"]/div[1]/div[3]/div[2]/div[2]/div/div[3]/div[1]/div[4]/div[2]/div[1]/button/div/span")).click();
		String book = "10 धोखे जो सब खाते हैं";
		
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

	}

}
