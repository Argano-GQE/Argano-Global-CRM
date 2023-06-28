package com.Argano.pages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.reports.ExtentLogger;
import com.Argano.utlis.DynamicXpathUtlis;
import com.google.common.util.concurrent.Uninterruptibles;

public class LeadPage extends ApplicationMethods {

	private final By bttnCreateNewLead = By.xpath("//div[text()='New']");
	private final By btnPopupNext = By.xpath("//span[text()='Next']");
	private final By Title = By.xpath("//button[@name='salutation']");
	private final String dropTitlevalue = "//span[contains(@title,'%s')]";
	private final By txtTitle = By.xpath("//input[@name='Title']");
//Name Field
	private final By txtFirstName = By.xpath("//input[@name='firstName']");
	private final By txtMiddleName = By.xpath("//input[@name='middleName']");
	private final By txtLastName = By.xpath("//input[@name='lastName']");
	private final By txtSuffix = By.xpath("//input[@name='suffix']");
	private final By txtDescription = By.xpath("//label[text()='Description']/following-sibling::div/textarea");
//Company name and email
	private final By txtCompanyName = By.xpath("//input[@name='Company']");
	private final By txtEmail = By.xpath("//input[@name='Email']");

//Tower
	private final String towerValue = "//span[contains(text(),'%s')]/parent::label/following-sibling::div//input";

//Lead Details
	private final By dropLeadStatus = By.xpath("//button[@aria-label='Lead Status, MCL']");
	private final String dropLeadStatusvalue = "//span[contains(@title,'%s')]";
	private final By dropLeadSource = By.xpath("//button[@aria-label='Source, --None--']");
	private final String dropLeadSourcevalue = "//span[contains(@title,'%s')]";
	private final By dropLeadSourcetype = By.xpath("//button[@aria-label='Source Type, --None--']");
	private final String dropLeadSourcetypevalue = "//span[contains(@title,'%s')]";

//Address details
	private final By Street = By.xpath("//textarea[@name='street']");
	private final By Cityname = By.xpath("//input[@name='city']");
	private final By Zip = By.xpath("//input[@name='postalCode']");

	private final By bttnSave = By.xpath("//button[@name='SaveEdit']");

	private final By bttnStatusComplete = By
			.xpath("//div[@class='slds-grid slds-path__action runtime_sales_pathassistantPathAssistantHeader']/button");
	private final By bttnConvert = By.xpath("//button[text()='Convert']");
	private final By bttnConvertInPoPUp = By
			.xpath("//span[contains(@class,'runtime_sales_leadConvertModalFooter')]/button[text()='Convert']");

	private final By LeadConvertSucesssTXT = By
			.xpath("//lightning-formatted-text[text()='Your lead has been converted']");

	private final By convertedAccount = By.xpath("//div[text()='Account']//parent::div//div//a");
	private final By convertedContact = By.xpath("//div[text()='Contact']//parent::div//div//a");
	private final By convertedOpportunity = By.xpath("//div[text()='Opportunity']//parent::div//div//a");

	public String getConvertedAccount() {
		return getText(convertedAccount, 10);

	}

	public String getConvertedContact() {
		return getText(convertedContact, 5);

	}

	public String getConvertedOpportunity() {
		return getText(convertedOpportunity, 5);

	}

	private final By bttnGotoLead = By.xpath("//button[text()='Go to Leads']");

	public Boolean isLeadConverted() {
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

		return isDisplayed(LeadConvertSucesssTXT, 20);
	}

	public LeadPage updateLeadStatus() {

		for (int i = 0; i < 4; i++) {

			jsOperation(JSAction.CLICK, bttnStatusComplete);
			sleep(5);

		}
		return this;

	}

