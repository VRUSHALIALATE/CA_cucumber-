Feature: Explore Shop By Category Menu

Scenario: Testing the Shop By Category Menu
Given Get the driver from the ChristmasGiftSD file
When Click on the ShopByCategory
And Select the second category
And Select the first product in shopByCatagory menu
And Add it to the wishlist
Then verify that item added in wish list