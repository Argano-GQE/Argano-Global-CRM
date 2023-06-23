package com.Argano.pages;



import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.Argano.driver.DriverManager;
import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.reports.ExtentLogger;
import com.Argano.utlis.DynamicXpathUtlis;


 
public class AccountsPage extends ApplicationMethods {

	private final By linkApproval = By.xpath("//slot/span[contains(text(),'Approval History')]");
	private final By linkOpportunity = By.xpath("//slot/span[contains(text(),'Opportunities')]");
	private final By linkContact = By.xpath("//slot/span[contains(text(),'Related Contact')]");
	private final By linkSelectAccount = By
			.xpath("//span[text()='Account Name']/following::a[@data-special-link='true'][1]");
	private final By dropforconversion = By
			.xpath("//lightning-button-menu[contains(@data-target-reveals,'sfdc:QuickAction.Account.Submit')]/button");
	private final By dropOptSumitforApproval = By.xpath("//span[text()='Submit for Conversion Approval']");
	private final By txtCustomerlegalentity = By.xpath("//input[@name='Customer_Legal_Entity']");
	private final By dropCustomergroup = By.xpath("//select[@name='Customer_Group_Screen']");
	private final By dropMethodOfPayment = By.xpath("//select[@name='Method_of_Payment_Screen']");
	private final By dropTermsofPayment = By.xpath("//select[@name='Terms_of_Payment_Screen']");
	private final By txtWebsite = By.xpath("//input[@type='url']");
	private final By txtShipingstreet = By.xpath("//textarea[@class='slds-textarea']");
	private final By txtShippingcity = By.xpath("//input[@name='Shipping_City']");
	private final By dropShippingCountry = By.xpath("//label[text()='Shipping Country']/following::select");
	private final By txtShippingzip = By.xpath("//input[@name='Shipping_Zip_Postal_Code']");
	private final By bttnFinish = By.xpath("//button[text()='Finish']");
	private final By bttnApprove = By.xpath("//div[text()='Approve']");
	private final By txtComment = By.xpath("//textarea[contains(@class,'TextArea textarea')]");
	private final By bttnPostApprove = By.xpath("//span[text()='Approve']");
	private final By accountTypetxt = By.xpath("(//lightning-formatted-text[text()='Customer'])[1]");
    private final By bttnclosepopupWindow= By.xpath("//button[@title='Close']/lightning-primitive-icon");
    private final By bttnCloseSucessPopup = By.xpath("//button[@title='Close this window']");
    private final By txtCustomerAccountValidation = By.xpath("//li[contains(text(),'Only Admins can Select or Change')]");
    
    public boolean isValidationDisplayed()
    {
    return	isDisplayed(txtCustomerAccountValidation,5);
    	
    }
	public String accountConversionMsg() {

		String accountconversionmsg = getText(accountTypetxt, 5);

		return accountconversionmsg;
	}

	private final String accountToBeClicked = "//a[@title ='%s']";
	
	public AccountsPage selectAccount(String accountname)
	{
			String accountToBeSelectedXpath = DynamicXpathUtlis.getXpath(accountToBeClicked, accountname);
					click(By.xpath(accountToBeSelectedXpath), WaitStrategy.CLICKABLE, 15, "Navigated to Account : " + accountname);
return this;
	}
	
	public AccountsPage SelectAccount() {
		sleep(2);
		jsOperation(JSAction.CLICK, linkSelectAccount);
		return this;
	}

	public AccountsPage ClickApprovalhistory() {

		click(linkApproval, WaitStrategy.CLICKABLE, 15);

		return this;
	}
	public OpportunityPage ClickrelatedOpportunityView() {

		sleep(2);
		click(linkOpportunity, WaitStrategy.CLICKABLE, 15);

		return new OpportunityPage();
	}
	
	private final By bttnNewRelatedOpp = By.xpath("//button[@name= 'New']");
	public OpportunityPage createRelatedOpportunity() {

		sleep(2);
		click(linkOpportunity, WaitStrategy.CLICKABLE, 15);
		click(bttnNewRelatedOpp, WaitStrategy.CLICKABLE, 10);

		return new OpportunityPage();
	}
	public AccountsPage ClickrelatedContactView() {

		sleep(2);
		click(linkContact, WaitStrategy.CLICKABLE, 15);

		return this;
	}
	
