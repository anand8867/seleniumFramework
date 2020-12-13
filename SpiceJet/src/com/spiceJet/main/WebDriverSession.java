package com.spiceJet.main;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSession {

	static ArrayList<WebDriver> session = new ArrayList<WebDriver>();

	public static void loadDriverSession() {
		System.out.println(System.getProperty("user.dir") + "\\resources\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		if (driver != null) {
			session.add(driver);
			driver.manage().window().maximize();
		}
	}

	public static WebDriver getWebDriverSession() {
		WebDriver toReturn = null;
		if (session.size() > 0) {
			toReturn = session.get(0);
		} else {
			loadDriverSession();
			System.out.println("++ New WebDriver Instance Created - with Id [" + Thread.currentThread().getId() + "]");
			toReturn = session.get(0);
		}
		return toReturn;
	}

	public static class WebDriverSteps {

		public static void openApplication(String Url) {
			System.out.println("Start opening the application");
			WebDriverSession.getWebDriverSession().get(Url);
			System.out.println("URL opening: " + Url);
			WebDriverSession.getWebDriverSession().manage().window().maximize();
		}

		public static String getCurrentUrl() {
			return WebDriverSession.getWebDriverSession().getCurrentUrl();
		}

		public static void closeBrowser() {
			WebDriverSession.getWebDriverSession().quit();
			WebDriverSession.session.clear();
		}
	}

}
