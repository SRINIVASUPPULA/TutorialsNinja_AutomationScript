package actualTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.DriverFactory;
import frameworkPackage.Base;
import pages.HomePage;
import pages.SearchResultsPage;

public class ProductSearch extends Base {

	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;

	@Test(priority = 0)
	public void user_opens_the_application() {

		driver = DriverFactory.getDriver();

	}

	@Test(priority = 1)
	public void user_enters_valid_product_into_search_box_field() {
		String validProductText = "HP";
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProductText);

	}

	@Test(priority = 2)
	public void user_clicks_on_search_button() {

		searchResultsPage = homePage.clickOnSearchButton();

	}

	@Test(priority = 3)
	public void user_should_get_valid_product_displayed_in_search_results() {

		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		utility.Screenshot.snap(driver, "successfulProductSearch");
	}

}
