@checkout1 
Feature: User Registration

Background:
Given User navigate to Register Account page 

@smoke
Scenario: Register with mandatory fields
When User enters below details into the fields
|firstname    | Shwetha |
|lastname     | Vannala|
|telephone    |12432536|
|password     |214225|
|confirmpassword | 214225 |
And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created

@smoke
Scenario: Register with all fields
When User enters below details into the fields
|firstname    | Shwetha |
|lastname     | Vannala|
|telephone    |124325536|
|password     |2140252|
|confirmpassword | 2140252 |
And Selects Yes for Newsletter
And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created


Scenario: Register without providing any fields
When User dont enter details into any fields
And Clicks on Continue button
Then Warning message should be displayed for all the mandatory fields


Scenario: Register with duplicate email address
When User enters below details into the fields with duplicate email
|firstname    | Shwetha |
|lastname     | Vannala|
|email        |shwetha.htcorps12@gmail.com|
|telephone    |12432576|
|password     |214005|
|confirmpassword | 214005 |
And Selects Yes for Newsletter
And Selects Privacy Policy field
And Clicks on Continue button
Then Warning message informating the user about duplicate email should be displayed

