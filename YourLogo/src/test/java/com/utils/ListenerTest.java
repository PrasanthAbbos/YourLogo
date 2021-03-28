package com.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{
	


	 public  void onTestSuccess(ITestResult result) {
	    // not implemented
		 
	  }

	  public void onTestFailure(ITestResult result) {
	    // not implemented
	  }

	
	 
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	

	  public void onFinish(ITestContext context) {
	    // not implemented
	  }
}
