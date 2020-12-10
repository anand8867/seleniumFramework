package com.spiceJet.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.HomeSteps;

public class TC_05 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void fromDestination (){
		
		
		HomeSteps.clickOnFrom();
		
		WebElement text = WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Select a region and city below']"));
		String textValue = text.getText();
		System.out.println(textValue);
		if (text.isDisplayed()) {
			System.out.println("Text is displayed");
		}else {
			System.out.println("Text is not displayed");

		}
		
		
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}

	
}
