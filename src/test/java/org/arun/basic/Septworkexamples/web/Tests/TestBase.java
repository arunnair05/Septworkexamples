package org.arun.basic.Septworkexamples.web.Tests;

import org.arun.basic.Septworkexamples.core.DriverFactory;
import org.arun.basic.Septworkexamples.core.DriverManager;
import org.arun.basic.Septworkexamples.core.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class TestBase {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		String browserName = "chrome";

		browserName = browserName == null ? "chrome" : browserName;
		driver = DriverFactory.getDriver(browserName);
		DriverManager.setWebDriver(driver);
		DriverManager.setBrowserInfo(browserName);
		Log.info("Done! Created " + browserName + " driver!" + DriverManager.getDriver().toString());

	}

	@AfterMethod
	public void tearDown() {

		Log.info("Closing " + DriverManager.getBrowserInfo());

		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			driver.quit();
		}

	}

}
