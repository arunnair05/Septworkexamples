package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OfferPage extends AbstractPage<OfferPage> {

	OfferDataTablePage dtablePage;

	public OfferPage(WebDriver driver) {
		super(driver);
	}

	@FindAll(value = { @FindBy(className = "section--sm") })
	public List<WebElement> rows;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div[1]/div/div/div[2]/div/div/ul")
	private WebElement rowList;

	@Override
	protected void load() {
		wait.until(ExpectedConditions.urlContains("funnel/offer-page"));

	}

	@Override
	protected void isLoaded() throws Error {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fWaitc")));
		assertTrue(driver.getCurrentUrl().contains("funnel/offer-page"));

	}

	public OfferDataTablePage getDataTable() {
		dtablePage = new OfferDataTablePage(driver).get();
		return dtablePage;
	}

	public WebElement getSelectButtons(int index) {
		String xpath = "//*[@id=\"root\"]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div[" + index
				+ "]/div/div/div[2]/div/button";
		return driver.findElement(By.xpath(xpath));
	}

}
