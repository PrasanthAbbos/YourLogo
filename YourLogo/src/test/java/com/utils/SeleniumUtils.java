package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.reports.ReportsFiles;

public class SeleniumUtils {

	static ReportsFiles reports = new ReportsFiles();

	public void EnterUrl(WebDriver driver, String url) {
		try {
			driver.get(url);
			String file = this.takeScreenShot(driver);
			reports.pass(file);

		} catch (Exception e) {
			reports.fail();
		}
	}

	public void endRun(WebDriver driver) {
		driver.quit();
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
