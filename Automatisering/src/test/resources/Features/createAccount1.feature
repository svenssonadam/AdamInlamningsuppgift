Feature: Create account
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
@testfall1
Scenario: Create account - everything goes as expected
Given I have entered "email" + randomInt + "@hotmail.com" into the e-mail slot
And I have also entered "username" + randomInt into the username slot
And I have also entered "Password123*" into the password slot
When I press sign up
Then I continue to the next page that tells me to check my e-mail for verification

@testfall2
Scenario: Create account - long username (more than 100 letters)
Given I have entered "email" + randomInt + "@hotmail.com" in the e-mail slot
And I have also entered "lundbackaalundbackaalundbackaalundbackaalundbackaalundbackaalundbackaalundbackaalundbackaalundbackaa" into as the username slot
And I have also entered "Password123*" into the password slot
When I press sign up
Then It tells me "Enter a value less than 100 characters long" 

@testfall3
Scenario: Create account - username already taken
Given I have entered "username" + randomInt + "@hotmail.com" in the e-mail slot
And I have also entered "Adam653" into username slot
And I have also entered "Password123*" into the password slot
When I press sign up
Then It will tell me "Another user with this username already exists. Maybe it's your evil twin. Spooky." 

@testfall4
Scenario: Create account - e-mail is missing
Given I have also entered "username" + randomInt into the username slot
And I have also entered "Password123*" into the password slot
When I press sign up
Then It tells me "Please enter a value" under the e-mail slot