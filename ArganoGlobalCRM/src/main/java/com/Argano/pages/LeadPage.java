package com.Argano.pages;

import org.openqa.selenium.By;

import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.DynamicXpathUtlis; 


public class LeadPage extends BasePage {

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
	private final By ChBoxSelectTower = By
			.xpath("//span[contains(@class,'checkbox_standalone')]/following::input[@name='Argano_Tower__c']");

//Lead Details
	private final By dropLeadStatus = By.xpath("//button[@aria-label='Lead Status, MCL']");
	private final String dropLeadStatusvalue = "//span[contains(@title,'%s')]";
	private final By dropLeadSource = By.xpath("//button[@aria-label='Source, --None--']");
	private final String dropLeadSourcevalue = "//span[contains(@title,'%s')]";
	private final By dropLeadSourcetype = By.xpath("//button[@aria-label='Source Type, --None--']");
	private final String dropLeadSourcetypevalue = "//span[contains(@title,'%s')]";

//Address details
	private final By Address = By
			.xpath("//legend[text()='Address']/following::lightning-lookup-address//div[1]//div[1]/div[1]/input");
	private final String Addressvalue = "//lightning-base-combobox-formatted-text[contains(@title,'%s')]";
	private final By Street = By.xpath("//textarea[@name='street']");
	private final By Cityname = By.xpath("//input[@name='city']");
	private final By Zip = By.xpath("//input[@name='postalCode']");


	private final By bttnSave = By.xpath("//button[@name='SaveEdit']");

	private final By bttnStatusComplete = By
			.xpath("//div[@class='slds-grid slds-path__action runtime_sales_pathassistantPathAssistantHeader']/button");
	private final By bttnConvert = By.xpath("//button[text()='Convert']");
	private final By bttnPostConvert = By
			.xpath("//span[contains(@class,'runtime_sales_leadConvertModalFooter')]/button[text()='Convert']");

	private final By LeadConvertSucesssTXT = By
			.xpath("//lightning-formatted-text[text()='Your lead has been converted']");

	private final By bttnGotoLead = By.xpath("//button[text()='Go to Leads']");

	public String getLeadConvertedMessage() {
	
		String leadConvertmsg = getText(LeadConvertSucesssTXT, 20);
		
		return leadConvertmsg;
	}

	public LeadPage Clicklead() {

		for (int i = 0; i < 3; i++) {

			jsOperation(JSAction.CLICK, bttnStatusComplete);
			
		}
		click(bttnConvert, WaitStrategy.CLICKABLE, 10);
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

		click(Title, WaitStrategy.NONE, 2, "Lead Salutation dropdown");
		String TitleXpath = DynamicXpathUtlis.getXpath(dropTitlevalue, salutation);
		click(By.xpath(TitleXpath), WaitStrategy.CLICKABLE, 5, "Lead Salutation value" + salutation);

		return this;

	}

	public LeadPage enterLeadFirstName() {

		sendKeys(txtFirstName,getFirstName(), WaitStrategy.CLICKABLE, 20);

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
		click(By.xpath(leadstatusXpath), WaitStrategy.CLICKABLE, 0, "Lead Status dropdown" + Leadvalue);
		return this;

	}

	public LeadPage SelectLeadsource(String Leadsource) {

		jsOperation(JSAction.SCROLLTOVIEW, dropLeadSource);
		click(dropLeadSource, WaitStrategy.NONE, 2, "Lead Source dropdown");
		String leadsourceXpath = DynamicXpathUtlis.getXpath(dropLeadSourcevalue, Leadsource);
		click(By.xpath(leadsourceXpath), WaitStrategy.CLICKABLE, 0, "Lead Source dropdown" + Leadsource);
		return this;

	}

	public LeadPage SelectLeadsourcetype(String Sourcetype) {

		click(dropLeadSourcetype, WaitStrategy.NONE, 2, "Lead Source Type dropdown");
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(dropLeadSourcetypevalue, Sourcetype);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Lead Source Type dropdown" + Sourcetype);

		return this;
	}

	public LeadPage SelectTower() {

		jsOperation(JSAction.CLICK, ChBoxSelectTower);

		return this;

	}

	public LeadPage enteLeadAddress(String typeaddress, String leadaddress) {

		jsOperation(JSAction.SCROLLTOVIEW, Address);
		sendKeys(Address, typeaddress, WaitStrategy.PRESENCE, 3);
		String addressXpath = DynamicXpathUtlis.getXpath(Addressvalue, leadaddress);
		click(By.xpath(addressXpath), WaitStrategy.CLICKABLE, 5, "Address Dropdown" + leadaddress);
		return this;
	}

	public LeadPage enterLeadStreet() {

		sendKeys(Street,getStreetName(), WaitStrategy.CLICKABLE, 10, "Lead Street");
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

	public LeadPage saveLead() {

		click(bttnSave, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public LeadPage Clickconvert() {
		sleep(5);
		click(bttnPostConvert, WaitStrategy.CLICKABLE, 50);

		return this;
	}

	public LeadPage navigateTolead() {

		click(bttnGotoLead, WaitStrategy.CLICKABLE, 50);

		return this;
	}

}
