package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMS.LOGINPAGE;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testset1 {
	WebDriver DRIVER=null;
	@Given("Open the browser and launch the URL")
	public void open_the_browser_and_launch_the_url() {
		WebDriverManager.chromedriver().setup();
		DRIVER=new ChromeDriver();
		DRIVER.manage().window().maximize();
		DRIVER.get("https://www.saucedemo.com/");
	    System.out.println("Open the browser and launch the URL");
	}

	@When("Enter valid UserID and Password")
	public void enter_valid_user_id_and_password() throws Throwable {
		LOGINPAGE loginpage = new LOGINPAGE();
		loginpage.Username(DRIVER).sendKeys("standard_user");
		loginpage.Password(DRIVER).sendKeys("secret_sauce");
		loginpage.Loginbutton(DRIVER).click();
		Thread.sleep(5000);
		System.out.println("Enter valid UserID and Password");
	}
	
	@When("Enter invalid UserID and Password")
	public void enter_invalid_user_id_and_password() throws Throwable {
		Thread.sleep(3000);
		System.out.println("Enter invalid UserID and Password");
	}

	@Then("Verify the Saucedemo.com home page")
	public void verify_the_saucedemo_com_home_page() {
		DRIVER.close();
		System.out.println("Verify the Saucedemo.com home page");
	}
}