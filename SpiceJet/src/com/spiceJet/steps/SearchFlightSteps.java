package com.spiceJet.steps;

import com.spiceJet.main.BaseStep;
import com.spiceJet.page.SearchFlightPage;

public class SearchFlightSteps extends BaseStep {

	public static SearchFlightPage searchFPage = new SearchFlightPage();
	
	public static void searchFlight() {
		
		BaseStep.Clicks.clickElement(searchFPage.toDestination);
		BaseStep.Clicks.clickElement(searchFPage.selectBang);
		BaseStep.Clicks.clickElement(searchFPage.departureDate);
		BaseStep.Clicks.clickElement(searchFPage.Dec17);
		BaseStep.Clicks.clickElement(searchFPage.fAndF);
		BaseStep.Clicks.clickElement(searchFPage.searchFlightButton);
	}
}
