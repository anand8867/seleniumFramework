package com.spiceJet.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;

public class FlightStatusTC_04 {
	
	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

//	@Test
//	public void toDestination(){
//		
//		FlightStatusSteps.clickOnTo();
//	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}

}
