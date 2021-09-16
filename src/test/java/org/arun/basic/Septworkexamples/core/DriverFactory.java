package org.arun.basic.Septworkexamples.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver getDriver(String browserName) {
		browserName = browserName.toUpperCase();
		Log.info("Local Driver Creation");
		WebDriver driver = null;
		String exePath = "";
		DesiredCapabilities capabilities = setCapabilities(browserName);
		switch (browserName) {
		case "IE":

			InternetExplorerOptions ieOptions = setIEOptions();
			ieOptions.merge(capabilities);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(ieOptions);
			break;
		case "FIREFOX":
			FirefoxOptions firefoxoptions = setFireFoxOptions();
			firefoxoptions.merge(capabilities);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxoptions);
			break;
		case "CHROME":

			ChromeOptions chromeOptions = setChromeOptions();
			Log.info("Options are " + chromeOptions.toJson());
			chromeOptions.merge(capabilities);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			break;

		}
		Log.info("DriverFactory created an instance of WebDriver on local machine for: " + browserName);
		driver.manage().window().maximize();
		return driver;

	}

	private static DesiredCapabilities setCapabilities(String browserName) {

		DesiredCapabilities capabilities = null;
		switch (browserName) {
		case "IE":
			// capabilities = setIECapabilities();
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setJavascriptEnabled(true);
			break;
		case "FIREFOX":
			// capabilities = setFirefoxCapabilities();
			capabilities = DesiredCapabilities.firefox();
			break;
		case "CHROME":
		default:
			capabilities = DesiredCapabilities.chrome();
			break;
		}

		return capabilities;
	}

	private static DesiredCapabilities setFirefoxCapabilities() {
		DesiredCapabilities capabilities = null;
		try {
			String firefoxProfileTemplate = "DEFAULT";

			FirefoxProfile firefoxProfile = new FirefoxProfile();

			if (!("DEFAULT".equals(firefoxProfileTemplate))) {
				File file = new File(firefoxProfileTemplate);
				if (file.exists())
					firefoxProfile = new FirefoxProfile(file);
			}

			firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
			firefoxProfile.setAcceptUntrustedCertificates(false);

			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return capabilities;
	}

	private static ChromeOptions setChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_settings.popups", 0);
		// needed only for headless
		// options.addArguments("--headless", "--disable-gpu",
		// "--window-size=1920,1200", "--ignore-certificate-errors");
		options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("w3c", true);

		return options;
	}

	private static FirefoxOptions setFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.useDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		options.addPreference("pdfjs.disabled", true);
		options.addPreference("security.insecure_password.ui.enabled", false);
		options.addPreference("security.insecure_field_warning.contextual.enabled", false);
		return options;
	}

	private static InternetExplorerOptions setIEOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		return options;
	}

}
