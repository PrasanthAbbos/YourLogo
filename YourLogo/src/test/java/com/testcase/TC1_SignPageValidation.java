package com.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.drivers.DriverClass;
import com.pages.HomePage;
import com.utils.ExtentReportFiles;
import com.utils.SeleniumUtils;

//@Listeners(com.utils.ListenerTest.class)
public class TC1_SignPageValidation {

	WebDriver driver;
	static DriverClass driverclass = new DriverClass();
	static SeleniumUtils selUtil = new SeleniumUtils();
	static HomePage homepage;
	static ExtentReportFiles ext;
	
	@BeforeMethod
	public void intialSetup() {
		//ext = new ExtentReportFiles("TC1_SignPageValidation");
		selUtil.startSetup("TC1_SignPageValidation");
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
		ext.Pass("Succssfully page validated");
	}
	@Test
	public void signPageDisplayed2() {
		homepage = new HomePage(driver);
		homepage.clickSign();
		String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String actualUrl = driver.getCurrentUrl();
		selUtil.validatePageUrl(driver,expectedUrl, actualUrl);
		ext.Pass("Succssfully page validated");
	}
	
	@AfterClass
	public void testend() {
		selUtil.endRun(driver);
		//ext.flushReport();
	}
	
	
}
