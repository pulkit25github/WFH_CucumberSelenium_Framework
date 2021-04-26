@All
Feature: AddCustomer

Background: Below are the common steps for every scenario
Given User launch chrome browser
When user open url "https://admin-demo.nopcommerce.com/login"
And user enter email as "admin@yourstore.com" and password as "admin"
And user clicks on login button
Then user click on customer link 
Then user will see customers link as sub menu option and user click on customers sub menu link
Then user land on Customers Screen and page title should be "Customers"

#1
@functional
Scenario: Verify user able to add customer

And user able to see Add button on customers screen and user clicks on Add button
Then user will land on Add customer screen and title should be "Add a new customer"
When user enter details and information
And Click on save
Then user will get the messsage "The new customer has been added successfully."
And close the browser

#2
@sanity
Scenario: Verfiy user able to search customer with email id

And enter customer email
When click on search button
Then user able to get details of customer from email
And close the browser

#3
@sanity
Scenario: Verfiy user able to search customer with firstname and lastname

And enter customer firstname
And enter customer lastname
When click on search button
Then user able to get details of customer from first and last name.
And close the browser







