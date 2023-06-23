package com.Argano.pages;

import org.openqa.selenium.By;
import com.Argano.enums.JSAction;
import com.Argano.reports.ExtentLogger;
import com.Argano.utlis.DynamicXpathUtlis;


public class Homepage extends ApplicationMethods {

	private final By Select_Account = By.xpath("//a[text()='Create Account']");
	private final By Select_Opportunity = By.xpath("//a[text()='Create Opportunity']");
	private final By linkAccountstab = By.xpath("//a/span[text()='Accounts']");
	private final By linkOpportunities = By.xpath("//a[@title='Opportunities']");

	private final By iconSales = By.xpath("//span[@title='Sales']");

	public boolean isHomePageDisplayed()
	{
		return isDisplayed(iconSales, 10);
	
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
