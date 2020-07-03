package com.test.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	public HomePage hm;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		intilization();
	 hm=new HomePage();
	}
	
	@Test(priority=0)
	public void verifyHomePageTitleTest(){
		String title=hm.verifyHomePageTitle();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority=1)
	public void verifyHomePageImgTest(){
		boolean b=hm.verifyImagePresent();
		Assert.assertEquals(true, b);
	}
	
	@Test(priority=2)
	public void verifyContactLinkHomePageTest(){
		boolean t=hm.verifyContactLinkHomePage();
		Assert.assertEquals(true, t);
	}
	
	@Test(priority=3)
	public void verifySigninLinkHomePageTest(){
		boolean p=hm.verifySigninLinkHomePage();
		Assert.assertEquals(true, p);
	}
	
	@AfterMethod
	public void EndTest(){
		hm.quit();
	}

}
