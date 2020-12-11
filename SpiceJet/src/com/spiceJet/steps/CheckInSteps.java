package com.spiceJet.steps;

import org.openqa.selenium.By;

import com.spiceJet.main.BaseStep;
import com.spiceJet.page.CheckInPage;

public class CheckInSteps extends BaseStep {

	public static CheckInPage chcekInPage = new CheckInPage();
	
	public static void clickOnCheckInTab() {
		
		BaseStep.Clicks.clickElement(chcekInPage.checkInTab);
	}
	
	public static void PNRNumberFilling() {
		
		BaseStep.Clicks.clickElement(chcekInPage.PNRNumberFilling);
		BaseStep.SendKeys.clearFieldAndSendKeys(chcekInPage.PNRNumberFilling, "AB456");
	}
	
	public static void emailFilling() {
		
		BaseStep.Clicks.clickElement(chcekInPage.emailFilling);
		BaseStep.SendKeys.clearFieldAndSendKeys(chcekInPage.emailFilling, "prabhat9759@gmail.com");
				
	}
	
	public static void clickOnSearchBooking() {
		
		BaseStep.Clicks.clickElement(chcekInPage.searchBookingButton);
	}
}
