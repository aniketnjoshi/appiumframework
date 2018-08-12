package com.vuclip.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.vuclip.utility.Init;
import com.vuclip.utility.Services;
import com.vuclip.utility.eventLogger;

public class AppInstallTest extends Init{
	
	@Test(groups= {"CheckAppInstall"} ,priority=1)
	public void verifyAppInstall() throws Exception
	{
		try
		{
			eventLogger.startTestCase("Application install verification");
			Assert.assertTrue(Services.isAppInstalled("com.vuclip.viu",driver));
			eventLogger.endTestCase("Application install verification");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+ex.getStackTrace());
			throw ex;
		}
	}
	
}
