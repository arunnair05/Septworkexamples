package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RightMenuHomePage extends AbstractPage<RightMenuHomePage> {

	public RightMenuHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#root > div > main > div > header > div")
	public WebElement menu;

	@FindBy(css = "#root > div > main > div > header > div > nav > ul > li:nth-child(2) > a")
	public WebElement signOut;

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(menu.isDisplayed());

	}

	public void doSignOut() {
		wait.until(ExpectedConditions.visibilityOf(signOut));
		signOut.click();

	}

}
