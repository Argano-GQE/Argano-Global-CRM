package com.Argano.pages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.Argano.driver.DriverManager;
import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.reports.ExtentLogger;
import com.Argano.utlis.DynamicXpathUtlis;
import com.google.common.util.concurrent.Uninterruptibles;


public class OpportunityPage extends BasePage {

	private final By linkOpportunityTab = By.xpath("//a[@title='Opportunities']");

	private final By linkOpportunitylist = By
			.xpath("//span[text()='Opportunity Name']/following::a[@data-special-link='true'][1]");

	private final String oppfromRelatedList = "(//span[text() = '%s'])[2]";
	
	private final By Close_date = By.xpath("//input[@name='CloseDate']");
	private final By project_Stdate = By.xpath("//input[@name='Project_Start_Date__c']");
	
	private final String value = "//span[text()='%s']";
	private final By stage = By.xpath("//button[@aria-label='Stage, --None--']");

	private final By Opp_Type = By.xpath("//button[@aria-label='Opportunity Type, --None--']");
	private final By Save_bttn = By.xpath("//button[@name='SaveEdit']");
	
//----------------------->Add Argano Solution<-----------------------------

	private final By linkArganoSolution = By.xpath("//slot/span[contains(text(),'Argano Solutions')]");
	private final By bttnAddarganoSolutions = By.xpath("//div[text()='Add Argano Solutions']");
	private final By bttnNext = By.xpath("//span[text()='Next']");
	private final By checkboxArganosolution = By.xpath(
			"//a[@title='App Dev']/parent::span/parent::th/parent::tr//div[contains(@class,'forceVirtualCheckbox uiInput--default')]");
	private final By dropTower = By.xpath(
			"//td[@class='slds-cell-edit slds-cell-error errorColumn cellContainer']/following::span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'][2]");
	private final By dropTowerValueclick = By.xpath(
			"//td[@class='slds-cell-edit slds-cell-error errorColumn cellContainer']/following::span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'][2]//button/following::a[@class='select']");
	private final By dropArganoJoinerCompany = By.xpath(
			"//td[@data-aura-class='forceInlineEditCell'][2]/span[contains(@class,'forceInlineEditCell')]//button");
	private final By dropArganoJoineroption = By.xpath(
			"//td[@class='slds-cell-edit slds-is-edited cellContainer']/span//button/following::a[text()='--None--']");
	private final By ArganoJoinerValue = By.xpath("//a[text()='Argano']");
//private final String ArganoJoinerValue = "//a[text()='%s']";
	private final By dropsolutionowner = By.xpath(
			"//td[@data-aura-class='forceInlineEditCell'][3]/span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//button");
//private final By dropSolutionOption= By.xpath("//div[contains(@class,'autocompleteWrapper')]/input");
	private final By txtSolcrossBook = By.xpath(
			"//td[@data-aura-class='forceInlineEditCell'][4]/span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//button");
	private final By txtSolcrossBookclear = By.xpath("//div[contains(@class,'uiInput--input')]//input");
	private final String txtSolcrossBookValue = "//input[@type='text']";
	private final By bttnSaveSolution = By.xpath(
			"//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']");
  private final By bttncloseSolutionwindow= By.xpath("//button[@title='Close this window']/lightning-primitive-icon");
//------------------------->Proposal Request<--------------------------------
	private final By linkProposalRequest = By.xpath("//slot/span[contains(text(),'Proposal Requests')]");
	private final By linkPRnumber = By.xpath("//slot/span[contains(text(),'PR')]");
	private final By bttnSubmitforApprval = By.xpath("//button[text()='Submit for Approval']");
	private final By dropProposalType = By.xpath("//select[@name='Proposal_Type']");
//proposal type under select tag
	private final By txtPRduedate = By.xpath("//input[@name='PR_Due_Date']");
	private final By dropApprover = By.xpath(
			"//label[text()='Approver 1']/following-sibling::div//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']//input");
	private final String dropApproverValue = "//lightning-base-combobox-formatted-text[@title='%s']";
	private final By bttnFinish = By.xpath("//button[text()='Finish']");
	private final By txtApprover = By.xpath("(//input[@placeholder='Search People...'])[1]");
	
//post Pr Approval process
	private final By linkApprovePrReq = By.xpath("//slot/span[contains(text(),'Approval History')]");
	private final By bttnApprovePrReq = By.xpath("//a[@title='Approve']");
	private final By txtcomments = By.xpath("//textarea[contains(@class,'messageTextArea textarea')]");
	private final By bttnpostApprove = By.xpath("//span[text()='Approve']");

//-------------------------------->Opportunity Summary<------------------------------------------
	private final By bttncategoryedit = By.xpath("//span[text()='Edit Close Date']");
	private final By dropOpportunitycategory = By.xpath("//button[@aria-label='Opportunity Category, --None--']");
	private final String OpportunityCategoryvalue = "//span[text()='%s']";

