package com.mindtree.StepDefinations;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.SearchBoxPage;
import com.mindtree.utility.RetreiveExcelData;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class SearchProductSD {

	Logger log = LogManager.getLogger(HomePageSD.class.getName());
	static WebDriver driver = null;
	SearchBoxPage sb=null;

	@Given("^Get the driver form the PersonalizedGiftsSD file$")
	public void get_the_driver_form_the_personalizedgiftssd_file() throws Throwable {

		driver = PersionalizedGiftSD.getDriver();
	}

	@Then("^Click the SearchBox and send prodcut name to search box$")
	public void click_the_searchbox_and_send_prodcut_name_to_search_box() throws Throwable {

	    sb = new SearchBoxPage(driver);

		List<String> list = RetreiveExcelData.getData("searchProduct");

		Thread.sleep(5000);

		sb.getSearchBox().sendKeys(list.get(1));
		sb.getSearchBox().sendKeys(Keys.ENTER);
		log.info("product name has been sent to search box");

	}

	@Then("^Verify the products which are displayed$")
	public void verify_the_products_which_are_displayed() throws Throwable {

		if (sb.getProductList().size() > 0) {
			Assert.assertTrue(true);
			log.info("list appeared of searched product");
		} else {
			Assert.assertTrue(false);
			log.info("list not appeared of searched product");
		}
	}
	
	  public static WebDriver getDriver() {
			return driver;
		}

}
