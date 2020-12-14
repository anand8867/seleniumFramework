package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.FlightTabSteps;

public class FlightTab {

	@BeforeMethod
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test(priority = 1)
	public void TC_01() {

		String expectedUrl = "https://beta.spicejet.com/";

		String actualUrl = WebDriverSession.WebDriverSteps.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("url  : " + actualUrl);

	}

	/**
	 * Description: ksdfks
	 */
	@Test(priority = 2)
	public void TC_01A() {
		FlightTabSteps.clickOnFlightTab();
		String ActualTitle = WebDriverSession.getWebDriverSession().getTitle();
		String ExpectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed");
		System.out.println(ActualTitle);

	}

	@Test(priority = 3)
	public void TC_02() {

		FlightTabSteps.oneWay();

		// WebElement radioSelected = WebDriverSession.getWebDriverSession()
		// .findElement(By.xpath("//div[@data-testid=\"one-way-radio-button\"]/div/*/*/*[2]"));
		Boolean isPresent = WebDriverSession.getWebDriverSession()
				.findElements(By.xpath("//div[@data-testid='one-way-radio-button']/div/*/*/*[2]")).size() > 0;
		System.out.println(isPresent);

	}

	@Test(priority = 4)
	public void TC_03() {

		FlightTabSteps.roundTrip();
		int actLength = WebDriverSession.getWebDriverSession()
				.findElements(By.xpath("//div[@data-testid='round-trip-radio-button']")).size();
		System.out.println(actLength + " :length");
		int exp = 2;

		Assert.assertEquals(actLength, exp);

	}

	@Test(priority = 5)
	public void TC_04() {

		FlightTabSteps.clickOnFrom();

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

	@Test(priority = 6)
	public void TC_05() {

		FlightTabSteps.clickOnTo();
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

	@Test(priority = 7)
	public void TC_06() {

		FlightTabSteps.departureDate();
		WebElement actualText = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("(//div[text()='December '])[1]"));
		String actTextValue = actualText.getText();
		String expText = "December 2020";
		Assert.assertEquals(actTextValue, expText);
		System.out.println(actTextValue);

	}

	@Test(priority = 8)
	public void TC_07() {

		FlightTabSteps.returnDate();
		WebElement actualText = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("(//div[text()='December '])[2]"));
		String actTextValue = actualText.getText();
		String expText = "December 2020";
		Assert.assertEquals(actTextValue, expText);
		System.out.println(actTextValue);

	}

	@AfterMethod
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}

}
