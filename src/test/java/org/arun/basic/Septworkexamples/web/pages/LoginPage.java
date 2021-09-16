package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import org.arun.basic.Septworkexamples.core.Log;
import org.arun.basic.Septworkexamples.web.Tests.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage<LoginPage> {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	public WebElement userName;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(css = "#root > div > main > div > div > div > div > div > div > div > form > button")
	public WebElement submitBtn;

	@Override
	protected void load() {
		driver.get(Constants.LOGINURL);
		Log.info("Inside Load ");
	}

	@Override
	protected void isLoaded() throws Error {

		Log.info("Came inside is Loaded for Login page");

		assertTrue(driver.getCurrentUrl().equals(Constants.LOGINURL));

	}

}
