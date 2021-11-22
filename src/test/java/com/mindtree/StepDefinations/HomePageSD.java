package com.mindtree.StepDefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponent.WebDriverHelper;

import com.mindtree.utility.ReadPropertyFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class HomePageSD {

	Logger log = LogManager.getLogger(HomePageSD.class.getName());
	static WebDriver driver = null;
	static ReadPropertyFile rp = null;

	@Given("^Open the Browser$")
	public void open_the_browser() throws Throwable {

		rp = new ReadPropertyFile();

		WebDriverHelper.launchingBrowser();
		log.info("Browser has been luanched");
	}

	@Then("^Hit the url$")
	public void hit_the_url() throws Throwable {

		driver = WebDriverHelper.getDriver();

		driver.get(rp.getUrl());
		log.info("url hited");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static ReadPropertyFile getReadProbObject()
	{
		return rp;
	}
}
