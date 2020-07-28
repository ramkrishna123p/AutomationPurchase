package com.test.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.test.qa.base.TestBase;
import com.test.qa.pages.HomePage;


public class HomePageTest extends TestBase{
	public HomePage hm;
	public static Logger log = Logger.getLogger(HomePageTest.class);
	public HomePageTest(){
		super();
	}
	
	@BeforeTest
	public void setup(){
		intilization();
	 hm=new HomePage();
	}
	
	@Test(priority=0)
	public void verifyHomePageTitleTest(){
		String title=hm.verifyHomePageTitle();
		log.info("The title of the page"+"...."+title);
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority=1)
	public void verifyHomePageImgTest(){
		boolean b=hm.verifyImagePresent();
		Assert.assertEquals(true, b);
	}
	
	@Test(priority=2)
	public void verifyContactLinkHomePageTest() throws IOException{
	    log.info("checking Contact link in the home page");
		boolean t=hm.verifyContactLinkHomePage();
		Assert.assertEquals(true, t);
	}
	
	
	@Test(priority=3)
	public void verifySigninLinkHomePageTest(){
		boolean p=hm.verifySigninLinkHomePage();
		Assert.assertEquals(true, p);
	}
	
	@AfterTest
	public void EndTest(){
		hm.quit();
		}

}
