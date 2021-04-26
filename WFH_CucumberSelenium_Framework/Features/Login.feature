@All
Feature: Login

@sanity @smoke
Scenario: Verify the login
   
Given User launch chrome browser 
When user open url "https://admin-demo.nopcommerce.com/login" 
And user enter email as "admin@yourstore.com" and password as "admin" 
And user clicks on login button
Then user will land on nopcommerce homescreen and title should be "Dashboard / nopCommerce administration"
When user clicks on logout button
Then title should be "Your store. Login"  
And close the browser

@regression
Scenario Outline: Verify the login using data
   
Given User launch chrome browser 
When user open url "https://admin-demo.nopcommerce.com/login" 
And user enter email as "<email>" and password as "<password>" 
And user clicks on login button
Then user will land on nopcommerce homescreen and title should be "Dashboard / nopCommerce administration"
When user clicks on logout button
Then title should be "Your store. Login"  
And close the browser

Examples:

| email | password |
|admin@yourstore.com | admin |
|admin@yourstore.com | 34553436 |