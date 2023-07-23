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

public class PlaceOrderAsGuest extends Base {

	WebDriver driver;
	private CheckoutPage checkoutPage;

	@Test(priority = 0)
	public void user_opens_the_application() {

		driver = DriverFactory.getDriver();

	}

	@Test(priority = 1)
	public void user_proceeding_for_checkout_product_as_guest() throws InterruptedException {

		Properties prop = new ConfigReader().intializeProperties();
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.clickOnItem();
		checkoutPage.clickOnAddToCart();
		checkoutPage.clickOnCheckout();
		checkoutPage.clickOnFinalCheckout();
		Thread.sleep(5000);
		checkoutPage.clickOnGuestCheckoutRadioButton();
		checkoutPage.clickOnContinueCheckout();
		Thread.sleep(5000);
		checkoutPage.enterBillingFirstName("Guest");
		checkoutPage.enterBillingLastName("User");
		checkoutPage.enterBillingEmail("guestuser@test.com");
		checkoutPage.enterBillingTelephone("9876543210");
		checkoutPage.enterBillingAddressLine1(prop.getProperty("addressline1"));
		checkoutPage.enterBillingCity(prop.getProperty("city"));
		checkoutPage.enterBillingPostcode(prop.getProperty("postcode"));
		checkoutPage.selectBillingCountry(prop.getProperty("country"));
		checkoutPage.selectBillingState(prop.getProperty("state"));
		utility.Screenshot.snap(driver, "PlacingOrderAsGuestUser");
		Thread.sleep(5000);
		checkoutPage.clickOnBillingGuestdUserContinueButton();
		checkoutPage.clickOnAgreeCheckbox();
		checkoutPage.clickOnPaymentContinue();

	}

}
