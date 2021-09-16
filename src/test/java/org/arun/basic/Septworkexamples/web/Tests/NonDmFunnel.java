package org.arun.basic.Septworkexamples.web.Tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.arun.basic.Septworkexamples.core.Log;
import org.arun.basic.Septworkexamples.web.pages.BasicInformationPage;
import org.arun.basic.Septworkexamples.web.pages.CreateYourAccountPage;
import org.arun.basic.Septworkexamples.web.pages.IndividualIncomePage;
import org.arun.basic.Septworkexamples.web.pages.IndividualOfferPage;
import org.arun.basic.Septworkexamples.web.pages.LoginPage;
import org.arun.basic.Septworkexamples.web.pages.NonDmHomePage;
import org.arun.basic.Septworkexamples.web.pages.OfferPage;
import org.arun.basic.Septworkexamples.web.pages.RightMenuHomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NonDmFunnel extends TestBase {

	@Test
	public void mainElements_Visible_PageLoad() {
		NonDmHomePage ndm = new NonDmHomePage(driver).get();
		assertTrue(ndm.txtLoanAmount.isDisplayed());
		assertTrue(ndm.selectLoanPurpose.isDisplayed());
		assertTrue(ndm.btnCheckYourRate.isDisplayed());
		Log.info(ndm.btnCheckYourRate.getText());
		assertTrue(ndm.btnCheckYourRate.getText().equals("Check Your Rate"));
		ndm.selectLoanPurposeOptions().getOptions().forEach(e -> Log.info(" " + e.getText()));
	}

	@Test
	public void verify_DropDown_Contains_Allvalues() {
		NonDmHomePage ndm = new NonDmHomePage(driver).get();
		ArrayList<String> expectedValue = new ArrayList<String>();
		expectedValue.add("Pay off Credit Cards");
		expectedValue.add("Debt Consolidation");
		expectedValue.add("Business");
		expectedValue.add("Home Improvement");
		expectedValue.add("Large Purchase");
		expectedValue.add("Other");
		List<String> actualValue = ndm.selectLoanPurposeOptions().getOptions().stream().map(e -> e.getText())
				.collect(Collectors.toList());
		expectedValue.forEach(e -> assertTrue(actualValue.contains(e)));

	}

	@Test(dependsOnMethods = "verify_DropDown_Contains_Allvalues")
	public void allValidValues_MoveToNextPage() {
		NonDmHomePage ndm = new NonDmHomePage(driver).get();
		int input_randomAmount = CommonMethods.valueBetweenRange(1000, 5000);
		ndm.selectLoanPurpose.click();
		String input_loanPurpose = ndm.selectLoanPurposeOptionsByIndex(1).getText();
		Log.info("input_loanPurpose " + input_loanPurpose);
		enterValuesAndClickSubmitOnNonDmHomePage(ndm, input_randomAmount, 1);
		BasicInformationPage basicInfo = new BasicInformationPage(driver).get();
		enterValuesAndClickSubmitOnBasicInformationPage(basicInfo);
		IndividualIncomePage incomePage = new IndividualIncomePage(driver).get();
		incomePage.txtBorrowerAdditionalIncome.sendKeys("50000");
		incomePage.txtBorrowerIncome.sendKeys("130000");
		incomePage.btnContinue.click();
		incomePage.btnContinue.click();

		CreateYourAccountPage cPage = new CreateYourAccountPage(driver).get();

		String userName = "candidate" + CommonMethods.valueBetweenRange(1000, 2000) + "@upgrade-challenge.com";

		cPage.txtUserName.sendKeys(userName);
		Log.info("User username is " + userName);
		cPage.txtPassword.sendKeys("Cisco_1221");
		// driver.findElements(By.className("kTTKRj")).get(0).click();
		cPage.ckBoxAgreements.click();
		cPage.btnCheckYourRate.click();

		OfferPage of1 = new OfferPage(driver).get();
		Log.info("Size of Row is " + (of1.rows.size()));

		List<String> expectedValues = of1.getDataTable().getRowValues();

		// Going to SignOut after creating the Account
		RightMenuHomePage rm1 = new RightMenuHomePage(driver).get();
		rm1.menu.click();
		rm1.doSignOut();

		LoginPage l1 = new LoginPage(driver).get();
		l1.userName.sendKeys(userName);
		l1.password.sendKeys("Cisco_1221");
		l1.submitBtn.click();

		IndividualOfferPage if1 = new IndividualOfferPage(driver).get();
		List<String> actualValues = if1.getDataTable().getRowValues();
		Log.info(expectedValues);
		Log.info(actualValues);

		Collections.sort(expectedValues);
		Collections.sort(actualValues);

		assertTrue(expectedValues.equals(actualValues));

	}

	public void enterValuesAndClickSubmitOnNonDmHomePage(NonDmHomePage ndm, int amount, int index) {
		ndm.txtLoanAmount.sendKeys(String.valueOf(amount));
		ndm.selectLoanPurposeOptions().selectByIndex(1);
		ndm.btnCheckYourRate.click();

	}

	public void enterValuesAndClickSubmitOnBasicInformationPage(BasicInformationPage basicinfo) {

		basicinfo.txtBorrowerFirstName.sendKeys(CommonMethods.getRandomString(10, true, false));
		basicinfo.txtBorrowerLastName.sendKeys(CommonMethods.getRandomString(10, true, false));
		basicinfo.txtBorrowerCity.sendKeys("Fremont");
		basicinfo.txtBorrowerState.sendKeys("CA");
		basicinfo.txtBorrowerDateOfBirth.sendKeys("01/01/1982");
		basicinfo.txtBorrowerStreet.sendKeys("Fremont");

		List<WebElement> size = basicinfo.waitForGeoSuggestions();
		Log.info("Size is " + size.size());
		size.get(0).click();
		basicinfo.txtBorrowerZipCode.clear();
		basicinfo.txtBorrowerZipCode.sendKeys("94538");

		basicinfo.btnContinue.click();
		Log.info("Did it click ");

	}

}
