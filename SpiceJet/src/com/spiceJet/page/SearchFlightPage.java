package com.spiceJet.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spiceJet.main.WebDriverSession;

public class SearchFlightPage {

	public SearchFlightPage() {
		
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
	}
	
	@FindBy (xpath = "//div[text()='To']")
	public WebElement toDestination;
	
	@FindBy (xpath = "//div[text()='Bengaluru']")
	public WebElement selectBang;
	
	@FindBy (xpath = "//div[text()='Departure Date']")
	public WebElement departureDate;
	
	@FindBy (xpath = "(//div[text()='17'])[1]")
	public WebElement Dec17;
	
	@FindBy (xpath = "//div[text()='Family & Friends']")
	public WebElement fAndF;
	
	@FindBy (xpath = "//div[text()='Search Flight']")
	public WebElement searchFlightButton;
}
