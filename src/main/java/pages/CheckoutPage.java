package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonUtils;
import utility.ElementUtils;

public class CheckoutPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//a[text()='MacBook']")
	private WebElement macBookItem;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//a[contains(@href,'route=checkout/checkout')]")
	private WebElement checkout;

	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElement finalCheckOut;

	@FindBy(xpath = "//label[text()='Guest Checkout']")
	private WebElement guestCheckout;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement loginRegisteredEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement loginRegisteredPassword;

	@FindBy(xpath = "//input[@id='button-login']")
	private WebElement registeredLoginButton;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueCheckout;

	@FindBy(id = "input-payment-firstname")
	private WebElement billingFirstName;

	@FindBy(id = "input-payment-lastname")
	private WebElement billingLastName;

	@FindBy(id = "input-payment-email")
	private WebElement billingEmail;

	@FindBy(id = "input-payment-telephone")
	private WebElement billingTelephone;

	@FindBy(id = "input-payment-address-1")
	private WebElement billingAddressLine1;

	@FindBy(id = "input-payment-city")
	private WebElement billingCity;

	@FindBy(id = "input-payment-postcode")
	private WebElement billingPostcode;

	@FindBy(id = "input-payment-country")
	private WebElement billingCountry;

	@FindBy(id = "input-payment-zone")
	private WebElement billingState;

	@FindBy(id = "button-guest")
	private WebElement billingGuestContinue;

	@FindBy(xpath = "//input[@value = 'Continue']")
	private WebElement billingRegisteredContinue;

	@FindBy(name = "agree")
	private WebElement paymentAgree;

	@FindBy(id = "button-payment-method")
	private WebElement paymentMethod;

	@FindBy(xpath = "//*[text()='Step 4: Confirm Order']")
	private WebElement confirmOrder;

	@FindBy(xpath = "//label[text()='I want to use an existing address']")
	private WebElement existingAddress;

	public CheckoutPage clickOnItem() {

		elementUtils.clickOnElement(macBookItem, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new CheckoutPage(driver);
	}

	public void clickOnAddToCart() {

		elementUtils.clickOnElement(addToCart, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnCheckout() {

		elementUtils.clickOnElement(checkout, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnContinueCheckout() {

		elementUtils.clickOnElement(continueCheckout, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnGuestCheckoutRadioButton() {

		elementUtils.clickOnElement(guestCheckout, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterRegisteredUserEmail(String inputEmail) {

		elementUtils.typeTextIntoElement(loginRegisteredEmail, inputEmail, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterRegisteredUserPassword(String inputPassword) {

		elementUtils.typeTextIntoElement(loginRegisteredPassword, inputPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void ClickOnRegisteredLogin() {

		elementUtils.clickOnElement(registeredLoginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnFinalCheckout() {

		elementUtils.clickOnElement(finalCheckOut, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterBillingFirstName(String inputFirstName) {

		elementUtils.typeTextIntoElement(billingFirstName, inputFirstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterBillingLastName(String inputLastName) {

		elementUtils.typeTextIntoElement(billingLastName, inputLastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterBillingEmail(String inputEmail) {

		elementUtils.typeTextIntoElement(billingEmail, inputEmail, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterBillingTelephone(String inputTelephone) {

		elementUtils.typeTextIntoElement(billingTelephone, inputTelephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterBillingAddressLine1(String inputAddressLine1) {

		elementUtils.typeTextIntoElement(billingAddressLine1, inputAddressLine1, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterBillingCity(String inputCity) {

		elementUtils.typeTextIntoElement(billingCity, inputCity, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterBillingPostcode(String inputPostcode) {

		elementUtils.typeTextIntoElement(billingPostcode, inputPostcode, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void selectBillingCountry(String inputValue) {

		elementUtils.selectOptionInDropdown(billingCountry, inputValue, 5);

	}

	public void selectBillingState(String inputValue) {

		elementUtils.selectOptionInDropdown(billingState, inputValue, 5);

	}

	public void clickOnBillingGuestdUserContinueButton() {

		elementUtils.clickOnElement(billingGuestContinue, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnBillingRegisteredUserContinueButton() {

		elementUtils.clickOnElement(billingRegisteredContinue, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnAgreeCheckbox() {

		elementUtils.clickOnElement(paymentAgree, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnPaymentContinue() {

		elementUtils.clickOnElement(paymentMethod, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnConfirmOrder() {

		elementUtils.clickOnElement(confirmOrder, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public boolean verifyExistingAddressRadioButton() {

		return elementUtils.displayStatusOfElement(existingAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

}