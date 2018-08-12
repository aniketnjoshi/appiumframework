package com.vuclip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.vuclip.utility.Services;
import com.vuclip.utility.eventLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AppHomePage extends Services{

	String SearchButton = "com.vuclip.viu:id/iv_search";
	String SearchTextBox = "com.vuclip.viu:id/search_box";
	String SearchIcon = "com.vuclip.viu:id/search_icon";
	
	public AppHomePage(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	public AppHomePage SearchVideo(String VideoName) throws Exception
	{
		try
		{
			waitForElementByID(SearchButton);
			
			eventLogger.debug("Searching video - "+ VideoName);
			
			driver.findElement(By.id(SearchButton)).click();
			driver.findElement(By.id(SearchTextBox)).sendKeys(VideoName);
			driver.findElement(By.id(SearchIcon)).click();
			String ActualVideoName = driver.findElement(By.id(SearchTextBox)).getText();
			if(ActualVideoName.equals(VideoName))
			{
				eventLogger.debug("video name matching");
			}
			else
			{
				eventLogger.debug("video name not matching");
			}
			
			Assert.assertEquals(ActualVideoName, VideoName,"Video name is not matching as per the provided");
			return this;
		}
		catch(Exception ex)
		{
			eventLogger.error(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
		
	}
	
	
}
