package com.spiceJet.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.FlightStatusSteps;

public class FlightStatusTC_03 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void fromDestination(){
		
		FlightStatusSteps.clickOnFrom();
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}
}
