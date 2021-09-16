package org.arun.basic.Septworkexamples.web.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateYourAccountPage extends AbstractPage<CreateYourAccountPage> {

	public CreateYourAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	public WebElement txtUserName;

	@FindBy(name = "password")
	public WebElement txtPassword;

	@FindBy(className = "kTTKRj")
	public WebElement ckBoxAgreements;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[3]/button")
	public WebElement btnCheckYourRate;

	@Override
	protected void load() {
		wait.until(ExpectedConditions.urlContains("step=login"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fWaitc")));

	}

	@Override
	protected void isLoaded() throws Error {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fWaitc")));
		assertTrue(driver.getCurrentUrl().contains("step=login"));
		assertTrue(txtUserName.isDisplayed());
		assertTrue(txtPassword.isDisplayed());
		assertTrue(btnCheckYourRate.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(ckBoxAgreements));
		assertTrue(ckBoxAgreements.isDisplayed());

	}

}
