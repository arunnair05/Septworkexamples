package org.arun.basic.Septworkexamples.api.testscripts;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.HttpStatus;
import org.arun.basic.Septworkexamples.api.pojo.BodyLoanAppSecret;
import org.arun.basic.Septworkexamples.api.pojo.BorrowerResumptionInfo;
import org.arun.basic.Septworkexamples.api.pojo.LoanAppResumptionInfo;
import org.arun.basic.Septworkexamples.api.pojo.LoanAppSecretResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ByLeadSecretTests {
	RequestSpecification rspec;
	RequestSpecBuilder build;
	private String SOURCE_ID = "coding-challenge";
	private int Expected_ResponseTime = 5;
	private String VALID_APP_UUID = "b8096ec7-2150-405f-84f5-ae99864b3e96";
	private String baseUri = "https://credapi.credify.tech/api/brfunnelorch/v2/";
	private String basePath = "resume/byLeadSecret";

	@DataProvider(name = "positiveInput")
	public Object[] supplyPositiveInputs() {
		Object[] objArray = new Object[2];
		BodyLoanAppSecret b1 = new BodyLoanAppSecret();
		b1.setLoanAppUuid(UUID.fromString(VALID_APP_UUID));
		b1.setSkipSideEffects(true);
		objArray[0] = b1;

		BodyLoanAppSecret b2 = new BodyLoanAppSecret();
		b2.setLoanAppUuid(UUID.fromString(VALID_APP_UUID));
		b2.setSkipSideEffects(false);
		objArray[1] = b2;
		return objArray;

	}

	@DataProvider(name = "negativeInput")
	public Object[] supplyInvalidInputs() {
		Object[] objArray = new Object[1];
		BodyLoanAppSecret b1 = new BodyLoanAppSecret();
		b1.setLoanAppUuid(randomUUId());
		b1.setSkipSideEffects(true);
		objArray[0] = b1;
		return objArray;

	}

	@BeforeClass
	public void setup() {
		build = new RequestSpecBuilder();
		build.setBaseUri(baseUri);
		build.setBasePath(basePath);
		build.addHeader("x-cf-source-id", SOURCE_ID);
		build.addHeader("x-cf-corr-id", randomUUId().toString());
		build.setContentType(ContentType.JSON);
		rspec = build.build();

	}

	@AfterClass
	public void tearDown() {

		build = null;
		rspec = null;
	}

	@Test(dataProvider = "negativeInput")
	public void ResponseCode_InvalidInput_404(BodyLoanAppSecret b1) {

		Response response = execute(rspec, b1);
		responseCodeValidation(response, HttpStatus.SC_NOT_FOUND);

	}

	@Test(dataProvider = "positiveInput")
	public void ResponseCode_NoCorrIdHeader_500ErrorExpected(BodyLoanAppSecret b1) {

		Response response = execute(given().baseUri(baseUri).basePath(basePath).headers("x-cf-source-id", SOURCE_ID),
				b1);
		responseCodeValidation(response, HttpStatus.SC_INTERNAL_SERVER_ERROR);

	}

	@Test(dataProvider = "positiveInput")
	public void ResponseCode_NoSourceIdHeader_500ErrorExpected(BodyLoanAppSecret b1) {

		Response response = execute(
				given().baseUri(baseUri).basePath(basePath).headers("x-cf-corr-id", randomUUId().toString()), b1);
		responseCodeValidation(response, HttpStatus.SC_INTERNAL_SERVER_ERROR);

	}

	@Test(dataProvider = "positiveInput")
	public void ResponseCode_ValidInput_Http200Ok(BodyLoanAppSecret b1) {

		Response response = execute(rspec, b1);
		responseCodeValidation(response, HttpStatus.SC_OK);

	}

	@Test(dataProvider = "positiveInput", dependsOnMethods = "ResponseCode_ValidInput_Http200Ok")
	public void ResponseCode_ReponseTime_LessThanNSeconds(BodyLoanAppSecret b1) {
		Response response = execute(rspec, b1);
		assertTrue(response.getTimeIn(TimeUnit.SECONDS) < Expected_ResponseTime,
				"Response not received in expected time of ");

	}

	@Test(dataProvider = "positiveInput", dependsOnMethods = "ResponseCode_ValidInput_Http200Ok")
	public void ResponseValue_ProductType_Personal_Loan(BodyLoanAppSecret b1) {

		Response response = execute(rspec, b1);
		System.out.println(response.asString());
		LoanAppSecretResponse apiresponse = response.getBody().as(LoanAppSecretResponse.class);
		LoanAppResumptionInfo lifo = apiresponse.getLoanAppResumptionInfo();
		BorrowerResumptionInfo brInfo = lifo.getBorrowerResumptionInfo();

		int loanAppId = lifo.getLoanAppId();
		String loanAppUuid = lifo.getLoanAppUuid();
		String referrer = lifo.getReferrer();
		String status = lifo.getStatus();
		String productType = lifo.getProductType();
		String sourceSystem = lifo.getSourceSystem();
		double desiredAmount = lifo.getDesiredAmount();
		lifo.getCoBorrowerResumptionInfo();
		boolean isTurnDown = lifo.isTurnDown();
		boolean isHasLogin = lifo.isHasLogin();
		lifo.getAvailableAppImprovements();
		lifo.getCashOutAmount();
		boolean isCanAddLiteral = lifo.isCanAddCollateral();
		Object rewardProgramCode = lifo.getRewardProgramCode();
		System.out.println(" --> " + lifo.getAddon());
		Object isMobileDiscountApplied = lifo.getIsMobileDiscountApplied();
		lifo.isCheckingDiscountAvailable();

		apiresponse.getOffers();
		apiresponse.getRequiredAgreements();
		apiresponse.getResetOptions();
		apiresponse.getOriginalLoanApp();

		String fName = brInfo.getFirstName();
		String maskedEmail = brInfo.getMaskedEmail();
		String email = brInfo.getEmail();
		String state = brInfo.getState();

		assertTrue(apiresponse.getLoanAppResumptionInfo().getProductType().equals("PERSONAL_LOAN"));

	}

	public static UUID randomUUId() {
		return UUID.randomUUID();
	}

	public Response execute(RequestSpecification rspec, BodyLoanAppSecret b1) {
		return given().spec(rspec).when().log().ifValidationFails().body(b1).post();
	}

	public static void responseCodeValidation(Response response, int httpStatus) {
		int statusCode = response.getStatusCode();
		assertTrue(statusCode == httpStatus, "Status code is not " + httpStatus + "  Received is " + statusCode);
	}

}
