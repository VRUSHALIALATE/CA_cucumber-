Feature: Wish List 

Scenario: Checking wheather the products are present in Wishlist or not
Given Get the driver form the AllOfItSD file
When Click on the WishList option in the web page
And close the popup in the page if appeared
Then Validate wheather product is present or not