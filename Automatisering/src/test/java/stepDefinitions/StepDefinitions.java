package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
			driver = creator.createBrowser("chrome");
		    driver.get("https://login.mailchimp.com/signup/");
		    driver.manage().window().maximize();
		    Thread.sleep(2000);
		    driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		    Thread.onSpinWait();
		}
		@Given("I have entered {string} + randomInt + {string} into the e-mail slot")
		public void i_have_entered_random_int_into_the_e_mail_slot(String string, String string2) {
			
			sendKeys(driver, By.id("email"), string + randomInt + string2);			
		}
		@Given("I have also entered {string} + randomInt into the username slot")
		public void i_have_also_entered_random_int_into_the_username_slot(String string) {
			
			sendKeys(driver, By.id("new_username"), string + randomInt);
		}
		@Given("I have also entered {string} into the password slot")
		public void i_have_also_entered_into_the_password_slot(String string) {
			
			sendKeys(driver, By.id("new_password"), string);		
		}
			@Given("I have entered {string} + randomInt + {string} in the e-mail slot")
			public void i_have_entered_random_int_in_the_e_mail_slot(String string, String string2) {
				
				sendKeys(driver, By.id("email"), string + randomInt + string2);				
		}
			@Given("I have also entered {string} into as the username slot")
			public void i_have_also_entered__into_as_the_username_slot(String string) {
				
				sendKeys(driver, By.id("new_username"), repeated); 			    
			}
				@Given("I have also entered {string} into username slot")
				public void i_have_also_entered_into_username_slot(String string) {
					
					sendKeys(driver, By.id("new_username"), string);		    
			}
			
		@When("I press sign up")
		public void i_press_sign_up() {
			
		    click(driver, By.id("create-account"));
		}
		@Then("I continue to {string} for verification")
		public void i_continue_to_verification(String string) throws InterruptedException {
			WebElement checkEmail = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3"));
			assertEquals(string, checkEmail.getText());
			Thread.sleep(1000);
			driver.close();
		}
			@Then("It tells me {string}")
			public void it_tells_me(String string) throws InterruptedException {
				WebElement hundred = driver.findElement(By.className("invalid-error"));
				assertEquals(string, hundred.getText());
				Thread.sleep(1000);
				driver.close();
		}
				@Then("It will tell me {string}")
				public void it_will_tell_me(String string) throws InterruptedException {
				WebElement username = driver.findElement(By.className("invalid-error"));
				assertEquals(string, username.getText());
				Thread.sleep(1000);
				driver.close();
			}
					@Then("It tells me {string} under the e-mail slot")
					public void it_tells_me_under_the_e_mail_slot(String string) throws InterruptedException {
						WebElement value = driver.findElement(By.className("invalid-error"));
						assertEquals(string, value.getText());
						Thread.sleep(1000);
						driver.close();
					}
					public void click(WebDriver driver, By by) {
						(new WebDriverWait(driver,10)).until(ExpectedConditions.
					
								elementToBeClickable(by));
								driver.findElement(by).click();
						}
						public void sendKeys(WebDriver driver, By by, String keys) {
							(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(by));
							
								driver.findElement(by).sendKeys(keys);

				}
}