package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFiles {
	static ExtentReports extent;
	static ExtentTest test;
	static ExtentSparkReporter spark;
	public ExtentReportFiles(String TCName){
		 extent = new ExtentReports();
		 spark = new ExtentSparkReporter("./target/extentReports/Spark.html");
		 test  = extent.createTest(TCName);
	}
	
	public void Pass(String desc) {
		test.log(Status.PASS, desc);
	}
	
	public void Fail(String desc) {
		test.log(Status.FAIL, desc);
	}
	
	
	public void flushReport() {
		extent.flush();
	}
}
