package com.Argano.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.Argano.driver.DriverManager;
import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;

 
public class AccountsPage extends BasePage {

	private final By linkApproval = By.xpath("//slot/span[contains(text(),'Approval Hi')]");
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
	public String accountConversionMsg() {

		String accountconversionmsg = getText(accountTypetxt, 5);

		return accountconversionmsg;
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

	public AccountsPage SubmittingForApproval() {

		click(dropforconversion, WaitStrategy.CLICKABLE, 50);
		click(dropOptSumitforApproval, WaitStrategy.CLICKABLE, 15);

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

	public AccountsPage enterCommentandApprove(String Accountcmmt) {

		sendKeys(txtComment, Accountcmmt, WaitStrategy.NONE, 5);
		click(bttnPostApprove, WaitStrategy.CLICKABLE, 15);
		DriverManager.getDriver().navigate().back();
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

}
