package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Searchstep {
	
	WebDriver driver;
	private HomePage homePage;

	@Given("User opens the Application")
	public void user_opens_the_application() {
	    
		driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search field")
	public void user_enters_valid_product_into_search_field(String validproduct) {
		
	    homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validproduct);
		
	
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	  
		homePage.clickOnSearchButton();
	}

	@Then("Valid Product should get displayed in search results")
	public void valid_product_should_get_displayed_in_search_results() {
	   
		SearchResultPage searchPage = new SearchResultPage(driver);
		Assert.assertEquals("HP LP3065",searchPage.displayStatusOfValidProduct());
	}

	@When("User enters non-existing product {string} into search field")
	public void user_enters_non_existing_product_into_search_field(String invalidProduct) {
	   
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProduct);
		
	}

	@Then("Proper text informing the user about no product matching should be displayed")
	public void proper_text_informing_the_user_about_no_product_matching_should_be_displayed() {
	   
		SearchResultPage searchPage = new SearchResultPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.",searchPage.displayStatusProductNotMatching());
	}

	@When("User dont enter any product into search field")
	public void user_dont_enter_any_product_into_search_field() {
	   
		homePage = new HomePage(driver);
		//kept blank
	}


}
