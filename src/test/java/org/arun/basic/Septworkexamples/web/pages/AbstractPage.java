package org.arun.basic.Septworkexamples.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

abstract class AbstractPage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