	private final By bttnNewContact = By.xpath("//div[contains(text(),'New Contact')]");
	
	public ContactPage clickNewContact()
	{
		sleep(2);
		click(bttnNewContact, WaitStrategy.CLICKABLE, 15);
		return new ContactPage();
	}
	
	public AccountsPage submitForApproval(Map<String, String> data)
	{
		clicksubmitForApproval().populateSubmitForApprovalFields(data).ClickFinish();
		return this;
	}
	
	public AccountsPage approveAccount()
	{
		ClickApprovallink().ApprovetheConversion().enterCommentandApprove().CloseDuplicatepopup().closeSubmissionSucesspopup();
		return this;
	}
	public AccountsPage clicksubmitForApproval() {
		click(dropforconversion, WaitStrategy.CLICKABLE, 50);
		click(dropOptSumitforApproval, WaitStrategy.CLICKABLE, 15);

		return this;
	}
	

	public AccountsPage populateSubmitForApprovalFields(Map<String, String> data)
	{
		enterCustomerLegalEntity(getRandomString(10)).selectCustomerGroup(data.get("AccountCustomerGroup"))
		.selectMethodofPayment(data.get("AccountPaymentMethod")).selectTermsofPayment(data.get("AccountPaymemtTerm")).enterWebsiteAddress(data.get("WebAddress"))
		.enterShippingStreet().enterShippingCity().enterShippingZip().selectShippCountry(data.get("AccountShippingCountry"));
	
		return this;
	}

	public AccountsPage enterCustomerLegalEntity(String Customerlegalentity) {

		sendKeys(txtCustomerlegalentity, Customerlegalentity, WaitStrategy.NONE, 5);

		return this;
	}

	public AccountsPage selectCustomerGroup(String Customergroup) {

		WebElement Customergrpele = DriverManager.getDriver().findElement(dropCustomergroup);
		Select customergrp = new Select(Customergrpele);
		customergrp.selectByVisibleText(Customergroup);
		return this;
	}

	public AccountsPage selectMethodofPayment(String Methodpayment) {

		WebElement methodpaypele = DriverManager.getDriver().findElement(dropMethodOfPayment);
		Select methodpay = new Select(methodpaypele);
		methodpay.selectByVisibleText(Methodpayment);
		return this;
	}

	public AccountsPage selectTermsofPayment(String Termspayment) {

		WebElement termspaypele = DriverManager.getDriver().findElement(dropTermsofPayment);
		Select termspay = new Select(termspaypele);
		termspay.selectByVisibleText(Termspayment);
		return this;
	}

	public AccountsPage enterWebsiteAddress(String Webaddress) {

		clear(txtWebsite, WaitStrategy.NONE, 5);
		sendKeys(txtWebsite, Webaddress, WaitStrategy.NONE, 5);

		return this;
	}

	public AccountsPage enterShippingStreet() {

		sendKeys(txtShipingstreet,getStreetName(), WaitStrategy.NONE, 5);

		return this;
	}

	public AccountsPage enterShippingCity() {

		sendKeys(txtShippingcity, getCity(), WaitStrategy.NONE, 5);

		return this;
	}

	public AccountsPage enterShippingZip() {

		sendKeys(txtShippingzip,getPincode(), WaitStrategy.NONE, 5);

		return this;
	}

	public AccountsPage selectShippCountry(String Shipcountry) {

		WebElement Countryele = DriverManager.getDriver().findElement(dropShippingCountry);
		Select country = new Select(Countryele);
		country.selectByVisibleText(Shipcountry);
		return this;
	}

	public AccountsPage ClickFinish() {

		click(bttnFinish, WaitStrategy.CLICKABLE, 15);

		return this;
	}

	public AccountsPage ClickApprovallink() {

		jsOperation(JSAction.CLICK, linkApproval);

		return this;
	}

	public AccountsPage ApprovetheConversion() {
		refresh();
		click(bttnApprove, WaitStrategy.CLICKABLE, 15);

		return this;
	}

