package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHpProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatching;
	
	
	
	public String displayStatusOfValidProduct() {
		return validHpProduct.getText();
	}
	
	public String displayStatusProductNotMatching() {
		return noProductMatching.getText();
	}
}


