package com.Argano.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Argano.driver.DriverManager;
import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.factory.ExplicitWaitFactory;
import com.Argano.reports.ExtentLogger;
import com.github.javafaker.Faker;
import com.google.common.util.concurrent.Uninterruptibles;

public class BasePage {
	private static final Faker faker = new Faker(new Locale("en-IND"));

	protected void click(By by, WaitStrategy waitstragety, int waitTime, String elementname) {

		ExplicitWaitFactory.performExplicitWait(by, waitstragety, waitTime).click();
		ExtentLogger.info(elementname + " is clicked");
	}

	protected void click(By by, WaitStrategy waitstragety, int waitTime) {

		ExplicitWaitFactory.performExplicitWait(by, waitstragety, waitTime).click();
	}

	protected void sendKeys(By by, String value, WaitStrategy waitstragety, int waitTime, String elementname) {
		ExplicitWaitFactory.performExplicitWait(by, waitstragety, waitTime).sendKeys(value);
		ExtentLogger.info(value + " is entered in  " + elementname);
	}

	protected void sendKeys(By by, String value, WaitStrategy waitstragety, int waitTime) {
		ExplicitWaitFactory.performExplicitWait(by, waitstragety, waitTime).sendKeys(value);

	}

	protected void clickENTER(By by, WaitStrategy waitstragety, int waitTime) {
		ExplicitWaitFactory.performExplicitWait(by, waitstragety, waitTime).sendKeys(Keys.BACK_SPACE);

	}

	protected void clear(By by, WaitStrategy waitstragety, int waitTime) {
		ExplicitWaitFactory.performExplicitWait(by, waitstragety, waitTime).clear();
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected String getText(By by, int waitTime) {
		return ExplicitWaitFactory.performExplicitWait(by, WaitStrategy.VISIBLE, waitTime).getText();
	}

	protected List<WebElement> getElements(By by) {
		return DriverManager.getDriver().findElements(by);
	}

	protected List<String> getElementstext(By by) {
		List<String> textList = new ArrayList<String>();

		List<WebElement> elements = getElements(by);
		for (WebElement element : elements) {
			textList.add(element.getText().trim());
		}
		return textList;

	}

	protected static String getRandomString(int n) {
		String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaString.length() * Math.random());
			sb.append(AlphaString.charAt(index));
		}
		return sb.toString();
	}

	protected static void jsOperation(JSAction jsaction, By by, String message) {
		WebElement element = DriverManager.getDriver().findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();

		if (jsaction == JSAction.CLICK) {
			executor.executeScript("arguments[0].click();", element);
			ExtentLogger.pass(message);
		} else if (jsaction == JSAction.SCROLLTOVIEW) {
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}

	protected static void jsOperation(JSAction jsaction) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();

		if (jsaction == JSAction.SCROLLDOWN) {
			executor.executeScript("window.scrollBy(0,350)", "");
		}
	}

	protected static void jsOperation(JSAction jsaction, By by) {
		WebElement element = DriverManager.getDriver().findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();

		if (jsaction == JSAction.CLICK) {
			executor.executeScript("arguments[0].click();", element);

		} else if (jsaction == JSAction.SCROLLTOVIEW) {
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}

	protected String getcurrentDateInFormat(String format) {

		Date date = new Date();
		SimpleDateFormat simpleformat = new SimpleDateFormat(format);
		return simpleformat.format(date);
	}

	protected String getCurrentDatePlusInFormat(String format, int dateplus) {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, dateplus);
		Date date = c.getTime();
		SimpleDateFormat simpleformat = new SimpleDateFormat(format);
		return simpleformat.format(date);
	}

	protected void navigateToFrame(By by) {
		WebElement containerFrame = DriverManager.getDriver().findElement(by);
		DriverManager.getDriver().switchTo().frame(containerFrame);
	}

	protected List<String> removeAllOccuranceOfStringFromList(List<String> list, String valuetoberemoved) {
		int index;
		while ((index = list.indexOf(valuetoberemoved)) >= 0) {
			list.remove(index);
		}
		return list;
	}

	protected void refresh() {
		DriverManager.getDriver().navigate().refresh();
	}

	protected void refreshByCurrURL() {
		DriverManager.getDriver().get(DriverManager.getDriver().getCurrentUrl());

	}

	protected String getDD() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Date date = new Date();
		String s = formatter.format(date);
		if (s.charAt(0) == '0') {
			return s.charAt(1) + "";
		}
		return s;

	}

	protected String getMM() {

		SimpleDateFormat formatter = new SimpleDateFormat("mm");
		Date date = new Date();
		String s = formatter.format(date);

		return s;

	}

	protected String getYYYY() {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String s = formatter.format(date);

		return s;
	}

	protected void alertAccept() {
		DriverManager.getDriver().switchTo().alert().accept();
	}

	protected void alertReject() {
		DriverManager.getDriver().switchTo().alert().dismiss();
	}

	// JS Executer click

	protected void jseClickByScript(String script, String elementname, int time) {
		Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
		WebElement element = (WebElement) jse.executeScript(script);
		jse.executeScript("arguments[0].click();", element);
		ExtentLogger.info(elementname + " is clicked");
	}

	protected void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected String getTitletxt() {
		return faker.job().position();
	}

	protected String getCompanyName() {
		return faker.company().name().replaceAll("[^a-zA-Z ]", "");
	}

	protected String getAddress() {
		return faker.address().streetAddress();
	}

	protected String getCity() {
		return faker.address().city();
	}

	protected String getCountry() {
		return faker.country().toString();
	}

	protected String getFirstName() {
		return faker.name().firstName();
	}

	protected String getMiddleName() {
		return faker.name().nameWithMiddle();
	}

	protected String getLastName() {
		return faker.name().lastName();
	}

	protected String getStreetName() {
		return faker.address().streetName();

	}

	protected String getPincode() {
		return faker.address().streetName();

	}

	protected String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public static String getContactNumber() {
		return faker.phoneNumber().cellPhone();
	}

}
