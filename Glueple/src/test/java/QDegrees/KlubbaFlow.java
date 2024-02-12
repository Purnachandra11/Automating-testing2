package QDegrees;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KlubbaFlow {
    
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Step 1: Open the login page
        driver.get("https://www.klubba.in/login&register");
        
        // Step 2: Enter email and password and click login
        loginWithCredentials(driver, "kalidindi@qdegrees.org", "Admin@11");
        
        // Step 3: Enter email only and click login
        loginWithEmailOnly(driver, "kalidindi");
        
        // Step 4: Enter phone number and password and click login
        loginWithPhoneAndPass(driver, "9640571324", "Admin@11");
        
        // Step 5: Close the browser
        driver.quit();
    }

    // Method to login with email and password
    private static void loginWithCredentials(WebDriver driver, String email, String password) throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='float_left']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
    }

    // Method to login with email only
    private static void loginWithEmailOnly(WebDriver driver, String email) throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.xpath("//button[@id='float_left']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("Admin@11");
        driver.findElement(By.xpath("//button[@id='float_left']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("email")).clear();
    }

    // Method to login with phone number and password
    private static void loginWithPhoneAndPass(WebDriver driver, String phone, String password) throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(phone);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='float_left']")).click();
    }
}
