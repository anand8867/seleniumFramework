package com.spiceJet.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spiceJet.main.WebDriverSession;

public class CheckInPage {

	public CheckInPage() {
		
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
	}
	
	@FindBy (xpath = "//div[@data-testid='check-in-horizontal-nav-tabs']")
	public WebElement checkInTab;
	
	@FindBy (xpath ="//div[text()='Web Check-In']")
	public WebElement webCheckInText;
	
	@FindBy (xpath = "//input[@placeholder=\"e.g. W3X3H8\"]")
	public WebElement PNRNumberFilling;
	
	@FindBy (xpath = "//input[@placeholder=\"john.doe@spicejet.com\"]")
	public WebElement emailFilling;
	
	@FindBy (xpath = "//div[text()='Search Booking']")
	public WebElement searchBookingButton;
	
	
	
	
}
