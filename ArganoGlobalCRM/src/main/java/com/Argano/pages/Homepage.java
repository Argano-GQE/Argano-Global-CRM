package com.Argano.pages;

import org.openqa.selenium.By;
import com.Argano.enums.JSAction;


public class Homepage extends BasePage {

	private final By Select_Lead = By.xpath("//one-app-nav-bar-item-root[@data-id='Lead']/a/span[text()='Leads']");
	private final By Select_Account = By.xpath("//a[text()='Create Account']");
	private final By Select_Opportunity = By.xpath("//a[text()='Create Opportunity']");
	private final By linkAccountstab = By.xpath("//a/span[text()='Accounts']");
	private final By linkOpportunities = By.xpath("//a[@title='Opportunities']");

	public LeadPage Create_New_Lead() {

		jsOperation(JSAction.CLICK, Select_Lead);

		return new LeadPage();

	}

	public OpportunityPage Create_Newcontact() {

		sleep(7);

		jsOperation(JSAction.CLICK, Select_Account);

		return new OpportunityPage();

	}

	public OpportunityPage Create_NewOpportunity() {

		sleep(7);

		jsOperation(JSAction.CLICK, Select_Opportunity);

		return new OpportunityPage();

	}

	public AccountsPage ClickAccountTab() {

		jsOperation(JSAction.CLICK, linkAccountstab);

		return new AccountsPage();

	}

	public OpportunityPage ClickOpportunityTab() {

		jsOperation(JSAction.CLICK, linkOpportunities);

		return new OpportunityPage();
	}

}
