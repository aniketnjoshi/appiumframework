package com.vuclip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.vuclip.utility.Services;
import com.vuclip.utility.eventLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SearchResultPage extends Services{

	
	String SearchResultTextBox = "com.vuclip.viu:id/search_box";
	String CloseSearch = "com.vuclip.viu:id/search_close";
	String SearchResultContainer = "com.vuclip.viu:id/viu_search_container";
	String EpisodeName = "com.vuclip.viu:id/v_detail_episode_name";
	String ResultGridView = "com.vuclip.viu:id/grid_view";
	WebElement SearchResultContent = null;
	
	
	public SearchResultPage(AppiumDriver<WebElement> driver) {
		super(driver);
	}
	
	public SearchResultPage SearchResultSelectVideobyName(String VideoName) throws Exception
	{
		try
		{
			waitForElementByID(SearchResultContainer);
			driver.findElementByAccessibilityId(VideoName).click();
		    Assert.assertTrue(true);
			return this;
			
		}
		catch(Exception ex)
		{
			eventLogger.error(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}
	
}
