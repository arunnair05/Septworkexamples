package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import org.arun.basic.Septworkexamples.web.Tests.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class NonDmHomePage extends AbstractPage<NonDmHomePage> {

	public NonDmHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "desiredAmount")
	public WebElement txtLoanAmount;

	@FindBy(name = "loan-purpose")
	public WebElement selectLoanPurpose;

	@FindBy(tagName = "button")
	public WebElement btnCheckYourRate;

	@Override
	protected void load() {
		this.driver.get(Constants.NONDMFUNNELURL);
		wait.until(ExpectedConditions.urlContains(Constants.NONDMFUNNELURL));
		wait.until(ExpectedConditions.titleContains("Upgrade - Personal Loans and Cards"));

	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().contains(Constants.NONDMFUNNELURL));
	}

	public Select selectLoanPurposeOptions() {
		return new Select(selectLoanPurpose);
	}

	public WebElement selectLoanPurposeOptionsByIndex(int index) {
		return selectLoanPurposeOptions().getOptions().get(index);
	}

}
