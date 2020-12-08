package com.spiceJet.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spiceJet.main.WebDriverSession;


public class HomePage {
	
	public HomePage() {
		
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
		
	}
	
	@FindBy (xpath = "//div[text()='Flights']")
	public WebElement Flights;
	
	@FindBy (xpath = "//div[@data-testid='one-way-radio-button']")
	public WebElement Oneway;
	
	@FindBy (xpath = "//div[@data-testid='round-trip-radio-button']")
	public WebElement Roundtrip;
	
	@FindBy (xpath = "//div[text()='From']")
	public WebElement FromDestination;
	
	@FindBy (xpath = "//div[text()='To']")
	public WebElement ToDestination;
	
	@FindBy (xpath = "//div[text()='Departure Date']")
	public WebElement DepartureDate;
	
	@FindBy (xpath = "//div[text()='Return Date']")
	public WebElement ReturnDate;

	@FindBy (xpath = "//div[text()='Passengers']")
	public WebElement Passengers;
	
	@FindBy (xpath = "//div[text()='Family & Friends']")
	public WebElement FamilyAndFriends;
	
	@FindBy (xpath = "//div[text()='Senior Citizen']")
	public WebElement SeniorCitizen;
	
	@FindBy (xpath = "//div[text()='Unaccompanied Minor']")
	public WebElement Minor;
	
	@FindBy (xpath = "//div[text()='Students']")
	public WebElement Students;
	
	@FindBy (xpath = "//div[text()='Armed Forces']")
	public WebElement ArmedForces;
	
	
	
	
	
	
	
	
	
	
}
