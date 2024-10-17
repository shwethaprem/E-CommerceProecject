@all
Feature: Search functionality
Background:
Given User opens the Application

@my
Scenario: Search for a valid product
When User enters valid product "HP" into search field
And User clicks on Search button
Then Valid Product should get displayed in search results

@smoke11
Scenario: Search for a non-existing product
When User enters non-existing product "Honda" into search field
And User clicks on Search button
Then Proper text informing the user about no product matching should be displayed 

@smoke11
Scenario: Search without providing any product
When User dont enter any product into search field
And User clicks on Search button
Then Proper text informing the user about no product matching should be displayed 