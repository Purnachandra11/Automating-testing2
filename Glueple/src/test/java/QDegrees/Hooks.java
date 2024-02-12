package QDegrees;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot and attach to report
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
}
        public static void main(String[] args) throws InterruptedException {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            
            // Step 1: Open the login page
            driver.get("https://www.klubba.in/login&register");
            
            // Step 2: Enter invalid email only and click login
            loginWithEmailOnly(driver, "testingqdegreesIOJ@###$IJI");
            
            // Step 3: Enter invalid phone number only and click login
            loginWithPhoneOnly(driver, "999988889999");
            
            // Step 4: Enter password only and click login
            loginWithpassOnly(driver, "Admin@11");
            
            // Step 5: Enter valid email and password and click login
            loginWithCredentials(driver, "testingqdegrees@gmail.com", "Admin@11");
            
            // Step 6: Enter invalid email and password and click login
            loginWithCredentials(driver, "kalidindi@qdegrees.org", "Admin@11");
            
            // Step 7: Enter valid email only and click login
            loginWithEmailOnly(driver, "testingqdegrees@gmail.com");
            
            // Step 8: Enter phone number and password and click login
            loginWithPhoneAndPass(driver, "9640571324", "Admin@11");
            
            // Step 9: Close the browser
            driver.quit();
        }

        private static void loginWithpassOnly(WebDriver driver, String password) throws InterruptedException { 
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("//button[@id='float_left']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("password")).clear();
        }

        private static void loginWithPhoneOnly(WebDriver driver, String phone) throws InterruptedException  {
            driver.findElement(By.id("email")).sendKeys(phone);
            driver.findElement(By.xpath("//button[@id='float_left']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("email")).clear();
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
            driver.findElement(By.id("email")).clear();
        }

        // Method to login with phone number and password
        private static void loginWithPhoneAndPass(WebDriver driver, String phone, String password) throws InterruptedException {
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("email")).sendKeys(phone);
            driver.findElement(By.xpath("//button[@id='float_left']")).click();
            Thread.sleep(2000);
        }

		public void tearDown() {
			//Close the browser
            driver.quit();
		}
}      
  