package POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LOGINPAGE {

	WebDriver Webdriver = null;

	public WebElement Username(WebDriver Driver) {
		return Driver.findElement(By.id("user-name"));
	}

	public WebElement Password(WebDriver Driver) {
		return Driver.findElement(By.id("password"));
	}

	public WebElement Loginbutton(WebDriver Driver) {
		return Driver.findElement(By.id("login-button"));
	}
}