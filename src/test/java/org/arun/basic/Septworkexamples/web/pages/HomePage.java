package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage<HomePage> {

	@FindBy(className = "h000-mktg")
	private WebElement slogan;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		// driver.get(Environment.getProperties().url());
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getTitle().equals(""));
	}

	public String getSloganText() {
		return slogan.getText();
	}

}
