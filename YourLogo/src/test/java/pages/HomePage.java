package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(name = "userName") WebElement usernametxtbx;
	@FindBy(name = "password") WebElement passwordtxtbx;
	@FindBy(name = "login") WebElement SignBtn;
	@FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]") WebElement SignOffLink;
	@FindBy(xpath = "//a[contains(text(),'REGISTER')]") WebElement RegistrerLink;
	@FindBy(xpath = "//a[contains(text(),'SUPPORT')]") WebElement SupportLink;
	@FindBy(xpath = "//a[contains(text(),'CONTACT')]") WebElement ContactLink;
	@FindBy(xpath = "//a[contains(text(),'Home')]") WebElement HomeLink;
	@FindBy(xpath = "//a[contains(text(),'Flights')]") WebElement FlightsLink;
	@FindBy(xpath = "//a[contains(text(),'Hotels')]") WebElement HotelsLink;
	@FindBy(xpath = "//a[contains(text(),'Car Rentals')]") WebElement CarRentalsLink;
	@FindBy(xpath = "//a[contains(text(),'Cruises')]") WebElement CruisesLink;
	@FindBy(xpath = "//a[contains(text(),'Destinations')]") WebElement DestinationsLink;
	@FindBy(xpath = "//a[contains(text(),'Vacations')]") WebElement VacationsLink;
	
	
	public HomePage(WebDriver driver) {		
		this.driver = driver;		
		PageFactory.initElements(driver, this);		
	}
	
	public void setUsername(String usrname) {
		usernametxtbx.sendKeys(usrname);
	}
	
	public void setPassword(String pwd) {
		passwordtxtbx.sendKeys(pwd);
	}
	
	public void clicSignup() {
		SignBtn.click();
	}
	
	public void SignUp(String usr,String pwd) {
		this.setUsername(usr);
		this.setPassword(pwd);
		this.clicSignup();
	}
}
