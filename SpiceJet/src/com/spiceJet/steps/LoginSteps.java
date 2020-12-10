package com.spiceJet.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.spiceJet.main.BaseStep;
import com.spiceJet.page.LoginPage;

public class LoginSteps extends BaseStep {

	public static LoginPage loginPage = new LoginPage();

	public static void loginWithValidCredential() {

		BaseStep.Clicks.clickElement(loginPage.login);
		BaseStep.Clicks.clickElement(loginPage.mobRadioButton);
		BaseStep.Clicks.clickElement(loginPage.mobFilling);
		BaseStep.SendKeys.sendKey(loginPage.mobFilling, "9759474847");
		BaseStep.Clicks.clickElement(loginPage.passwordFilling);
		BaseStep.SendKeys.sendKey(loginPage.passwordFilling, "Prabhat@1420");
		BaseStep.Clicks.clickElement(loginPage.loginButton);
		
		
		
//		WebElement ele = BaseStep.Finds.findElement(By.xpath("//div[@data-testid='login-submit-btn]")); 
//		BaseStep.Waits.waitForElementToBeClickable(ele);
		//Boolean v = ele.isDisplayed();
		//System.out.println(v+ " : boolean");

		
		WebElement ele = BaseStep.Finds.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a']")); 
		BaseStep.Waits.waitForElementToBeClickable(loginPage.profile);
		for (int i = 0; i <= 10; i++) {
			try {
				if (ele.isDisplayed()) {
					ele.click();
					break;
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Trying again....");
			}
		}

	}

	public static void loginWithInvalidCredential() {

		BaseStep.Clicks.clickElement(loginPage.login);
		BaseStep.Clicks.clickElement(loginPage.mobRadioButton);
		BaseStep.Clicks.clickElement(loginPage.mobFilling);
		BaseStep.SendKeys.sendKey(loginPage.mobFilling, "9759474800");
		BaseStep.Clicks.clickElement(loginPage.passwordFilling);
		BaseStep.SendKeys.sendKey(loginPage.passwordFilling, "Prabhat@1440");
		BaseStep.Clicks.clickElement(loginPage.loginButton);

	}

}
