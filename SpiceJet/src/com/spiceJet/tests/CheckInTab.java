package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.CheckInSteps;

public class CheckInTC_01 {
	
	@BeforeTest
	public void openApplication() {
		
		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();	
	}
	
	@Test
	public void clickOnTab() {
		
		CheckInSteps.clickOnCheckInTab();
		String exptTest = "Web Check-In";
		WebElement text = WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Web Check-In']"));
		String textValue = text.getText();
		System.out.println(textValue);
		Assert.assertEquals(textValue, exptTest);
		
	}
	
	@AfterTest
	public void closeApplication(){
		
		WebDriverSteps.closeBrowser();
	}
}
