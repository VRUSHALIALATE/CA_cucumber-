package com.mindtree.StepDefinations;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mindtree.pageObjects.ShopByCatagoryPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class ShopByCatagorySD {

	Logger log = LogManager.getLogger(HomePageSD.class.getName());
	static WebDriver driver = null;
	ShopByCatagoryPage sc=null;
	
	  @Given("^Get the driver from the ChristmasGiftSD file$")
	    public void get_the_driver_from_the_christmasgiftsd_file() throws Throwable {
	       
		  driver = ChristmasGiftSD.getDriver();
	    }

	    @When("^Click on the ShopByCategory$")
	    public void click_on_the_shopbycategory() throws Throwable {
	        
	        sc = new ShopByCatagoryPage(driver);

			sc.getShopByCatagory().click();
			log.info("clicked on shop By catagory menu");
	    }

	    @And("^Select the second category$")
	    public void select_the_second_category() throws Throwable {
	      
	    	List<WebElement> list2 = sc.getBirthdayCatagory();
			list2.get(1).click();
	    }

	    @And("^Select the first product in shopByCatagory menu$")
	    public void select_the_first_product_in_shopByCatagory_menu() throws Throwable {
	    	 
	    	List<WebElement> list = sc.getBirthdayProductList();
			list.get(0).click();
	    }

	    @And("^Add it to the wishlist$")
	    public void add_it_to_the_wishlist() throws Throwable {
	    	sc.getAddtoWish().click();
			log.info("clicked on add to wish");
	    }
	    
	    @Then("^verify that item added in wish list$")
	    public void verify_that_item_added_in_wish_list() throws Throwable {
	       
	    	Thread.sleep(5000);
			if (sc.getRemove().getText().equalsIgnoreCase("remove")) {
				Assert.assertTrue(true);
				log.info("item has been added in wish list");
			} else {
				Assert.assertTrue(false);
				log.info("item has not been added in wish list");
			}
	    }
	    
	    public static WebDriver getDriver() {
			return driver;
		}
}
