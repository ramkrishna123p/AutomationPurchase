package com.test.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static Properties props;
	public static WebDriver driver;
	public static final int TIMEOUT=30;
	
	public TestBase(){
		try{
		props=new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/test"
				+ "/qa/config/config.properties");
		props.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void intilization(){
		String browserName=props.getProperty("browser");
		if(browserName.contains("FF")){
			System.setProperty("webdriver.gecko.driver", "E:/geckodriver-v0.24.0-win64/geckodriver.exe");
			driver=new FirefoxDriver();
		} else if(browserName.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"E:/geckodriver-v0.24.0-win64/geckodriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.contains("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"E:/geckodriver-v0.24.0-win64/geckodriver.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}
	
	

}
