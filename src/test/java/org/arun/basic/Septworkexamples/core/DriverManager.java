package org.arun.basic.Septworkexamples.core;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	/*
	 * This simple line does all the multithread magic. :)
	 */
	private static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> BROWSER_NAME = new ThreadLocal<String>();

	public static WebDriver getDriver() {
		if (DRIVER.get() == null) {
			// this is needed when running tests from IDE
			Log.info("Thread has no WedDriver, creating new one");
			setWebDriver(DriverFactory.getDriver("chrome"));
		}
		Log.debug("Getting instance of remote driver" + DRIVER.get().getClass());
		return DRIVER.get();
	}

	public static void setWebDriver(WebDriver driver) {
		DriverManager.DRIVER.set(driver);
	}

	/**
	 * Returns a string containing current browser name, its version and OS name.
	 * This method is used in the the *WebDriverListeners to change the test name.
	 */
	public static String getBrowserInfo() {
		Log.debug("Getting browser info");
		return DriverManager.BROWSER_NAME.get();
	}

	public static void setBrowserInfo(String browserName) {
		DriverManager.BROWSER_NAME.set(browserName);

	}
}
