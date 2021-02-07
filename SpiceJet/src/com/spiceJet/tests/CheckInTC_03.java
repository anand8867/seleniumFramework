package com.spiceJet.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;

public class CheckInTC_03 {
	
	@BeforeTest
	public void openApplication() {
		
		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}
	
//	@Test
//	public void pnrNumber() {
//		
//		CheckInSteps.emailFilling();
//		
//	}
	@AfterTest
	public void closeApplication() {
		
		WebDriverSteps.closeBrowser();

	}

}
