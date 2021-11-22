package com.mindtree.StepDefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.AboutUsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class AboutUsSD {

	AboutUsPage ap = null;
	Logger log = LogManager.getLogger(AboutUsSD.class.getName());
	static WebDriver driver = null;
	
	  @Given("^Get the driver from the GiftCardSD file$")
	    public void get_the_driver_from_the_giftcardsd_file() throws Throwable {
	       driver = GiftCardSD.getDriver();
	    }

	    @When("^Click on the About Us from he footer section$")
	    public void click_on_the_about_us_from_he_footer_section() throws Throwable {
	    	
	    	ap = new AboutUsPage(driver);
			ap.getAboutMenu().click();
			log.info("clicked on about us menu");
	    	
	    }

	    @Then("^Validate whether About us is opened or not$")
	    public void validate_whether_about_us_is_opened_or_not() throws Throwable {
	       
	    	if (ap.getTitle().getText().equalsIgnoreCase("about us")) {
				Assert.assertTrue(true);
				log.info("getting all info about website");
			} else {
				Assert.assertTrue(false);
				log.info("not getting info about website");
			}

	    }
	    
	    public static WebDriver getDriver() {
			return driver;
		}
}
