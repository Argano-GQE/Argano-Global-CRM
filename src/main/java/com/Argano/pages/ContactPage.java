package com.Argano.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.DynamicXpathUtlis;
import com.Argano.utlis.FakerAPI;
import com.Argano.utlis.Waits;
import com.google.common.util.concurrent.Uninterruptibles;

public class ContactPage extends BasePage {
	private final By bttnNewContact = By.xpath("//div[@title='New']");

	private final By txtTitle = By.xpath("//input[@name='Title']");

	private final By First_Name = By.xpath("//input[@name='firstName']");
	private final By Middle_Name = By.xpath("//input[@name='middleName']");
	private final By Last_Name = By.xpath("//input[@name='lastName']");
//	private final By Suffix = By.xpath("//input[@name='suffix']");
	private final By txtAccountName = By
			.xpath("//label[text()='Account Name']/parent::lightning-grouped-combobox//input");

	private final By txtEmail = By.xpath("//input[@name='Email']");

	private final By Department_Textbox = By.xpath("//input[@name='Department]");

	private final By SourceDropdown = By.xpath("//button[@aria-label='Source, --None--']");
	private final By sourceOption = By.xpath("//span[text()='Client']");

	private final String account_NameXpath = "//li//lightning-base-combobox-item//span[text()='%s']/ancestor::li";

	private final By Street = By.xpath("//textarea[@name='street']");
	private final By Cityname = By.xpath("//input[@name='city']");
	private final By Zip = By.xpath("//input[@name='postalCode']");

	public ContactPage newContact() {

		click(bttnNewContact, WaitStrategy.CLICKABLE, 5, "New contact ");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		return this;
	}

	private final By SalutationDropdown = By.xpath("//button[@name='salutation']");
//	private final By Salution_Mr = By.xpath("//span[text()='Mr.']");
	String value = "//span[text()='%s']";

	public ContactPage select_source(String sourceOption) {
		jsOperation(JSAction.CLICK, SourceDropdown);
		String option = DynamicXpathUtlis.getXpath(value, sourceOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	String towerXpath = "//span[text()='%s']/parent::label/following-sibling::div//input";

	public ContactPage select_Tower(String Tower) {
		String option = DynamicXpathUtlis.getXpath(towerXpath, Tower);
		jsOperation(JSAction.CLICK, By.xpath(option));

		return this;
	}

	public ContactPage enter_Email() {
		sendKeys(txtEmail, FakerAPI.getEmailAddress(), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	public ContactPage enter_Title() {
		sendKeys(txtTitle, FakerAPI.getTitle(), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	public ContactPage enter_AccountName(String AccoutName) {
		sendKeys(txtAccountName, AccoutName, WaitStrategy.CLICKABLE, 5);
		String AccountNameDropdownOptionXpath = DynamicXpathUtlis.getXpath(account_NameXpath, AccoutName);
		final By AccountNameDropdownOption = By.xpath(AccountNameDropdownOptionXpath);

		try {
			jsOperation(JSAction.CLICK, AccountNameDropdownOption, WaitStrategy.CLICKABLE, 5);
//			click(AccountNameDropdownOption, WaitStrategy.CLICKABLE, 15);
		} catch (Exception e) {
			sendKeys(txtAccountName, Keys.ARROW_DOWN, WaitStrategy.CLICKABLE, 5);
			sendKeys(txtAccountName, Keys.ARROW_DOWN, WaitStrategy.CLICKABLE, 5);
			sendKeys(txtAccountName, Keys.ENTER, WaitStrategy.CLICKABLE, 5);

		}
		return this;
	}

	public ContactPage enter_LastName() {
		sendKeys(Last_Name, FakerAPI.getLastName(), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	public ContactPage enter_MiddleName() {
		sendKeys(Middle_Name, FakerAPI.getMiddleName(), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	public ContactPage enter_FirstName() {
		sendKeys(First_Name, FakerAPI.getFirstName(), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	public ContactPage select_Salutatiom(String SalutationOption) {
		click(SalutationDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, SalutationOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	private final By SourceTypeDropdown = By.xpath("//button[@aria-label='Source Type, --None--']");
//	private final By sourceTypeOption = By.xpath("//span[text()='Growth on Existing Client Base']");

	public ContactPage sourceType(String sourceTypeOption) {
		jsOperation(JSAction.CLICK, SourceTypeDropdown);
		String option = DynamicXpathUtlis.getXpath(value, sourceTypeOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 5);
		return this;
	}

	private final By Cancelbttn = By.xpath("//button[@name='CancelEdit']");

	public Homepage cancelContact() {
		Waits.sleep(3);
		click(Cancelbttn, WaitStrategy.CLICKABLE, 5);
		return new Homepage();
	}

	private final By Savebttn = By.xpath("//button[text()='Save']");

	public Homepage saveContact() {
		Waits.sleep(3);
		click(Savebttn, WaitStrategy.CLICKABLE, 5);
		return new Homepage();
	}

}
