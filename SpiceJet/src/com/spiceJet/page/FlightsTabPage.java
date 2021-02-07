package com.spiceJet.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.spicejet.main.WebDriverSession;

public class FlightsTabPage {
	
	public FlightsTabPage() {
	
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
	}
	
	@FindBy (xpath = "//div[text()='Flights']")
	public WebElement flightsTab;
	
	@FindBy (xpath = "//div[text()='Welcome aboard.']")
	public WebElement welcomeAboardText;
	
	@FindBy (xpath = "//div[@data-testid='one-way-radio-button']/div/*/*/*[2]")
	public WebElement oneWay;
	
	@FindBy (xpath = "//div[@data-testid='round-trip-radio-button']/div/*/*/*[2]")
	public WebElement roundTrip;
	
	@FindBy (xpath = "//div[text()='From']")
	public WebElement fromDest;
	
	@FindBy (xpath = "//div[text()='Cities']")
	public WebElement cities;
	
	@FindBy (xpath = "//div[text()='To']")
	public WebElement toDest;
	
	@FindBy (xpath = "//div[text()='Departure Date']")
	public WebElement deptDate;
	
	@FindBy (xpath = "//div[text()='Return Date']")
	public WebElement returnDate;
	
	@FindBy (xpath = "//div[text()='Passengers']")
	public WebElement passenger;
	
	@FindBy (xpath = "//div[text()='Students']")
	public WebElement students;
	
	@FindBy (xpath = "//div[@style='display: grid; grid-template-columns: 1fr 1fr 1fr;']/div[4]/div/div/div[1]/*/*/*[2]")
	public WebElement selectedStudentRadionBttn;
	
	
	@FindBy (xpath = "//div[text()='Search Flight']")
	public WebElement search;
	
	@FindBy (xpath = "//div[@class='css-view-1dbjc4n r-marginBottom-1yflyrw']")
	public WebElement selectARegionAndCity;
	
	@FindBy (xpath = "//div[@class='css-view-1dbjc4n r-cursor-1loqt21 r-left-19bllq0 r-position-u8s1d r-top-1v2oles r-touchAction-1otgn73 r-transform-16zfatd r-transitionDuration-eafdt9 r-transitionProperty-1i6wzkk r-userSelect-lrvibr r-zIndex-184en5c']")
	public WebElement leftArrowDeptDate;

	@FindBy (xpath = "//div[text()='Adult']")
	public WebElement adultText;
	
	@FindBy (xpath = "//div[text()='Children']")
	public WebElement childrenText;
	
	@FindBy (xpath = "//div[text()='Infant']")
	public WebElement infantText;
}
