package com.Argano.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.Argano.pages.Homepage;
import com.Argano.pages.LeadPage;
import com.Argano.pages.LogInPage;
import com.Argano.pages.Opportunity;

public class Salesforce_Test extends BaseTest {

	LogInPage login;
	Homepage home;
	LeadPage lead;
	Opportunity opp;

	@Test(priority = 1)
	public void CreateLeadAccount(Map<String, String> data) {

		login = new LogInPage();
		login.Login_To_SF(data.get("Username"), data.get("Password"));

		home = new Homepage();
		home.Create_New_Lead();
		lead = new LeadPage();
		lead.LeadPage_Fields();
	}

	@Test(priority = 2)
	public void CreateOpportunity(Map<String, String> data) {

		login = new LogInPage();
		login.Login_To_SF(data.get("Username"), data.get("Password"));
		home = new Homepage();
		home.Create_NewOpportunity();
		opp = new Opportunity();
		opp.CreateOpportunity();

	}

}
