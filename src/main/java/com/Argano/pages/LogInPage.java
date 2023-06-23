package com.Argano.pages;

import org.openqa.selenium.By;

import com.Argano.enums.WaitStrategy;

public class LogInPage extends BasePage {

	private final By txtUserName = By.id("username");

	private final By txtPassword = By.id("password");

	private final By bttnLoginToSandbox = By.xpath("//input[@value='Log In to Sandbox']");

	public LogInPage enterUsername(String username) {

		sendKeys(txtUserName, username, WaitStrategy.CLICKABLE, 5);

		return this;
	}

	public LogInPage enterPassword(String password) {

		sendKeys(txtPassword, password, WaitStrategy.CLICKABLE, 2);

		return this;
	}

	public void LogintoSalesforce() {

		click(bttnLoginToSandbox, WaitStrategy.CLICKABLE, 3);
	}


 public Homepage  LoginToSalesforceCRM(String username,String password) {
	 
	 enterUsername(username).enterPassword(password).LogintoSalesforce();
	 return new Homepage();
 }

   
}