	public LeadPage CreateNewLead() {

		click(bttnCreateNewLead, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public final LeadPage Clicknextbttn() {

		click(btnPopupNext, WaitStrategy.CLICKABLE, 10);
		return this;

	}

	public LeadPage SelectTitletext() {

		sendKeys(txtTitle, getTitletxt(), WaitStrategy.CLICKABLE, 100);

		return this;
	}

	public LeadPage SelectSalutation(String salutation) {

		click(Title, WaitStrategy.VISIBLE, 1);
		String TitleXpath = DynamicXpathUtlis.getXpath(dropTitlevalue, salutation);
		click(By.xpath(TitleXpath), WaitStrategy.CLICKABLE, 5, "Selected Salutation : " + salutation);

		return this;

	}

	public LeadPage SelectLeadTower(String tower) {

		String leadTowerXpath = DynamicXpathUtlis.getXpath(towerValue, tower);
		jsOperation(JSAction.SCROLLTOVIEW, By.xpath(leadTowerXpath));
		jsOperation(JSAction.CLICK, By.xpath(leadTowerXpath));
		// click(By.xpath(leadTowerXpath), WaitStrategy.CLICKABLE, 5, "Selected Tower :
		// " + tower);

		return this;

	}

	public LeadPage enterLeadFirstName() {

		sendKeys(txtFirstName, getFirstName(), WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public LeadPage enterLeadMiddleName() {

		sendKeys(txtMiddleName, getMiddleName(), WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public LeadPage enterLeadLastName() {

		sendKeys(txtLastName, getLastName(), WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public LeadPage enterSuffix(String Suffixvalue) {
		sendKeys(txtSuffix, Suffixvalue, WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage enterCompanyName() {
		sendKeys(txtCompanyName, getCompanyName(), WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage enterCompanyEmail() {

		sendKeys(txtEmail, getEmailAddress(), WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage enterDescription(String LeadDes) {

		sendKeys(txtDescription, LeadDes, WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage SelectLeadstatus(String Leadvalue) {

		jsOperation(JSAction.SCROLLTOVIEW, dropLeadStatus);
		click(dropLeadStatus, WaitStrategy.NONE, 2, "Lead status dropdown");
		String leadstatusXpath = DynamicXpathUtlis.getXpath(dropLeadStatusvalue, Leadvalue);
		click(By.xpath(leadstatusXpath), WaitStrategy.CLICKABLE, 0, "Lead Status dropdown " + Leadvalue);
		return this;

	}

	public LeadPage SelectLeadsource(String Leadsource) {

		jsOperation(JSAction.SCROLLTOVIEW, dropLeadSource);
		click(dropLeadSource, WaitStrategy.NONE, 2);
		String leadsourceXpath = DynamicXpathUtlis.getXpath(dropLeadSourcevalue, Leadsource);
		click(By.xpath(leadsourceXpath), WaitStrategy.CLICKABLE, 0, "Selected Source as :" + Leadsource);
		return this;

	}

	public LeadPage SelectLeadsourcetype(String Sourcetype) {

		click(dropLeadSourcetype, WaitStrategy.NONE, 2);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(dropLeadSourcetypevalue, Sourcetype);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Selected Source Type as :" + Sourcetype);

		return this;
	}

	public LeadPage saveLead() {

		click(bttnSave, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public LeadPage clickconvertLead() {
		sleep(2);
		click(bttnConvert, WaitStrategy.CLICKABLE, 10);
		sleep(10);
		click(bttnConvertInPoPUp, WaitStrategy.CLICKABLE, 50000);

		return this;

	}

	public LeadPage navigateTolead() {

		click(bttnGotoLead, WaitStrategy.CLICKABLE, 50);

		return this;
	}

	private final By dropDownCountry = By.xpath("//input[@name ='country']");

	private final By CountryListforBilling = By.xpath(
			"//input[@name='country']/parent::div/following-sibling::div/lightning-base-combobox-item//span/span");

	public LeadPage selectleadCountry() {
		jsOperation(JSAction.SCROLLTOVIEW, dropDownCountry);
		click(dropDownCountry, WaitStrategy.CLICKABLE, 5);
		List<WebElement> countryList = getElements(CountryListforBilling);
		int n = getRandomNumber(countryList.size() - 1) + 2;
		String country = countryList.get(n).getAttribute("innerHTML");
		jsOperation(JSAction.SCROLLTOVIEW, countryList.get(n));
		jsOperation(JSAction.CLICK, countryList.get(n));
		ExtentLogger.info("Selected country as :" + country);
		return this;
	}

	public LeadPage enterLeadStreet() {

		sendKeys(Street, getStreetName(), WaitStrategy.CLICKABLE, 10, "Lead Street");
		return this;
	}

	public LeadPage enterLeadCity() {

		sendKeys(Cityname, getCity(), WaitStrategy.VISIBLE, 10, "Lead City");
		return this;
	}

	public LeadPage enterLeadZipcode() {

		sendKeys(Zip, getPincode(), WaitStrategy.VISIBLE, 2, "Lead Zip");
		return this;
	}

	public LeadPage createLead(Map<String, String> data) {
		clickNew();
		Clicknextbttn().SelectTitletext().SelectSalutation(data.get("LeadSalutation")).enterLeadFirstName()
				.enterLeadMiddleName().enterLeadLastName().enterCompanyName().enterCompanyEmail()
				.enterDescription(data.get("LeadDescription")).SelectLeadsource(data.get("LeadSource"))
				.SelectLeadsourcetype(data.get("LeadSourceType")).SelectLeadTower(data.get("LeadTower"))
				.selectleadCountry().enterLeadStreet().enterLeadCity().enterLeadZipcode();
		return this;
	}

}
