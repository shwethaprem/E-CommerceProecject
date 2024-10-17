package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesspage {

WebDriver driver;
	
	public AccountSuccesspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement accountCreated;
	
	public String displayAccountCreatedMeassage() {
		return accountCreated.getText();
	}
}
