package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.HomeSteps;

public class TC_14 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void clickOnArmedForces(){
				
		HomeSteps.armedForces();
		Boolean radioSelected= WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Armed Forces']")).isSelected();
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
