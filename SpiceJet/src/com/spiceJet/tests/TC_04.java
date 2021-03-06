package com.spiceJet.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.HomeSteps;

public class TC_04 {
	
	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void OneWay() {
		
		HomeSteps.roundTrip();
		int actLength = WebDriverSession.getWebDriverSession().findElements(By.xpath("//div[@data-testid='round-trip-radio-button']")).size();
		System.out.println(actLength + " :lnght");
		int exp = 2;
		
		Assert.assertEquals(actLength, exp);
//		WebElement radioSelected= WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[@data-testid='round-trip-radio-button']"));
//	     if (radioSelected.isSelected()){
//	    	 
//	      System.out.println("Radio Button is selected");
//	    }else{
//	    	radioSelected.click();
//	    }
//		
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();
	}
}
