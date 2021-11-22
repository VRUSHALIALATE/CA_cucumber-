package com.mindtree.StepDefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.GitCardPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class GiftCardSD {
    
	GitCardPage gp=null;
	Logger log = LogManager.getLogger(HomePageSD.class.getName());
	static WebDriver driver = null;
	
	  @Given("^Get the driver from the WishListSD file$")
	    public void get_the_driver_from_the_wishlistsd_file() throws Throwable {
	       
		  driver = WIshListSD.getDriver();
	    }

	    @Then("^Click on the Gift Card on the web page$")
	    public void click_on_the_gift_card_on_the_web_page() throws Throwable {
	       
	        gp = new GitCardPage(driver);

			gp.getGiftCard().click();
			log.info("clicked on gift card button");
			
	    }

	    @And("^Validate the title$")
	    public void validate_the_title() throws Throwable {
	    	
	    	Thread.sleep(3000);
	    	
	    	if (gp.getTitle().getText().equalsIgnoreCase("gift card")) {
				Assert.assertTrue(true);
				log.info("gift card feature is working");
			} else {
				Assert.assertTrue(false);
				log.info("gift card feature is not working");
			}
	    }

	    
	    public static WebDriver getDriver() {
			return driver;
		}
}
