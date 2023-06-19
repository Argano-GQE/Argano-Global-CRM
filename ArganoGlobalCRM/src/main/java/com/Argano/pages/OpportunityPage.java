package com.Argano.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.Argano.driver.DriverManager;
import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.DynamicXpathUtlis;

public class OpportunityPage extends BasePage {

	private final By linkOpportunityTab = By.xpath("//a[@title='Opportunities']");

	private final By linkOpportunitylist = By
			.xpath("//span[text()='Opportunity Name']/following::a[@data-special-link='true'][1]");

//----------------------->Add Argano Solution<-----------------------------

	private final By linkArganoSolution = By.xpath("//slot/span[contains(text(),'Argano Solutions')]");
	private final By bttnAddarganoSolutions = By.xpath("//div[text()='Add Argano Solutions']");
	private final By bttnNext = By.xpath("//span[text()='Next']");
	private final By checkboxArganosolution = By.xpath(
			"//a[@title='App Dev']/parent::span/parent::th/parent::tr//div[contains(@class,'forceVirtualCheckbox uiInput--default')]");
	private final By dropTower = By.xpath(
			"//td[@class='slds-cell-edit slds-cell-error errorColumn cellContainer']/following::span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'][2]");
	private final By dropTowervalue = By.xpath(
			"//td[@class='slds-cell-edit slds-cell-error errorColumn cellContainer']/following::span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'][2]//button");
	private final By dropTowerValueclick = By.xpath(
			"//td[@class='slds-cell-edit slds-cell-error errorColumn cellContainer']/following::span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'][2]//button/following::a[@class='select']");
	private final By dropTowerValue = By.xpath("//a[text()='Microsoft']");
//private final String dropTowerValue = "//a[text()='Microsoft']";
	private final By dropArganoJoinerCompany = By.xpath(
			"//td[@data-aura-class='forceInlineEditCell'][2]/span[contains(@class,'forceInlineEditCell')]//button");
	private final By dropArganoJoineroption = By.xpath(
			"//td[@class='slds-cell-edit slds-is-edited cellContainer']/span//button/following::a[text()='--None--']");
	private final By ArganoJoinerValue = By.xpath("//a[text()='Argano']");
//private final String ArganoJoinerValue = "//a[text()='%s']";
	private final By dropsolutionowner = By.xpath(
			"//td[@data-aura-class='forceInlineEditCell'][3]/span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']//button");
//private final By dropSolutionOption= By.xpath("//div[contains(@class,'autocompleteWrapper')]/input");
	private final By SolutionOwnerValue = By.xpath("//div[@title='Akash SV']");
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
	private final String dropApproverValue = "(//span[@title='%s'])[1]";
	private final By bttnFinish = By.xpath("//button[text()='Finish']");

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

	private final By closewontxt = By.xpath("//span[text()='Stage changed successfully.']");

	
	public String StageCompleteMsg() {
		
		String stagecompletetxt = getText(closewontxt, 100);
		
		return stagecompletetxt;
	
	
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

		click(linkArganoSolution, WaitStrategy.CLICKABLE, 10);

		return this;

	}
  
	public OpportunityPage AddArganoSolution() {

		click(bttnAddarganoSolutions, WaitStrategy.CLICKABLE, 10);

		click(checkboxArganosolution, WaitStrategy.CLICKABLE, 10);

		click(bttnNext, WaitStrategy.CLICKABLE, 10);

		return this;

	}

	public OpportunityPage SelectTower() {

		jsOperation(JSAction.CLICK, dropTower);
		click(dropTowervalue, WaitStrategy.CLICKABLE, 10);
		click(dropTowerValueclick, WaitStrategy.CLICKABLE, 10);
		click(dropTowerValue, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage SelectArganoJoinerCompany() {

		click(dropArganoJoinerCompany, WaitStrategy.CLICKABLE, 50);
		click(dropArganoJoineroption, WaitStrategy.CLICKABLE, 10);
		click(ArganoJoinerValue, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage SelectSolutionOwner() {
		click(dropsolutionowner, WaitStrategy.CLICKABLE, 10);
		click(SolutionOwnerValue, WaitStrategy.CLICKABLE, 10);
		return this;
	}

	public OpportunityPage EnterGrossBookingValue(String crossBookvalue) {
		click(txtSolcrossBook, WaitStrategy.CLICKABLE, 10);
		clear(txtSolcrossBookclear, WaitStrategy.CLICKABLE, 10);
		sendKeys(By.xpath(txtSolcrossBookValue), crossBookvalue, WaitStrategy.CLICKABLE, 20);
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

	public OpportunityPage SelectApprover(String Approver) {

		WebElement Approve = DriverManager.getDriver().findElement(dropApprover);
		Actions oapprove = new Actions(DriverManager.getDriver());
		oapprove.moveToElement(Approve).build().perform();
		click(dropApprover, WaitStrategy.CLICKABLE, 10);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(dropApproverValue, Approver);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Approver Dropdown" + Approver);

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

	public OpportunityPage enterProjectStartdate() {
		jsOperation(JSAction.CLICK, bttncategoryedit);
		sleep(5);

		sendKeys(txtProjectStartdate, "07/09/2023", WaitStrategy.CLICKABLE, 20);

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

	public OpportunityPage enterDebriefValue(String debriefvalue) {

		sendKeys(txtDebrief, debriefvalue, WaitStrategy.CLICKABLE, 20);

		return this;
	}

	public OpportunityPage SelectReason(String reason) {

		jsOperation(JSAction.SCROLLTOVIEW, dropReason);
		jsOperation(JSAction.CLICK, dropReason);
		String sourceTypeXpath = DynamicXpathUtlis.getXpath(dropReasonvalue, reason);
		click(By.xpath(sourceTypeXpath), WaitStrategy.CLICKABLE, 5, "Reasonvalue Drop down" + reason);

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

	

}
