package com.Argano.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Argano.driver.DriverManager;
import com.Argano.pages.AccountPage;
import com.Argano.pages.ContactPage;
import com.Argano.pages.Homepage;
import com.Argano.pages.LogInPage;
import com.Argano.pages.Opportunity;
import com.Argano.utlis.Waits;

public class Salesforce_Test extends BaseTest {

	LogInPage login;
	Homepage home;
	AccountPage accountObj;
	ContactPage contactsObj;

	Opportunity oppObj;

	@Test(priority = 1)
	public void Sample(Map<String, String> data) {

		login = new LogInPage();
		login.Login_To_SF(data.get("Username"), data.get("Password"));
		home = new Homepage();

		home.navigateToTab("Accounts");

		accountObj = new AccountPage();
		String AccountName = accountObj.clicknewAccount().enterAccountName();
		accountObj.select_type("Internal").select_source("Sales").select_Type_source("Employee").BillingAddress()
				.saveAccount();
		System.out.println(AccountName);
		Waits.sleep(5);
		home.navigateToTab("Contacts");
		Waits.sleep(5);
		contactsObj = new ContactPage();

		contactsObj.newContact().select_Salutatiom("Mr.").enter_FirstName().enter_MiddleName().enter_LastName()
				.enter_AccountName(AccountName).enter_Title().enter_Email().select_Tower("Salesforce Tower")
				.select_source("Client").sourceType("Referral").saveContact();
		Waits.sleep(5);

		home.navigateToTab("Opportunities");
		Waits.sleep(5);
		oppObj = new Opportunity();
		String OpportunityName = oppObj.newOpportunity().oppname();
		oppObj.enter_AccountName(AccountName).Select_Oppurtunitycategory("Intercompany SOW")
				.Select_Stage("2. Proposal Development").Select_OppurtunityType("Net New (NN)").enter_closedate()
				.enter_Stdate().Select_ItService("Implementation")
				.Select_Service_Subtype("Infrastructure Implementation").enter_projectDuration()
				.select_source("Marketing").select_Type_source("Marketplace").enter_OPTY_Gross_Booking_Value().save();
		Waits.sleep(5);
		home.navigateToTab("Accounts");
		Waits.sleep(5);
		home.navigateToTab("Opportunities");
		oppObj.CloseLost(OpportunityName);
 	  

	}

}
