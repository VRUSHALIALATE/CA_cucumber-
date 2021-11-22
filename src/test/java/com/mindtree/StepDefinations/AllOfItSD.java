package com.mindtree.StepDefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.pageObjects.AllOfItPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class AllOfItSD {

	Logger log = LogManager.getLogger(AllOfItSD.class.getName());
	static WebDriver driver = null;
	AllOfItPage ai = null;

	@Given("^Get the driver from the ShopByCategorySD file$")
	public void get_the_driver_from_the_shopbycategorysd_file() throws Throwable {
		driver = ShopByCatagorySD.getDriver();
	}

	@When("^Click on the AllOfIt option from the menu bar$")
	public void click_on_the_allofit_option_from_the_menu_bar() throws Throwable {
		ai = new AllOfItPage(driver);

		ai.getAllOfIt().click();
		log.info("clicked on all of it menu");

	}

	@And("^Select the first product in AllOfIt menu$")
	public void select_the_first_product_in_AllOfIt_menu() throws Throwable {
		ai.getProduct().click();
	}

	@Then("^Validate its title$")
	public void validate_its_title() throws Throwable {
		if (ai.getTitle().getText().contains("Auto Rickshaw Pen Stand")) {
			Assert.assertTrue(true);
			log.info("Title under All ot It is verified");
		} else {
			log.info("not verifired");
			Assert.assertTrue(false);
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
