package com.Argano.pages;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Argano.enums.WaitStrategy;
import com.Argano.reports.ExtentLogger;
import com.Argano.utlis.DynamicXpathUtlis;
import com.Argano.utlis.FakerAPI;
import com.google.common.util.concurrent.Uninterruptibles;

public class AccountPage extends BasePage {
	private final By bttnNewAccount = By.xpath("//div[@title='New']");

	public AccountPage clicknewAccount() {

		click(bttnNewAccount, WaitStrategy.CLICKABLE, 5, "New Account Button");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		return this;
	}

	private final By txtAccountName = By
			.xpath("//span[text()='Account Name']/following-sibling::span/parent::label/parent::div//input");

	public String enterAccountName() {
		String AccountName = FakerAPI.getFirstName() + FakerAPI.getLastName();
		sendKeys(txtAccountName, AccountName, WaitStrategy.CLICKABLE, 10);
		ExtentLogger.info(AccountName + "is the name of the Account");

		return AccountName;
	}

	private final By TypeDropdown = By.xpath("//span[text()='Type']/parent::span/following-sibling::div//a");
//	private final By OptionsInternal = By.xpath("//a[text()='%s']");
	String value = "//a[text()='%s']";

	public AccountPage select_type(String Type) {

		click(TypeDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, Type);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 5, "Type" + Type + "is selcted");

		return this;
	}

	private final By soruceDropdown = By.xpath("//span[text()='Source']/parent::span/following-sibling::div//a");
 

	public AccountPage select_source(String source) {

		click(soruceDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, source);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10, "source" + source + " is Selected");

		return this;
	}

	private final By soruceTypeDropdown = By.xpath("//span[text()='Source Type']/parent::span/following-sibling::div//a");
// 

	public AccountPage select_Type_source(String sourceType) {

		click(soruceTypeDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, sourceType);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10, "source Type " + sourceType + "is Selected");

		return this;
	}

	private final By Account_Currency_Dropdown = By
			.xpath("//span[text()='Account Currency']/parent::span/following-sibling::div//a");
	private final By OptionsIndianRupee = By.xpath("//a[text()='INR - Indian Rupee']");

	public AccountPage select_Account_Currency(String Account_Currency) {

		click(Account_Currency_Dropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, Account_Currency);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10, "Account Currency Indian Rupee  is Selected");

		return this;
	}

//	need to change
	private final By CountryListforBilling = By.xpath("//a[text()='Aland Islands']/ancestor::ul//a"); 

//	need to change
	private final By CountryDropDownforbilling = By
			.xpath("//div[@class='country compoundTLRadius compoundTRRadius compoundBorderBottom uiMenu']//a");
	private final By txtBillingStreet = By.xpath("//textarea[@placeholder='Billing Street']"); 
	public AccountPage BillingAddress() {
		click(CountryDropDownforbilling, WaitStrategy.CLICKABLE, 5);
		List<WebElement> list1 = getElements(CountryListforBilling);
		System.out.println(list1.size());
		int n = getRandomNumber(list1.size() - 1) + 2;
		String countryforBilling = list1.get(n).getAttribute("innerHTML");
		ExtentLogger.info(countryforBilling + "Country is selcted");
		list1.get(n).click();
		sendKeys(txtBillingStreet, FakerAPI.getAddress(), WaitStrategy.CLICKABLE, 10);

		return this;
	}
 
	private final By Savebttn = By.xpath("//button[@title='Save']//span[text()='Save']");

	public Homepage saveAccount() {
		click(Savebttn, WaitStrategy.CLICKABLE, 5);
		return new Homepage();
	}

	private final By cancelbttn = By
			.xpath("//button[@title='Cancel']//span[text()='Cancel']");

	public Homepage cancelAccount() {
		click(cancelbttn, WaitStrategy.CLICKABLE, 5);
		return new Homepage();
	}
}
