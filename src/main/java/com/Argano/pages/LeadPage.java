package com.Argano.pages;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Argano.driver.DriverManager;
import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.DynamicXpathUtlis;
import com.Argano.utlis.FakerAPI;
import com.Argano.utlis.Waits;

public class LeadPage extends BasePage {

	private final By Select_New = By.xpath("//div[text()='New']");

	private final By Popup_Next = By.xpath("//span[text()='Next']");

	private final By Title = By.xpath("//button[@name='salutation']");
	private final String Title_Mr = "//span[contains(@title,'%s')]";
	private final By Title_text = By.xpath("//input[@name='Title']");
//	Name Field
	private final By First_Name = By.xpath("//input[@name='firstName']");
	private final By Middle_Name = By.xpath("//input[@name='middleName']");
	private final By Last_Name = By.xpath("//input[@name='lastName']");
	private final By Suffix = By.xpath("//input[@name='suffix']");
	private final By Desc = By.xpath("(//textarea[@class='slds-textarea'])[1]");
//	Company name and email
	private final By Company_Name = By.xpath("//input[@name='Company']");
	private final By Email = By.xpath("//input[@name='Email']");
//	Contact Details
	private final By phone = By.xpath("//input[@name='Phone']");
	private final By Cell = By.xpath("//input[@name='MobilePhone']");
//	Tower
	private final By Select_Tower = By.xpath(
			"/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___0125f000000qlasaaq___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row[1]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-checkbox/lightning-input/div/span/input");

//	Lead Details
	private final By Lead_Status = By.xpath("//button[@aria-label='Lead Status, --None--']");
	private final String Lead_Statusvalue = "//span[contains(@title,'%s')]";
	private final By Lead_Source = By.xpath("//button[@aria-label='Lead Source, --None--']");
	private final String Lead_Source1 = "//span[contains(@title,'%s')]";
	private final By Lead_Source_type = By.xpath("//button[@aria-label='Lead Source Type, --None--']");
	private final String Lead_Source_type_value = "//span[contains(@title,'%s')]";

	private final By LinkId = By.xpath("//input[@name='LinkedIn__c']");
	private final By Mob_No = By.xpath("//input[@name='Direct_Phone__c']");
	private final By Emp_ReportTo = By.xpath("//input[@name='Employee_Reports_To__c']");

//	Joiner

	private final By Joiner_first = By.xpath("//button[@aria-label='Joiner First Touch, --None--']");
	private final String Joiner_first_Value = "//span[contains(@title,'%s')]";
	private final By Tech_Stack = By.xpath("//button[@aria-label='Technology Stack, --None--']");
	private final String Tech_StackValue = "//span[contains(@title,'%s')]";

//	Address details
	private final By Address = By
			.xpath("//legend[text()='Address']/following::lightning-lookup-address//div[1]//div[1]/div[1]/input");
	private final String Addressvalue = "//lightning-base-combobox-formatted-text[contains(@title,'%s')]";
	private static final By country = By
			.xpath("//label[text()='Country']/following::lightning-base-combobox[1]//input");
	private static final String countryvalue = "(//span[contains(@title,'%s')])[1]";
	private final By countryvalue1 = By.xpath("//span[text()='%s']");
	private final By Street = By.xpath("//textarea[@name='street']");
	private final By Cityname = By.xpath("//input[@name='city']");
	private final By Zip = By.xpath("//input[@name='postalCode']");
//	Industry
	private final By Industry = By.xpath("//button[@aria-label='Industry, --None--']");
	private final String IndustryValue = "//span[contains(@title,'%s')]";
	private final By Industry_Emp = By.xpath("//input[@name='NumberOfEmployees']");
	private final By Industry_Rev = By.xpath("//input[@name='AnnualRevenue']");
	private final By Save_bttn = By.xpath("//button[@name='SaveEdit']");

