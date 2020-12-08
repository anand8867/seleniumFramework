package com.spiceJet.steps;

import com.spiceJet.main.BaseStep;
import com.spiceJet.page.HomePage;

public class HomeSteps extends BaseStep {
	
	public static HomePage homePage = new HomePage ();
	
	public static void clickOnFlightTab() {
		
		BaseStep.Clicks.clickElement(homePage.Flights);
		
		
	}
	public static void oneWay() {
		
		BaseStep.Clicks.clickElement(homePage.Oneway);
			
	}
	
	public static void roundTrip() {
		
		BaseStep.Clicks.clickElement(homePage.Roundtrip);
	}
	
	public static void clickOnFrom() {
		
		BaseStep.Clicks.clickElement(homePage.FromDestination);
	}
	
	public static void clickOnTo() {
		
		BaseStep.Clicks.clickElement(homePage.ToDestination);
	}
	public static void departureDate() {
		
		BaseStep.Clicks.clickElement(homePage.DepartureDate);
	}
	
	public static void returnDate() {
		
		BaseStep.Clicks.clickElement(homePage.ReturnDate);
	}
	public static void passenger() {
		
		BaseStep.Clicks.clickElement(homePage.Passengers);
	}
	public static void familyAndFiends() {
		 
		BaseStep.Clicks.clickElement(homePage.FamilyAndFriends);
		 
	}
	public static void seniorCitizen() {
		 
		BaseStep.Clicks.clickElement(homePage.SeniorCitizen);
		 
	}
	public static void minor() {
		 
		BaseStep.Clicks.clickElement(homePage.Minor);
		 
	}
	public static void students() {
		 
		BaseStep.Clicks.clickElement(homePage.Students);
		 
	}
	public static void armedForces() {
		 
		BaseStep.Clicks.clickElement(homePage.ArmedForces);
		 
	}
	
	

}
