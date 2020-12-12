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

	public void FlightTab() {
		HomeSteps.clickOnFlightTab();
		String ActualTitle = WebDriverSession.getWebDriverSession().getTitle();
		String ExpectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed");
		System.out.println(ActualTitle);

	}

	public void OneWay() {

		HomeSteps.oneWay();

		WebElement radioSelected = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("//div[@data-testid='one-way-radio-button']"));
		if (radioSelected.isSelected()) {
			System.out.println("Radio Button is selected");
		} else {
			radioSelected.click();
			System.out.println("select");

		}

		// //circle[contains(@cx, '9') AND fill = '#EDB16A']
		// //circle[@fill='#EDB16A']
	}

	public void roundTrip() {

		HomeSteps.roundTrip();
		int actLength = WebDriverSession.getWebDriverSession()
				.findElements(By.xpath("//div[@data-testid='round-trip-radio-button']")).size();
		System.out.println(actLength + " :length");
		int exp = 2;

		Assert.assertEquals(actLength, exp);
//	WebElement radioSelected= WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[@data-testid='round-trip-radio-button']"));
//     if (radioSelected.isSelected()){
//    	 
//      System.out.println("Radio Button is selected");
//    }else{
//    	radioSelected.click();
//    }
//	
	}

	public void fromDestination() {

		HomeSteps.clickOnFrom();

		WebElement text = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("//div[text()='Select a region and city below']"));
		String textValue = text.getText();
		System.out.println(textValue);
		if (text.isDisplayed()) {
			System.out.println("Text is displayed");
		} else {
			System.out.println("Text is not displayed");

		}

	}

	public void toDestination() {

		HomeSteps.clickOnTo();

		WebElement text = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("//div[text()='Select a region and city below']"));
		String textValue = text.getText();
		System.out.println(textValue);
		if (text.isDisplayed()) {
			System.out.println("Text is displayed");
		} else {
			System.out.println("Text is not displayed");

		}

	}

	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}

}