	public LeadPage Select_New() {

		click(Select_New, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public final LeadPage Popupwindow() {

		click(Popup_Next, WaitStrategy.CLICKABLE, 10);
		return this;

	}

	public LeadPage Select_Title() {
		Waits.sleep(3);
		sendKeys(Title_text, "TestLead", WaitStrategy.CLICKABLE, 100);
		Waits.sleep(1);
		click(Title, WaitStrategy.NONE, 2, "Lead Salutation dropdown");
		String TitleXpath = DynamicXpathUtlis.getXpath(Title_Mr, "Mr.");
		click(By.xpath(TitleXpath), WaitStrategy.CLICKABLE, 5, "Lead Salutation value" + "Mr.");

		return this;
	}

	public LeadPage enter_Name(String Fname, String Mname, String Lname) {

		sendKeys(First_Name, Fname, WaitStrategy.CLICKABLE, 20);
		sendKeys(Middle_Name, Mname, WaitStrategy.CLICKABLE, 20);
		sendKeys(Last_Name, Lname, WaitStrategy.CLICKABLE, 20);
		sendKeys(Suffix, "N S", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage enter_CompanyName(String Cname) {
		sendKeys(Company_Name, Cname, WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage enter_Company_Email(String Cemail) {

		sendKeys(Email, Cemail, WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage ContactDetails() {
		sendKeys(phone, FakerAPI.getContactNumber(), WaitStrategy.CLICKABLE, 20);
		sendKeys(Cell, FakerAPI.getContactNumber(), WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage Description() {

		sendKeys(Desc, "Salesforce Test", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage Select_Leadsource() {

		Waits.sleep(3);
		jsOperation(JSAction.SCROLLTOVIEW, Lead_Source);

		click(Lead_Source, WaitStrategy.NONE, 2, "Lead Source dropdown");

		String leadsourceXpath = DynamicXpathUtlis.getXpath(Lead_Source1, "Marketing");
		click(By.xpath(leadsourceXpath), WaitStrategy.CLICKABLE, 0, "Lead Source dropdown" + "Marketing");
		return this;

	}

	public LeadPage Select_Leadsourcetype() {
		Waits.sleep(3);
		click(Lead_Source_type, WaitStrategy.NONE, 2, "Lead Source Type dropdown");
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(Lead_Source_type_value, "Marketplace");
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Lead Source Type dropdown" + "Marketplace");

		return this;
	}

	public LeadPage Emp_Details() {

		sendKeys(LinkId, FakerAPI.getUserName(), WaitStrategy.CLICKABLE, 20);
		sendKeys(Emp_ReportTo, "John", WaitStrategy.CLICKABLE, 20);
		sendKeys(Mob_No, FakerAPI.getContactNumber(), WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public LeadPage Select_JoinerFirst() {
		Waits.sleep(3);
		try {
			jsOperation(JSAction.SCROLLTOVIEW, Joiner_first);
			Waits.sleep(5);
			click(Joiner_first, WaitStrategy.NONE, 2, "Joiner First Dropdown");
			String JoinXpath = DynamicXpathUtlis.getXpath(Joiner_first_Value, "Arbela");
			click(By.xpath(JoinXpath), WaitStrategy.CLICKABLE, 5, "Joiner First Dropdown" + "Arbela");

		} catch (Exception e) {
			System.out.println("Not clicked");
		}

		return this;
	}

	public LeadPage Select_Tech_Stack() {
		Waits.sleep(3);
		jsOperation(JSAction.SCROLLTOVIEW, Tech_Stack);
		click(Tech_Stack, WaitStrategy.NONE, 2, "Tech Stack dropdown");
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(Tech_StackValue, "JDE E1");
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Tech Stack dropdown" + "JDE E1");

		return this;
	}

	public LeadPage Select_Tower() {
		Waits.sleep(5);
		jsOperation(JSAction.CLICK, Select_Tower);

		return this;

	}

	public LeadPage Industry_Info() {

		Waits.sleep(2);
		jsOperation(JSAction.SCROLLTOVIEW, Industry);
		click(Industry, WaitStrategy.NONE, 2, "Industry dropdown");
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(IndustryValue, "Aerospace & Defense");
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Industry dropdown" + "Aerospace & Defense");

		sendKeys(Industry_Emp, "20", WaitStrategy.CLICKABLE, 20);
		sendKeys(Industry_Rev, "$100000", WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public LeadPage enter_Address() {

		jsOperation(JSAction.SCROLLTOVIEW, Address);
		sendKeys(Address, "Herat", WaitStrategy.PRESENCE, 3);
		String addressXpath = DynamicXpathUtlis.getXpath(Addressvalue, "Herat");
		click(By.xpath(addressXpath), WaitStrategy.CLICKABLE, 5, "Address Dropdown" + "Herat");
		return this;
	}

	public LeadPage enterLeadStreet() {

		sendKeys(Street, "XYZ Street", WaitStrategy.CLICKABLE, 10, "Lead Street");
		return this;
	}

	public LeadPage enterLeadCity() {

		sendKeys(Cityname, FakerAPI.getplace(), WaitStrategy.VISIBLE, 10, "Lead City");
		return this;
	}

	public LeadPage enterLeadZip() {

		sendKeys(Zip, FakerAPI.getPincode(), WaitStrategy.VISIBLE, 2, "Lead Zip");
		return this;
	}

	public LeadPage save() {

		click(Save_bttn, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public LeadPage enter_Street() {

		sendKeys(Street, "AVbti", WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public void LeadPage_Fields() {
		Select_New().Popupwindow().Select_Title()
				.enter_Name(FakerAPI.getFirstName(), FakerAPI.getMiddleName(), FakerAPI.getLastName())
				.enter_CompanyName(FakerAPI.getCompanyName()).enter_Company_Email(FakerAPI.getEmailAddress())
				.ContactDetails().Description().Select_Leadsource().Select_Leadsourcetype().Emp_Details()
				.Select_JoinerFirst().Select_Tech_Stack().Select_Tower().Industry_Info().enter_Address()
				.enterLeadStreet().enterLeadCity().enterLeadZip().save();

	}

}
