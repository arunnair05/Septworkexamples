package org.arun.basic.Septworkexamples.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndividualOfferPage extends AbstractPage<IndividualOfferPage> {

	OfferDataTablePage dtablePage;

	public IndividualOfferPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {
		// Nothing is needed
	}

	@Override
	protected void isLoaded() throws Error {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fWaitc")));
		wait.until(ExpectedConditions.urlContains("funnel/offer-page"));

	}

	public OfferDataTablePage getDataTable() {
		dtablePage = new OfferDataTablePage(driver).get();
		return dtablePage;
	}

}