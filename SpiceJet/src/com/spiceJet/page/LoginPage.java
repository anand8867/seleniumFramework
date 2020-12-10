package com.spiceJet.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spiceJet.main.WebDriverSession;

public class LoginPage {
	
	public LoginPage() {
		
		PageFactory.initElements(WebDriverSession.getWebDriverSession(), this);
	}
	@FindBy (xpath = "//div[text()='Login']")
	public WebElement login;
	
	@FindBy (xpath = "//div[text()='Mobile Number']")
	public WebElement mobRadioButton;
	
	@FindBy (xpath = "//div[text()='Email']")
	public WebElement emailRadioButton;
	
	@FindBy (xpath = "//div[@data-testid='user-country-code-selection']")
	public WebElement countryCode;
	
	@FindBy (xpath = "//input[@data-testid='user-mobileno-input-box']")
	public WebElement mobFilling;
	
	@FindBy (xpath = "//input[@data-testid='password-input-box-cta']")
	public WebElement passwordFilling;
	
	@FindBy (xpath = "//div[@class='css-1dbjc4n r-1v8vaea r-1d2f490 r-u8s1d r-zchlnj r-1pozq62']")//div[@data-testid='login-submit-btn']")
			
	public WebElement loginButton;
	
	
	
	@FindBy (xpath = "//div[@class='css-76zvg2 r-jwli3a']")
	public WebElement profile;
	
}
