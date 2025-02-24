package QDegrees;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import java.util.concurrent.TimeUnit;

	public class Report {	
	    private static WebDriver driver;
		@SuppressWarnings("deprecation")
		@Before
	    public void setUp() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    @After
	    public void tearDown(Scenario scenario) {
	        if (scenario.isFailed()) {
	            // Take screenshot and embed in the report
	            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "screenshot");
	        }
	        driver.quit();
	    }

	    public static void main(String[] args) throws InterruptedException {
	        Hooks hooks = new Hooks();
	        hooks.setUp();

	        // Step 1: Open the login page
	        driver.get("https://www.klubba.in/login&register");
	        
	        // Step 2: Enter invalid email only and click login
	        loginWithEmailOnly(driver, "testingqdegreesIOJ@###$IJI");
	        
	        // Step 3: Enter invalid phone number only and click login
	        loginWithEmailOnly(driver, "999988889999");
	        
	        // Step 4: Enter password only and click login
	        loginWithEmailOnly(driver, "Admin@11");
	        
	        // Step 5: Enter valid email and password and click login
	        loginWithCredentials(driver, "testingqdegrees@gmail.com", "Admin@11");
	        
	        // Step 6: Enter invalid email and password and click login
	        loginWithCredentials(driver, "kalidindi@qdegrees.org", "Admin@11");
	        
	        // Step 7: Enter valid email only and click login
	        loginWithEmailOnly(driver, "testingqdegrees@gmail.com");
	        
	        // Step 8: Enter phone number and password and click login
	        loginWithPhoneAndPass(driver, "9640571324", "Admin@11");
	        
	        // Step 9: Close the browser
	        hooks.tearDown();
	    }

		private static void loginWithPhoneAndPass(WebDriver driver2, String phone, String password) throws InterruptedException {
			        driver.findElement(By.id("email")).clear();
		            driver.findElement(By.id("password")).sendKeys(password);
		            driver.findElement(By.id("email")).sendKeys(phone);
		            driver.findElement(By.xpath("//button[@id='float_left']")).click();
		            Thread.sleep(2000);
			
		}

		private static void loginWithCredentials(WebDriver driver2, String email, String password) throws InterruptedException {
			driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("//button[@id='float_left']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("password")).clear();
		}

		private static void loginWithEmailOnly(WebDriver driver2, String email) throws InterruptedException {
			driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.xpath("//button[@id='float_left']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("email")).clear();
        }
		 // Rest of the login methods remain the same
		}

	   
	
