package com.spiceJet.tests;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spiceJet.main.BaseStep;
import com.spiceJet.main.WebDriverSession;
import com.spiceJet.main.WebDriverSession.WebDriverSteps;
import com.spiceJet.page.LoginPage;
import com.spiceJet.steps.LoginSteps;

public class LoginTC_01 {
	
	
	@BeforeTest
	public void openApplication() {

		WebDriverSteps.openApplication("https://beta.spicejet.com/");
		WebDriverSession.getWebDriverSession().manage().window().maximize();
		
	}

	@Test 
	public void LoginIntoApp() throws InterruptedException { 
		
		LoginSteps.loginWithValidCredential();
		
		WebElement ele = BaseStep.Finds.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a']")); 
		BaseStep.Waits.waitForElementToBeClickable(ele);
		Boolean v = ele.isDisplayed();
		System.out.println(v+ " : boolean");
	

	}
	
	@AfterTest
	public void closeApplication() {

		WebDriverSteps.closeBrowser();

	}
	
}
