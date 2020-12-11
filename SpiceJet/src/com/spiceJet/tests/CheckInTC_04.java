package com.spiceJet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.CheckInSteps;

public class CheckInTC_04 {

	@BeforeTest
	public void openApplication() {
		
		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}
	
	@Test
	public void pnrNumber() {
		
		CheckInSteps.clickOnSearchBooking();
		String expt = "https://beta.spicejet.com/checkin/trip-details?pnr=ABC123&email=prabhat9759@gmail.com";
		String act = WebDriverSession.getWebDriverSession().getCurrentUrl();
		System.out.println(act);
		Assert.assertEquals(act, expt);
		
	}
	@AfterTest
	public void closeApplication() {
		
		WebDriverSteps.closeBrowser();

	}
}
