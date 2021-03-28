package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reports.ReportsFiles;

public class SeleniumUtils {

	static ReportsFiles reports;

	public void EnterUrl(WebDriver driver, String url) {
		try {
			driver.get(url);
			String file = this.takeScreenShot(driver);
			reports.pass(file);

		} catch (Exception e) {
			reports.fail();
		}
	}
	
	public Properties getProperty() throws IOException
	{
		FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {        	 
            properties.load(new FileInputStream(".resources/YourLogo.properties"));
         
        } catch (Exception e) {
            System.out.println("Exception: " + e);
       } 
         return properties;
	}
	
	public void startSetup(String TCNAME) {
		reports = new ReportsFiles(TCNAME);
	}

	public void endRun(WebDriver driver) {
		driver.quit();
		
	}
	public void endsuite() {
		reports.reportFlush();
	}

	public void validatePageUrl(WebDriver driver, String expectedUrl, String acutalUrl) {
		try {
			Assert.assertEquals(expectedUrl, acutalUrl);
			String file = this.takeScreenShot(driver);
			reports.pass(file);
		} catch (Exception e) {
			reports.fail();
		}

	}

	public String takeScreenShot(WebDriver driver) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String filename = System.currentTimeMillis() + ".png";
		String des = "./target/Images/" + filename;

		File DestFile = new File(des);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filename;
	}

}
