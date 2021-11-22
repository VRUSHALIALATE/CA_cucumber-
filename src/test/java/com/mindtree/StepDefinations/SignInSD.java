package com.mindtree.StepDefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class SignInSD {
	Logger log = LogManager.getLogger(SignInSD.class.getName());
	static WebDriver driver = null;
	SignInPage sp =null;

    @Given("^Getting driver from the HomePageSD file$")
    public void getting_driver_from_the_homepagesd_file() throws Throwable {
          driver = HomePageSD.getDriver();
    }

    @When("^click on SignIn button$")
    public void click_on_signin_button() throws Throwable {
    	HomePage hp = new HomePage(driver);

		hp.getSignIn().click();
		log.info("clicked on sign button");   	
    }

    @And("^giving the email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void giving_the_email_as_something_and_password_as_something(String email, String passwrod) throws Throwable {
       
	    sp = new SignInPage(driver);

	    log.info("going to send data");
	    
		
		sp.getEmail().sendKeys(email);
		log.info(email + " entered");
		//sp.getPassword().clear();
		sp.getPassword().sendKeys(passwrod);
		log.info(passwrod + " entered");
    	
    }

    @And("^Clicking on the submit button$")
    public void clicking_on_the_submit_button() throws Throwable {
    	
    	sp.getSignInSmmitButton().click();
		log.info("clicked on summit button");
    }

    public static WebDriver getDriver() {
		return driver;
	}
}
