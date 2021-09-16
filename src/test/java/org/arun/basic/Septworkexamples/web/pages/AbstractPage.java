package org.arun.basic.Septworkexamples.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class AbstractPage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
	protected WebDriver driver;
	private int TimeoutValue = 30;
	WebDriverWait wait;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
		wait = new WebDriverWait(driver, 10);
	}
}
