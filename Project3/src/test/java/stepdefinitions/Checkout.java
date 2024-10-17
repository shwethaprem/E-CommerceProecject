package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchResultPage;

public class Checkout {

	
	WebDriver driver;
	private CheckoutPage checkoutPage;
	private HomePage homePage;
	
	@Given("Open the Application")
	public void user_opens_the_application() {
	    
		driver = DriverFactory.getDriver();
	}

	@When("Enter valid product {string} into search field")
	public void enter_valid_product_into_search_field(String validproduct) {
		
	    homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validproduct);
		
	
	}

	@When("Click on Search button")
	public void click_on_search_button() {
	  
		homePage.clickOnSearchButton();
	}

	@Then("Product should get displayed in search results")
	public void product_should_get_displayed_in_search_results() {
	   
		SearchResultPage searchPage = new SearchResultPage(driver);
		Assert.assertEquals("HP LP3065",searchPage.displayStatusOfValidProduct());
	}

	
	@When("Click on the Add to cart button")
	public void click_on_the_add_to_cart_button() {
		checkoutPage = new CheckoutPage(driver);
	  checkoutPage.clickOnAddtoCart();
	}

	@Then("Verify specification page get displayed")
	public void verify_specification_page_get_displayed() {
		checkoutPage =new CheckoutPage(driver);
		Assert.assertEquals("HP LP3065",checkoutPage.displaySpecificationPage());
		
	}

	@When("Click on the Add to cart button on specification page")
	public void click_on_the_add_to_cart_button_on_specification_page() throws InterruptedException {
		checkoutPage =new CheckoutPage(driver);
		
		checkoutPage.clickOnAddtoCartOnSpecificationPage();
		
	}

	@Then("Check valid message is displayed after adding to the cart")
	public void check_valid_message_is_displayed_after_adding_to_the_cart() throws InterruptedException {
		checkoutPage =new CheckoutPage(driver);
		String mess = checkoutPage.addtoCartSuccessfullMessage();
		System.out.println(mess);
		
	}

	@When("Click on the Checkout link")
	public void click_on_the_checkout_link() throws InterruptedException {
		checkoutPage =new CheckoutPage(driver);
		checkoutPage.clickOnAddtoCartOnSpecificationPage();
		checkoutPage.clickOnCheckoutLink();
	    }

	@Then("Verify Checkout page gets displayed succesfully")
	public void verify_checkout_page_gets_displayed_succesfully() {
		checkoutPage =new CheckoutPage(driver);
		checkoutPage.displayCheckoutPage();
	}
	

	@When("User select on Guest Checkout in Step1:Checkout Options")
	public void user_select_on_guest_checkout_in_step1_checkout_options() throws InterruptedException {
		/*checkoutPage =new CheckoutPage(driver);
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validproduct);
		homePage.clickOnSearchButton();
		checkoutPage.clickOnAddtoCart();
		checkoutPage.clickOnAddtoCartOnSpecificationPage();
		checkoutPage.clickOnCheckoutLink(); */
	
		
		checkoutPage.clickOnGuestCheckoutButton();
	}

	@And("Click on continue button")
	public void click_on_continue_button() {
		checkoutPage =new CheckoutPage(driver);
		checkoutPage.clickOnGuestCheckoutContinueButton();
	}

	@And("Step2:Billing details section pop ups and User enters below details into the fields")
	public void step2_billing_details_section_pop_ups_and_user_enters_below_details_into_the_fields(DataTable dataTable) throws InterruptedException {
		
		
	
			Map<String, String> map = dataTable.asMap(String.class, String.class);
			
			checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterFirstName(map.get("firstname"));
			checkoutPage.enterLastName(map.get("lastname"));
			checkoutPage.enterEmail(map.get("email"));
			checkoutPage.enterTelephoneNumber(map.get("telephone"));
			checkoutPage.enterAddress1(map.get("address1"));
			checkoutPage.enterCity(map.get("city"));
			checkoutPage.enterPostCode(map.get("postcode"));
			checkoutPage.enterCountry(map.get("country"));
			checkoutPage.enterState(map.get("region/state"));
			
			
	}

	@And("Select on checkbox and click on continue button")
	public void select_on_checkbox_and_click_on_continue_button() throws InterruptedException {
		checkoutPage =new CheckoutPage(driver);
		
		
		checkoutPage.clickOnbillingDetailsContinueButton();
	}

	@And("Step4:Delivery Method section pop ups and Click on continue button")
	public void step4_delivery_method_section_pop_ups() {
		checkoutPage =new CheckoutPage(driver);
		checkoutPage.clickOnDeliveryMethodContinueButton();
	}

	@And("Step5: Payment Method section pop ups and Click on Terms and Condition Checkbox")
	public void step5_payment_method_section_pop_ups() {
		checkoutPage =new CheckoutPage(driver);
		checkoutPage.clickOntermsAndConditionCheckbox();
		
	}

	@And("Click on payment method continue button")
	public void click_on_payment_method_continue_button() {
		checkoutPage =new CheckoutPage(driver);
		checkoutPage.clickOnpaymentMethodContinueButton();
	}

	@And("Step6:Confirm Order section pop ups and Click on confirm order button")
	public void step6_confirm_order_section_pop_ups() {
		checkoutPage =new CheckoutPage(driver);
		checkoutPage.clickOnconfirmOrderContinueButton();
	}


	@Then("Successfull message should be displayed")
	public void successfull_message_should_be_displayed() {
		
		checkoutPage =new CheckoutPage(driver);
		
		Assert.assertEquals("Your order has been placed!",checkoutPage.displayOrderPlacedSuccessfullMessage());
	    
	}

}
