package actualTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.DriverFactory;
import frameworkPackage.Base;
import pages.CheckoutPage;
import pages.ForgottenPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import utility.ConfigReader;

public class PlaceOrderAsRegisteredUser extends Base {

	WebDriver driver;
	private CheckoutPage checkoutPage;

	@Test(priority = 0)
	public void user_opens_the_application() {

		driver = DriverFactory.getDriver();
		checkoutPage = new CheckoutPage(driver);
	}

	@Test(priority = 1)
	public void user_proceeding_for_checkout_product_as_registered_user() throws InterruptedException {

		Properties prop = new ConfigReader().intializeProperties();
		checkoutPage.clickOnItem();
		checkoutPage.clickOnAddToCart();
		checkoutPage.clickOnCheckout();
		checkoutPage.clickOnFinalCheckout();
		Thread.sleep(5000);
		checkoutPage.enterRegisteredUserEmail(prop.getProperty("email"));
		checkoutPage.enterRegisteredUserPassword(prop.getProperty("password"));
		checkoutPage.ClickOnRegisteredLogin();
		checkoutPage.clickOnContinueCheckout();
		Thread.sleep(5000);
		if (checkoutPage.verifyExistingAddressRadioButton() == false) {
			checkoutPage.enterBillingFirstName(prop.getProperty("firstName"));
			checkoutPage.enterBillingLastName(prop.getProperty("lastName"));
			checkoutPage.enterBillingAddressLine1(prop.getProperty("addressline1"));
			checkoutPage.enterBillingCity(prop.getProperty("city"));
			checkoutPage.enterBillingPostcode(prop.getProperty("postcode"));
			checkoutPage.selectBillingCountry(prop.getProperty("country"));
			checkoutPage.selectBillingState(prop.getProperty("state"));
		}
		utility.Screenshot.snap(driver, "PlacingOrderAsRegisteredUser");
		checkoutPage.clickOnBillingRegisteredUserContinueButton();

		Thread.sleep(5000);
		checkoutPage.clickOnAgreeCheckbox();
		checkoutPage.clickOnPaymentContinue();

	}

}
