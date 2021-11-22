package com.mindtree.StepDefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.PersonalizedGiftPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class PersionalizedGiftSD {

	Logger log = LogManager.getLogger(PersionalizedGiftSD.class.getName());
	static WebDriver driver = null;
	PersonalizedGiftPage pg=null;
	
	   @Given("^Get the driver from the SignInSD file$")
	    public void get_the_driver_from_the_signinsd_file() throws Throwable {
	        
		 driver = SignInSD.getDriver();
		 
		 Thread.sleep(5000);
	    }

	    @Then("^Click on the Personalized Gift Menu$")
	    public void click_on_the_personalized_gift_menu() throws Throwable {
	      
	    	pg = new PersonalizedGiftPage(driver);

			Thread.sleep(6000L);

			pg.getPersionaizedGiftMenu().click();
			log.info("clicked on Persionaized Gift Menu");

	    }

	   

	    @And("^Click on Sort By option$")
	    public void click_on_sort_by_option() throws Throwable {
	      
	    	Thread.sleep(10000);
			pg.getSortBy().click();
			log.info("clicked on sort by button");
			
	    }

	    @And("^Select the High To Low option$")
	    public void select_the_high_to_low_option() throws Throwable {
	      
	    	pg.getDropDownOption().click();
	    	log.info("clicked on how to low options");
	    }

	    @And("^Select first product of product lists$")
	    public void select_first_product_of_product_lists() throws Throwable {
	      
	    	pg.getGetFirstItem().click();
	    }
	    
	    @Then("^Verify it$")
	    public void verify_it() throws Throwable {
	      
	    	Thread.sleep(5000L);

			if (pg.getAddToCard().getText().equalsIgnoreCase("add to cart")) {
				Assert.assertTrue(true);
				log.info("persionalized gift menu's item selected");
			} else {
				Assert.assertTrue(false);
				log.info("persionalized gift menu's item not selected");
			}
	    }
	    
	    public static WebDriver getDriver() {
			return driver;
		}

}
