package org.arun.basic.Septworkexamples.core;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebDriverListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("Test Started :::: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("Test Success ::::" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("Test Failed ::::" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("Test skipped ::::" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void onStart(ITestContext context) {

		Map<String, String> map = context.getCurrentXmlTest().getAllParameters();
		// get browser name specified in the TestNG XML test suite file
		String browserName = map.get("browserName");

		browserName = browserName == null ? "chrome" : browserName;

		WebDriver driver = DriverFactory.getDriver(browserName);
		DriverManager.setWebDriver(driver);
		DriverManager.setBrowserInfo(browserName);
		Log.info("Done! Created " + browserName + " driver!" + DriverManager.getDriver().toString());
	}

	@Override
	public void onFinish(ITestContext context) {
		// close the browser
		Log.info("Closing " + DriverManager.getBrowserInfo());

		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			driver.quit();
		}
	}

}