package com.mindtree.StepDefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.ContactUsPage;
import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class ContactUsSD {

	ContactUsPage ct=null;
	Logger log = LogManager.getLogger(ContactUsSD.class.getName());
	static WebDriver driver = null;
	ReadPropertyFile rp =null;
	
	 @Given("^getting driver from AboutUsSD file$")
	    public void getting_driver_from_aboutussd_file() throws Throwable {
	       driver = AboutUsSD.getDriver();
	    }

	    @When("^Click on ContactUs footer$")
	    public void click_on_contactus_footer() throws Throwable {
	        ct = new ContactUsPage(driver);

			ct.getContactUs().click();
			log.info("clicked on contact us");	
	    }

	    @And("^sending email, name and message to the contact form$")
	    public void sending_email_name_and_message_to_the_contact_form() throws Throwable {
	    	
	    	rp = HomePageSD.getReadProbObject();
	    	
	    	ct.getEmail().sendKeys(rp.getEmail());
			ct.getMessage().sendKeys(rp.getMessage());
			ct.getName().sendKeys(rp.getName());
			log.info("all info added");
	    }

	    
	    
	    @Then("^Verify that data has been sent$")
	    public void verify_that_data_has_been_sent() throws Throwable {

			if (ct.getTitle().getText().equalsIgnoreCase("contact us")) {
				Assert.assertTrue(true);
				log.info("thank you for contacting us");
			} else {
				Assert.assertTrue(false);
				log.info("could not verified");
			}
	    }
	    
//	    @And("^close driver$")
//	    public void close_driver() throws Throwable {
//	       
//	    	 driver.close(); driver = null;
//	    } 
}
