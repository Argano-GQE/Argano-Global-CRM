package com.Argano.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Argano.pages.AccountsPage;
import com.Argano.pages.Homepage;
import com.Argano.pages.LeadPage;
import com.Argano.pages.LogInPage;
import com.Argano.pages.OpportunityPage;
import com.Argano.reports.ExtentLogger;

public class GlobalCRM_Test extends BaseTest {

	LogInPage login;
	Homepage home;
	LeadPage lead;
	OpportunityPage opp;
	AccountsPage acc;

	@Test(priority = 1)
	public void markClosedWon(Map<String, String> data) {

		login = new LogInPage();
		login.LoginToSalesforceCRM(data.get("Username"), data.get("Password"));
		ExtentLogger.pass("Logged in Browser: " + data.get("Browser"));
		home = new Homepage();
		home.Create_New_Lead();
		lead = new LeadPage();
		lead.CreateNewLead().Clicknextbttn().SelectTitletext().SelectSalutation("Mr.").enterLeadFirstName()
				.enterLeadMiddleName().enterLeadLastName().enterCompanyName().enterCompanyEmail()
				.enterDescription(data.get("LeadDescription")).SelectLeadstatus("MEL").SelectLeadsource("Marketing")
				.SelectLeadsourcetype("Marketplace").SelectTower().enteLeadAddress("Herat", "Herat").enterLeadStreet()
				.enterLeadCity().enterLeadZipcode().saveLead().Clicklead().Clickconvert();
		String leadConvertSuccessMessage = lead.getLeadConvertedMessage();
		Assert.assertEquals(data.get("Leadsuscessmsg"), leadConvertSuccessMessage);
		lead.navigateTolead();
		home.ClickAccountTab();
		acc = new AccountsPage();
		acc.SelectAccount().SubmittingForApproval().enterCustomerLegalEntity("Test").selectCustomerGroup("All")
				.selectMethodofPayment("ACH").selectTermsofPayment("N0").enterWebsiteAddress(data.get("WebAddress"))
				.enterShippingStreet().enterShippingCity().enterShippingZip().selectShippCountry("Algeria")
				.ClickFinish().ClickApprovallink().ApprovetheConversion().enterCommentandApprove(data.get("AccCommet"))
				.CloseDuplicatepopup(); 

		String accountConversionMsg = acc.accountConversionMsg();
		Assert.assertEquals(data.get("AccountTypemsg"), accountConversionMsg);
		opp = new OpportunityPage();
		opp.ClickOpportunityTab().SelectOpportunityfromList().ClickArganoSolutionlink().AddArganoSolution()
				.SelectTower().SelectArganoJoinerCompany().SelectSolutionOwner().EnterGrossBookingValue("1")
				.SaveSolution().ClosePopupwindow().ClickOpportunityTab().SelectOpportunityfromList().ClickProposalReqlink()
				.ClickProposalReqNumber().SubmitforApproval().SelectProposalType().SelectPrDuedate(data.get("Prdue"))
				.SelectApprover(data.get("OppApprover")).FinishApprovalSubmission().ClickApprovallink()
				.ApprovePRrequest().ClickOpportunityTab().SelectOpportunityfromList().enterProjectStartdate()
				.SelectOpportunitycategory("Professional Services").SelectStage(data.get("OppStage"))
				.SelectOpportunitytype("Net New (NN)").SelectItService("Consulting")
				.SelectServiceSubcategory("Business Consulting").enterProjectduration("2")
				.enterDebriefValue(data.get("Debrief")).SelectReason("Continuing Business").SaveOpportnitydetails()
				.CompleteTheStage().ConvertToClosedWon();
		String StagecompletesuccessMsg = opp.StageCompleteMsg();
		Assert.assertEquals(data.get("StageMsg"), StagecompletesuccessMsg);

	}

}
