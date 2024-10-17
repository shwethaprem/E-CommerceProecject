package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccesspage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Registerstep {
	
	WebDriver driver;
	private RegisterPage registerPage;
	
	@Given("User navigate to Register Account page")
	public void user_navigate_to_register_account_page() {
	    
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();
		
	}
	
	
	@When("User enters below details into the fields")
	public void User_enters_below_details_into_the_fields(DataTable datatable ) {
		Map<String, String> map = datatable.asMap(String.class, String.class);
		
	    registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(map.get("firstname"));
		registerPage.enterLastName(map.get("lastname"));
		registerPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
		registerPage.entertelephone(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("confirmpassword"));
		
	}
	
	@When("User enters below details into the fields with duplicate email")
	public void User_enters_below_details_into_the_fields_with_duplicate_email(DataTable datatable ) {
		Map<String, String> map = datatable.asMap(String.class, String.class);
		
		registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(map.get("firstname"));
		registerPage.enterLastName(map.get("lastname"));
		registerPage.enterEmailAddress(map.get("email"));
		registerPage.entertelephone(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("confirmpassword"));
		
	}

	@And("Selects Privacy Policy field")
	public void selects_privacy_policy_field() {
		
		registerPage.selectPrivacyPolicy();
	    
	}

	@And("Clicks on Continue button")
	public void clicks_on_continue_button() {

		registerPage.clickContinueButton();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
		
		AccountSuccesspage accountSuccessPage = new AccountSuccesspage(driver);
		Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.displayAccountCreatedMeassage());
	}

	@When("Selects Yes for Newsletter")
	public void selects_yes_for_newsletter() {
	 
		registerPage.selectYesNewsletterOptions();
	}

	@When("User dont enter details into any fields")
	public void user_dont_enter_details_into_any_fields() {
		
		registerPage = new RegisterPage(driver);
	}

	@Then("Warning message should be displayed for all the mandatory fields")
	public void warning_message_should_be_displayed_for_all_the_mandatory_fields() {
		
		registerPage = new RegisterPage(driver);
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",registerPage.displaywarningMeassage());
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.displayFirstNamewarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.displayLastNamewarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.displayEmailwarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.displayTelephoneNumberwarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.displayPasswordwarning());
		
		
	}

	@Then("Warning message informating the user about duplicate email should be displayed")
	public void warning_message_informating_the_user_about_duplicate_email_should_be_displayed() {
		
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerPage.displayDuplicateEmailWarningMeassage());


	}
}
