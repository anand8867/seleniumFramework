package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.HomeSteps;

public class TC_09 {
	
	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test
	public void clickOnPassengers(){
		
		
		HomeSteps.passenger();
		WebElement text = WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Adult']"));
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
