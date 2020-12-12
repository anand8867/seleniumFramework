package com.spiceJet.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spiceJet.main.WebDriverSession;

public class FlightPage {

	public FlightPage() {

		// TODO Auto-generated constructor stub
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
	}
	
	@FindBy (xpath ="//div[text()='flight status']" )
	public WebElement flightStatusTab;
	
	
	@FindBy (xpath = "//div[text()='Departure Date']")
	public WebElement departureDate;
	
	@FindBy (xpath = "//div[text()='Yesterday']")
	public WebElement yesterdayDate;
	
	@FindBy (xpath = "//div[text()='Today']")
	public WebElement todayDate;
	
	@FindBy (xpath = "//div[text()='Tomorrow']")
	public WebElement tomorrowDate;
	
	@FindBy (xpath = "//div[text()='From']")
	public WebElement from;
	
	@FindBy (xpath = "//div[text()='To']")
	public WebElement to;
	
	@FindBy (xpath = "//input[@autocomplete='new-password']")
	public WebElement flightNo;
	
	@FindBy (xpath = "(//div[text()='Search Flights'])[1]")
	public WebElement searchFlightButton;
}
