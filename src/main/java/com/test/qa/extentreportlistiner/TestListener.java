package com.test.qa.extentreportlistiner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.test.qa.base.TestBase;

public class TestListener extends TestBase implements ITestNGListener{
	private static ExtentReports extent=ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		ExtentTest test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	public void onTestSuccess(ITestResult result) {
		/* String logText="Test Case Passed";
		 Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);*/
		 extentTest.get().log(Status.PASS,"Test Case Passed");  
		
	}
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
	    	try {
				extentTest.get().addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    //String logText="Test Case Failed";
		 //Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		 extentTest.get().log(Status.FAIL, "TestCase Failed"); 
		
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	/*public String takeScreenshot(String methodName) {
		  String fileName = getScreenshotName(methodName);
	      String directory=System.getProperty("user.dir")+"/screenshots/";
	      new File(directory).mkdirs();
	      String path=directory+fileName;
	      try{
	    	  File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	  FileUtils.copyFile(screenshot, new File(path));
	    	  System.out.println("***************************");
	    	  System.out.println("screenshot stored at: "+"..."+path);
	    	  System.out.println("***************************");
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
	      return path;
	}*/

}
