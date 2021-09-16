package org.arun.basic.Septworkexamples.web.Tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
	public void NonDmFunnelPage_mainElements_Visible_PageLoad() {
		// Testing if all elements are visible
		NonDmHomePage ndm = new NonDmHomePage(driver).get();
		assertTrue(ndm.txtLoanAmount.isDisplayed());
		assertTrue(ndm.selectLoanPurpose.isDisplayed());
		assertTrue(ndm.btnCheckYourRate.isDisplayed());
		Log.info(ndm.btnCheckYourRate.getText());
		assertTrue(ndm.btnCheckYourRate.getText().equals("Check Your Rate"));
		ndm.selectLoanPurposeOptions().getOptions().forEach(e -> Log.info(" " + e.getText()));
	}

	@Test
	public void NonDmFunnelPage_verify_LoanPurpose_DropDown_Contains_Allvalues() {
		// Testing if dropdown contains all expected options

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

	@Test(dependsOnMethods = "NonDmFunnelPage_verify_LoanPurpose_DropDown_Contains_Allvalues")
	public void NonDmFunnelPage_allValidValues_Account_Success() {

		// Testing Account creation and login with all success Values

		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put("BorrowerIncome", "130000");
		hm1.put("AdditionalBorrowerIncome", "50000");
		hm1.put("City", "Fremont");
		hm1.put("State", "CA");
		hm1.put("ZipCode", "94538");
		hm1.put("Street", "Fremont");
		hm1.put("Dob", "01/01/1982");

		// Going to enter loan amount and loan purpose and click on Submit button
		// input values are stored
		NonDmHomePage ndm = new NonDmHomePage(driver).get();
		int input_loan_randomAmount = CommonMethods.valueBetweenRange(1000, 5000);
		ndm.selectLoanPurpose.click();
		String input_loanPurpose = ndm.selectLoanPurposeOptionsByIndex(1).getText();
		Log.info("input_loanPurpose " + input_loanPurpose);
		enterValuesAndClickSubmitOnNonDmHomePage(ndm, input_loan_randomAmount, 1);

		// Enter basic User details
		BasicInformationPage basicInfo = new BasicInformationPage(driver).get();
		enterValuesAndClickSubmitOnBasicInformationPage(basicInfo, hm1);

		// on successful submission of values from NonDmFunnel page
		// Going to enter Individual income and Additional Income and click on Submit
		// button
		// input values are stored

		IndividualIncomePage incomePage = new IndividualIncomePage(driver).get();
		incomePage.txtBorrowerAdditionalIncome.sendKeys(hm1.get("AdditionalBorrowerIncome"));
		incomePage.txtBorrowerIncome.sendKeys(hm1.get("BorrowerIncome"));
		incomePage.btnContinue.click();
		incomePage.btnContinue.click();

		CreateYourAccountPage cPage = new CreateYourAccountPage(driver).get();
		String userName = "candidate" + CommonMethods.valueBetweenRange(1000, 2000) + "@upgrade-challenge.com";
		String password = CommonMethods.getRandomString(8, true, true);
		Log.info("password is " + password);
		enterUserNamePasswordForAccountCreation(cPage, userName, password);

		// Getting the data from Offer Page
		// This is the data we are shown as Offered loan. Storing this for comparison
		// later
		OfferPage of1 = new OfferPage(driver).get();
		Log.info("Size of Row is " + (of1.rows.size()));
		List<String> expectedValues = of1.getDataTable().getRowValues();

		// Going to SignOut after creating the Account
		RightMenuHomePage rm1 = new RightMenuHomePage(driver).get();
		rm1.menu.click();
		rm1.doSignOut();

		// Going to SignOut after creating the Account

		LoginPage l1 = new LoginPage(driver).get();
		LoginAsRegisteredUser(l1, userName, password);

		// Checking the Offer rates when login
		// This should be compared with offered rate
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

	public void enterValuesAndClickSubmitOnBasicInformationPage(BasicInformationPage basicinfo,
			HashMap<String, String> hm1) {

		basicinfo.txtBorrowerFirstName.sendKeys(CommonMethods.getRandomString(10, true, false));
		basicinfo.txtBorrowerLastName.sendKeys(CommonMethods.getRandomString(10, true, false));
		basicinfo.txtBorrowerCity.sendKeys(hm1.get("City"));
		basicinfo.txtBorrowerState.sendKeys(hm1.get("State"));
		basicinfo.txtBorrowerDateOfBirth.sendKeys(hm1.get("Dob"));
		basicinfo.txtBorrowerStreet.sendKeys(hm1.get("Street"));

		// Accepting the Address shown in suggestions
		List<WebElement> size = basicinfo.waitForGeoSuggestions();
		Log.info("Size is " + size.size());
		size.get(0).click();
		basicinfo.txtBorrowerZipCode.clear();
		basicinfo.txtBorrowerZipCode.sendKeys(hm1.get("ZipCode"));

		basicinfo.btnContinue.click();

	}

	public void enterUserNamePasswordForAccountCreation(CreateYourAccountPage cPage, String userName, String password) {

		cPage.txtUserName.sendKeys(userName);
		Log.info("User username is " + userName);
		cPage.txtPassword.sendKeys(password);
		cPage.ckBoxAgreements.click();
		cPage.btnCheckYourRate.click();
	}

	public void LoginAsRegisteredUser(LoginPage l1, String userName, String password) {
		l1.userName.sendKeys(userName);
		l1.password.sendKeys(password);
		l1.submitBtn.click();
	}
}
