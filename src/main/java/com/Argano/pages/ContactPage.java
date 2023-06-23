package com.Argano.pages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.reports.ExtentLogger;
import com.Argano.utlis.DynamicXpathUtlis;
import com.google.common.util.concurrent.Uninterruptibles;

public class ContactPage extends ApplicationMethods{
	
	private final By bttnNewContact = By.xpath("//div[@title='New']");

	private final By txtTitle = By.xpath("//input[@name='Title']");

	private final By First_Name = By.xpath("//input[@name='firstName']");
	private final By Last_Name = By.xpath("//input[@name='lastName']");

	private final By txtEmail = By.xpath("//input[@name='Email']");
	
	private final By SourceDropdown = By.xpath("//button[@aria-label='Source, --None--']");
	private final By Sourceoptions = By
			.xpath("//button[@aria-label='Source, --None--']/parent::div//following-sibling::div//span[normalize-space(text())]");
	
	public ContactPage selectContactSource() {
		jsOperation(JSAction.SCROLLTOVIEW, SourceDropdown);
		click(SourceDropdown, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listSourceoptions = getElements(Sourceoptions);
		int n = getRandomNumber(1, listSourceoptions.size() - 1);
		String contactSource = listSourceoptions.get(n).getAttribute("innerHTML");
		
		jsOperation(JSAction.SCROLLTOVIEW, listSourceoptions.get(n));
		jsOperation(JSAction.CLICK, listSourceoptions.get(n));
		ExtentLogger.info("Selected contact Source as :" + contactSource );
		return this;
	}
	
	private final By SourceTypeDropdown = By.xpath("//button[@aria-label='Source Type, --None--']");
	private final By SourceTypeoptions = By
			.xpath("//button[@aria-label='Source Type, --None--']/parent::div//following-sibling::div//span[normalize-space(text())]");
	
	public ContactPage selectContactSourceType() {
		click(SourceTypeDropdown, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listSourceTypeoptions = getElements(SourceTypeoptions);
		int n = getRandomNumber(1, listSourceTypeoptions.size() - 1);
		String contactSourceType = listSourceTypeoptions.get(n).getAttribute("innerHTML");
		
		jsOperation(JSAction.SCROLLTOVIEW, listSourceTypeoptions.get(n));
		jsOperation(JSAction.CLICK, listSourceTypeoptions.get(n));
		ExtentLogger.info("Selected contact Source as :" + contactSourceType );
		return this;
	}
	
	public ContactPage newContact() {

		click(bttnNewContact, WaitStrategy.CLICKABLE, 5, "New contact ");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		return this;
	}

	private final By SalutationDropdown = By.xpath("//button[@name='salutation']");
	String value = "//span[text()='%s']";
	

	String towerXpath = "//span[text()='%s']/parent::label/following-sibling::div//input";

	public ContactPage select_Tower(String Tower) {
		String option = DynamicXpathUtlis.getXpath(towerXpath, Tower);
		jsOperation(JSAction.CLICK, By.xpath(option));

		return this;
	}

	public ContactPage enter_Email(String email) {
		sendKeys(txtEmail, email, WaitStrategy.CLICKABLE, 5);
		return this;
	}

	public ContactPage enter_Title() {
		sendKeys(txtTitle, getTitletxt(), WaitStrategy.CLICKABLE, 5);
		return this;
	}



	public ContactPage enter_LastName(String lastname) {
		sendKeys(Last_Name, lastname, WaitStrategy.CLICKABLE, 5);
		return this;
	}


	public ContactPage enter_FirstName(String firstname) {
		sendKeys(First_Name, firstname, WaitStrategy.CLICKABLE, 5);
		return this;
	}

	public ContactPage select_Salutatiom(String SalutationOption) {
		click(SalutationDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, SalutationOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	private final By Cancelbttn = By.xpath("//button[@name='CancelEdit']");

	public Homepage cancelContact() {
		//Waits.sleep(3);
		click(Cancelbttn, WaitStrategy.CLICKABLE, 5);
		return new Homepage();
	}

	private final By Savebttn = By.xpath("//button[text()='Save']");

	public Homepage saveContact() {
		//Waits.sleep(3);
		click(Savebttn, WaitStrategy.CLICKABLE, 5);
		return new Homepage();
	}

	
	public  String createContact(Map<String, String> data)
	{
		String firstname = getFirstName();
		String Lastname = getLastName();
		String email = firstname+"."+Lastname+"@automationtest.com";
		
		enter_FirstName(firstname).enter_LastName(Lastname).enter_Email(email).enter_Title().select_Tower(data.get("ContactTower")).selectContactSource().selectContactSourceType().saveContact();
return firstname + " " + Lastname;
	}
	
	private String recordInRelatedList = "//a[contains(@title,'%s')]";
	
	public boolean isContactDisplayedInReleatedList(String contactname) {
		
	Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
	
		String contactInRelatedListXpath = DynamicXpathUtlis.getXpath(recordInRelatedList, contactname);
		return	isDisplayed(By.xpath(contactInRelatedListXpath), 20);

		
	}
	
}



