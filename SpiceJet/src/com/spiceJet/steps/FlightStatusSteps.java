package com.spiceJet.steps;

import com.spiceJet.main.BaseStep;
import com.spiceJet.page.FlightPage;

public class FlightStatusSteps extends BaseStep {

	public static FlightPage flightStatusPage = new FlightPage();

	public static void clickOnTab() {

		BaseStep.Clicks.clickElement(flightStatusPage.flightStatusTab);
	}

	public static void clickOnDepartureDate() {

		BaseStep.Clicks.clickElement(flightStatusPage.departureDate);
	}

	public static void clickOnFrom() {

		BaseStep.Clicks.clickElement(flightStatusPage.from);
	}

	public static void clickOnTo() {

		BaseStep.Clicks.clickElement(flightStatusPage.to);
	}

	public static void fillFlightNumber() {

		BaseStep.Clicks.clickElement(flightStatusPage.flightNo);
		BaseStep.SendKeys.clearFieldAndSendKeys(flightStatusPage.flightNo, "keys");
	}

	public static void clickOnSearchFlights() {

		BaseStep.Clicks.clickElement(flightStatusPage.searchFlightButton);
	}
}
