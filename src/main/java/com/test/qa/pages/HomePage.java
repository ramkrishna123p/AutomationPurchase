package com.test.qa.pages;

import java.io.IOException;

import org.apache.http.util.ExceptionUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;
import com.test.qa.testutil.Utility;

public class HomePage extends TestBase {

	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement homePageImg;
	
	@FindBy(xpath="//a[contains(text(),'abc Contact us')]")
	WebElement contactUsLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signInLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyImagePresent(){
	return homePageImg.isDisplayed();
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyContactLinkHomePage() throws IOException{
		try{
			return contactUsLink.isDisplayed();
		}catch(NoSuchElementException e){
			Utility.takeScreenshotAtEndOfTest();
		e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean verifySigninLinkHomePage(){
		return signInLink.isDisplayed();
	}
	
	public void quit(){
		driver.quit();
	}
}
