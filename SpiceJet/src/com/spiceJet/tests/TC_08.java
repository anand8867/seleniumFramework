package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.HomeSteps;

public class TC_08 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void returnDate(){
		
		
		HomeSteps.returnDate();
		WebElement actualText = WebDriverSession.getWebDriverSession().findElement(By.xpath("(//div[text()='December '])[2]"));
		String actTextValue = actualText.getText();
		String expText = "December 2020";
		Assert.assertEquals(actTextValue, expText);
		System.out.println(actTextValue);
		
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}
	
}