	private final By txtProjectStartdate = By.xpath("//input[@name='Project_Start_Date__c']");

	private final By dropStage = By.xpath("//button[@aria-label='Stage, 0. Identifying']");
	private final String dropStagevalue = "//span[@title='%s']";

	private final By dropOpportunitytype = By.xpath("//button[@aria-label='Opportunity Type, --None--']");
	private final String OpportunityTypevalue = "//span[text()='%s']";

	private final By dropItService = By.xpath("//button[@aria-label='IT Service, --None--']");
	private final String ItServicevalue = "//span[text()='%s']";

	private final By dropServicesubCategory = By.xpath("//button[@aria-label='Service Sub-Category, --None--']");
	private final String ServicesubCategoryvalue = "//span[text()='%s']";

	private final By txtProjectduration = By.xpath("//input[@name='Project_Approximate_Duration_Months__c']");
	private final By txtDebrief = By.xpath(
			"//label[text()='Debrief (Won/Lost/Not Awarded/Cancelled)']/following::textarea[@class='slds-textarea']");

//5. Closed - Won

	private final By dropReason = By.xpath("//button[@aria-label='Reason (Won/Lost/Not Awarded/Cancelled), --None--']");
	private final String dropReasonvalue = "//span[text()='%s']";
//Continuing Business

	private final By bttSaveOppdetails = By.xpath("//button[text()='Save']");

	private final By bttnDone = By.xpath("//button[text()='Done']");

	private final By bttnCompleteStage = By.xpath("//span[text()='Change Closed Stage']");

	private final By stageChangedtxt = By.xpath("//span[text()='Stage changed successfully.']");


	public OpportunityPage selectOpporturnityFromRelatedList(String oppname)
	{
			String oppToBeSelectedXpath = DynamicXpathUtlis.getXpath(oppfromRelatedList, oppname);
					click(By.xpath(oppToBeSelectedXpath), WaitStrategy.CLICKABLE, 15, "Navigated to Opportunity : " + oppname);
return this;
	}
	
	public String StageCompleteMsg() {
		
		String stagecompletetxt = getText(stageChangedtxt, 100);
		
		return stagecompletetxt;
	
	}
	
	public boolean isStageChangeTxtDisplayed()
	{
		return isDisplayed(stageChangedtxt, 20);
		
	}
	private final By Opportunity_name = By.xpath("//input[@name='Name']");
	
	public OpportunityPage enteroppname(String oppname) {

		
		sendKeys(Opportunity_name, oppname, WaitStrategy.CLICKABLE, 20);

		return this;
	}

	
	public OpportunityPage ClickOpportunityTab() {
		sleep(3);
		jsOperation(JSAction.CLICK, linkOpportunityTab);

		return this;
	}

