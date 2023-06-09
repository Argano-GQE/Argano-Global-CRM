package com.Argano.pages;

import org.openqa.selenium.By;

import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.Waits;

public class Homepage extends BasePage {

	private final By Select_Lead = By.xpath("//one-app-nav-bar-item-root[@data-id='Lead']/a/span[text()='Leads']");
	private final By Select_Account = By.xpath("//a[text()='Create Account']");
	private final By Select_Opportunity = By.xpath("//a[text()='Create Opportunity']");

	public LeadPage Create_New_Lead() {

		Waits.sleep(7);

		jsOperation(JSAction.CLICK, Select_Lead);
		// click(Select_Lead, WaitStrategy.CLICKABLE, 15);

		return new LeadPage();

	}

	public Opportunity Create_Newcontact() {

		Waits.sleep(7);

		jsOperation(JSAction.CLICK, Select_Account);
		// click(Select_Lead, WaitStrategy.CLICKABLE, 15);

		return new Opportunity();

	}

	public Opportunity Create_NewOpportunity() {

		Waits.sleep(7);

		jsOperation(JSAction.CLICK, Select_Opportunity);
		// click(Select_Lead, WaitStrategy.CLICKABLE, 15);

		return new Opportunity();

	}

}
