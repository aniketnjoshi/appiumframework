package com.vuclip.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Init{

	  protected static AppiumDriver<WebElement> driver = null;
	  Properties prop = new Properties();
	  public static Logger logWriter = Logger.getLogger(Init.class.getName());
	  InputStream input = null;
	  Map<String, String> LanguageIds = new HashMap<String, String>();
	  public static ExtentReports reports;
	  public static ExtentTest testInfo;
	  ExtentHtmlReporter htmlReporter;
	  
	  /**
	     * This function is used for doing web driver setup.
	     * @throws Exception 
	     */
	    @BeforeSuite(alwaysRun = true)
	    public void setUp() throws Exception {
	        try
	        {
		    	System.out.println("*** Setup ***");		    	
		    	input = new FileInputStream("src/main/resources/config.properties");
				// load a properties file
				prop.load(input);
				
			    htmlReporter = new ExtentHtmlReporter(new File("automationReport.html"));
			    reports = new ExtentReports();
			    reports.attachReporter(htmlReporter);
			    
			    String appFilePath = System.getProperty("user.dir")+"\\"+prop.getProperty("apppath").replace("\"", "");
				String deviceName = prop.getProperty("devicename").replace("\"", "");
				String appiumServerURL = prop.getProperty("appiumserverurl").replace("\"", "");
				String language = prop.getProperty("language").replace("\"", "");
				System.out.println("Application file path = "+appFilePath);
				System.out.println("Device Name = "+deviceName);
				System.out.println("Appium server URL = "+appiumServerURL);
				eventLogger.debugInit("Application file path = "+appFilePath);
				eventLogger.debugInit("Device Name = "+deviceName);
				eventLogger.debugInit("Appium server URL = "+appiumServerURL);
				
		        PopulateLanguageSupported();
						        
		   
		        
		        //Driver initialization
		        DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
					
				cap.setCapability(MobileCapabilityType.APP, appFilePath);
				cap.setCapability("appPackage", "com.vuclip.viu");
				cap.setCapability("appActivity", "com.vuclip.viu.ui.screens.MainActivity");
				cap.setCapability("newCommandTimeout", 60 * 5);
				
				driver = new AndroidDriver<WebElement>(new URL(appiumServerURL), cap);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				
				//Language selection
				
				if(language.toLowerCase().equals("hindi"))
				{
					if(driver.findElement(By.id(LanguageIds.get("hindi"))).getSize()!=null)
					{
						driver.findElement(By.id(LanguageIds.get("hindi"))).click();
					}
				}
				
				if(language.toLowerCase().equals("telgu"))
				{
					if(driver.findElement(By.id(LanguageIds.get("telgu"))).getSize()!=null)
					{
						driver.findElement(By.id(LanguageIds.get("telgu"))).click();
					}
				}
				
				if(language.toLowerCase().equals("tamil"))
				{
					if(driver.findElement(By.id(LanguageIds.get("tamil"))).getSize()!=null)
					{
						driver.findElement(By.id(LanguageIds.get("tamil"))).click();
					}
				}
				
				if(language.toLowerCase().equals("korean"))
				{
					if(driver.findElement(By.id(LanguageIds.get("korean"))).getSize()!=null)
					{
						driver.findElement(By.id(LanguageIds.get("korean"))).click();
					}
				}
				
		    }
	        catch(Exception ex)
	        {
	        	eventLogger.error(ex.getMessage()+ex.getStackTrace());
	        	throw ex;
	        }
	        
	    }
	    
	    private void PopulateLanguageSupported()
	    {
	    	LanguageIds.put("hindi", "com.vuclip.viu:id/internal_layout_1");
	    	LanguageIds.put("telgu", "com.vuclip.viu:id/internal_layout_2");
	    	LanguageIds.put("tamil", "com.vuclip.viu:id/internal_layout_3");
	    	LanguageIds.put("korean", "com.vuclip.viu:id/internal_layout_4");
	    }

	   
	 
	    @AfterSuite(alwaysRun = true)
	    public void teardown() {
	        System.out.println("*** Teardown ***");
	        if (driver != null)
	            driver.quit();

	        reports.flush();
	    }

	 	    
	    @AfterTest
	    public void captureStatus()
	    {
	    	ITestResult testngResult=Reporter.getCurrentTestResult();
	    	if(testngResult.getStatus()==ITestResult.SUCCESS)
	    	{
	    		testInfo.log(Status.PASS , "Test execution successful - "+testngResult.getName());
	    	}
	    	else if(testngResult.getStatus()==ITestResult.FAILURE)
	    	{
	    		testInfo.log(Status.PASS , "Test execution Failed - "+testngResult.getName());
	    	}
	    	
	     }
	

}
