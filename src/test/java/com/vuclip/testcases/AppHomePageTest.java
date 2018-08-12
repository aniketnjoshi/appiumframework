package com.vuclip.testcases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vuclip.pages.AppHomePage;
import com.vuclip.utility.Init;
import com.vuclip.utility.eventLogger;

public class AppHomePageTest extends Init{
	
	@Test(groups= {"SearchVideoByName"},dependsOnGroups = {"CheckAppInstall"},priority=2)
	@Parameters({ "VideoName" })
	public void SearchVideo(@Optional("Lego Batman Trailer") String VideoName) throws Exception 
	{
		try
		{
			eventLogger.startTestCase("Search Video");
			AppHomePage appHomepage = new AppHomePage(driver);
			appHomepage.SearchVideo(VideoName);	
			eventLogger.endTestCase("Search Video");
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
		
	}

}
