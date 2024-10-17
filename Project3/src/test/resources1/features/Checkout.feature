
Feature: Checkout functionality

Background:
Given Open the Application

@checkout
Scenario: Search for a product
When Enter valid product "HP" into search field
And Click on Search button
Then Product should get displayed in search results

@checkout
Scenario: Add the product to cart
When Click on the Add to cart button
Then Verify specification page get displayed 

@checkout
Scenario: Product is successfully added to the cart
When Click on the Add to cart button on specification page
Then Check valid message is displayed after adding to the cart 

@checkout
Scenario: Checkout page display
When Click on the Checkout link
Then Verify Checkout page gets displayed succesfully

@checkout1
Scenario: Search the product and add to cart and checkout
When Enter valid product "HP" into search field
And Click on Search button
When Click on the Add to cart button
When Click on the Add to cart button on specification page
When Click on the Checkout link
When User select on Guest Checkout in Step1:Checkout Options
And  Click on continue button
And   Step2:Billing details section pop ups and User enters below details into the fields
|firstname    | Shwetha |
|lastname     | Vannala|
|email        | Vannala@gmail.com|
|telephone    | 12432536|
|address1     | 214225,JPNagar|
|city         | Banagalore |
|postcode     | 560078 |
|country      | India |
|region/state | Karnataka |

And  Select on checkbox and click on continue button
And  Step4:Delivery Method section pop ups and Click on continue button
And  Step5: Payment Method section pop ups and Click on Terms and Condition Checkbox
And  Click on payment method continue button
And  Step6:Confirm Order section pop ups and Click on confirm order button
Then Successfull message should be displayed


 