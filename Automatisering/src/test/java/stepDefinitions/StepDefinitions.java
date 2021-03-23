package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitions {
		private WebDriver driver;
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(10000);
		String longUsername = "username";
		String repeated = longUsername.repeat(13);
		
		@Before
		public void openBrowser() throws InterruptedException {
			DriveCreator creator = new DriveCreator();
			driver = creator.createBrowser("firefox");
		    driver.get("https://login.mailchimp.com/signup/");
		    driver.manage().window().maximize();
		    Thread.sleep(2000);
		    driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		    Thread.onSpinWait();
		}
		@Given("I have entered email + randomInt + hotmail into the e-mail slot")
		public void i_have_entered_email_random_int_hotmail_into_the_e_mail_slot() {
			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("email" + randomInt + "@hotmail.com");
		}
		@Given("I have also entered username + randomInt into the username slot")
		public void i_have_also_entered_username_random_int_into_the_username_slot() {
			WebElement username = driver.findElement(By.id("new_username"));
			username.sendKeys("username" + randomInt);
		}
		@Given("I have also entered Password123& into the password slot")
		public void i_have_also_entered_password123_into_the_password_slot() {
			WebElement password = driver.findElement(By.id("new_password"));
			password.sendKeys("Password123*");
		}
			@Given("I have entered email + randomInt + hotmail in the e-mail slot")
			public void i_have_entered_email_random_int_hotmail_in_the_e_mail_slot() {
				WebElement email = driver.findElement(By.id("email"));
				email.sendKeys("email" + randomInt + "@hotmail.com");
		}
			@Given("I have also entered longUsername into as the username slot")
			public void i_have_also_entered_longUsername_into_as_the_username_slot() {
				WebElement username = driver.findElement(By.id("new_username"));
			    username.sendKeys(repeated);			    
			}
				@Given("I have also entered Adam653 into username slot")
				public void i_have_also_entered_adam653_into_username_slot() {
					WebElement username = driver.findElement(By.id("new_username"));
				    username.sendKeys("Adam653");
			}
			
		@When("I press sign up")
		public void i_press_sign_up() {
			//WebElement signUp = driver.findElement(By.id("create-account"));
		    //signUp.submit();
		    click(driver, By.id("create-account"));
		}
		@Then("I continue to Check your email for verification")
		public void i_continue_to_check_your_email_for_verification() throws InterruptedException {
			WebElement checkEmail = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3"));
			assertEquals("Check your email", checkEmail.getText());
			Thread.sleep(1000);
			driver.close();
			///html/body/div[1]/div/div[1]/div[2]/main/div/div/div/div/div/div/div/h1
		}
			@Then("It tells me Enter a value less than {int} characters long")
			public void it_tells_me_enter_a_value_less_than_characters_long(Integer int1) throws InterruptedException {
				WebElement hundred = driver.findElement(By.className("invalid-error"));
				assertEquals("Enter a value less than 100 characters long", hundred.getText());
				Thread.sleep(1000);
				driver.close();
		}
				@Then("It will tell me Another user with this username already exists. Maybe it's your evil twin. Spooky.")
				public void it_will_tell_me_another_user_with_this_username_already_exists_maybe_it_s_your_evil_twin_spooky() throws InterruptedException {
				WebElement username = driver.findElement(By.className("invalid-error"));
				assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.", username.getText());
				Thread.sleep(1000);
				driver.close();
			}
					@Then("It tells me Please enter a value under the e-mail slot")
					public void it_tells_me_please_enter_a_value_under_the_e_mail_slot() throws InterruptedException {
						WebElement value = driver.findElement(By.className("invalid-error"));
						assertEquals("Please enter a value", value.getText());
						Thread.sleep(1000);
						driver.close();
					}
					
					
	public void click(WebDriver driver, By by) {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.
				
				elementToBeClickable(by));
				driver.findElement(by).click();
	}
}