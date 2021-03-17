package stepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
		private WebDriver driver;
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		
		@Before
		public void openBrowser() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Svens\\OneDrive\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		    driver.get("https://login.mailchimp.com/signup/");
		    driver.manage().window().maximize();
		    Thread.sleep(2000);
		    driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		    Thread.onSpinWait();
		    
		}
		@Given("I have entered {string} + randomInt + {string} into the e-mail slot")
		public void i_have_entered_random_int_into_the_e_mail_slot(String string, String string2) {
		    WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("email" + randomInt + "@hotmail.com");
		}

		@Given("I have also entered {string} + randomInt into the username slot")
		public void i_have_also_entered_random_int_into_the_username_slot(String string) {
		    WebElement username = driver.findElement(By.id("new_username"));
			username.sendKeys("username" + randomInt);
		}
		@Given("I have also entered {string} into the password slot")
		public void i_have_also_entered_into_the_password_slot(String string) {
			WebElement password = driver.findElement(By.id("new_password"));
			password.sendKeys("Password123*");
		}
			@Given("I have entered {string} + randomInt + {string} in the e-mail slot")
			public void i_have_entered_random_int_in_the_e_mail_slot(String string, String string2) {
		    WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("email" + randomInt + "@hotmail.com");
		}
			@Given("I have also entered {string} into as the username slot")
			public void i_have_also_entered_into_as_the_username_slot(String string) {
			    WebElement username = driver.findElement(By.id("new_username"));
			    username.sendKeys("usernameeeusernameeeusernameeeusernameeeusernameeeusernameeeusernameeeusernameeeusernameeeusernameeee");			    
			}
				@Given("I have also entered {string} into username slot")
				public void i_have_also_entered_into_username_slot(String string) {
			    WebElement username = driver.findElement(By.id("new_username"));
			    username.sendKeys("Adam653");
				}
		
		

		@When("I press sign up")
		public void i_press_sign_up() {
		    WebElement signUp = driver.findElement(By.id("create-account"));
		    signUp.submit();
		    }
		@Then("I continue to the next page that tells me to check my e-mail for verification")
		public void i_continue_to_the_next_page_that_tells_me_to_check_my_e_mail_for_verification() throws InterruptedException {			
		  Thread.sleep(1000);
		  driver.close();
		}
			@Then("It tells me {string}")
			public void it_tells_me(String string) throws InterruptedException {
		    driver.findElement(By.className("invalid-error"));
		    Thread.sleep(1000);
		    driver.close();
			}
				@Then("It will tell me {string}")
				public void it_will_tell_me(String string) throws InterruptedException {
				driver.findElement(By.className("invalid-error"));
				Thread.sleep(1000);
				driver.close();
				}

					@Then("It tells me {string} under the e-mail slot")
					public void it_tells_me_under_the_e_mail_slot(String string) throws InterruptedException {
					driver.findElement(By.className("invalid-error"));
					Thread.sleep(1000);
					driver.close();
					}
}