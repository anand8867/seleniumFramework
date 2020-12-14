package com.spiceJet.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.FlightTabSteps;

public class Passengers {

	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
	}

	@Test(priority = 1)
	public void TC_09() {

		FlightTabSteps.passenger();
		WebElement text = WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Adult']"));
		String textValue = text.getText();
		System.out.println(textValue);
		if (text.isDisplayed()) {
			System.out.println("Text is displayed");
		} else {
			System.out.println("Text is not displayed");

		}
	}

	@Test(priority = 2)
	public void TC_10() {
		FlightTabSteps.familyAndFiends();
		Boolean radioSelected = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("//div[text()='Family & Friends']")).isSelected();
		if (radioSelected) {
			System.out.println("Radio Button is selected");
		} else {
			System.out.println("Radio Button is not selected");
		}

	}

	@Test(priority = 3)
	public void TC_11() {

		FlightTabSteps.seniorCitizen();
		Boolean radioSelected = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected();
		if (radioSelected) {
			System.out.println("Radio Button is selected");
		} else {
			System.out.println("Radio Button is not selected");
		}

	}

	@Test(priority = 4)
	public void TC_12() {

		FlightTabSteps.minor();
		Boolean radioSelected = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("//div[text()='Unaccompanied Minor']")).isSelected();
		if (radioSelected) {
			System.out.println("Radio Button is selected");
		} else {
			System.out.println("Radio Button is not selected");
		}

	}

	@Test(priority = 5)
	public void TC_13() {

		FlightTabSteps.students();
		Boolean radioSelected = WebDriverSession.getWebDriverSession().findElement(By.xpath("//div[text()='Students']"))
				.isSelected();
		if (radioSelected) {
			System.out.println("Radio Button is selected");
		} else {
			System.out.println("Radio Button is not selected");
		}

	}

	@Test(priority = 6)
	public void TC_14() {

		FlightTabSteps.armedForces();
		Boolean radioSelected = WebDriverSession.getWebDriverSession()
				.findElement(By.xpath("//div[text()='Armed Forces']")).isSelected();
		if (radioSelected) {
			System.out.println("Radio Button is selected");
		} else {
			System.out.println("Radio Button is not selected");
		}

	}

	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}

}
