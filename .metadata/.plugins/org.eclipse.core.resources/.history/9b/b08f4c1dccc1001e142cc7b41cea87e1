package Ecommerce.Application;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement SearchBox=driver.findElement(By.name("q"));
		SearchBox.sendKeys("iphone 15 pro");
		SearchBox.submit();
		
		String mainpage = driver.getWindowHandle();
		System.out.print("main page="+ mainpage);
		driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 15 Pro (Natural Titanium, 128 GB)']")).click();
		
		Set<String> allpages = driver.getWindowHandles();
		for(String page : allpages) {
			if(!page.equals(mainpage)) {
				driver.switchTo().window(page);
				break;
			}	
		}	
		System.out.print(driver.getCurrentUrl());
		List<WebElement> products= driver.findElements(By.className("_21Ahn-"));
		System.out.print(products.getFirst());
		for(WebElement product: products) {
			System.out.print(product.getText());
		}
	driver.findElement(By.xpath("//button[normalize-space()='Buy Now']")).click();
	}
}
