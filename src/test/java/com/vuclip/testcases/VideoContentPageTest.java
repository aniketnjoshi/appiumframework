package com.vuclip.testcases;

import org.testng.annotations.Test;

import com.vuclip.pages.VideoContentPage;
import com.vuclip.utility.Init;
import com.vuclip.utility.eventLogger;

public class VideoContentPageTest extends Init{
	
	@Test(groups= {"DownloadVideo"},dependsOnGroups = {"CheckAppInstall","SearchVideoByName","SelectSearchedVideo"},priority=4)
	public void DownloadVideoTest() throws Exception
	{
		try
		{
			eventLogger.startTestCase("Download video");
			VideoContentPage videoContentPage = new VideoContentPage(driver);
			videoContentPage.DownloadVideo(10);
			eventLogger.endTestCase("Download video");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}

	@Test(groups= {"PlayVideo"},dependsOnGroups= {"CheckAppInstall","SearchVideoByName","SelectSearchedVideo","DownloadVideo"},priority=5)
	public void PlayVideo() throws Exception
	{
		try
		{
			eventLogger.startTestCase("Play video");
			VideoContentPage videoContentPage = new VideoContentPage(driver);
			videoContentPage.PlayDownloadedVideo(1);
			
			eventLogger.endTestCase("Play video");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}
	
}
