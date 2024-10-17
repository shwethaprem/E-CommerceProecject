@checkout1
Feature: Login functionality 

Background:
Given User navigates to Login page 

@login @smoke
Scenario Outline: Login with valid credential
When User enters the valid email address <email>
And Enter the valid password <password>
And Clicks on Login button
Then User should logged in successfully
Examples:
|email                    |password|
|shwethapatil106@gmail.com|Shwetha@123|
|vprem4u@gmail.com        |12345|
|shwethasini.htcorps111@gmail.com|45678|

@login @smoke
Scenario: Login with invalid credential
When User enters the invalid email address
And Enter invalid password "546789"
And Clicks on Login button
Then User should get a proper warning message

@login @smoke
Scenario: Login with valid email address and invalid password
When User enters the valid email address "shwethasini.htcorps111@gmail.com"
And Enter invalid password "546729"
And Clicks on Login button
Then User should get a proper warning message

@smoke @login
Scenario: Login with invalid email address and valid password
When User enters the invalid email address
And Enter the valid password "Shwetha@123"
And Clicks on Login button
Then User should get a proper warning message

@smoke @login
Scenario: Login without providing any credentials
When User dont enter email address into email field
And User dont enter password into password field
And Clicks on Login button
Then User should get a proper warning message