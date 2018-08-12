package com.vuclip.testcases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vuclip.pages.SearchResultPage;
import com.vuclip.utility.Init;
import com.vuclip.utility.eventLogger;

public class SearchResultPageTest extends Init{

	//@Test(dependsOnMethods={"com.vuclip.testcases.AppHomePageTest.SearchVideo"},priority=3)
	@Test(groups= {"SelectSearchedVideo"},dependsOnGroups = {"CheckAppInstall","SearchVideoByName"},priority=3)
	@Parameters({"VideoName"})
	public void SelectVideoByNameTest(@Optional("Lego Batman Trailer") String VideoName) throws Exception
	{
		try
		{
			eventLogger.startTestCase("Search video by Name");
			SearchResultPage searchResultPage = new SearchResultPage(driver);
			searchResultPage.SearchResultSelectVideobyName(VideoName);
			eventLogger.endTestCase("Search video by Name");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}
	
}
