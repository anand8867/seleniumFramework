package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.HomeSteps;

public class TC_12 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void clickOnMinor(){
				
		HomeSteps.minor();
		Boolean radioSelected= WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Unaccompanied Minor']")).isSelected();
	     if (radioSelected)
	    {
	      System.out.println("Radio Button is selected");
	    }else{
	      System.out.println("Radio Button is not selected");
	    }
		
		
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}
}