	public OpportunityPage SelectOpportunityfromList() {
		sleep(3);
		click(linkOpportunitylist, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage ClickArganoSolutionlink() {
		sleep(2);

		click(linkArganoSolution, WaitStrategy.CLICKABLE, 10);

		return this;

	}
  
	public OpportunityPage AddArganoSolution() {

		click(bttnAddarganoSolutions, WaitStrategy.CLICKABLE, 10);

		click(checkboxArganosolution, WaitStrategy.CLICKABLE, 10);

		click(bttnNext, WaitStrategy.CLICKABLE, 10);

		return this;

	}
private final String dropTowerValue = "//a[text()='%s']";
private final By dropTowervalue = By.xpath(
		"//td[@class='slds-cell-edit slds-cell-error errorColumn cellContainer']/following::span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'][2]//button");

	public OpportunityPage SelectTower(String towervalue) {

		jsOperation(JSAction.CLICK, dropTower);
		click(dropTowervalue, WaitStrategy.CLICKABLE, 10);
		click(dropTowerValueclick, WaitStrategy.CLICKABLE, 10);
		String towertypeXpath = DynamicXpathUtlis.getXpath(dropTowerValue, towervalue);
		click(By.xpath(towertypeXpath), WaitStrategy.CLICKABLE, 5, "Tower Value Dropdown" + towervalue);

		return this;
	}
	private final String dropArganoJoinerValue = "//a[text()='%s']";
	public OpportunityPage SelectArganoJoinerCompany(String joinerValue) {

		click(dropArganoJoinerCompany, WaitStrategy.CLICKABLE, 50);
		click(dropArganoJoineroption, WaitStrategy.CLICKABLE, 10);
		String joinertypeXpath = DynamicXpathUtlis.getXpath(dropArganoJoinerValue, joinerValue);
		click(By.xpath(joinertypeXpath), WaitStrategy.CLICKABLE, 5, "Argano Joiner Dropdown" + joinerValue);
		return this;
	}
	private final By txtsolutionowner = By.xpath("//input[@placeholder='Search People...']");
	private final String SolutionOwnerValue = "//div[@title='%s']";
	
	public OpportunityPage SelectSolutionOwner(String SolutionOwner) {
		click(dropsolutionowner, WaitStrategy.CLICKABLE, 10);
		sendKeys(txtsolutionowner, SolutionOwner, WaitStrategy.CLICKABLE, 20);
		String ownerTypeXpath = DynamicXpathUtlis.getXpath(SolutionOwnerValue, SolutionOwner);
		click(By.xpath(ownerTypeXpath), WaitStrategy.CLICKABLE, 5, "Approver Dropdown" + SolutionOwner);
		return this;
	}
	

	public OpportunityPage SelectArganoJoinerCompany() {

		click(dropArganoJoinerCompany, WaitStrategy.CLICKABLE, 50);
		click(dropArganoJoineroption, WaitStrategy.CLICKABLE, 10);
		click(ArganoJoinerValue, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage ApprovePRrequest(String Comments) {
		refresh();
		click(bttnApprovePrReq, WaitStrategy.CLICKABLE, 10);
		sendKeys(txtcomments, Comments, WaitStrategy.CLICKABLE, 20);
		click(bttnpostApprove, WaitStrategy.CLICKABLE, 10);
		DriverManager.getDriver().navigate().back();
		return this;
	}
	public OpportunityPage enterProjectStartdate() {
		String startDate = getCurrentDatePlusInFormat("M/d/yyyy", 90);
		jsOperation(JSAction.CLICK, bttncategoryedit);
		sleep(5);
		sendKeys(txtProjectStartdate, startDate, WaitStrategy.CLICKABLE, 20);

		return this;
	}
	public OpportunityPage EnterGrossBookingValue(String crossBookvalue) {
		click(txtSolcrossBook, WaitStrategy.CLICKABLE, 10);
		clear(txtSolcrossBookclear, WaitStrategy.CLICKABLE, 10);
		sendKeys(By.xpath(txtSolcrossBookValue), crossBookvalue, WaitStrategy.CLICKABLE, 20);
		return this;
	}
	
	public OpportunityPage SelectProposalType(String proposalType) {
		WebElement proposalele = DriverManager.getDriver().findElement(dropProposalType);
		Select pvalue = new Select(proposalele);
		pvalue.selectByVisibleText(proposalType);
		return this;
	}
	public OpportunityPage SaveSolution() {

		click(bttnSaveSolution, WaitStrategy.CLICKABLE, 10);

		return this;
	}
  public OpportunityPage ClosePopupwindow() {
	  try {
		  click(bttncloseSolutionwindow, WaitStrategy.CLICKABLE, 5);
	  } catch(Exception e)
	  {
		  System.out.println("No popupwindow");
	  }
	 return this; 
  }
//-------------->Proposal Request<---------------

	public OpportunityPage ClickProposalReqlink() {

		click(linkProposalRequest, WaitStrategy.CLICKABLE, 30);
		return this;
	}

	public OpportunityPage ClickProposalReqNumber() {

		click(linkPRnumber, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage SubmitforApproval() {

		click(bttnSubmitforApprval, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage SelectProposalType() {
		WebElement proposalele = DriverManager.getDriver().findElement(dropProposalType);
		Select pvalue = new Select(proposalele);
		pvalue.selectByVisibleText("Proposal");
		return this;
	}

	public OpportunityPage SelectPrDuedate(String Prdate) {

		sendKeys(txtPRduedate, Prdate, WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public OpportunityPage SelectApprover(String SelectApprover) {

		WebElement Approve = DriverManager.getDriver().findElement(dropApprover);
		Actions oapprove = new Actions(DriverManager.getDriver());
		oapprove.moveToElement(Approve).build().perform();
		click(dropApprover, WaitStrategy.CLICKABLE, 10);
		sendKeys(txtApprover, SelectApprover, WaitStrategy.CLICKABLE, 10);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(dropApproverValue, SelectApprover);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Approver Dropdown" + SelectApprover);

		return this;
	}

	public OpportunityPage FinishApprovalSubmission() {

		click(bttnFinish, WaitStrategy.CLICKABLE, 10);
		return this;
	}

//--------------------->PR Approval<----------------------

	public OpportunityPage ClickApprovallink() {

		jsOperation(JSAction.CLICK, linkApprovePrReq);

		return this;
	}

	public OpportunityPage ApprovePRrequest() {
		refresh();
		click(bttnApprovePrReq, WaitStrategy.CLICKABLE, 10);
		sendKeys(txtcomments, "Test123", WaitStrategy.CLICKABLE, 20);
		click(bttnpostApprove, WaitStrategy.CLICKABLE, 10);
		DriverManager.getDriver().navigate().back();
		return this;
	}

	public OpportunityPage SelectOpportunitycategory(String Oppcategory) {

		jsOperation(JSAction.SCROLLTOVIEW, dropOpportunitycategory);
		jsOperation(JSAction.CLICK, dropOpportunitycategory);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(OpportunityCategoryvalue, Oppcategory);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "OpenCategory Dropdown" + Oppcategory);
		return this;

	}

	

	public OpportunityPage SelectStage(String stagevalue) {

		jsOperation(JSAction.SCROLLTOVIEW, dropStage);
		jsOperation(JSAction.CLICK, dropStage);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(dropStagevalue, stagevalue);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Stage Drop down" + stagevalue);

		return this;
	}

	public OpportunityPage SelectOpportunitytype(String type) {

		jsOperation(JSAction.SCROLLTOVIEW, dropOpportunitytype);
		jsOperation(JSAction.CLICK, dropOpportunitytype);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(OpportunityTypevalue, type);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "OpportunityType Drop down" + type);
		return this;
	}

	public OpportunityPage SelectItService(String itservicevalue) {

		jsOperation(JSAction.SCROLLTOVIEW, dropItService);
		jsOperation(JSAction.CLICK, dropItService);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(ItServicevalue, itservicevalue);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "ItService Drop down" + itservicevalue);
		return this;
	}

	public OpportunityPage SelectServiceSubcategory(String subcategory) {

		jsOperation(JSAction.SCROLLTOVIEW, dropServicesubCategory);
		jsOperation(JSAction.CLICK, dropServicesubCategory);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(ServicesubCategoryvalue, subcategory);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "ServicesubCategory Drop down" + subcategory);
		return this;
	}

	public OpportunityPage enterProjectduration(String Projectdurtion) {

		sendKeys(txtProjectduration, Projectdurtion, WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public OpportunityPage enterDebriefValue() {

		sendKeys(txtDebrief, getRandomString(5), WaitStrategy.CLICKABLE, 20);
		
		return this;
	}

	public OpportunityPage SelectReason(String reason) {

		jsOperation(JSAction.SCROLLTOVIEW, dropReason);
		jsOperation(JSAction.CLICK, dropReason);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(dropReasonvalue, reason);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Reason value Drop down" + reason);

		return this;
	}

	public OpportunityPage SaveOpportnitydetails() {

		click(bttSaveOppdetails, WaitStrategy.CLICKABLE, 5);

		return this;
	}

	public OpportunityPage CompleteTheStage() {

		jsOperation(JSAction.SCROLLTOVIEW, linkOpportunityTab);
		jsOperation(JSAction.CLICK, bttnCompleteStage);

		return this;
	}

	public OpportunityPage ConvertToClosedWon() {

		click(bttnDone, WaitStrategy.CLICKABLE, 5);

		return this;
	}
	private final By categoryDropdown = By.xpath("//button[@aria-label='Opportunity Category, --None--']");
	private final By categoryptions = By
			.xpath("//button[@aria-label='Opportunity Category, --None--']/parent::div//following-sibling::div//span[normalize-space(text())]");
	
	public OpportunityPage selectOppCategory() {
		jsOperation(JSAction.SCROLLTOVIEW, categoryDropdown);
		click(categoryDropdown, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listcategoryoptions = getElements(categoryptions);
		int n = getRandomNumber(1, listcategoryoptions.size() - 1);
		String oppCategory = listcategoryoptions.get(n).getAttribute("innerHTML");
		
		jsOperation(JSAction.SCROLLTOVIEW, listcategoryoptions.get(n));
		jsOperation(JSAction.CLICK, listcategoryoptions.get(n));
		ExtentLogger.info("Selected Opporuntity category as : " + oppCategory );
		return this;
	}
	private final By Oppor_Category = By.xpath("//button[@aria-label='Opportunity Category, --None--']");

	public OpportunityPage Select_Oppurtunitycategory(String OpportunityCategoryOption) {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		click(Oppor_Category, WaitStrategy.NONE, 2, "Opportunity Category dropdown");
		String CatXpath = DynamicXpathUtlis.getXpath(value, OpportunityCategoryOption);
		click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 0,
				"Opportunity Category dropdown" + OpportunityCategoryOption);
		return this;
	}
	private final By ItServiceDropdown = By.xpath("//button[@aria-label='IT Service, --None--']");
	private final By ITServiceptions = By
			.xpath("//button[@aria-label='IT Service, --None--']/parent::div//following-sibling::div//span[normalize-space(text())]");
	
	public String selectOppITService() {
		jsOperation(JSAction.SCROLLTOVIEW, ItServiceDropdown);
		click(ItServiceDropdown, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listITServiceoptions = getElements(ITServiceptions);
		int n = getRandomNumber(1, listITServiceoptions.size() - 1);
		String oppITService = listITServiceoptions.get(n).getAttribute("innerHTML");
		
		jsOperation(JSAction.SCROLLTOVIEW, listITServiceoptions.get(n));
		jsOperation(JSAction.CLICK, listITServiceoptions.get(n));
		ExtentLogger.info("Selected Opporuntity IT Service  as : " + oppITService );
		return oppITService;
	}
	
	
	private final By serviceSubTypeDropdown = By.xpath("//button[@aria-label='Service Sub-Category, --None--']");
	private final By serviceSubTypeptions = By
			.xpath("//button[@aria-label='Service Sub-Category, --None--']/parent::div//following-sibling::div//span[normalize-space(text())]");
	
	public OpportunityPage selectOppServiceSubType() {
		try {
		jsOperation(JSAction.SCROLLTOVIEW, serviceSubTypeDropdown);
		click(serviceSubTypeDropdown, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listServiceSubTypeoptions = getElements(serviceSubTypeptions);
		int n = getRandomNumber(1, listServiceSubTypeoptions.size() - 1);
		String oppServiceSubType = listServiceSubTypeoptions.get(n).getAttribute("innerHTML");
		
		jsOperation(JSAction.SCROLLTOVIEW, listServiceSubTypeoptions.get(n));
		jsOperation(JSAction.CLICK, listServiceSubTypeoptions.get(n));
		ExtentLogger.info("Selected Opporuntity Service subType  as : " + oppServiceSubType );}
		catch(Exception e)
		{
			System.out.print(e.getStackTrace());
		}
		return this;
	} 

	private final By managedserviceDropdown = By.xpath("//button[@aria-label='MS Renewal Type, --None--']");
	private final By managedServiceOptions = By
			.xpath("//button[@aria-label='MS Renewal Type, --None--']/parent::div//following-sibling::div//span[normalize-space(text())]");
	
	public OpportunityPage selectManagedService() {
		
		jsOperation(JSAction.SCROLLTOVIEW, managedserviceDropdown);
		click(managedserviceDropdown, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listmanagedServiceoptions = getElements(managedServiceOptions);
		int n = getRandomNumber(1, listmanagedServiceoptions.size() - 1);
		String oppmanagedService = listmanagedServiceoptions.get(n).getAttribute("innerHTML");
		
		jsOperation(JSAction.SCROLLTOVIEW, listmanagedServiceoptions.get(n));
		jsOperation(JSAction.CLICK, listmanagedServiceoptions.get(n));
		ExtentLogger.info("Selected Opporuntity managed Service  as : " + oppmanagedService );
		
	
		return this;
	}
	public OpportunityPage enter_closedate() {
		String closedate = getCurrentDatePlusInFormat("M/d/yyyy", 30);

		sendKeys(Close_date, closedate, WaitStrategy.CLICKABLE, 20);
		ExtentLogger.info("Entered opportunity Close Date as : " +closedate);
		return this;
	}
	
	public OpportunityPage enter_Startdate() {
		String startDate = getCurrentDatePlusInFormat("M/d/yyyy", 60);
		sendKeys(project_Stdate, startDate, WaitStrategy.CLICKABLE, 20);
		ExtentLogger.info("Entered opportunity Start Date as : " +startDate);
		return this;
	}

	String stagexpath = "//lightning-base-combobox-item//span[text()='%s']/parent::span";

	public OpportunityPage Select_Stage(String StageOpion) {
		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
		jsOperation(JSAction.SCROLLTOVIEW, stage);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		try {
			click(stage, WaitStrategy.NONE, 2);
		} catch (Exception e1) {
			jsOperation(JSAction.CLICK, stage);
		}
		String CatXpath = DynamicXpathUtlis.getXpath(stagexpath, StageOpion);
		try {
			click(By.xpath(CatXpath), WaitStrategy.CLICKABLE, 3);
		} catch (Exception e) {
			jsOperation(JSAction.CLICK, stage);
			jsOperation(JSAction.CLICK, By.xpath(CatXpath));
		}

		return this;
	}
	
	public OpportunityPage Select_OppurtunityType(String OpportunityTypeOption) {
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		click(Opp_Type, WaitStrategy.NONE, 2);
		String option = DynamicXpathUtlis.getXpath(value, OpportunityTypeOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 2);
		return this;
	}
	private final By Project_Duration = By.xpath("//input[@name='Project_Approximate_Duration_Months__c']");
	
	public OpportunityPage enter_projectDuration() {

		sendKeys(Project_Duration, "60", WaitStrategy.CLICKABLE, 20);
		return this;
	}

	private final By OPTY_Gross_Booking_Value = By.xpath("//input[@name='Amount']");

	public OpportunityPage enter_OPTY_Gross_Booking_Value() {

		sendKeys(OPTY_Gross_Booking_Value, "5", WaitStrategy.CLICKABLE, 20);

		return this;
	}
	
	private final By soruceDropdown = By.xpath("//label[text()='Source']/..//lightning-base-combobox//button");
//	private final By OptionsSales = By.xpath("//lightning-base-combobox-item//span[text()='Sales']/../..");
	String source_value = "//lightning-base-combobox-item//span[text()='%s']/parent::span";

	public OpportunityPage selectOppSource(String sourceOption) {

//		click(soruceDropdown, WaitStrategy.CLICKABLE, 5);
		jsOperation(JSAction.SCROLLTOVIEW, soruceDropdown);
		jsOperation(JSAction.CLICK, soruceDropdown);
		String option = DynamicXpathUtlis.getXpath(source_value, sourceOption);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10);

		return this;
	}

	private final By soruceTypeDropdown = By
			.xpath("//label[text()='Source Type']/parent::lightning-combobox//lightning-base-combobox//button");

	public OpportunityPage selectOppSourceType(String sourceType_Option) {

		click(soruceTypeDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(source_value, sourceType_Option);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage save() {

		click(Save_bttn, WaitStrategy.CLICKABLE, 10);
		Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
		return this;
	}

	
private final String opportunityToBeClicked = "//a[@title ='%s']";
	
	public OpportunityPage selectOpportuntiy(String oppname)
	{
			String oppToBeSelectedXpath = DynamicXpathUtlis.getXpath(opportunityToBeClicked, oppname);
					click(By.xpath(oppToBeSelectedXpath), WaitStrategy.CLICKABLE, 15, "Navigated to Opportunity : " + oppname);
return this;
	} 
	public String  createOpportunity(Map<String, String> data)
	{
		String OpportunityName = getCompanyName();
		enteroppname(OpportunityName).enter_closedate().Select_Oppurtunitycategory(data.get("OppCategory"))
		.enter_Startdate().Select_Stage(data.get("OppStage"));
		String ITService = selectOppITService();
		selectOppServiceSubType().Select_OppurtunityType(data.get("OppType"))
		.enter_projectDuration().enter_OPTY_Gross_Booking_Value().selectOppSource(data.get("OppSource")).selectOppSourceType(data.get("oppSourceType"));
		if(ITService.contains("Managed Services"))
		{
			selectManagedService();
		}
		save();
		return OpportunityName;
	}
	
	private By editDebrief = By.xpath("//span[contains(text(),'Edit Debrief')]");
	private By txtdebrief = By.xpath("//label[contains(text(),'Debrief')]//parent::lightning-textarea/div");
	
	public OpportunityPage enterDebrief()
	{
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		jsOperation(JSAction.SCROLLTOVIEW, editDebrief);
		jsOperation(JSAction.CLICK, editDebrief);
		//click(editDebrief, WaitStrategy.CLICKABLE, 10);
		sendKeys(txtdebrief, getRandomString(5), WaitStrategy.CLICKABLE, 20);
		SaveOpportnitydetails();
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		return this;
	}
	private By stageClosed = By.xpath("//a[@title='Closed']");
	private By bttnstageClosed = By.xpath("//span[text()='Select Closed Stage']");
	private By stageDropdown = By.xpath("//button[contains(@aria-label , 'Closed - Won')]");
	private By closedLostDropdownValue = By.xpath("//label[text()='Stage']/parent::lightning-combobox//lightning-base-combobox//span[contains(text(), 'Closed - Lost')]");
	
	
	public OpportunityPage markStageClosedLost()
	{
		refresh();
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		jsOperation(JSAction.SCROLLTOVIEW, stageClosed);
		jsOperation(JSAction.CLICK, stageClosed);
		//click(stageClosed, WaitStrategy.CLICKABLE, 10);
		jsOperation(JSAction.CLICK, bttnstageClosed);
		//click(bttnstageClosed, WaitStrategy.CLICKABLE, 10);
		click(stageDropdown, WaitStrategy.CLICKABLE, 10);
		click(closedLostDropdownValue, WaitStrategy.CLICKABLE, 10);
		selectReasonWon_Lost();
		jsOperation(JSAction.CLICK, bttnDone);
		//Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		return this;
	}

	
	private final By reasonWon_LostDropdown = By.xpath("//button[contains(@aria-label, 'Reason (Won/Lost/Not Awarded/Cancelled')]");
	private final By reasonWon_LostOptions = By
			.xpath("//button[contains(@aria-label, 'Reason (Won/Lost/Not Awarded/Cancelled')]/parent::div//following-sibling::div//span[normalize-space(text())]");
	
	
	public OpportunityPage selectReasonWon_Lost() {
		
		jsOperation(JSAction.SCROLLTOVIEW, reasonWon_LostDropdown);
		click(reasonWon_LostDropdown, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listreasonWon_Lostoptions = getElements(reasonWon_LostOptions);
		int n = getRandomNumber(1, listreasonWon_Lostoptions.size() - 1);
		jsOperation(JSAction.SCROLLTOVIEW, listreasonWon_Lostoptions.get(n));
		jsOperation(JSAction.CLICK, listreasonWon_Lostoptions.get(n));
		return this;
	}
}
