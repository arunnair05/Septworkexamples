package org.arun.basic.Septworkexamples.api.testscripts;

import org.arun.basic.Septworkexamples.web.pages.HomePage;
import org.testng.annotations.Test;

@Test
public class GithubTest extends TestBase {

	public void verifyGithubSlogan() {
		HomePage homePage = new HomePage(driver);
		homePage.get();
		homePage.getSloganText();
	}
}
