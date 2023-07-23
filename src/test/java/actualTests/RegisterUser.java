package actualTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.DriverFactory;
import frameworkPackage.Base;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utility.CommonUtils;
import utility.ConfigReader;
import utility.Excel;

public class RegisterUser extends Base {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private HomePage homePage;
	private CommonUtils commonUtils;
	public static String emailid;

	@Test(priority = 0)
	public void user_navigates_to_register_account_page() {

		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();

	}

	@Test(priority = 1)
	public void user_enters_the_details_to_register() throws InvalidFormatException, IOException {

		Properties prop = new ConfigReader().intializeProperties();

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		commonUtils = new CommonUtils();
		emailid = commonUtils.getEmailWithTimeStamp();
		registerPage.enterEmailAddress(emailid);
		registerPage.enterTelephoneNumber(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));

	}

	@Test(priority = 2)
	public void user_clicks_on_continue_button() {

		registerPage.selectPrivacyPolicy();
		registerPage.selectYesNewsletterOption();
		accountSuccessPage = registerPage.clickOnContinueButton();

	}

	@Test(priority = 3)
	public void user_account_should_get_created_successfully() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
		utility.Screenshot.snap(driver, "successfulRegistration");
	}

	@Test(priority = 4)
	public void user_clicks_on_account_logout() {
		homePage.clickOnMyAccount();
		homePage.clickOnLogout();

		Assert.assertEquals("Account Logout", accountSuccessPage.getPageHeading());
	}

}
