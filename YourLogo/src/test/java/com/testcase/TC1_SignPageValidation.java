package com.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.drivers.DriverClass;
import com.pages.HomePage;
import com.utils.SeleniumUtils;

@Listeners(com.utils.ListenerTest.class)
public class TC1_SignPageValidation {

	WebDriver driver;
	static DriverClass driverclass = new DriverClass();
	static SeleniumUtils selUtil = new SeleniumUtils();
	static HomePage homepage;
	
	@BeforeMethod
	public void intialSetup() {
		
		driver= driverclass.launchDriver();
		selUtil.EnterUrl(driver, "http://automationpractice.com/");
	}
	
	@Test
	public void signPageDisplayed() {
		homepage = new HomePage(driver);
		homepage.clickSign();
		String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String actualUrl = driver.getCurrentUrl();
		selUtil.validatePageUrl(driver,expectedUrl, actualUrl);
	}
	
	@AfterMethod
	public void testend() {
		selUtil.endRun(driver);
	}
	
	
}
