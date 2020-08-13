package com.test.qa.extentreportlistiner;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	   public static ExtentReports extent;
	   public static ExtentSparkReporter reporter;
	   public static ExtentTest test;

	/*    public static ExtentReports getInstance() {
		        if (extent == null) {
		            extent = createInstance();
		        }
		        return extent;
		    }*/

		    public static ExtentReports createInstance() {
		        String fileName = getReportName();
		        String directory=System.getProperty("user.dir");
		        System.out.println(directory);
		        new File(directory).mkdirs();
		        String path=directory+fileName;
		        reporter = new ExtentSparkReporter(path);
		        //reporter.config().setEncoding("utf-8");
		        reporter.config().setDocumentTitle("Test Results");
		        reporter.config().setReportName("Automation Test Results");
		       //reporter.config().setTheme(Theme.DARK);
		        extent = new ExtentReports();
		        extent.attachReporter(reporter);
		        extent.setSystemInfo("Tester", "RamKrishna");
		        extent.setSystemInfo("Browser", "Chrome");
		        return extent;
		    }

		     public static String getReportName() {
			    Date d=new Date();
			    String fileName="AutomationReport_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
			    return fileName; 
			} 

			public static void quitExtent() {
		        extent.flush();
		        extent = null;
		    }
}
