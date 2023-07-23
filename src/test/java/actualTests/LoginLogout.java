package actualTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.DriverFactory;
import frameworkPackage.Base;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.LoginPage;
import utility.CommonUtils;
import utility.ConfigReader;

public class LoginLogout extends Base {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private AccountSuccessPage accountSuccessPage;
	private HomePage homePage;

	@Test(priority = 0)
	public void user_navigates_to_login_page() {

		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@Test(priority = 1, dependsOnMethods = "user_navigates_to_login_page")
	public void user_successfull_login() {
		Properties prop = new ConfigReader().intializeProperties();
		loginPage.enterEmailAddress(prop.getProperty("email"));
		loginPage.enterPassword(prop.getProperty("password"));
		accountPage = loginPage.clickOnLoginButton();

	}

	@Test(priority = 2, dependsOnMethods = "user_successfull_login")
	public void user_successfully_logged_in() throws InterruptedException {

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
		utility.Screenshot.snap(driver, "successfulLogin");
		Thread.sleep(10000);
	}

	@Test(priority = 3, dependsOnMethods = "user_successfully_logged_in")
	public void user_clicks_on_account_logout() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnMyAccount();
		homePage.clickOnLogout();
		Thread.sleep(8000);
		accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals("Account Logout", accountSuccessPage.getPageHeading());
		utility.Screenshot.snap(driver, "successfulLogout");
	}

}
