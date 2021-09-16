package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.arun.basic.Septworkexamples.core.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasicInformationPage extends AbstractPage<BasicInformationPage> {

	public BasicInformationPage(WebDriver driver) {
		super(driver);
	}

	String urlContains = "personal-information";

	@FindBy(name = "borrowerFirstName")
	public WebElement txtBorrowerFirstName;

	@FindBy(name = "borrowerLastName")
	public WebElement txtBorrowerLastName;

	@FindBy(name = "borrowerStreet")
	public WebElement txtBorrowerStreet;

	@FindBy(name = "borrowerCity")
	public WebElement txtBorrowerCity;

	@FindBy(name = "borrowerState")
	public WebElement txtBorrowerState;

	@FindBy(name = "borrowerZipCode")
	public WebElement txtBorrowerZipCode;

	@FindBy(name = "borrowerDateOfBirth")
	public WebElement txtBorrowerDateOfBirth;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/button")
	public WebElement btnContinue;

	@FindAll(value = { @FindBy(name = "jointApplicationToggle") })
	private List<WebElement> radioButtons;

	@Override
	protected void load() {
		wait.until(ExpectedConditions.urlContains(urlContains));
		Log.info("Went through Basic Information");

	}

	public void getRadioButtonsByText() {

		radioButtons.forEach(e -> Log.info(" Radio " + e.getText()));
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().contains(urlContains));
		assertTrue(txtBorrowerFirstName.isDisplayed());
		assertTrue(txtBorrowerStreet.isDisplayed());
		assertTrue(txtBorrowerCity.isDisplayed());
		assertTrue(txtBorrowerState.isDisplayed());
		assertTrue(txtBorrowerZipCode.isDisplayed());

	}

	public List<WebElement> waitForGeoSuggestions() {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("geosuggest__item")));
		return driver.findElements(By.className("geosuggest__item"));
	}

}
