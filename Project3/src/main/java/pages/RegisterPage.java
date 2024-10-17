package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//label[@class='radio-inline']/child::input[@value=1]")
	private WebElement newsletterYesOption;
	
	@FindBy(xpath="//div[@id='account-register']/div[1]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//div[@id='account-register']/div[1]")
	private WebElement duplicateEmailWarningMessage;
	
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement EmailAddressWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneNumberWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void entertelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void selectPrivacyPolicy() {
		privacyPolicyOption.click();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public void selectYesNewsletterOptions() {
		newsletterYesOption.click();
	}
	
	public String displaywarningMeassage() {
		return warningMessage.getText();
	}
	
	public String displayDuplicateEmailWarningMeassage() {
		return duplicateEmailWarningMessage.getText();
	}
	
	public String displayFirstNamewarning() {
		return firstNameWarning.getText();
	}
	
	public String displayLastNamewarning() {
		return lastNameWarning.getText();
	}
	
	public String displayEmailwarning() {
		return EmailAddressWarning.getText();
	}
	
	public String displayTelephoneNumberwarning() {
		return telephoneNumberWarning.getText();
	}
	
	public String displayPasswordwarning() {
		return passwordWarning.getText();
	}
	
}