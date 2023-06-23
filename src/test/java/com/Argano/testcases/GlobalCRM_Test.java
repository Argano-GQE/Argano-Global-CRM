package com.Argano.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Argano.pages.AccountsPage;
import com.Argano.pages.ContactPage;
import com.Argano.pages.Homepage;
import com.Argano.pages.LeadPage;
import com.Argano.pages.LogInPage;
import com.Argano.pages.OpportunityPage;
import com.Argano.reports.ExtentLogger;

public class GlobalCRM_Test extends BaseTest {

	LogInPage login;
	Homepage homepage;
	LeadPage leadpage;
	OpportunityPage opportunitypage;
	AccountsPage accountspage;
	ContactPage contactpage;
	
	
	@Test()
	public void LeadToClosedWon(Map<String, String> data) {
		ExtentLogger.pass("Logged in Browser: " + data.get("Browser"));
		
		login = new LogInPage();
		homepage =login.LoginToSalesforceCRM(data.get("Username"), data.get("Password"));
		
		Assert.assertEquals(true, homepage.isHomePageDisplayed());
		ExtentLogger.pass("Logged in to application Successfully");
		
		
		Boolean isNavigationSuccessful=	homepage.navigateToTab("Leads");
		Assert.assertTrue(isNavigationSuccessful);

		leadpage = new LeadPage();
		leadpage.createLead(data).saveLead().updateLeadStatus().clickconvertLead();
		
		//Assert.assertTrue(leadpage.isLeadConverted());
		
		String convertedAccount =leadpage.getConvertedAccount();
		String convertedOpportunity = leadpage.getConvertedOpportunity();
		
		ExtentLogger.pass("Lead converted Successfully to Account "+ convertedAccount + ", Contact :" + leadpage.getConvertedContact() + ", Opportunity :" + convertedOpportunity);
		
		homepage.navigateToTab("Accounts");
		accountspage = new AccountsPage();
		accountspage.selectAccount(convertedAccount).submitForApproval(data).approveAccount();
		ExtentLogger.info("Navigated to Lead converted Account");
		
		String accountConversionMsg = accountspage.accountConversionMsg();
		Assert.assertEquals(data.get("ApprovedAccountType"), accountConversionMsg);
		ExtentLogger.pass("Account converted to type : " + accountConversionMsg);
		
		opportunitypage = new OpportunityPage();
		opportunitypage.ClickOpportunityTab().SelectOpportunityfromList().ClickArganoSolutionlink().AddArganoSolution().SelectTower("Microsoft").SelectArganoJoinerCompany("Argano").SelectSolutionOwner(data.get("SolutionOwner")).EnterGrossBookingValue("1")
		.SaveSolution().ClosePopupwindow().ClickOpportunityTab().SelectOpportunityfromList().ClickProposalReqlink()
		.ClickProposalReqNumber().SubmitforApproval().SelectProposalType("Proposal").SelectPrDuedate(data.get("Prdue"))
		.SelectApprover(data.get("Approver")).FinishApprovalSubmission().ClickApprovallink()
		.ApprovePRrequest(data.get("Prcomments")).ClickOpportunityTab().SelectOpportunityfromList().enterProjectStartdate()
		.SelectOpportunitycategory("Professional Services").SelectStage(data.get("OppStage"))
		.SelectOpportunitytype("Net New (NN)").SelectItService("Consulting")
		.SelectServiceSubcategory("Business Consulting").enterProjectduration("2")
		.enterDebriefValue().SelectReason("Continuing Business").SaveOpportnitydetails()
		.CompleteTheStage().ConvertToClosedWon();
		Assert.assertTrue(opportunitypage.isStageChangeTxtDisplayed());
		
		ExtentLogger.pass("Opportunity marked as CLOSED WON");
		}
	

	
	@Test()
	public void AccountToClosedLost(Map<String, String> data) {
		ExtentLogger.pass("Logged in Browser: " + data.get("Browser"));
		
		login = new LogInPage();
		homepage =login.LoginToSalesforceCRM(data.get("Username"), data.get("Password"));
		
		Assert.assertEquals(true, homepage.isHomePageDisplayed());
		ExtentLogger.pass("Logged in to application Successfully");
		
		homepage.navigateToTab("Accounts");

		accountspage = new AccountsPage();
		
		String accountname = accountspage.createAccount(data);
		ExtentLogger.pass("Created Account : "+ accountname +" of type :" + data.get("AccountType"));
		
		contactpage = accountspage.ClickrelatedContactView().clickNewContact();
		String contactname = contactpage.createContact(data);
		Assert.assertTrue(contactpage.isContactDisplayedInReleatedList(contactname));
		ExtentLogger.pass("Created Contact : "+ contactname);
		
		homepage.navigateToTab("Accounts");
		accountspage.selectAccount(accountname);
		opportunitypage =accountspage.createRelatedOpportunity();
		
		String oppName = opportunitypage.createOpportunity(data);
		ExtentLogger.pass("Created Opportunity : "+ oppName );
		
		homepage.navigateToTab("Opportunities");
		opportunitypage.selectOpportuntiy(oppName).enterDebrief().markStageClosedLost();
		
		Assert.assertTrue(opportunitypage.isStageChangeTxtDisplayed());
		
		ExtentLogger.pass("Opportunity marked as CLOSED LOST");
		
	}
	
	
	@Test()
	public void CreateCustomerAccount(Map<String, String> data)
	{ExtentLogger.pass("Logged in Browser: " + data.get("Browser"));
	
	login = new LogInPage();
	homepage =login.LoginToSalesforceCRM(data.get("Username"), data.get("Password"));
	
	Assert.assertEquals(true, homepage.isHomePageDisplayed());
	ExtentLogger.pass("Logged in to application Successfully");
	
	homepage.navigateToTab("Accounts");

	accountspage = new AccountsPage();
	
	 accountspage.createAccount(data);
	ExtentLogger.info("selected account type as :" + data.get("AccountType"));
	Assert.assertTrue(accountspage.isValidationDisplayed());
	ExtentLogger.pass("Validation is displayed when User tries to create Customer Account");

		
	}

	}
