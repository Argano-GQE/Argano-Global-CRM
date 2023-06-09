package com.Argano.pages;

import org.openqa.selenium.By;

import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.DynamicXpathUtlis;
import com.Argano.utlis.Waits;

public class Opportunity extends BasePage {


private final By Opportunity_name= By.xpath("//input[@name='Name']");
private final By Accname = By.xpath("//input[contains(@placeholder,'Search Account')]");
private final By Close_date=By.xpath("//input[@name='CloseDate']");
private final By project_Stdate= By.xpath("//input[@name='Project_Start_Date__c']");
private final By Oppor_Category=By.xpath("//button[@aria-label='Opportunity Category, --None--']");

private final String value= "//span[text()='%s']";
private final By stage= By.xpath("//button[@aria-label='Stage, --None--']");
private final By Itservice=By.xpath("//button[@aria-label='IT Service, --None--']");

private final By Opp_Type= By.xpath("//button[@aria-label='Opportunity Type, --None--']");
private final By Service_Subtype= By.xpath("//button[@aria-label='Service Sub-Category, --None--']");
private final By probability= By.xpath("//input[@name='Probability']");
private final By OPTYBook= By.xpath("//input[@name='Amount']");
private final By Project_Duration= By.xpath("//input[@name='Project_Approximate_Duration_Months__c']");
private final By Lead_Source=By.xpath("//button[@aria-label='Lead Source, --None--']");
private final By Lead_sourceType= By.xpath("//button[@aria-label='Lead Source Type, --None--']");




private static final String Accvalue = "//lightning-base-combobox-formatted-text[contains(@title,'%s')]";


private final By POreq= By.xpath("//button[@aria-label='PO Required, --None--]");
private final By Save_bttn = By.xpath("//button[@name='SaveEdit']");


public Opportunity oppname() {
	
	sendKeys(Opportunity_name,"Test123", WaitStrategy.CLICKABLE, 20);
	
	
	return this;
}

public Opportunity enter_AccountName() {
	 
	click(Accname, WaitStrategy.NONE, 2, "Account name dropdown");
	sendKeys(Accname,"Test5 Company", WaitStrategy.PRESENCE,3);
	String AccountNameXpath = DynamicXpathUtlis.getXpath(Accvalue, "Test5 Company");
	click(By.xpath(AccountNameXpath), WaitStrategy.CLICKABLE, 5, "account name" + "Test5 Company");
	return this;
}

public Opportunity enter_closedate() {
sendKeys(Close_date,"5/17/2023", WaitStrategy.CLICKABLE, 20);
return this;
}

public  Opportunity Select_Oppurtunitycategory() {
	Waits.sleep(3);
	click(Oppor_Category, WaitStrategy.NONE, 2, "Opportunity Category dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(value, "Intercompany SOW");
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Opportunity Category dropdown" + "Intercompany SOW");
return this;
}
public Opportunity enter_Stdate() {
sendKeys(project_Stdate,"5/18/2023", WaitStrategy.CLICKABLE, 20);
return this;
}

public  Opportunity Select_Stage() {
	Waits.sleep(4);
	 jsOperation(JSAction.SCROLLTOVIEW, stage);
	 Waits.sleep(2);
	 click(stage, WaitStrategy.NONE, 2, "Stage dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(value, "2. Proposal Development");
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Stage dropdown" + "2. Proposal Development");
return this;
}
public  Opportunity Select_ItService() {
	Waits.sleep(2);
	click(Itservice, WaitStrategy.NONE, 2, "It Service dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(value, "Implementation");
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "It Service dropdown" + "Implementation");
return this;
}


public  Opportunity Select_OppurtunityType() {
	Waits.sleep(2);
	click(Opp_Type, WaitStrategy.NONE, 2, "Opportunity Type dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(value, "Net New (NN)");
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Opportunity Type dropdown" + "Net New (NN)");
return this;
}
public  Opportunity Select_Service_Subtype() {
	Waits.sleep(2);
	click(Service_Subtype, WaitStrategy.NONE, 2, "Opportunity Type dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(value, "Infrastructure Implementation");
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Opportunity Type dropdown" + "Infrastructure Implementation");
return this;
}


public  Opportunity enter_probability() {
	
	sendKeys(probability,"60", WaitStrategy.CLICKABLE, 20);
return this;
}

public Opportunity enter_OPTYBookvalue() {
	sendKeys(OPTYBook,"60", WaitStrategy.CLICKABLE, 20);
return this;	
}

public  Opportunity enter_projectDuration() {
	
	sendKeys(Project_Duration,"60", WaitStrategy.CLICKABLE, 20);
return this;
}

public  Opportunity Select_LeadSource() {
	Waits.sleep(2);
	 jsOperation(JSAction.SCROLLTOVIEW, Lead_Source);
	click(Lead_Source, WaitStrategy.NONE, 2, "Lead_Source dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(value, "Marketing");
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Lead_Source dropdown" + "Marketing");
return this;
}

public  Opportunity Select_LeadSourceType() {
	Waits.sleep(2);
	click(Lead_sourceType, WaitStrategy.NONE, 2, "Lead_Source Type dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(value, "Marketplace");
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Lead_Source Type dropdown" + "Marketplace");
return this;
}

public  Opportunity save() {

	click(Save_bttn, WaitStrategy.CLICKABLE, 10);
	return this;
}

public void CreateOpportunity() {
	
	
	oppname().enter_AccountName().enter_closedate().Select_Oppurtunitycategory().enter_Stdate().Select_Stage().Select_ItService().Select_OppurtunityType()
	.Select_Service_Subtype().enter_probability().enter_OPTYBookvalue().enter_projectDuration().Select_LeadSource().Select_LeadSourceType().save();
	
	
	
	
}
private final By AccountSrc= By.xpath("//span[text()='Account Source']/following::div[1]/span/following::a[1]");

private final String Accsrcvalue= "//a[text()='%s']";


public Opportunity acct() { 
	
	Waits.sleep(10);
	jsOperation(JSAction.SCROLLTOVIEW, AccountSrc);
	click(AccountSrc, WaitStrategy.NONE, 2, "Account source dropdown");
	String CatXpath = DynamicXpathUtlis.getXpath(Accsrcvalue, "Argano Joint-Sell");
	Waits.sleep(10);
	click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0, "Account source dropdown" + "Argano Joint-Sell");


return this;
}



}
