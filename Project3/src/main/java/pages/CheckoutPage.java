package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Add to Cart')]")
	private WebElement addCart;
	
	@FindBy(xpath="//a[contains(text(),'HP LP3065')]")
	private WebElement specificationPage;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addCartOnSpecificationPage;
	
	
	@FindBy(xpath = "/html/body/div[2]/div[1]")
	private WebElement successfullMessage;
	
	
	@FindBy(xpath="//span[contains(text(),'Checkout')]")
	private WebElement checkoutLink;
	
	
	@FindBy(xpath="//h1[contains(text(),'Checkout')]")
	private WebElement checkoutPage;
	
	
	@FindBy(xpath="//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]")
	private WebElement selectGuestCheckoutButton;
	
	@FindBy(xpath="//input[@id='button-account']")
	private WebElement guestCheckoutContinueButton;
	
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	private WebElement firstNameField;
	
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	private WebElement lastNameField;
	
	
	@FindBy(xpath="//input[@id='input-payment-email']")
	private WebElement emailField;
	

	@FindBy(xpath="//input[@id='input-payment-telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	private WebElement address1Field;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	private WebElement cityField;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	private WebElement postCodeField;
	
	
	@FindBy(xpath="//select[@id='input-payment-country']")
	private WebElement countryField;
	
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	private WebElement stateField;
	
	@FindBy(xpath="//input[@id='input-payment-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@id='newsletter']")
	private WebElement newsLetterCheckboxField;
	
	
	
	@FindBy(xpath="//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/label[1]/input[1]")
	private WebElement billingDetailsCheckboxButton;
	
	@FindBy(xpath="//input[@id='button-guest']")
	private WebElement billingDetailsContinueButton;
	
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	private WebElement deliveryMethodContinueButton;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement termsAndConditionCheckbox;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	private WebElement paymentMethodContinueButton;
	
	
	@FindBy(xpath="//input[@id='button-confirm']")
	private WebElement confirmOrderContinueButton;
	
	
	@FindBy(xpath="//h1[contains(text(),'Your order has been placed!')]")
	private WebElement orderPlacedSuccessfullMessage;
	
	

    public void clickOnAddtoCart() {
    	addCart.click();
}
    public String displaySpecificationPage() {
    	return specificationPage.getText();
    }
    
    public void clickOnAddtoCartOnSpecificationPage() throws InterruptedException {
    	Thread.sleep(2000);
    	addCartOnSpecificationPage.click();
}
    public String addtoCartSuccessfullMessage() throws InterruptedException {
    	Thread.sleep(2000);
    	return successfullMessage.getText();
}
    public void clickOnCheckoutLink() {
    	checkoutLink.click();
}
    public String displayCheckoutPage() {
    	return checkoutPage.getText();
}
    public void clickOnGuestCheckoutButton() {
    	selectGuestCheckoutButton.click();
    	
}
    
    public void clickOnGuestCheckoutContinueButton() {
    	guestCheckoutContinueButton.click();
    	
}
    public void enterFirstName(String firstName) {
    	firstNameField.sendKeys(firstName);
}
    public void enterLastName(String lastName) {
    	lastNameField.sendKeys(lastName);
}
    
    public void enterEmail(String email) {
    	emailField.sendKeys(email);
}
    
    public void enterTelephoneNumber(String telephoneNumber) {
    	telephoneField.sendKeys(telephoneNumber);
}
    
    public void enterAddress1(String address1) {
    	address1Field.sendKeys(address1);
}
    public void enterCity(String city) {
    	cityField.sendKeys(city);
}
    
    public void enterPostCode(String postcode) {
    	postCodeField.sendKeys(postcode);
}
    public void enterCountry(String country) {
    	Select select = new Select(countryField);
    	select.selectByVisibleText("India");
    	
}
    
    public void enterState(String state) {
    	Select select = new Select(stateField);
    	select.selectByVisibleText("Karnataka");
}
    
    public void enterPassword(String password) {
    	passwordField.sendKeys(password);
}
    
    public void enterConfirmPassword(String confirmpassword ) {
    	confirmPasswordField.sendKeys(confirmpassword);
}
    
    public void clickOnNewsLetterCheckbox() {
    	newsLetterCheckboxField.click();
    }
    
    public void clickOnbillingDetailsCheckboxButton() throws InterruptedException {
    	Thread.sleep(2000);
    	billingDetailsCheckboxButton.click();
}
    
    
    
    public void clickOnbillingDetailsContinueButton() throws InterruptedException {
    	Thread.sleep(2000);
    	billingDetailsContinueButton.click();
}
    
    public void clickOnDeliveryMethodContinueButton() {
    	deliveryMethodContinueButton.click();
}
    
    public void clickOntermsAndConditionCheckbox() {
    	termsAndConditionCheckbox.click();
}
    
    public void clickOnpaymentMethodContinueButton() {
    	paymentMethodContinueButton.click();
}
    
    public void clickOnconfirmOrderContinueButton() {
    	confirmOrderContinueButton.click();
}
    
    public String displayOrderPlacedSuccessfullMessage() {
    	return orderPlacedSuccessfullMessage.getText();
}
    
	
}
