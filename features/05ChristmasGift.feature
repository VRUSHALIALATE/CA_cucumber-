Feature: Explore Christmas Gift Menu

Scenario: Testing the Christmas Gifts Menu

Given Get the driver from the SearchProductSD file
When click on the Chirstmas Gift Menu on the website
And Click on the first product
And click on Add to cart
And click on check out
And close the popup if appeared
And Click on the Return to cart
Then Validate it