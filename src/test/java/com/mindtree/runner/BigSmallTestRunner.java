
package com.mindtree.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = "com.mindtree.StepDefinations", // to tell about stepdefiantions file
		dryRun = false, // to cross check that all steps having corresponding methods or not
		monochrome = true) // it is used for remove all unnecessary charactor
public class BigSmallTestRunner extends AbstractTestNGCucumberTests {

}
