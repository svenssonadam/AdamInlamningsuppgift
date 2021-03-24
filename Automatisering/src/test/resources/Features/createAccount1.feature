Feature: Create account
//Göra om email osv till variablar att använda till sendkeys metod i stepdef
@testfall1
Scenario Outline: Create account - everything goes as expected
Given I have entered <email> + randomInt + <hotmail> into the e-mail slot
And I have also entered <username> + randomInt into the username slot
And I have also entered <password> into the password slot
When I press sign up
Then I continue to <verify> for verification
Examples:
|email|hotmail|username|password    |verify|
|email|hotmail|username|Password123&|Check your email|

@testfall2
Scenario Outline: Create account - long username (more than 100 letters)
Given I have entered <email> + randomInt + <hotmail> in the e-mail slot
And I have also entered <username> into as the username slot
And I have also entered <password> into the password slot
When I press sign up
Then It tells me <verify>
Examples:
|email|hotmail|username                                                                                             |password    |verify|
|email|hotmail|longUsername|Password123&|Enter a value less than 100 characters long|

@testfall3
Scenario Outline: Create account - username already taken
Given I have entered <email> + randomInt + <hotmail> in the e-mail slot
And I have also entered <username> into username slot
And I have also entered <password> into the password slot
When I press sign up
Then It will tell me <verify>
Examples:
|email|hotmail|username|password    |verify|
|email|hotmail|Adam653|Password123&|Another user with this username already exists. Maybe it's your evil twin. Spooky.|

@testfall4
Scenario Outline: Create account - e-mail is missing
Given I have also entered <username> + randomInt into the username slot
And I have also entered <password> into the password slot
When I press sign up
Then It tells me <verify> under the e-mail slot
Examples:
|username|password    |verify|
|username|Password123&|Please enter a value|