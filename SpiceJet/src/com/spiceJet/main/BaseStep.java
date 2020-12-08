package com.spiceJet.main;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseStep {

	public static class Alerts {

		private static final String MESSAGE_P1 = "Alert with text [";

		private Alerts() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Accept the alert.
		 */
		public static void confirmationAlertAccept() {
			Alert simpleAlert = WebDriverSession.getWebDriverSession().switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();
			// Reporting.logReporter(Status.DEBUG, MESSAGE_P1 + alertText + "] Accept -
			// Done");
		}

		/**
		 * OBJECTIVE: Dismiss the alert.
		 */
		public static void confirmationAlertDismiss() {
			Alert confirmationAlert = WebDriverSession.getWebDriverSession().switchTo().alert();
			String alertText = confirmationAlert.getText();
			confirmationAlert.dismiss();
			// Reporting.logReporter(Status.DEBUG, MESSAGE_P1 + alertText + "] Dismiss -
			// Done");
		}

		/**
		 * OBJECTIVE: SendKeys to the alert.
		 */
		public static void promptAlertSendKeys(String textToSend) {
			Alert promptAlert = WebDriverSession.getWebDriverSession().switchTo().alert();
			String alertText = promptAlert.getText();
			promptAlert.sendKeys(textToSend);
			promptAlert.accept();
			// Reporting.logReporter(Status.DEBUG, MESSAGE_P1 + alertText + "] SendKeys with
			// text " + textToSend + " - Done");
		}

	}

	/**
	 * Utilities to handle Checkboxes; Depending on how the page was made, the
	 * regular implementation might not work in that case use the ones that check
	 * Class properties
	 */
	public static class CheckBoxes {

		private static final String LOGGER_MESSAGE = "Validating isCheckboxActive: ";

		private CheckBoxes() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Return if the checkbox is active(selected)
		 */
		public static boolean isCheckboxActive(WebElement aCheckbox) {
			boolean value = aCheckbox.isSelected();
			// Reporting.logReporter(Status.DEBUG, LOGGER_MESSAGE + value);
			return value;
		}

		/**
		 * OBJECTIVE: Return if the checkbox has a class property as active
		 */
		public static boolean isCheckboxActiveByClassProperty(WebElement aCheckbox) {
			if (WebElementUtils.elementHasClass(aCheckbox, "active")) {
				// Reporting.logReporter(Status.DEBUG, LOGGER_MESSAGE + "True");
				return true;
			}
			// Reporting.logReporter(Status.DEBUG, LOGGER_MESSAGE + "false");
			return false;
		}

		/**
		 * OBJECTIVE: Remove the Check if a Checkbox is active
		 */
		public static void uncheckCheckbox(WebElement aCheckbox) {
			if (aCheckbox.isSelected()) {
				aCheckbox.click();
				// Reporting.logReporter(Status.DEBUG, "Checkbox uncheck done");
				return;
			}
			// Reporting.logReporter(Status.DEBUG, "Checkbox uncheck NOT done - Element is
			// not active(Selected)");
		}

		/**
		 * OBJECTIVE: Remove the Check if a Checkbox is active by looking a class
		 * property as active
		 */
		public static void unCheckCheckboxByClassProperty(WebElement aCheckbox) {
			if (isCheckboxActiveByClassProperty(aCheckbox)) {
				aCheckbox.click();
				// Reporting.logReporter(Status.DEBUG, "Checkbox uncheck done");
				return;
			}
			// Reporting.logReporter(Status.DEBUG, "Checkbox uncheck NOT done - Element is
			// not active(Selected)");
		}

	}

	/**
	 * Utilities to click Elements
	 */
	public static class Clicks {

		private Clicks() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Short Wait for an element to be Clickable to do the click.
		 */
		public static void clickElement(WebElement element) {
			clickElement(element, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: Custom Wait for an element to be Clickable to do the click.
		 */
		private static void clickElement(WebElement element, int waitInSeconds) {
			Waits.waitForElementToBeClickable(element, waitInSeconds);
			element.click();
			// Reporting.logReporter(Status.DEBUG, "click Done");
		}

		/**
		 * OBJECTIVE: Short Wait for an element to be Clickable to do the click, Try the
		 * regular method before this one
		 */
		public static void clickElementCoordinates(WebElement element) {
			Waits.waitForElementVisibility(element);
			SeleniumActions.getActions().click(element).perform();
			// Reporting.logReporter(Status.DEBUG, "click ElementCoordinates Done");
		}

		/**
		 * OBJECTIVE: Wait for an element to be Clickable to do the click, Try the
		 * regular method before this one
		 */
		public static void clickElementCoordinatesLongWait(WebElement element) {
			Waits.waitForElementVisibilityLongWait(element);
			SeleniumActions.getActions().click(element).perform();
			// Reporting.logReporter(Status.DEBUG, "click ElementCoordinatesLongWait Done");
		}

		/**
		 * OBJECTIVE: Wait for an element to be Clickable to do the click.
		 */
		public static void clickElementLongWait(WebElement element) {
			clickElement(element, GENERIC_LONG_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: From the given list - Wait for an element to be Clickable to do
		 * the click
		 */
		public static void clickElementsCoordinatesInList(List<WebElement> list) {
			for (WebElement e : list) {
				clickElementCoordinates(e);
				// Reporting.logReporter(Status.DEBUG, "click ElementsCoordinatesInList -
				// Done");
			}
		}

		/**
		 * OBJECTIVE: From the given list - Wait for an element to be Clickable to do
		 * the click
		 */
		public static void clickElementsCoordinatesInListLongWait(List<WebElement> list) {
			for (WebElement e : list) {
				clickElementCoordinatesLongWait(e);
				// Reporting.logReporter(Status.DEBUG, "click
				// clickElementsCoordinatesInListLongWait - Done");
			}
		}

		/**
		 * OBJECTIVE: From the given list - Wait for an element to be Clickable to do
		 * the click
		 */
		public static void clickElementsInList(List<WebElement> list) {
			for (WebElement e : list) {
				clickElement(e);
				// Reporting.logReporter(Status.DEBUG, "click ElementsInList - Done");
			}
		}

		/**
		 * OBJECTIVE: From the given list - Wait for an element to be Clickable to do
		 * the click
		 */
		public static void clickElementsInListLongWait(List<WebElement> list) {
			for (WebElement e : list) {
				clickElementLongWait(e);
				// Reporting.logReporter(Status.DEBUG, "click ElementsInListLongWait - Done");
			}
		}

		/**
		 * OBJECTIVE: From the given list - Wait for an element to be Clickable to do
		 * the click
		 */
		public static void clickElementsUsingJSInList(List<WebElement> list) {
			for (WebElement e : list) {
				clickElementUsingJS(e);
				// Reporting.logReporter(Status.DEBUG, "click clickElementsUsingJSInList -
				// Done");
			}
		}

		/**
		 * OBJECTIVE: From the given list - Wait for an element to be Clickable to do
		 * the click
		 */
		public static void clickElementsUsingJSInListLongWait(List<WebElement> list) {
			for (WebElement e : list) {
				clickElementUsingJSLongWait(e);
				// Reporting.logReporter(Status.DEBUG, "click clickElementsUsingJSInListLongWait
				// - Done");
			}
		}

		/**
		 * OBJECTIVE: Short Wait for an element to be Clickable to do the click (With
		 * JavaScript).
		 */
		public static void clickElementUsingJS(WebElement element) {
			clickElementUsingJS(element, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: Wait for an element to be Clickable to do the click(With
		 * JavaScript), Try the regular method before this one, this should be a last
		 * option as it is not interacting with the actual page.
		 */
		private static void clickElementUsingJS(WebElement element, int waitInSeconds) {
			Waits.waitForElementVisibility(element, waitInSeconds);
			JavaScripts.executeJavaScript("arguments[0].click()", element);
			// Reporting.logReporter(Status.DEBUG, "click clickElementUsingJavaScript
			// Done");
		}

		/**
		 * OBJECTIVE: Wait for an element to be Clickable to do the click(With
		 * JavaScript).
		 */
		public static void clickElementUsingJSLongWait(WebElement element) {
			clickElementUsingJS(element, GENERIC_LONG_TIME_OUT_SECONDS);
		}

	}

	/**
	 * Utilities to deal with Dates
	 */
	public static class DatesUtils {

		public static final String FORMAT_YYYY_MM_DD_SEPARATOR_SPACE = "yyyy MM dd";

		public static final String FORMAT_YYYY_MM_DD_SEPARATOR_SLASHES = "yyyy/MM/dd";
		public static final String FORMAT_YYYY_MM_DD_SEPARATOR_HYPHENS = "yyyy-MM-dd";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_SEPARATOR_SPACE = "yyyy MM dd hh:mm:ss";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_SEPARATOR_SLASHES = "yyyy/MM/ddhh:mm:ss";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_SEPARATOR_HYPHENS = "yyyy-MM-dd hh:mm:ss";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_SEPARATOR_SPACE_ALL = "yyyy MM dd hh mm ss";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_SEPARATOR_NO_SPACE_ALL = "yyyyMMddhhmmss";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SS_WITH_SEPARATOR_NO_SPACE_ALL = "yyyyMMdd-hhmmss";
		public static final String FORMAT_MM_DD_YYYY_SEPARATOR_SPACE = "MM dd yyyy";

		public static final String FORMAT_MM_DD_YYYY_SEPARATOR_SLASHES = "MM/dd/yyyy";
		public static final String FORMAT_MM_DD_YYYY_SEPARATOR_HYPHENS = "MM-dd-yyyy";
		public static final String FORMAT_MM_DD_YYYY_HH_MM_SS_SEPARATOR_SPACE = "MM dd yyyy hh:mm:ss";
		public static final String FORMAT_MM_DD_YYYY_HH_MM_SS_SEPARATOR_SLASHES = "MM/dd/yyyy hh:mm:ss";
		public static final String FORMAT_MM_DD_YYYY_HH_MM_SS_SEPARATOR_HYPHENS = "MM-dd-yyyy hh:mm:ss";
		public static final String FORMAT_DD_MM_YYYY_SEPARATOR_SPACE = "dd MM yyyy";

		public static final String FORMAT_DD_MM_YYYY_SEPARATOR_SLASHES = "dd/MM/yyyy";
		public static final String FORMAT_DD_MM_YYYY_SEPARATOR_HYPHENS = "dd-MM-yyyy";
		public static final String FORMAT_DD_MM_YYYY_HH_MM_SS_SEPARATOR_SPACE = "dd MM yyyy hh:mm:ss";
		public static final String FORMAT_DD_MM_YYYY_HH_MM_SS_SEPARATOR_SLASHES = "dd/MM/yyyy hh:mm:ss";
		public static final String FORMAT_DD_MM_YYYY_HH_MM_SS_SEPARATOR_HYPHENS = "dd-MM-yyyy hh:mm:ss";

		public static final String FORMAT_YYYY_MM_DD_HH_MM_SSS_SEPARATOR_UNDERSCORE = "yyyy_MM_dd_hh:mm:SSS";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SSS_SEPARATOR_UNDERSCORE_ALL = "yyyy_MM_dd_hh_mm_SSS";
		public static final String FORMAT_YYYY_MM_DD_HH_MM_SSS_SEPARATOR_NO_UNDERSCORE_ALL = "yyyyMMddhhmmSSS";

		private DatesUtils() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Convert date to string
		 */
		public static String convertDateToString(Date date, String format) {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			String dateAsString = formatter.format(date);
			// Reporting.logReporter(Status.DEBUG, "convertDateToString: " + dateAsString);
			return dateAsString;
		}

		/**
		 * OBJECTIVE: Get Current Date
		 */
		public static Date getCurrentDate() {
			// Reporting.logReporter(Status.DEBUG, "getCurrentDate");
			return new Date();
		}

		/**
		 * OBJECTIVE: Sent positive Numbers to obtain a future date, or Negative to
		 * obtain a previous one. All the results are based on the current date.
		 */
		public static Date getNewDateBasedInCurrentDate(int days) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, days);
			Date newDate = cal.getTime();
			// Reporting.logReporter(Status.DEBUG, "getNewDateBasedInCurrentDate - Done,
			// date(MM/dd/yyyy) obtained is " + convertDateToString(newDate,
			// FORMAT_MM_DD_YYYY_SEPARATOR_SLASHES));
			return newDate;
		}

	}

	public static class Debugs {

		private Debugs() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * <p>
		 * Use this method for debugging only. Will Hide the element modifying the CSS
		 * Styles. Note that it might not work depending on how the page was created
		 * </p>
		 */
		public static void hideElement(String elementName) {
			String script = "document.getElementsByName('%s')[0].style.display='none'";
			JavaScripts.executeJavaScript(String.format(script, elementName));
			// Reporting.logReporter(Status.DEBUG, "JS - hideElement done");
		}

		/**
		 * <p>
		 * Use this method for debugging only. Remove after Debug.
		 * </p>
		 */
		public static void highlightElement(WebElement element) {
			String script = "arguments[0].setAttribute('style', 'border: 5px solid #ffcc00;')";
			JavaScripts.executeJavaScript(script, element);
			// Reporting.logReporter(Status.DEBUG, "JS - highlightElement done");
		}

		/**
		 * <p>
		 * Method to put Element into the view
		 * </p>
		 */
		public static void scrollToElement(WebElement element) {
			JavaScripts.executeJavaScript("arguments[0].scrollIntoView(true);", element);
			// Reporting.logReporter(Status.DEBUG, "scrollToElement done");
		}
		
		public static void scrollToBottom() {
			JavaScripts.executeJavaScript("window.scrollTo(0,document.body.scrollHeight);");
		}

		/**
		 * <p>
		 * Use this method for debugging only. Will Hide the element modifying the CSS
		 * Styles. Note that it might not work depending on how the page was created
		 * </p>
		 */
		public static void showElement(String elementName) {
			String script = "document.getElementsByName('%s')[0].style.display='blocked'";
			JavaScripts.executeJavaScript(String.format(script, elementName));
			// Reporting.logReporter(Status.DEBUG, "JS - showElement done");
		}
	}

	// Additional Elements that do not require global Setup (SystemProperties)

	/**
	 * Utilities to deal with Dropdowns
	 */
	public static class Dropdowns {

		private Dropdowns() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Method to select a drop down option going through all options from
		 * the list.
		 */
		public static void selectByGoingThroughList(WebElement dropdownElement, String expectedOptionText) {

			Select selectList = new Select(dropdownElement);

			int selectSize = selectList.getOptions().size();
			// Reporting.logReporter(Status.DEBUG, "Size of list is " + selectSize);

			for (int i = 0; i <= selectSize; i++) {

				selectList.selectByIndex(i);

				String selectedOption = selectList.getFirstSelectedOption().getText();

				// Reporting.logReporter(Status.DEBUG, "Selected Item " + selectedOption);

				if (selectedOption.trim().equals(expectedOptionText.trim())) {
					// Reporting.logReporter(Status.DEBUG, "Value Matched");
					break;
				} else {
					// Reporting.logReporter(Status.DEBUG, "Value Not Matched");
					if (i == selectSize) {
						// Reporting.logReporter(Status.DEBUG, "Value NOT FOUND in List " +
						// expectedOptionText);
					}

				}
			}
		}

		/**
		 * OBJECTIVE: Method to select a drop down option using the index.
		 */
		public static void selectByIndex(WebElement dropdownElement, int index) {
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByIndex(index);
			// Reporting.logReporter(Status.DEBUG, "selectByIndex done");
		}

		/**
		 * OBJECTIVE: Method to select a drop down option using the value text.
		 */
		public static void selectByValue(WebElement dropdownElement, String value) {
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByValue(value);
			// Reporting.logReporter(Status.DEBUG, "selectByValue done");
		}

		/**
		 * OBJECTIVE: Method to select a drop down option using the visible text.
		 */
		public static void selectByVisibleText(WebElement dropdownElement, String optionVisibleText) {
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(optionVisibleText);
			// Reporting.logReporter(Status.DEBUG, "selectByVisibleText done");
		}
	}

	/**
	 * Utilities to Find Elements (By the usual dinamyc elements that cannot be
	 * mapped from the very beginning
	 */
	public static class Finds {

		private Finds() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * Method to be used when the elements are created on runtime, and not mapped as
		 * page objects
		 */
		public static WebElement findElement(By selector) {
			return findElement(ExpectedConditions.presenceOfElementLocated(selector));
		}

		private static WebElement findElement(ExpectedCondition<WebElement> expectedCondition) {
			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), GENERIC_LONG_TIME_OUT_SECONDS);
			return wait.until(expectedCondition);
		}

		/**
		 * Method to be used when the elements are created on runtime, and not mapped as
		 * page objects
		 */
		public static List<WebElement> findElements(By selector) {
			return findElements(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
		}

		private static List<WebElement> findElements(ExpectedCondition<List<WebElement>> expectedCondition) {
			List<WebElement> elements = new ArrayList<WebElement>();
			try {
				Wait<WebDriver> wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), GENERIC_LONG_TIME_OUT_SECONDS);
				elements = wait.until(expectedCondition);
			} catch (TimeoutException e) {
				// Ignore the exception as find elements can return an empty
				// list.
			}
			return elements;
		}

		/**
		 * Method to be used when the elements are created on runtime, and not mapped as
		 * page objects
		 */
		public static WebElement findNestedElement(WebElement element, By subSelector) {
			return findElement(ExpectedConditions.presenceOfNestedElementLocatedBy(element, subSelector));
		}

		/**
		 * Method to be used when the elements are created on runtime, and not mapped as
		 * page objects
		 */
		public static List<WebElement> findNestedElements(By selector, By subSelector) {
			return findElements(ExpectedConditions.presenceOfNestedElementsLocatedBy(selector, subSelector));
		}
	}

	/**
	 * Utilities to deal with Gets
	 */
	public static class Getters {

		private Getters() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Get Text (Using JS) This command will only work when there is
		 * direct text in the element.
		 */
		public static String getElementTextUsingJS(WebElement e) {
			String text = (String) JavaScripts.executeJavaScript("return arguments[0].text;", e);
			// Reporting.logReporter(Status.DEBUG, "getElementText");
			return text;
		}

	}

	/**
	 * Utilities to Interact with iFrames
	 */
	public static class Iframes {

		private static final String MESSAGE_SWITCH_DONE = "switchToIframe done";

		private Iframes() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Use this method to get a number of all iFrames from the current
		 * window.
		 */
		public static int getIframesCount() {
			int count = WebDriverSession.getWebDriverSession().findElements(By.tagName("iframe")).size();
			// Reporting.logReporter(Status.DEBUG, "getIframesCount: " + count);
			return count;
		}

		/**
		 * OBJECTIVE: Use this method to switch back from iFrame.
		 */
		public static void switchBackToDefaultContent() {
			WebDriverSession.getWebDriverSession().switchTo().defaultContent();
			// Reporting.logReporter(Status.DEBUG, "switchBackToDefaultContent done");
		}

		/**
		 * OBJECTIVE: Use this method to switch to an iFrame.
		 */
		public static void switchToiFrame(int index) {
			WebDriverSession.getWebDriverSession().switchTo().frame(index);
			// Reporting.logReporter(Status.DEBUG, MESSAGE_SWITCH_DONE);
		}

		/**
		 * OBJECTIVE: Use this method to switch to an iFrame.
		 */
		public static void switchToiFrame(String iFrameName) {
			WebDriverSession.getWebDriverSession().switchTo().frame(iFrameName);
			// Reporting.logReporter(Status.DEBUG, MESSAGE_SWITCH_DONE);
		}

		/**
		 * OBJECTIVE: Use this method to switch to an iFrame.
		 */
		public static void switchToiFrame(WebElement element) {
			WebDriverSession.getWebDriverSession().switchTo().frame(element);
			// Reporting.logReporter(Status.DEBUG, MESSAGE_SWITCH_DONE);
		}

		/**
		 * OBJECTIVE: switch to the first window that contains the expected iFrame and
		 * finally switch to that iFrame.
		 */
		public static boolean switchToWindowThatContainsiFrameAndSwitchToiFrame(String iFrameName) {

			for (String winHandle : WebDriverSession.getWebDriverSession().getWindowHandles()) {
				WebDriverSession.getWebDriverSession().switchTo().window(winHandle);
				Waits.waitGeneric(GENERIC_SHORT_TIME_OUT_SECONDS * ONE_SECOND);

				try {
					switchToiFrame(iFrameName);
					return true;
				} catch (NoSuchFrameException e) {
					// Reporting.logReporter(Status.DEBUG, "Looking for iFrame");
				}
			}

			// Reporting.logReporter(Status.DEBUG, "iFrame not found at any window");
			return false;
		}

	}

	/**
	 * Utilities to execute JavaScripts
	 */
	public static class JavaScripts {

		private JavaScripts() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Execute JS
		 */
		public static void executeJavaScript(String script) {
			JavascriptExecutor js = getJavaScriptExecutor();
			js.executeScript(script);
			// Reporting.logReporter(Status.DEBUG, "JS Execution done");
		}

		/**
		 * OBJECTIVE: Execute JS, with WebElement.
		 */
		public static Object executeJavaScript(String script, WebElement element) {
			return ((JavascriptExecutor) WebDriverSession.getWebDriverSession()).executeScript(script, element);
		}

		public static JavascriptExecutor getJavaScriptExecutor() {
			return ((JavascriptExecutor) WebDriverSession.getWebDriverSession());
		}

		/**
		 * Handle certificate error in Internet Explorer
		 *
		 * @param WebDriverSession.getWebDriverSession() WebDriver instance
		 */
		public static void handleCertificateError() {
			String pageTitle = WebDriverSession.getWebDriverSession().getTitle();
			while (pageTitle.equals("Certificate Error: Navigation Blocked")) {
				WebDriverSession.getWebDriverSession().navigate().to("javascript:document.getElementById('overridelink').click()");
				pageTitle = WebDriverSession.getWebDriverSession().getTitle();
			}
		}

		/**
		 * Handle unsecure connection in Internet Explorer
		 *
		 * @param WebDriverSession.getWebDriverSession() WebDriver instance
		 */
		public static void handleUnsecureConnectionError() {
			String pageTitle = WebDriverSession.getWebDriverSession().getTitle();
			while (pageTitle.equals("This site isn’t secure")) {
				WebDriverSession.getWebDriverSession().navigate().to("javascript:document.getElementById('overridelink').click()");
				pageTitle = WebDriverSession.getWebDriverSession().getTitle();
			}
		}

		public static void scrollToBottom() {
			executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
		}

	}

	/**
	 * Utilities to create Random Numbers
	 */
	public static class NumbersUtils {

		static Random random = new Random();

		private NumbersUtils() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/*
		 * OBJECTIVE: Get a random double, within the expected range.
		 */
		public static double getRandomDouble(double min, double max) {
			double x = (Math.random() * ((max - min) + 1)) + min;
			// Reporting.logReporter(Status.DEBUG, "getRandomDouble done");
			return x;
		}

		/**
		 * OBJECTIVE: Get a random int, within the expected range.
		 */
		public static int getRandomInt(int min, int max) {
			// Reporting.logReporter(Status.DEBUG, "getRandomInt done");
			return random.ints(min, (max + 1)).findFirst().getAsInt();
		}

	}

	/**
	 * Method to be used when the elements are created on runtime, and not mapped as
	 * page objects
	 */
	public static class SeleniumActions {

		private SeleniumActions() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		public static Actions getActions() {
			return new Actions(WebDriverSession.getWebDriverSession());
		}

		/**
		 * OBJECTIVE: Method to ClickElements Using Actions, after each action a
		 * wait(Custom Time) is done.
		 */
		private static void hoverAndClickTwoElementsWithCustomtWait(int pauseMilliSeconds, WebElement element1,
				WebElement element2) {
			Actions action = getActions();
			action.moveToElement(element1);
			action.pause(pauseMilliSeconds);
			action.click(element1);
			action.pause(pauseMilliSeconds);
			action.moveToElement(element2);
			action.pause(pauseMilliSeconds);
			action.click(element2);
			action.build();
			action.perform();

			// Reporting.logReporter(Status.DEBUG, "hoverAndClickTwoElementsWithCustomtWait
			// done");
		}

		/**
		 * OBJECTIVE: Method to ClickElements Using Actions, after each action a
		 * wait(Default Time) is done.
		 */
		public static void hoverAndClickTwoElementsWithDefaultWait(WebElement element1, WebElement element2) {
			hoverAndClickTwoElementsWithCustomtWait(1500, element1, element2);
		}

		/**
		 * OBJECTIVE: Method to ClickElements Using Actions, after each action a
		 * wait(Short Time) is done.
		 */
		public static void hoverAndClickTwoElementsWithShortWait(WebElement element1, WebElement element2) {
			hoverAndClickTwoElementsWithCustomtWait(GENERIC_SHORT_TIME_OUT_SECONDS, element1, element2);
		}

	}

	public static class SendKeys {

		private SendKeys() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Waits for element to be visible/enable / Then clear the field /
		 * then sent the text
		 */
		public static void clearFieldAndSendKeys(WebElement element, Keys keys) {
			Waits.waitForElementToBeClickable(element);
			element.clear();
			element.sendKeys(keys);
			// Reporting.logReporter(Status.DEBUG, "clearFieldAndSendKeys done");
		}

		/**
		 * OBJECTIVE: Waits for element to be visible/enable / Then clear the field /
		 * then sent the text
		 */
		public static void clearFieldAndSendKeys(WebElement element, String text) {
			Waits.waitForElementToBeClickable(element);
			element.clear();
			element.sendKeys(text);
			// Reporting.logReporter(Status.DEBUG, "clearFieldAndSendKeys done");
		}

		/**
		 * OBJECTIVE: Waits for element to be visible/enable / Then clear the field /
		 * then sent the text
		 */
		public static void clearFieldAndSendKeysUsingJS(WebElement element, String text) {
			Waits.waitForElementToBeClickable(element);
			element.clear();
			String script = "arguments[0].value='%s';";
			JavaScripts.executeJavaScript(String.format(script, text), element);
			// Reporting.logReporter(Status.DEBUG, "clearFieldAndSendKeysUsingJS done");
		}

		/**
		 * OBJECTIVE: Waits for element to be visible/enable / then sent the text. Note
		 * this method do not clean the field before
		 */
		public static void sendKey(WebElement element, Keys keys) {
			Waits.waitForElementToBeClickable(element);
			element.sendKeys(keys);
			// Reporting.logReporter(Status.DEBUG, "sendKey done");
		}

		/**
		 * OBJECTIVE: Waits for element to be visible/enable / then sent the text. Note
		 * this method do not clean the field before
		 */
		public static void sendKey(WebElement element, String text) {
			Waits.waitForElementToBeClickable(element);
			element.sendKeys(text);
			// Reporting.logReporter(Status.DEBUG, "sendKey done");
		}

		/**
		 * OBJECTIVE: Waits for element to be visible/enable / then sent the text. Note
		 * this method do not clean the field before
		 */
		public static void sendKeyUsingJS(WebElement element, String text) {
			Waits.waitForElementToBeClickable(element);
			String script = "arguments[0].value='%s';";
			JavaScripts.executeJavaScript(String.format(script, text), element);
			// Reporting.logReporter(Status.DEBUG, "sendKeyUsingJS done");
		}
	}

	/**
	 * Utilities to create Random Strings
	 */
	public static class StringUtils {

		private static final String AZ_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		private static final String NUMERIC_CHARS = "0123456789";
		private static final String ALPHA_NUMERIC_CHARS = AZ_CHARS + NUMERIC_CHARS;
		private static final String EMAIL_CHARS = ALPHA_NUMERIC_CHARS + "_";

		private StringUtils() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		public static int countMatches(String fullText, String textToLookFor) {
			System.out.println("textToLookFor= " + textToLookFor + " length: " + textToLookFor.length());
			System.out.println("antesde_" + textToLookFor + "_despuesde");

			int count = 0;
//          org.apache.commons.lang3.StringUtils.countMatches(fullText, textToLookFor);
			// Reporting.logReporter(Status.DEBUG, "countMatches - done - Found: " + count);
			return count;
		}

		public static int countMatchesForTextWithPrefix(String fullText, String prefix, String textToLookFor) {
			textToLookFor = prefix + textToLookFor;
			return countMatches(fullText, textToLookFor);
		}

		public static int countMatchesForTextWithPrefixAndSuffix(String fullText, String prefix, String suffix,
				String textToLookFor) {
			textToLookFor = prefix + textToLookFor + suffix;
			return countMatches(fullText, textToLookFor);
		}

		public static int countMatchesForTextWithSuffix(String fullText, String suffix, String textToLookFor) {
			textToLookFor = textToLookFor + suffix;
			return countMatches(fullText, textToLookFor);
		}

		public static String cssHrefContains(String urlContains) {
			return "[href*=\"" + urlContains + "\"]";
		}

		public static String cssHrefEndingWith(String urlSuffix) {
			// e.g. to look for <a
			// href="http://ihg.com/en/us/path/to/endpoint">, where the
			// "path/to/endpoint" is significant:
			return "[href$=\"" + urlSuffix + "\"]";
		}

		/**
		 * Returns the # of chars that are found BEFORE the text
		 */
		public static String extractTextThatEndsWith(String fullText, String textToLookFor,
				int extractionlenghtMaxSize) {
			int beginIndex = fullText.indexOf(textToLookFor);
			int sumBeginAndMaxSize = beginIndex - extractionlenghtMaxSize;
			String subString = null;

			if (sumBeginAndMaxSize >= 0) {
				subString = fullText.substring(sumBeginAndMaxSize, beginIndex);
			} else {
				subString = fullText.substring(0, beginIndex);
			}

			// Reporting.logReporter(Status.DEBUG, "extractTextThatEndsWith - done");
			return subString;
		}

		/**
		 * Returns the # of chars that are found AFTER the text
		 */
		public static String extractTextThatStartsWith(String fullText, String textToLookFor,
				int extractionlenghtMaxSize) {
			int beginIndex = fullText.indexOf(textToLookFor);
			int textToLookForSize = textToLookFor.length();
			int fullTextSize = fullText.length();
			int sumBeginAndMaxSize = beginIndex + extractionlenghtMaxSize;
			String subString = null;

			if (sumBeginAndMaxSize <= fullTextSize) {
				subString = fullText.substring(beginIndex + textToLookForSize, sumBeginAndMaxSize);
			} else {
				subString = fullText.substring(beginIndex + textToLookForSize, fullTextSize);
			}

			// Reporting.logReporter(Status.DEBUG, "extractTextThatStartsWith - done");
			return subString;
		}

		/**
		 * OBJECTIVE: Get a random String with Alphanumeric values.
		 */
		public static String getRandomAlphaNumeric(int count) {
			StringBuilder builder = new StringBuilder();
			while (count-- != 0) {
				int character = (int) (Math.random() * ALPHA_NUMERIC_CHARS.length());
				builder.append(ALPHA_NUMERIC_CHARS.charAt(character));
			}
			// Reporting.logReporter(Status.DEBUG, "getRandomAlphaNumeric done" +
			// builder.toString());
			return builder.toString();
		}

		/**
		 * OBJECTIVE: Get a random String in email format.
		 */
		public static String getRandomEmail() {
			String email = getRandomStringForEmail(18).concat("@yopmail.com");
			// Reporting.logReporter(Status.DEBUG, "getRandomEmail done:" + email);
			return email;
		}

		/**
		 * OBJECTIVE: Get a random String (with only Numbers) values.
		 */
		public static String getRandomNumericString(int count) {
			StringBuilder builder = new StringBuilder();
			while (count-- != 0) {
				int character = (int) (Math.random() * NUMERIC_CHARS.length());
				builder.append(NUMERIC_CHARS.charAt(character));
			}
			// Reporting.logReporter(Status.DEBUG, "getRandomNumericString done" +
			// builder.toString());
			return builder.toString();
		}

		/**
		 * OBJECTIVE: Get a random String (without Numbers) values.
		 */
		public static String getRandomString(int count) {
			StringBuilder builder = new StringBuilder();
			while (count-- != 0) {
				int character = (int) (Math.random() * AZ_CHARS.length());
				builder.append(AZ_CHARS.charAt(character));
			}
			// Reporting.logReporter(Status.DEBUG, "getRandomString done" +
			// builder.toString());
			return builder.toString();
		}

		/**
		 * OBJECTIVE: Get a random String (without Numbers) values.
		 */
		private static String getRandomStringForEmail(int count) {
			StringBuilder builder = new StringBuilder();
			while (count-- != 0) {
				int character = (int) (Math.random() * EMAIL_CHARS.length());
				builder.append(EMAIL_CHARS.charAt(character));
			}
			// Reporting.logReporter(Status.DEBUG, "getRandomStringForEmail done" +
			// builder.toString());
			return builder.toString();
		}

	}

	/**
	 * Utilities to deal with TimeZones
	 */
	public static class TimeZoneUtils {

		// Formatter options
		public static final String FORMAT_MM_DD_YYYY_HH_MM_SS_Z_SEPARATOR_SLASHES = "MM/dd/yyyy hh:mm:ss Z";

		public static final String FORMAT_MM_DD_YYYY_HH_MM_SS_Z_SEPARATOR_HYPHENS = "MM-dd-yyyy hh:mm:ss Z";
		public static final String FORMAT_DD_MM_YYYY_HH_MM_SS_Z_SEPARATOR_SLASHES = "dd/MM/yyyy hh:mm:ss Z";

		public static final String FORMAT_DD_MM_YYYY_HH_MM_SS_Z_SEPARATOR_HYPHENS = "dd-MM-yyyy hh:mm:ss Z";
		// Common city's for the following TIMEZONES however is possible that
		// change due
		// to daylight time savings
		public static final String ZONE_ID_RELATED_TO_IST = "Asia/Kolkata";

		// ZoneId - you can obtain more values with the utility class
		// PrintTimeZoneAndOffSetList or see
		// https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html

		public static final String ZONE_ID_RELATED_TO_PST = "America/Los_Angeles";
		public static final String ZONE_ID_RELATED_TO_CST = "America/Chicago";
		public static final String ZONE_ID_RELATED_TO_EST = "America/New_York";
		public static final String ZONE_ID_ASIA_CALCUTTA = "Asia/Calcutta";

		public static final String ZONE_ID_AMERICA_MEXICO_CITY = "America/Mexico_City";

		private TimeZoneUtils() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * Utility to convert a Custom Date to another time zone Time Zone(from) to
		 * another(To)
		 *
		 * @param dateInString
		 * @param dateFormat
		 * @param fromZoneId
		 * @param toZoneId
		 */
		public static ZonedDateTime convertTimeZoneFromNow(String dateFormat, String fromZoneId, String toZoneId) {
			LocalDateTime ldt = LocalDateTime.now();
			return getDateToZonedDateTime(ldt, dateFormat, fromZoneId, toZoneId);
		}

		/**
		 * Utility to convert a Custom Date to another time zone Time Zone(from) to
		 * another(To)
		 *
		 * @param dateInString --> example "1-22-2015 10:15:55 AM"
		 * @param dateFormat
		 * @param fromZoneId
		 * @param toZoneId
		 */
		public static ZonedDateTime convertTimeZoneFromString(String dateInString, String dateFormat, String fromZoneId,
				String toZoneId) {
			LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(dateFormat));
			return getDateToZonedDateTime(ldt, dateFormat, fromZoneId, toZoneId);
		}

		public static String convertZonedDateToString(ZonedDateTime zonedDateTime, String dateFormat) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);
			String dateAsString = format.format(zonedDateTime);
			// Reporting.logReporter(Status.DEBUG, "convertZonedDateToString: " +
			// dateAsString);
			return dateAsString;
		}

		/**
		 * Utility to convert a Todays Date to another time zone Time Zone(from) to
		 * another(To)
		 *
		 * @param dateInString
		 * @param dateFormat
		 * @param fromZoneId
		 * @param toZoneId
		 */
		private static ZonedDateTime getDateToZonedDateTime(LocalDateTime ldt, String dateFormat, String fromZoneId,
				String toZoneId) {

			ZoneId originalZoneId = ZoneId.of(fromZoneId);
			ZonedDateTime fromZonedDateTime = ldt.atZone(originalZoneId);
			ZoneId newZoneId = ZoneId.of(toZoneId);

			ZonedDateTime newDateTime = fromZonedDateTime.withZoneSameInstant(newZoneId);
			DateTimeFormatter format = DateTimeFormatter.ofPattern(dateFormat);

			String from = "DateTimeFormatter - Date From (" + fromZoneId + ") : " + format.format(fromZonedDateTime);
			String to = "DateTimeFormatter - Date To (" + toZoneId + ") : " + format.format(newDateTime);

			// Reporting.logReporter(Status.DEBUG, from);
			// Reporting.logReporter(Status.DEBUG, to);

			return newDateTime;
		}

	}

	/**
	 * Utilities to do waits
	 */
	public static class Waits {

		private static final String MESSAGE_ANGULAR_TESTABILITIES = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";

		private static final String MESSAGE_DOCUMENT_READY = "return document.readyState";
		private static final String MESSAGE_COMPLETE = "complete";

		private Waits() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * Utility for Ajax validations
		 */
		private static void ajaxComplete() {
			JavascriptExecutor jsExec = JavaScripts.getJavaScriptExecutor();

			jsExec.executeScript("var callback = arguments[arguments.length - 1];" + "var xhr = new XMLHttpRequest();"
					+ "xhr.open('GET', '/Ajax_call', true);" + "xhr.onreadystatechange = function() {"
					+ "  if (xhr.readyState == 4) {" + "    callback(xhr.responseText);" + "  }" + "};"
					+ "xhr.send();");
		}

		/**
		 * Utility for Angular validations
		 */
		/**
		 * private static void angularLoads(String angularReadyScript, int
		 * waitInSeconds) { WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(),
		 * waitInSeconds); JavascriptExecutor jsExec =
		 * JavaScripts.getJavaScriptExecutor();
		 * 
		 * try { ExpectedCondition<Boolean> angularLoad = WebDriverSession.getWebDriverSession() ->
		 * Boolean.valueOf(((JavascriptExecutor)
		 * WebDriverSession.getWebDriverSession()).executeScript(angularReadyScript).toString());
		 * 
		 * // boolean angularReady = //
		 * Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString()); boolean
		 * angularReady = Boolean.parseBoolean((String)
		 * jsExec.executeScript(angularReadyScript)); if (!angularReady) {
		 * wait.until(angularLoad); } } catch (WebDriverException ignored) { // Nothing
		 * to do } }
		 **/
		/**
		 * Polling time
		 */
		private static void poll(long milis) {
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * OBJECTIVE: Setup the implicit wait for the WebDriverSession.getWebDriverSession(). Warning will affect all
		 * the WebDriverSession.getWebDriverSession() waits.
		 */
		public static void setImplicitWait(int waitInSseconds) {
			WebDriverSession.getWebDriverSession().manage().timeouts().implicitlyWait(waitInSseconds, TimeUnit.SECONDS);
			// Reporting.logReporter(Status.DEBUG, "setImplicitWait done");
		}

		/**
		 * OBJECTIVE: Short Wait for an element to be invisible (The element Exist but,
		 * is not visible) e.g. A Hidden Menu.
		 */
		public static void waitForElementInvisibility(WebElement element) {
			waitForElementInvisibility(element, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		public static void waitForElementInvisibility(WebElement element, int seconds) {
			try {
				element.isDisplayed();
			} catch (NoSuchElementException e) {
				// Expected error if element is not even present
				// Reporting.logReporter(Status.DEBUG, "waitForElementInvisibility done");
				return;
			}

			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), seconds);
			wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
			// Reporting.logReporter(Status.DEBUG, "waitForElementInvisibility done");
		}

		/**
		 * OBJECTIVE: Wait for an element to be invisible (The element Exist but, is not
		 * visible) e.g. A Hidden Menu.
		 */
		public static void waitForElementInvisibilityLongWait(WebElement element) {
			waitForElementInvisibility(element, GENERIC_LONG_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: Short wait for an element to display specific text for specific
		 * time in seconds. Use in the steps and use Element, expected text and seconds
		 * to wait as inputs.
		 */
		public static void waitForElementText(WebElement element, String strExpectedText) {
			waitForElementText(element, strExpectedText, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		private static void waitForElementText(WebElement element, String strExpectedText, int seconds) {
			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), seconds);
			wait.until(ExpectedConditions.textToBePresentInElement(element, strExpectedText));
			// Reporting.logReporter(Status.DEBUG, "waitForElementText done");
		}

		/**
		 * OBJECTIVE: Method to wait for an element to display specific text for
		 * specific time in seconds. Use in the steps and use Element, expected text and
		 * seconds to wait as inputs.
		 */
		public static void waitForElementTextLongWait(WebElement element, String strExpectedText) {
			waitForElementText(element, strExpectedText, GENERIC_LONG_TIME_OUT_SECONDS);
		}

		public static void waitForElementToBeClickable(WebElement element) {
			waitForElementToBeClickable(element, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		private static void waitForElementToBeClickable(WebElement element, int seconds) {
			System.out.println("***************" + element);
			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), seconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			// Reporting.logReporter(Status.DEBUG, "waitForElementToBeClickable done");
		}

		public static void waitForElementToBeClickableLongWait(WebElement element) {
			waitForElementToBeClickable(element, GENERIC_LONG_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: Short Wait for an element visibility
		 */
		public static void waitForElementVisibility(WebElement element) {
			waitForElementVisibility(element, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		public static void waitForElementVisibility(WebElement element, int seconds) {
			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			// Reporting.logReporter(Status.DEBUG, "waitForElementVisibility done");
		}
		
		public static void waitForElementToPresent(By locator) {
			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), GENERIC_LONG_TIME_OUT_SECONDS / 1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}

		/**
		 * OBJECTIVE: Long Wait for an element visibility
		 */
		public static void waitForElementVisibilityLongWait(WebElement element) {
			waitForElementVisibility(element, GENERIC_LONG_TIME_OUT_SECONDS);
		}

		public static void waitForTabsToOpen(int expectedNumberOfTabs) {
			waitForTabsToOpen(expectedNumberOfTabs, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		public static void waitForTabsToOpen(int expectedNumberOfTabs, int seconds) {
			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), seconds);
			wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfTabs));
			// Reporting.logReporter(Status.DEBUG, "waitForTabsToOpen done");
		}

		public static void waitForTabsToOpenLongWait(int expectedNumberOfTabs) {
			waitForTabsToOpen(expectedNumberOfTabs, GENERIC_LONG_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: Generic wait to wait for an specific period of time in
		 * milliseconds. Avoid the use of the same, instead use custom expect waits.
		 */
		public static void waitGeneric(int milliseconds) {
			try {
				Thread.sleep(milliseconds);
				// Reporting.logReporter(Status.DEBUG, "waitGeneric done");
			} catch (InterruptedException e) {
				e.printStackTrace();
				// Reporting.logReporter(Status.DEBUG, "waitGeneric error");
			}

		}

		/**
		 * OBJECTIVE: Method to do a Wait(Custom) until the Conditions is true
		 */
		private static void waitUntil(Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {
			WebDriverWait webDriverWait = new WebDriverWait(WebDriverSession.getWebDriverSession(), timeoutInSeconds);
			webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
			try {
				webDriverWait.until(waitCondition);
			} catch (Exception e) {
				// Reporting.logReporter(Status.DEBUG, e.getMessage());
			}
		}

		/**
		 * OBJECTIVE: Default wait for Angular5 Loads
		 */
		private static void waitUntilAngular5Load() {
			String angularReadyScript = MESSAGE_ANGULAR_TESTABILITIES;
//          angularLoads(angularReadyScript, GENERIC_LONG_TIME_OUT_SECONDS);
			// Reporting.logReporter(Status.DEBUG, "waitUntilAngular5Load done");
		}

		/**
		 * OBJECTIVE: Long wait for Angular5 Loads
		 */
		private static void waitUntilAngular5LoadLongWait() {
			String angularReadyScript = MESSAGE_ANGULAR_TESTABILITIES;
//          angularLoads(angularReadyScript, GENERIC_PAGE_TIME_OUT_SECONDS);
			// Reporting.logReporter(Status.DEBUG, "waitUntilAngular5LoadLongWait done");
		}

		/**
		 * OBJECTIVE: Default wait for Angular5 Ready
		 */
		public static void waitUntilAngular5Ready() {
			JavascriptExecutor jsExec = ((JavascriptExecutor) WebDriverSession.getWebDriverSession());

			try {
				Object angular5Check = jsExec
						.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
				if (angular5Check != null) {
					Boolean angularPageLoaded = (Boolean) jsExec.executeScript(MESSAGE_ANGULAR_TESTABILITIES);
					if (!angularPageLoaded) {
						poll(20);

						waitUntilAngular5Load();

						poll(20);
					}
				}
			} catch (WebDriverException ignored) {
				// // Reporting.logReporter(Status.DEBUG, "Angular5 not found -
				// case expected");
			}
			// Reporting.logReporter(Status.DEBUG, "waitUntilAngular5Ready done");
		}

		/**
		 * OBJECTIVE: Long wait for Angular5 Ready
		 */
		public static void waitUntilAngular5ReadyLongWait() {
			JavascriptExecutor jsExec = ((JavascriptExecutor) WebDriverSession.getWebDriverSession());

			try {
				Object angular5Check = jsExec
						.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
				if (angular5Check != null) {
					Boolean angularPageLoaded = (Boolean) jsExec.executeScript(MESSAGE_ANGULAR_TESTABILITIES);
					if (!angularPageLoaded) {
						poll(20);

						waitUntilAngular5LoadLongWait();

						poll(20);
					}
				}
			} catch (WebDriverException ignored) {
				// // Reporting.logReporter(Status.DEBUG, "Angular5 not found -
				// case expected");
			}
			// Reporting.logReporter(Status.DEBUG, "waitUntilAngular5ReadyLongWait done");
		}

		/**
		 * OBJECTIVE: Default wait for Angular Loads
		 */
		// waitForAngularLoad
		private static void waitUntilAngularLoad() {
			String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
//          angularLoads(angularReadyScript, GENERIC_LONG_TIME_OUT_SECONDS);
			// Reporting.logReporter(Status.DEBUG, "waitUntilAngularLoad done");
		}

		/**
		 * OBJECTIVE: Long wait for Angular Loads
		 */
		// waitForAngularLoad
		private static void waitUntilAngularLoadLongWait() {
			String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
//          angularLoads(angularReadyScript, GENERIC_PAGE_TIME_OUT_SECONDS);
			// Reporting.logReporter(Status.DEBUG, "waitUntilAngularLoadLongWait done");
		}

		/**
		 * OBJECTIVE: Long wait for Angular Ready
		 */
		public static void waitUntilAngularReady() {
			JavascriptExecutor jsExec = JavaScripts.getJavaScriptExecutor();

			try {
				Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
				if (!angularUnDefined) {
					Boolean angularInjectorUnDefined = (Boolean) jsExec
							.executeScript("return angular.element(document).injector() === undefined");
					if (!angularInjectorUnDefined) {
						poll(20);

						waitUntilAngularLoad();

						poll(20);
					}
				}
			} catch (WebDriverException ignored) {
				// // Reporting.logReporter(Status.DEBUG, "Angular not found - case
				// expected");
			}

			// Reporting.logReporter(Status.DEBUG, "waitUntilAngularReady done");
		}

		/**
		 * OBJECTIVE: Custom wait for Angular Ready
		 */
		public static void waitUntilAngularReadyLongWait() {
			JavascriptExecutor jsExec = JavaScripts.getJavaScriptExecutor();

			try {
				Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
				if (!angularUnDefined) {
					Boolean angularInjectorUnDefined = (Boolean) jsExec
							.executeScript("return angular.element(document).injector() === undefined");
					if (!angularInjectorUnDefined) {
						poll(20);

						waitUntilAngularLoadLongWait();

						poll(20);
					}
				}
			} catch (WebDriverException ignored) {
				// // Reporting.logReporter(Status.DEBUG, "Angular not found - case
				// expected");
			}

			// Reporting.logReporter(Status.DEBUG, "waitUntilAngularReadyLongWait done");
		}

		/**
		 * OBJECTIVE: Method to do a Wait(Default) until the JQuery Count is Zero, (By
		 * the usual means that the request for certain event has finished, e.g. DB
		 * request)
		 */
		private static void waitUntilJqueryLoadComplete() {
			waitUntilJqueryLoadCompleteCustomTimeOut(Long.valueOf(GENERIC_LONG_TIME_OUT_SECONDS));
		}

		/**
		 * waitForJQueryLoad OBJECTIVE: Method to do a Wait(Custom) until the JQuery
		 * Count is Zero, (By the usual means that the request for certain event has
		 * finished, e.g. DB request)
		 */
		private static void waitUntilJqueryLoadCompleteCustomTimeOut(Long timeoutInSeconds) {
//          WebDriver WebDriverSession.getWebDriverSession() = WebDriverSession.getWebDriverSession();

//          waitUntil(d -> {
//              Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) WebDriverSession.getWebDriverSession()).executeScript("return jQuery.active==0");
//              if (!isJqueryCallDone) {
//                  // System.out.println("JQuery call is in Progress");
//              }
//              return isJqueryCallDone;
//          }, timeoutInSeconds);

			// Reporting.logReporter(Status.DEBUG, "waitUntilJqueryIsDone done");
		}

		/**
		 * OBJECTIVE: Method to do a Wait(Long) until the JQuery Count is Zero, (By the
		 * usual means that the request for certain event has finished, e.g. DB request)
		 */
		private static void waitUntilJqueryLoadCompleteLongWait() {
			waitUntilJqueryLoadCompleteCustomTimeOut(Long.valueOf(GENERIC_PAGE_TIME_OUT_SECONDS));
		}

		/**
		 * OBJECTIVE: Default wait for JQuery Ready
		 */
		public static void waitUntilJQueryReady() {
			JavascriptExecutor jsExec = ((JavascriptExecutor) WebDriverSession.getWebDriverSession());
			Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
			if (jQueryDefined) {
				poll(20);

				waitUntilJqueryLoadComplete();

				poll(20);
			}
			// Reporting.logReporter(Status.DEBUG, "waitUntilJQueryReady done");
		}

		/**
		 * OBJECTIVE: Long wait for JQuery Ready
		 */
		public static void waitUntilJQueryReadyLongWait() {
			JavascriptExecutor jsExec = ((JavascriptExecutor) WebDriverSession.getWebDriverSession());
			Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
			if (jQueryDefined) {
				poll(20);

				waitUntilJqueryLoadCompleteLongWait();

				poll(20);
			}
			// Reporting.logReporter(Status.DEBUG, "waitUntilJQueryReady done");
		}

		/**
		 * OBJECTIVE: Default wait for JS ready state, Ajax call completed, JQuery Ready
		 * state, Angular Ready, Angular5 Ready
		 */
		public static void waitUntilJsAjaxJqueryAngularAngular5RequestsReady() {
			waitUntilJSReady();
			ajaxComplete();
			waitUntilJQueryReady();
			waitUntilAngularReady();
			waitUntilAngular5Ready();
		}

		/**
		 * OBJECTIVE: Long wait for JS ready state, Ajax call completed, JQuery Ready
		 * state, Angular Ready, Angular5 Ready
		 */
		public static void waitUntilJsAjaxJqueryAngularAngular5RequestsReadyLongWait() {
			waitUntilJSReadyLongWait();
			ajaxComplete();
			waitUntilJQueryReadyLongWait();
			waitUntilAngularReadyLongWait();
			waitUntilAngular5ReadyLongWait();
		}

		/**
		 * OBJECTIVE: Custom wait for JS Ready
		 */
		public static void waitUntilJSReady() {
			waitUntilJSReadyCustomTimeOut(GENERIC_LONG_TIME_OUT_SECONDS);
		}

		// waitUntilJSReady
		private static void waitUntilJSReadyCustomTimeOut(int waitInSeconds) {
			WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), waitInSeconds);
			JavascriptExecutor jsExec = ((JavascriptExecutor) WebDriverSession.getWebDriverSession());

			try {
//              ExpectedCondition<Boolean> jsLoad = WebDriverSession.getWebDriverSession() -> ((JavascriptExecutor) WebDriverSession.getWebDriverSession()).executeScript(MESSAGE_DOCUMENT_READY).toString().equals(MESSAGE_COMPLETE);
//
//              boolean jsReady = jsExec.executeScript(MESSAGE_DOCUMENT_READY).toString().equals(MESSAGE_COMPLETE);
//
//              if (!jsReady) {
//                  wait.until(jsLoad);
//              }
			} catch (WebDriverException ignored) {
				// // Reporting.logReporter(Status.DEBUG, "JS not found - case
				// expected");
			}
			// Reporting.logReporter(Status.DEBUG, "waitUntilJSReadyCustomTimeOut done");
		}

		/**
		 * OBJECTIVE: lONG wait for JS Ready
		 */
		public static void waitUntilJSReadyLongWait() {
			waitUntilJSReadyCustomTimeOut(GENERIC_PAGE_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: Short wait - Method to create An expectation for checking that the
		 * First element from a list is present.
		 */
		public static void waitUntilListFirstElementIsPresent(List<WebElement> list) {
			waitUntilListFirstElementIsPresent(list, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		private static void waitUntilListFirstElementIsPresent(List<WebElement> list, int timeOutInSeconds) {

			for (int i = 1; i <= timeOutInSeconds; i++) {
				try {
					waitGeneric(ONE_SECOND);
					list.get(0);
					// Reporting.logReporter(Status.DEBUG, "waitUntilListFirstElementIsPresent
					// done");
					return; // To Exit after success Found
				} catch (IndexOutOfBoundsException e) {
					// Do nothing Expected Failure
				}
			}

			throw new UnsupportedOperationException(
					"Element not present after try for " + timeOutInSeconds + " seconds");
		}

		/**
		 * OBJECTIVE: Method to create An expectation for checking that the First
		 * element from a list is present.
		 */
		public static void waitUntilListFirstElementIsPresentLongWait(List<WebElement> list) {
			waitUntilListFirstElementIsPresent(list, GENERIC_LONG_TIME_OUT_SECONDS);
		}

		/**
		 * OBJECTIVE: Method to do a Wait(Default) until the page return
		 * document.readyState = complete, Means the page DOM hhas loaded, but that does
		 * not mean that is accessible; Recommended to use in conjunction of a wait for
		 * some Element Visibility.
		 */
		public static void waitUntilPageLoadComplete() {
			waitUntilPageLoadComplete(Long.valueOf(GENERIC_LONG_TIME_OUT_SECONDS));
		}

		/**
		 * OBJECTIVE: Method to do a Wait(Custom) until the page return
		 * document.readyState = complete, Means the page DOM has loaded, but that does
		 * not mean that is accessible; Recommended to use in conjunction of a wait for
		 * some Element Visibility.
		 */
		private static void waitUntilPageLoadComplete(Long timeoutInSeconds) {
//          WebDriver WebDriverSession.getWebDriverSession() = WebDriverSession.getWebDriverSession();

//          waitUntil(d -> {
//              Boolean isPageLoaded = ((JavascriptExecutor) WebDriverSession.getWebDriverSession()).executeScript(MESSAGE_DOCUMENT_READY).equals(MESSAGE_COMPLETE);
//              if (!isPageLoaded) {
//                  // System.out.println("Document is loading");
//              }
//              return isPageLoaded;
//          }, timeoutInSeconds);

			// Reporting.logReporter(Status.DEBUG, "waitUntilPageLoadComplete done");
		}

		/**
		 * OBJECTIVE: Method to do a Wait(Long) until the page return
		 * document.readyState = complete, Means the page DOM hhas loaded, but that does
		 * not mean that is accessible; Recommended to use in conjunction of a wait for
		 * some Element Visibility.
		 */
		public static void waitUntilPageLoadCompleteLongWait() {
			waitUntilPageLoadComplete(Long.valueOf(GENERIC_PAGE_TIME_OUT_SECONDS));
		}

	}

	/**
	 * Utilities to help interaction with WebElements
	 */
	public static class WebElementUtils {

		private WebElementUtils() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Know if a given element has a certain "class" name as attribute,
		 * useful for escenarios where some attribute is added under certain conditions
		 */
		public static boolean elementHasClass(WebElement element, String classToLook) {
			return element.getAttribute("class") != null && element.getAttribute("class").contains(classToLook);
		}

		/**
		 * OBJECTIVE: Some Elements Unique selector is not the one that we need to
		 * interact, so by the usual the "parent" will allow to perform some interaction
		 * with it.
		 */
		public static WebElement getParentElementFromCssClass(WebElement aCheckbox) {
			return aCheckbox.findElement(By.xpath(".."));
		}

		/**
		 * get an array resized
		 */
		public static Object resizeArray(Object oldArray, int newSize) {
			int oldSize = java.lang.reflect.Array.getLength(oldArray);
			Class elementType = oldArray.getClass().getComponentType();
			Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
			int preserveLength = Math.min(oldSize, newSize);

			if (preserveLength > 0) {
				System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
			} else {
				// Reporting.logReporter(Status.DEBUG, "resizeArray cannot be done");
			}
			return newArray;
		}
	}

	/**
	 * Utilities to Interact with iFrames
	 */
	public static class Windows {

		private Windows() {
			throw new IllegalStateException(CONSTRUCTOR_MESSAGE);
		}

		/**
		 * OBJECTIVE: Use this method to go back to the original window when switching
		 * to a new one.
		 */
		public static void closeNewWindow(String originalWindow) {

			while (WebDriverSession.getWebDriverSession().getWindowHandles().size() > 1) {
				switchBackFromNewWindow(originalWindow);
			}

			// Reporting.logReporter(Status.DEBUG, "closeNewWindow done");
		}

		public static void maximizeWindow() {
			WebDriverSession.getWebDriverSession().manage().window().maximize();
			Waits.waitGeneric(ONE_SECOND * 2);
			// Reporting.logReporter(Status.DEBUG, "maximizeWindow done");
		}

		public static void navigateBack() {
			WebDriverSession.getWebDriverSession().navigate().back();
			// Reporting.logReporter(Status.DEBUG, "navigateBack done");
		}

		public static void navigateForward() {
			WebDriverSession.getWebDriverSession().navigate().forward();
			// Reporting.logReporter(Status.DEBUG, "navigateForward done");
		}

		public static void refresh() {
			WebDriverSession.getWebDriverSession().navigate().refresh();
			// Reporting.logReporter(Status.DEBUG, "Refresh done");
		}

		/**
		 * OBJECTIVE: Use this method to go back to the original window when switching
		 * to a new one.
		 */
		public static void switchBackFromNewWindow(String window) {
			WebDriverSession.getWebDriverSession().close();
			WebDriverSession.getWebDriverSession().switchTo().window(window);
			// Reporting.logReporter(Status.DEBUG, "switchBackFromNewWindow done");
		}

		/**
		 * OBJECTIVE: Use this method when steps flow open a new window.
		 */
		public static String switchToNewWindow() {
			String winHandleBefore = WebDriverSession.getWebDriverSession().getWindowHandle();
			BaseStep.Waits.waitGeneric(GENERIC_SHORT_TIME_OUT_SECONDS * ONE_SECOND);

			for (String winHandle : WebDriverSession.getWebDriverSession().getWindowHandles()) {
				WebDriverSession.getWebDriverSession().switchTo().window(winHandle);
			}
			// Reporting.logReporter(Status.DEBUG, "switchToNewWindow done");
			return winHandleBefore;
		}

		public static boolean switchToWindowThatContainsPartialUrl(String partialUrl) {
			return switchToWindowThatContainsPartialUrl(partialUrl, GENERIC_SHORT_TIME_OUT_SECONDS);
		}

		private static boolean switchToWindowThatContainsPartialUrl(String partialUrl, int timeToWaitInSeconds) {
			for (int i = 0; i <= timeToWaitInSeconds; i++) {
				Waits.waitGeneric(ONE_SECOND);

				for (String winHandle : WebDriverSession.getWebDriverSession().getWindowHandles()) {
					WebDriverSession.getWebDriverSession().switchTo().window(winHandle);

					if (WebDriverSession.getWebDriverSession().getCurrentUrl().contains(partialUrl)) {
						// Reporting.logReporter(Status.DEBUG, "switchToWindowThatContainsPartialUrl
						// done");
						return true;
					}
				}
			}

			// Reporting.logReporter(Status.DEBUG, "Partial Url: " + partialUrl + " not
			// Found in any window");
			return false;
		}

		public static boolean switchToWindowThatContainsPartialUrlLongWait(String partialUrl) {
			return switchToWindowThatContainsPartialUrl(partialUrl, GENERIC_LONG_TIME_OUT_SECONDS);
		}

	}

	private static final String CONSTRUCTOR_MESSAGE = "Utility class - Not Designed to be Instantiated";

	private static final int ONE_SECOND = 1000;

	/**
	 * Global Variables, that are set by the SystemProperties file
	 */
//  private static final int GENERIC_LONG_TIME_OUT_SECONDS = SystemProperties.LONG_WAIT_TIMEOUT_MILLIS / ONE_SECOND;
	private static final int GENERIC_LONG_TIME_OUT_SECONDS = 10000;
	private static final int GENERIC_SHORT_TIME_OUT_SECONDS = 5000 / ONE_SECOND;

	private static final int GENERIC_PAGE_TIME_OUT_SECONDS = 10000 / ONE_SECOND;

}



