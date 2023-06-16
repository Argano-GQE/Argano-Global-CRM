package com.Argano.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.DynamicXpathUtlis;
import com.Argano.utlis.FakerAPI;
import com.Argano.utlis.Waits;

public class Opportunity extends BasePage {

	private final By Opportunity_name = By.xpath("//input[@name='Name']");
	private final By Accname = By.xpath("//input[contains(@placeholder,'Search Account')]");
	private final By Close_date = By.xpath("//input[@name='CloseDate']");
	private final By project_Stdate = By.xpath("//input[@name='Project_Start_Date__c']");
	private final By Oppor_Category = By.xpath("//button[@aria-label='Opportunity Category, --None--']");

	private final String value = "//span[text()='%s']";
	private final By stage = By.xpath("//button[@aria-label='Stage, --None--']");
	private final By Itservice = By.xpath("//button[@aria-label='IT Service, --None--']");

	private final By Opp_Type = By.xpath("//button[@aria-label='Opportunity Type, --None--']");
	private final By Service_Subtype = By.xpath("//button[@aria-label='Service Sub-Category, --None--']");
	private final By probability = By.xpath("//input[@name='Probability']");
	private final By OPTYBook = By.xpath("//input[@name='Amount']");
	private final By Project_Duration = By.xpath("//input[@name='Project_Approximate_Duration_Months__c']");
	private final By Lead_Source = By.xpath("//button[@aria-label='Lead Source, --None--']");
	private final By Lead_sourceType = By.xpath("//button[@aria-label='Lead Source Type, --None--']");

	private static final String Accvalue = "//lightning-base-combobox-item//span[text()='%s']";

	private final By POreq = By.xpath("//button[@aria-label='PO Required, --None--]");
	private final By Save_bttn = By.xpath("//button[@name='SaveEdit']");
	private final By new_bttn = By.xpath("//div[@title='New']");

	public Opportunity newOpportunity() {

		click(new_bttn, WaitStrategy.NONE, 2, "new button is clicked for Opportunity");

		return this;
	}

	private final By soruceDropdown = By.xpath("//label[text()='Source']/..//lightning-base-combobox//button");
//	private final By OptionsSales = By.xpath("//lightning-base-combobox-item//span[text()='Sales']/../..");
	String source_value = "//lightning-base-combobox-item//span[text()='%s']/parent::span";

	public Opportunity select_source(String sourceOption) {

//		click(soruceDropdown, WaitStrategy.CLICKABLE, 5);
		jsOperation(JSAction.SCROLLTOVIEW, soruceDropdown);
		jsOperation(JSAction.CLICK, soruceDropdown);
		String option = DynamicXpathUtlis.getXpath(source_value, sourceOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10, "source " + sourceOption + "is Selected");

		return this;
	}

	private final By soruceTypeDropdown = By
			.xpath("//label[text()='Source Type']/parent::lightning-combobox//lightning-base-combobox//button");

	public Opportunity select_Type_source(String sourceType_Option) {

		click(soruceTypeDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(source_value, sourceType_Option);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10, "sourceType " + sourceType_Option + "is Selected");
		return this;
	}

	private final By OPTY_Gross_Booking_Value = By.xpath("//input[@name='Amount']");

