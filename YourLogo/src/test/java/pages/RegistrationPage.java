package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class RegistrationPage {
	
WebDriver driver;
	
	@FindBy(xpath = "//input[@name='firstName']") WebElement firsttxtbx;
	@FindBy(xpath = "//input[@name='lastName']") WebElement lasttxtbx;
	@FindBy(xpath = "//input[@name='phone']") WebElement phonetxtbx;
	@FindBy(xpath = "//input[@id='userName']") WebElement useNametxtbx;
	@FindBy(xpath = "//input[@name='address1']") WebElement address1txtbx;
	@FindBy(xpath = "//input[@name='address2']") WebElement address2txtbx;
	@FindBy(xpath = "//input[@name='city']") WebElement citytxtbx;
	@FindBy(xpath = "//input[@name='state']") WebElement statetxtbx;
	@FindBy(xpath = "//input[@name='postalCode']") WebElement postcodetxtbx;
	@FindBy(xpath = "//select[@name='country']") WebElement countrytxtbx;
	@FindBy(xpath = "//input[@id='email']") WebElement emailtxtbx;
	@FindBy(xpath = "//input[@name='password']") WebElement passwordtxtbx;
	@FindBy(xpath = "//input[@name='confirmPassword']") WebElement confirmpasswordtxtbx;
	@FindBy(xpath = "//input[@name='register']") WebElement registrationbtn;
	@FindBy(xpath = "//b[contains(text(),'Note: Your user name is')]") WebElement registeredUsername;
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setfirstName(String firstName) {
		firsttxtbx.sendKeys(firstName);
	}
	public void setlastName(String lastName) {
		lasttxtbx.sendKeys(lastName);
	}
	public void setphone(String phone) {
		phonetxtbx.sendKeys(phone);
	}
	public void setuserName(String userName) {
		useNametxtbx.sendKeys(userName);
	}
	public void setaddress1(String address1) {
		address1txtbx.sendKeys(address1);
	}
	public void setaddress2(String address2) {
		address2txtbx.sendKeys(address2);
	}
	public void setcity(String city) {
		citytxtbx.sendKeys(city);
	}
	public void setstate(String state) {
		statetxtbx.sendKeys(state);
	}
	public void setpostalCode(String postalCode) {
		postcodetxtbx.sendKeys(postalCode);
	}
	public void setcountry(String country) {
		countrytxtbx.click();
		Select sel = new Select(countrytxtbx);
		sel.selectByVisibleText(country);
		
	}
	public void setemail(String email) {
		emailtxtbx.sendKeys(email);
	}
	public void setpassword(String password) {
		passwordtxtbx.sendKeys(password);
	}
	public void setconfirmPassword(String confirmPassword) {
		confirmpasswordtxtbx.sendKeys(confirmPassword);
	}
	public void clickregister() {
		registrationbtn.click();
	}
	public void registration(String firstName,String lastName,String phone,String userName,String address1,String address2,String city,
			String state,String post,String country,String email,String password,String confirmPassword) {
		
		String expUrl = "http://newtours.demoaut.com/create_account_success.php";
		this.setfirstName(firstName);
		this.setlastName(lastName);
		this.setphone(phone);
		this.setuserName(userName);
		this.setaddress1(address1);
		this.setaddress2(address2);
		this.setcity(city);
		this.setstate(state);
		this.setpostalCode(post);
		this.setcountry(country);
		this.setemail(email);
		this.setpassword(password);
		this.setconfirmPassword(confirmPassword);
		this.clickregister();
		
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		Assert.assertEquals(expUrl, actualUrl);
		
		String ExpecSuccessUser = "Note: Your user name is " +userName+"." ;
		
		String ActualRegSuccessUser= registeredUsername.getText();
		System.out.println(ActualRegSuccessUser);
		Assert.assertEquals(ExpecSuccessUser, ActualRegSuccessUser);

		
			}
	
}

