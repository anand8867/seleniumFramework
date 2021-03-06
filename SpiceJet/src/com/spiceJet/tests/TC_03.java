package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.HomeSteps;

public class TC_03 {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void OneWay() {
		
		HomeSteps.oneWay();		
		
		WebElement radioSelected= WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[@data-testid='one-way-radio-button']"));
	     if (radioSelected.isSelected())
	    {
	      System.out.println("Radio Button is selected");
	    }else{
	    	radioSelected.click();
	    	System.out.println("select");
	    	
	    	
	    	
	    	//   //circle[contains(@cx, '9') AND fill = '#EDB16A']
	    	//   //circle[@fill='#EDB16A']
}
				
	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}
	
}