	public Opportunity enter_OPTY_Gross_Booking_Value() {

		sendKeys(OPTY_Gross_Booking_Value, "5", WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public String oppname() {

		String OpportunityName = FakerAPI.getUserName();
		sendKeys(Opportunity_name, OpportunityName, WaitStrategy.CLICKABLE, 20);

		return OpportunityName;
	}

	public Opportunity enter_AccountName(String AccountName) {

		click(Accname, WaitStrategy.NONE, 2, "Account name dropdown");
		sendKeys(Accname, AccountName, WaitStrategy.PRESENCE, 3);
		String AccountNameXpath = DynamicXpathUtlis.getXpath(Accvalue, AccountName);

		try {
			click(By.xpath(AccountNameXpath), WaitStrategy.CLICKABLE, 10, "account name" + AccountName);
		} catch (Exception e) {
			sendKeys(Accname, Keys.ARROW_DOWN, WaitStrategy.CLICKABLE, 5);
			sendKeys(Accname, Keys.ARROW_DOWN, WaitStrategy.CLICKABLE, 5);
			sendKeys(Accname, Keys.ENTER, WaitStrategy.CLICKABLE, 5);
		}
		return this;
	}

	public Opportunity enter_closedate() {
		sendKeys(Close_date, "5/17/2024", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public Opportunity Select_Oppurtunitycategory(String OpportunityCategoryOption) {
		Waits.sleep(3);
		click(Oppor_Category, WaitStrategy.NONE, 2, "Opportunity Category dropdown");
		String CatXpath = DynamicXpathUtlis.getXpath(value, OpportunityCategoryOption);
		click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0,
				"Opportunity Category dropdown" + OpportunityCategoryOption);
		return this;
	}

	public Opportunity enter_Stdate() {
		sendKeys(project_Stdate, "7/17/2024", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	String stagexpath = "//lightning-base-combobox-item//span[text()='%s']/parent::span";

	public Opportunity Select_Stage(String StageOpion) {
		Waits.sleep(4);
		jsOperation(JSAction.SCROLLTOVIEW, stage);
		Waits.sleep(2);
		try {
			click(stage, WaitStrategy.NONE, 2, "stage dropdown s clicked");
		} catch (Exception e1) {
			jsOperation(JSAction.CLICK, stage);
		}
		String CatXpath = DynamicXpathUtlis.getXpath(stagexpath, StageOpion);
		try {
			click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Stage dropdown" + StageOpion);
		} catch (Exception e) {
			jsOperation(JSAction.CLICK, stage);
			jsOperation(JSAction.CLICK, By.xpath(CatXpath));
		}

		return this;
	}

	public Opportunity Select_ItService(String ItserviceOption) {
		Waits.sleep(2);

		jsOperation(JSAction.CLICK, Itservice);
		String option = DynamicXpathUtlis.getXpath(value, ItserviceOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 0, "It Service dropdown" + ItserviceOption);
		return this;
	}

	public Opportunity Select_OppurtunityType(String OpportunityTypeOption) {
		Waits.sleep(2);
		click(Opp_Type, WaitStrategy.NONE, 2, "Opportunity Type dropdown");
		String option = DynamicXpathUtlis.getXpath(value, OpportunityTypeOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 0, "Opportunity Type dropdown" + OpportunityTypeOption);
		return this;
	}

	public Opportunity Select_Service_Subtype(String service_subType_Option) {
		Waits.sleep(2);
		click(Service_Subtype, WaitStrategy.NONE, 2, "Opportunity Type dropdown");
		String option = DynamicXpathUtlis.getXpath(value, service_subType_Option);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 0, "Opportunity Type dropdown" + service_subType_Option);
		return this;
	}

	public Opportunity enter_probability() {

		sendKeys(probability, "60", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public Opportunity enter_OPTYBookvalue() {
		sendKeys(OPTYBook, "60", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public Opportunity enter_projectDuration() {

		sendKeys(Project_Duration, "60", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	public Opportunity Select_LeadSource() {
		Waits.sleep(2);
		jsOperation(JSAction.SCROLLTOVIEW, Lead_Source);
		click(Lead_Source, WaitStrategy.NONE, 2, "Lead_Source dropdown");
		String option = DynamicXpathUtlis.getXpath(value, "Marketing");
		click(By.xpath(option), WaitStrategy.CLICKABLE, 0, "Lead_Source dropdown" + "Marketing");
		return this;
	}

	public Opportunity Select_LeadSourceType() {
		Waits.sleep(2);
		click(Lead_sourceType, WaitStrategy.NONE, 2, "Lead_Source Type dropdown");
		String option = DynamicXpathUtlis.getXpath(value, "Marketplace");
		click(By.xpath(option), WaitStrategy.CLICKABLE, 0, "Lead_Source Type dropdown" + "Marketplace");
		return this;
	}

	public Opportunity save() {

		click(Save_bttn, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	private final By cancelbttn = By.xpath("//button[@name='CancelEdit']");

	public Homepage cancel() {
		click(cancelbttn, WaitStrategy.CLICKABLE, 5);
		return new Homepage();
	}

	private final By AccountSrc = By.xpath("//span[text()='Account Source']/following::div[1]/span/following::a[1]");

	private final String Accsrcvalue = "//a[text()='%s']";

	public Opportunity acct() {

		Waits.sleep(10);
		jsOperation(JSAction.SCROLLTOVIEW, AccountSrc);
		click(AccountSrc, WaitStrategy.NONE, 2, "Account source dropdown");
		String option = DynamicXpathUtlis.getXpath(Accsrcvalue, "Argano Joint-Sell");
		Waits.sleep(10);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 0, "Account source dropdown" + "Argano Joint-Sell");

		return this;
	}

	private final By Debrief_reason_bttn = By.xpath("//button[@title='Edit Reason (Won/Lost/Not Awarded/Cancelled)']");
	private final By txt_debreif_reason = By
			.xpath("//label[text()='Debrief (Won/Lost/Not Awarded/Cancelled)']/parent::lightning-textarea//textarea");

	private final By Closed_link = By.xpath("//a[@title='Closed']");
	private final By Select_Closed_Stage_bttn = By.xpath("//span[text()='Select Closed Stage']/parent::button");
	private final By StageDropDown = By.xpath("//button[@name='StageName']");
	private final String Stage_options = "//span[text()='%s']/ancestor::lightning-base-combobox-item";
	private final By Done_bttn = By.xpath("//button[@type='submit']");
	private final By reason_dropDown = By.xpath("//button[@name='Reason_Won_Lost_Not_Awarded__c']");
	private final String reason_option = " //span[text()='%s']/ancestor::lightning-base-combobox-item ";

	public Opportunity CloseLost(String opportunityName) {

		String option = DynamicXpathUtlis.getXpath(Accsrcvalue, opportunityName);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10);
		jsOperation(JSAction.CLICK, Debrief_reason_bttn, WaitStrategy.CLICKABLE, 10);

		sendKeys(txt_debreif_reason, "Other", WaitStrategy.CLICKABLE, 20);
		jsOperation(JSAction.CLICK, Closed_link, WaitStrategy.CLICKABLE, 10);
		jsOperation(JSAction.CLICK, Select_Closed_Stage_bttn, WaitStrategy.CLICKABLE, 10);

		try {
			
			option = DynamicXpathUtlis.getXpath(Stage_options, "6. Closed - Lost");
			click(By.xpath(option), WaitStrategy.CLICKABLE, 10);
		} catch (Exception e) {
			click(StageDropDown, WaitStrategy.CLICKABLE, 10);
			option = DynamicXpathUtlis.getXpath(Stage_options, "6. Closed - Lost");
			click(By.xpath(option), WaitStrategy.CLICKABLE, 10);
		}

		click(reason_dropDown, WaitStrategy.CLICKABLE, 10);
		option = DynamicXpathUtlis.getXpath(reason_option, "Other");
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10);
		click(Done_bttn, WaitStrategy.CLICKABLE, 10);
		return this;
	}

}
