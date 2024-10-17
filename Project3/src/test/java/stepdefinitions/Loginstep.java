package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Loginstep {
	
	WebDriver driver;
	private LoginPage loginPage;
	
	@Given("^User navigates to Login page$")
	public void user_navigates_to_login_page() {
	    
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
	}

	@When("^User enters the valid email address (.+)$")
	public void user_enters_the_valid_email_address(String email) {
	   
	    loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		
	}

	@When("^Enter the valid password (.+)$")
	public void enter_the_valid_password(String password) {
		
	    loginPage = new LoginPage(driver);
		loginPage.enterPassword(password);
	}

	@When("^Clicks on Login button$")
	public void clicks_on_login_button() {

	    loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
	    
	}

	@Then("^User should logged in successfully$")
	public void user_should_logged_in_successfully() {
		
		AccountPage accountPage = new AccountPage(driver);
	    Assert.assertTrue(accountPage.displayStatusEditYourAccountInformationOption());
	   
	}

	@When("^User enters the invalid email address$")
	public void user_enters_the_invalid_email_address() {
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
		
	}

	@When("^Enter invalid password (.+)$")
	public void enter_invalid_password(String invalidPassword) {
		
		loginPage.enterPassword(invalidPassword);
		
	}

	@Then("^User should get a proper warning message$")
	public void user_should_get_a_proper_warning_message() {
		
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",loginPage.displayWarningMessage());
	}

	@And("^User dont enter email address into email field$")
	public void User_dont_enter_email_address_into_email_field() {
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("");
	}
	
	@And("^User dont enter password into password field$")
	public void User_dont_enter_password_into_password_field() {
		
		loginPage.enterPassword("");
	}
	
	
}
