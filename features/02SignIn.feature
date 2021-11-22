Feature: Sign In

Scenario Outline: User is Signing In With Multiple Cradentials
Given Getting driver from the HomePageSD file
When click on SignIn button
And giving the email as "<email>" and Password as "<password>"
And Clicking on the submit button

Examples:
|email 			|password				|
|||
|defenceaspirants87@gmail.com|Banti#4321|
|vrushualate1008@gmail.com|Vrush@123|
