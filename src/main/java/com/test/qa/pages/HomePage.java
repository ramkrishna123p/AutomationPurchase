package com.test.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement homePageImg;
	
	@FindBy(xpath="//a[contains(text(),'Contact us')]")
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
	
	public boolean verifyContactLinkHomePage(){
		return contactUsLink.isDisplayed();
	}
	
	public boolean verifySigninLinkHomePage(){
		return signInLink.isDisplayed();
	}
	
	public void quit(){
		driver.quit();
	}
}
