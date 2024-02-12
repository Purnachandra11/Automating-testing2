package QDegrees;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KlubbaLogin1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.klubba.in/login&register");
		driver.findElement(By.id("email")).sendKeys("kalidindi@qdegrees.org");
		driver.findElement(By.id("password")).sendKeys("Admin@11");
		driver.findElement(By.xpath("//button[@id='float_left']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("kalidindi@qdegrees.org");
		driver.findElement(By.xpath("//button[@id='float_left']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Admin@11");
		driver.findElement(By.xpath("//button[@id='float_left']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("9640571324");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Admin@11");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='float_left']")).click();
		
	}
}