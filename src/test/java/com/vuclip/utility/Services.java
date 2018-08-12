package com.vuclip.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Services {
	
	protected static AppiumDriver<WebElement> driver;

	  public Services(AppiumDriver<WebElement> driver) {
		  Services.driver = driver;
	    }
	
	public static boolean isAppInstalled(String packageName, AppiumDriver<WebElement> driver2)
	{
		try
		{
			return driver2.isAppInstalled(packageName);
		}
		catch(Exception ex)
		{
			
			return false;
		}
		
	}
	public void waitForElementVisible(String locator) {

		eventLogger.debug("waiting for element visible - "+locator);
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementInVisible(String locator) {

    	eventLogger.debug("waiting for element invisible - "+locator);
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }
    
    public void waitForElementByID(String locator) throws Exception{

    	eventLogger.debug("waiting for element by id - "+locator);
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }
}
