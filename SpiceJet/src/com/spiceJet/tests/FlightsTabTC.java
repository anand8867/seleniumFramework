package com.spiceJet.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.steps.FlightsTabSteps;

public class FlightsTabTC {

	@BeforeTest
	public void openApp() {

		WebDriverSteps.openApplication("https://staging-m.spicejet.com/");
	}

	@Test(priority = 1)
	public void TC_01() {

		FlightsTabSteps.clickOnFlightsTab();
		Assert.assertTrue(FlightsTabSteps.searchFlightVisibility());
		Assert.assertTrue(FlightsTabSteps.welcomeAboardTextVisibility());
		Assert.assertTrue(FlightsTabSteps.isOneWayRadioButtonSelected());
		
	}

	@Test(priority = 2)
	public void TC_02() {
		FlightsTabSteps.clickOnOneWay();
		if (FlightsTabSteps.oneWayRadioButtonVisibility().isSelected()) {
			System.out.println("Selected");
		} else {
			System.out.println("Not Selected");
		}
		Assert.assertTrue(FlightsTabSteps.IsReturnDateDisable());
	}

	@Test(priority = 3)
	public void TC_03() {
		FlightsTabSteps.clickOnRoundTrip();
		if (FlightsTabSteps.roundTripRadioButtonVisibility().isSelected()) {
			System.out.println("Selected");
		} else {
			System.out.println("Not Selected");
		}
		Assert.assertTrue(FlightsTabSteps.IsReturnDateDisable());
	}

	
	@Test(priority = 4)
	public void TC_04() {
		FlightsTabSteps.clickOnFromDest();
		String expected = "Select a region and city below";
		Assert.assertEquals(FlightsTabSteps.selectCityAndRegion(), expected);
		

	}

	@Test(priority = 5)
	public void TC_05() {
		FlightsTabSteps.clickOnToDest();
		String expected = "Select a region and city below";
		Assert.assertEquals(FlightsTabSteps.selectCityAndRegion(), expected);
	}

	@Test(priority = 6)
	public void TC_06() {
		FlightsTabSteps.clickOnDeptDate();
		Assert.assertTrue(FlightsTabSteps.deptDateLeftArrow().isDisplayed());
	}

	@Test(priority = 7)
	public void TC_07() {
		FlightsTabSteps.clickOnReturnDate();
		Assert.assertTrue(FlightsTabSteps.deptDateLeftArrow().isDisplayed());
	}
//div[@data-testid='round-trip-radio-button']/div/*/*/*[2]
	
	@Test(priority = 8)
	public void TC_09() {
		FlightsTabSteps.clickOnPassengers();
		String expected = "Adult";
		Assert.assertEquals(FlightsTabSteps.adultText(), expected);
		Assert.assertTrue(FlightsTabSteps.isDisplayedAdultText());
		Assert.assertTrue(FlightsTabSteps.isDisplayedChildrenText());
		Assert.assertTrue(FlightsTabSteps.isDisplayedInfantText());
	}

	@Test(priority = 9)
	public void TC_13() {
		FlightsTabSteps.clickOnStudents();
		if (FlightsTabSteps.studentVisibility().isSelected()) {
			System.out.println("Selected");
		} else {
			System.out.println("Not Selected");
		}
		Assert.assertTrue(FlightsTabSteps.isStudentRadioBtnIsSelected());
	}

	@Test(priority = 10)
	public void TC9() {
		FlightsTabSteps.clickOnSearchFlight();
		String actualUrl = WebDriverSteps.getCurrentUrl();
		String expected = "https://staging-m.spicejet.com/";
		Assert.assertNotEquals(actualUrl, expected);
	}

	@AfterTest
	public void closeApp() {

		WebDriverSteps.closeBrowser();
	}
}
