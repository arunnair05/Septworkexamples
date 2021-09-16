package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import org.arun.basic.Septworkexamples.core.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndividualIncomePage extends AbstractPage<IndividualIncomePage> {

	public IndividualIncomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "borrowerIncome")
	public WebElement txtBorrowerIncome;

	@FindBy(name = "borrowerAdditionalIncome")
	public WebElement txtBorrowerAdditionalIncome;

	@FindBy(tagName = "button")
	public WebElement btnContinue;

	@Override
	protected void load() {
		wait.until(ExpectedConditions.urlContains("step=income"));
		wait.until(ExpectedConditions.visibilityOf(txtBorrowerAdditionalIncome));
		wait.until(ExpectedConditions.visibilityOf(txtBorrowerIncome));
		Log.info("Came inside Load of Individual Income ");

	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().contains("step=income"));

	}

}
