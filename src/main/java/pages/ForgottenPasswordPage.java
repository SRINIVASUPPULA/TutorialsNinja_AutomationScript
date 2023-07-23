package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUtils;
import utility.ElementUtils;

public class ForgottenPasswordPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public ForgottenPasswordPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement enterEmail;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public void enterEmailAddress(String enterText) {

		elementUtils.typeTextIntoElement(enterEmail, enterText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnContinue() {

		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
}
