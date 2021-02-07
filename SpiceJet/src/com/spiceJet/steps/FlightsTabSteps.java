package com.spicejet.steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.spicejet.main.BaseStep;
import com.spicejet.page.FlightsTabPage;

public class FlightsTabSteps extends BaseStep {

	public static FlightsTabPage flightsTabPage = new FlightsTabPage();

	public static void clickOnFlightsTab() {

		BaseStep.Clicks.clickElement(flightsTabPage.flightsTab);
	}

	public static boolean welcomeAboardTextVisibility() {

		boolean ele = flightsTabPage.welcomeAboardText.isDisplayed();
		return ele;
	}

	public static boolean searchFlightVisibility() {

		boolean ele = flightsTabPage.search.isDisplayed();
		return ele;
	}

	public static void clickOnOneWay() {

		BaseStep.Clicks.clickElement(flightsTabPage.oneWay);
	}

	public static boolean isOneWayRadioButtonSelected() {

		boolean ele = flightsTabPage.oneWay.isDisplayed();
		return ele;

	}

	public static WebElement oneWayRadioButtonVisibility() {

		WebElement radioBttn = flightsTabPage.oneWay;
		return radioBttn;
	}

	public static void clickOnRoundTrip() {

		BaseStep.Clicks.clickElement(flightsTabPage.roundTrip);
	}

	public static WebElement roundTripRadioButtonVisibility() {

		WebElement radioBttn = flightsTabPage.roundTrip;
		return radioBttn;
	}

	public static void clickOnFromDest() {

		BaseStep.Clicks.clickElement(flightsTabPage.fromDest);

	}

	public static WebElement deptDateLeftArrow() {

		WebElement ele = flightsTabPage.leftArrowDeptDate;
		return ele;

	}

	public static String selectCityAndRegion() {

		WebElement ele = flightsTabPage.selectARegionAndCity;
		String actual = ele.getText();
		return actual;
	}

	public static void clickOnToDest() {

		BaseStep.Clicks.clickElement(flightsTabPage.toDest);
	}

	public static void selectCityInDropdown() {

		Select dropdown = new Select(flightsTabPage.cities);
		dropdown.selectByVisibleText("Bengaluru");

	}

	public static void clickOnDeptDate() {

		BaseStep.Clicks.clickElement(flightsTabPage.deptDate);
	}

	public static void clickOnReturnDate() {

		BaseStep.Clicks.clickElement(flightsTabPage.returnDate);
	}

	public static boolean IsReturnDateDisable() {

		boolean ele = flightsTabPage.returnDate.isEnabled();
		return ele;

	}

	public static void clickOnPassengers() {

		BaseStep.Clicks.clickElement(flightsTabPage.passenger);
	}

	public static WebElement adultText() {

		WebElement ele = flightsTabPage.adultText;
		return ele;
	}

	public static boolean isDisplayedAdultText() {

		boolean ele = flightsTabPage.adultText.isDisplayed();
		return ele;
	}

	public static boolean isDisplayedChildrenText() {

		boolean ele = flightsTabPage.childrenText.isDisplayed();
		return ele;
	}

	public static boolean isDisplayedInfantText() {

		boolean ele = flightsTabPage.infantText.isDisplayed();
		return ele;
	}

	public static void clickOnStudents() {

		BaseStep.Clicks.clickElement(flightsTabPage.selectedStudentRadionBttn);

	}

	public static boolean isStudentRadioBtnIsSelected() {

		boolean ele = flightsTabPage.selectedStudentRadionBttn.isDisplayed();
		return ele;

	}

	public static WebElement studentVisibility() {

		WebElement ele = flightsTabPage.students;
		return ele;
	}

	public static void clickOnSearchFlight() {

		BaseStep.Clicks.clickElement(flightsTabPage.search);
	}

}
