package com.spiceJet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;


public class TC_01 {
	
	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void navigateToUrl() {
		
		String expectedUrl = "https://beta.spicejet.com/";

		String actualUrl = WebDriverSession.WebDriverSteps.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("url  : " + actualUrl);
		
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}

}
