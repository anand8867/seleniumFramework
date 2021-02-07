package com.spiceJet.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;

public class FlightStatusTC_06 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

//	@Test
//	public void clickOnSearchFlightsButton(){
//		
//		FlightStatusSteps.clickOnSearchFlights();
//	}
//	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}
}
