package actualTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.DriverFactory;
import frameworkPackage.Base;
import pages.ForgottenPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import utility.ConfigReader;

public class ForgottenPassword extends Base {

	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private ForgottenPasswordPage forgotPasswordPage;

	@Test(priority = 0)
	public void user_opens_the_application() {

		driver = DriverFactory.getDriver();

	}

	@Test(priority = 1)
	public void user_clicks_on_login_button_from_myaccount() {

		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@Test(priority = 2, dependsOnMethods = "user_clicks_on_login_button_from_myaccount")
	public void verify_forgotten_password_functionality() {
		Properties prop = new ConfigReader().intializeProperties();
		forgotPasswordPage = loginPage.clickOnForgottenPassword();
		forgotPasswordPage.enterEmailAddress(prop.getProperty("email"));
		forgotPasswordPage.clickOnContinue();

		Assert.assertEquals("An email with a confirmation link has been sent your email address.",
				loginPage.getWarningMessageText());
		utility.Screenshot.snap(driver, "ForgottenPassword");
	}
}
