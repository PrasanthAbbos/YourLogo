package com.reports;

import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.SeleniumUtils;

public class ReportsFiles {
	
	static SeleniumUtils  util = new SeleniumUtils();
	
	static Properties prop;
	
	static ExtentSparkReporter spark;

	static ExtentReports extent = new ExtentReports();
	static ExtentTest logger;
	

	public ReportsFiles(String TCName) {	
		try {
			prop = util.getProperty();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		spark = new ExtentSparkReporter(prop.getProperty("extentreportpath"));
		extent.attachReporter(spark);
		logger = extent.createTest(TCName);
	}
	
	public static void pass(String file) {
		//logger.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");	
		System.out.println(file);
		//logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\target\\Images\\1614455457730.png");
		logger.pass("This is a logging event for MyFirstTest, and it passed!",MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"\\target\\Images\\"+file).build());
	}
	
	public static void fail() {
		logger.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");
		logger.addScreenCaptureFromPath("fail.png");
	}
	
	public static void reportFlush() {
		extent.flush();
	}
	
}