	public AccountsPage enterCommentandApprove() {
		String approveComment = getRandomString(10);
		sendKeys(txtComment, approveComment, WaitStrategy.NONE, 5);
		click(bttnPostApprove, WaitStrategy.CLICKABLE, 15);
		DriverManager.getDriver().navigate().back();
		DriverManager.getDriver().navigate().refresh();
		sleep(2);
		return this;
	}

   public AccountsPage CloseDuplicatepopup() {
	   try {
		click(bttnclosepopupWindow, WaitStrategy.CLICKABLE, 10);
	} catch (Exception e) {
	
	System.out.println("No duplicte popup Window");
	}	
		return this;	
	
   }
   public AccountsPage closeSubmissionSucesspopup() {
	   try {
		click(bttnCloseSucessPopup, WaitStrategy.CLICKABLE, 10);
	} catch (Exception e) {
	
	System.out.println("No duplicte popup Window");
	}	
		return this;	
   }
   
	private final By txtAccountName = By
			.xpath("//span[text()='Account Name']/following-sibling::span/parent::label/parent::div//input");

	public String enterAccountName() {
		String AccountName = getCompanyName();
		sendKeys(txtAccountName, AccountName, WaitStrategy.CLICKABLE, 10);
		return AccountName;
	}
	
	
	private final By TypeDropdown = By.xpath("//span[text()='Type']/parent::span/following-sibling::div//a");

	private String value = "//a[text()='%s']";

	public AccountsPage select_type(String Type) {

		click(TypeDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, Type);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 5);

		return this;
	}
	
	private final By soruceDropdown = By.xpath("//span[text()='Source']/parent::span/following-sibling::div//a");
	 

	public AccountsPage select_source(String source) {

		click(soruceDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, source);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10, "Account source selected as : " + source );

		return this;
	}

	private final By soruceTypeDropdown = By.xpath("//span[text()='Source Type']/parent::span/following-sibling::div//a");
// 

	public AccountsPage select_Type_source(String sourceType) {

		click(soruceTypeDropdown, WaitStrategy.CLICKABLE, 5);
		String option = DynamicXpathUtlis.getXpath(value, sourceType);
		click(By.xpath(option), WaitStrategy.CLICKABLE, 10, "Account source Type selected as : " + sourceType);

		return this;
	}
	private final By CountryListforBilling = By.xpath("//a[text()='Aland Islands']/ancestor::ul//a"); 

	private final By CountryDropDownforbilling = By
			.xpath("//span[text()='Billing Country']//parent::span/following-sibling::div//a");
	
	private final By txtBillingStreet = By.xpath("//textarea[@placeholder='Billing Street']"); 
	
	public AccountsPage BillingAddress() {
		jsOperation(JSAction.SCROLLTOVIEW, CountryDropDownforbilling);
		click(CountryDropDownforbilling, WaitStrategy.CLICKABLE, 5);
		List<WebElement> listBillingCountry = getElements(CountryListforBilling);
		int n = getRandomNumber(listBillingCountry.size() - 1) + 2;
		String countryforBilling = listBillingCountry.get(n).getAttribute("innerHTML");
		
		jsOperation(JSAction.SCROLLTOVIEW, listBillingCountry.get(n));
		jsOperation(JSAction.CLICK, listBillingCountry.get(n));
		ExtentLogger.info("Selected Billing country as :" + countryforBilling );
		
	
		sendKeys(txtBillingStreet, getAddress(), WaitStrategy.CLICKABLE, 10);

		return this;
	}
	
	private final By Savebttn = By.xpath("//button[@title='Save']//span[text()='Save']");

	public AccountsPage saveAccount() {
		click(Savebttn, WaitStrategy.CLICKABLE, 5);
		return this;
	}
   public String createAccount(Map<String, String> data)
   {
	   
	   clickNew();
	   String accname = enterAccountName();
	   select_type(data.get("AccountType")).select_source(data.get("AccountSource")).select_Type_source(data.get("AccountSourceType")).BillingAddress();
	   saveAccount();
	   return accname;
   }
}
