package com.vuclip.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.vuclip.utility.Services;
import com.vuclip.utility.eventLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class VideoContentPage extends Services{

	String VideoName = "com.vuclip.viu:id/v_detail_episode_name";
	String DownloadVideoLink = "com.vuclip.viu:id/multi_image_view";
	String VideoRunTime = "com.vuclip.viu:id/episode_runtime";
	String VideoHDSize = "com.vuclip.viu:id/v_detail_hd_size";
	String VideoSDSize = "com.vuclip.viu:id/v_detail_sd_size";
	String VideoSDDownload = "com.vuclip.viu:id/tv_low";
	String DownloadVideoState = "com.vuclip.viu:id/v_detail_download_time_left";
	String PlayVideo = "com.vuclip.viu:id/iv_yes";
	String DownloadStatus = "com.vuclip.viu:id/v_detail_download_time_left";
	
	
	public VideoContentPage(AppiumDriver<WebElement> driver) {
		super(driver);
	}
	
	public boolean DownloadVideo(int DownloadWaitTimeInMin) throws Exception
	{
		try
		{
			waitForElementByID(VideoName);
			eventLogger.debug("Downloading video.");
			driver.findElement(By.id(DownloadVideoLink)).click();
			driver.findElement(By.id(VideoSDDownload)).click();
			String DownloadStatus = driver.findElement(By.id(DownloadVideoState)).getText();
			
			
			int DownloadWaitCounter = DownloadWaitTimeInMin;		
			while(DownloadWaitCounter>0)
			{
				System.out.println("Download Status in % - "+ DownloadStatus);
				eventLogger.debug("current download status - "+ DownloadStatus);
				
				if(CheckDownloadCompletion())
				{
					Assert.assertTrue(true);
					return true;
				}
				eventLogger.debug("waiting for 1 min");
				TimeUnit.MINUTES.sleep(1);
				DownloadWaitCounter--;
				eventLogger.debug("download not completed yet");
			}
			
			Assert.assertTrue(false);
			return false;
		}
		catch(Exception ex)
		{
			eventLogger.error(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}
	
	
	private boolean CheckDownloadCompletion() throws Exception
	{
		try
		{
			/*if(checkCurrentDownloadStatus())
			{
				
			}	*/			
			
			WebElement CompletionStatus = driver.findElementByAccessibilityId("SUCCESSFUL");
			if(CompletionStatus!=null)
			{
				return true; // returning false as downloading is still in progress
			}
			
			return false;
		}
		catch(NoSuchElementException ex)
		{
			return false;
		}
		catch(Exception ex)
		{
			eventLogger.error(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}
	
	private boolean checkCurrentDownloadStatus() throws Exception
	{
		try
		{
			String CurrentStatus = driver.findElement(By.id(DownloadStatus)).getText();
			eventLogger.debug("Current download status - "+ CurrentStatus);
			return false;
		}
		catch(NoSuchElementException ex)
		{
			return true;
		}
		catch(Exception ex)
		{
			eventLogger.error(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
		
	}
	
	public void PlayDownloadedVideo(int timeInMin)throws Exception
	{
		try
		{
			if(CheckDownloadCompletion())
			{
				driver.findElement(By.id(DownloadVideoLink)).click();
				driver.findElement(By.id(PlayVideo)).click();
				
				Assert.assertTrue(true);
				TimeUnit.MINUTES.sleep(timeInMin);
				return;
			}
			else
			{
				Assert.assertTrue(false,"Test case failed as video download is not successfull.");
			}
		}
		catch(Exception ex)
		{
			eventLogger.error(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}
}
