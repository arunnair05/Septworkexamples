package org.arun.basic.Septworkexamples.web.Tests;

import org.arun.basic.Septworkexamples.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

abstract class TestBase {

	protected WebDriver driver;

	@BeforeTest
	public void setupSuite() {
		driver = DriverManager.getDriver();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
