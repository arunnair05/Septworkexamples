package org.arun.basic.Septworkexamples.web.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.arun.basic.Septworkexamples.core.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferDataTablePage extends AbstractPage<OfferDataTablePage> {

	public OfferDataTablePage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {

	}

	public List<String> getRowValues() {

		List<String> rowValues = driver.findElement(By.className("sc-geBCVM")).findElements(By.tagName("li")).stream()
				.map(e -> e.findElement(By.className("sc-ciOKUB")).getText()).collect(Collectors.toList());
		Log.info("values are " + rowValues);
		return rowValues;

	}

}
