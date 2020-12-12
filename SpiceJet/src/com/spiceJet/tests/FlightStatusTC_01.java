package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.FlightStatusSteps;
import com.spiceJet.steps.HomeSteps;

public class FlightStatusTC_01 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void flightTab(){
		FlightStatusSteps.clickOnTab();
		WebElement actualText = WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Flight Status']"));
		String ActualTextValue = actualText.getText();
		
		String expectedText = "Flight Status";
		System.out.println(ActualTextValue);
		Assert.assertEquals(ActualTextValue, expectedText);
		
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}

}
