package com.mindtree.StepDefinations;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mindtree.pageObjects.WishListPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class WIshListSD {

	Logger log = LogManager.getLogger(WIshListSD.class.getName());
	static WebDriver driver = null;
	WishListPage wl=null;
	
	 @Given("^Get the driver form the AllOfItSD file$")
	    public void get_the_driver_form_the_allofitsd_file() throws Throwable {
	        driver = AllOfItSD.getDriver();
	        
	    }

	    @When("^Click on the WishList option in the web page$")
	    public void click_on_the_wishlist_option_in_the_web_page() throws Throwable {
	         wl = new WishListPage(driver);

			Thread.sleep(3000);
			wl.getWishList().click();
			log.info("clicked on wishlist menu");
	    }

	   

	    @And("^close the popup in the page if appeared$")
	    public void close_the_popup_in_the_page_if_appeared() throws Throwable {
	    	Thread.sleep(6000);
			if (wl.getPopup().isDisplayed())
				wl.getPopup().click();
	    }
	    
	    
	    @Then("^Validate wheather product is present or not$")
	    public void validate_wheather_product_is_present_or_no() throws Throwable {
	       
	    	List<WebElement> list = wl.getProductList();

			if (list.get(0).isDisplayed()) {
				Assert.assertTrue(true);
				log.info("products are available in wish list");
			} else {
				Assert.assertTrue(false);
				log.info("products were not added in wish list");
			}
	    }
	    
	    public static WebDriver getDriver() {
			return driver;
		}
}
