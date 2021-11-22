package com.mindtree.StepDefinations;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mindtree.pageObjects.ChristmasGiftPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class ChristmasGiftSD {

	Logger log = LogManager.getLogger(HomePageSD.class.getName());
	static WebDriver driver = null;
	ChristmasGiftPage cp=null;

    @Given("^Get the driver from the SearchProductSD file$")
    public void get_the_driver_from_the_searchproductsd_file() throws Throwable {

    	driver = SearchProductSD.getDriver();
    }

    @When("^click on the Chirstmas Gift Menu on the website$")
    public void click_on_the_chirstmas_gift_menu_on_the_website() throws Throwable {
      
    	cp = new ChristmasGiftPage(driver);

		cp.getChristmas().click();
		log.info("clicked on christmas menu");

    }

   

    @And("^Click on the first product$")
    public void click_on_the_first_product() throws Throwable {
    	List<WebElement> list = cp.getProductList();
		list.get(0).click();
    }

    @And("^click on Add to cart$")
    public void click_on_add_to_cart() throws Throwable {
       
    	cp.getAddToCart().click();
		log.info("christmas gift added in cart");

    }

    @And("^click on check out$")
    public void click_on_check_out() throws Throwable {
      
    	Thread.sleep(5000);
    	cp.getCheckOut().click();
    }

    @And("^close the popup if appeared$")
    public void close_the_popup_if_appeared() throws Throwable {
       
    	cp.getPop().click();
		log.info("pop up appeared");
    }

    @And("^Click on the Return to cart$")
    public void click_on_the_return_to_cart() throws Throwable {
       
    	Thread.sleep(3000);
		cp.getReturnCard().click();
    }
    
    @Then("^Validate it$")
    public void validate_it() throws Throwable {
       
    	Thread.sleep(3000L);
		if (cp.getShoppingCartTitle().getText().equalsIgnoreCase("shopping cart")) {
			Assert.assertTrue(true);
			log.info("christmas gift menu's item available in shopping cart");
		} else {
			Assert.assertTrue(false);
			log.info("christmas gift menu's item  available in shopping cart");
		}
    }

    public static WebDriver getDriver() {
		return driver;
	}
}
