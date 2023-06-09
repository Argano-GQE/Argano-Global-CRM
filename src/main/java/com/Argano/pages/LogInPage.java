package com.Argano.pages;

import org.openqa.selenium.By;

import com.Argano.enums.WaitStrategy;
import com.Argano.utlis.RandomTxt;

public class LogInPage extends BasePage{


private final By txtUserName= By.id("username");

private final By txtPassword= By.id("password");

private final By bttnLoginToSandbox= By.xpath("//input[@value='Log In to Sandbox']");

public Homepage Login_To_SF(String username, String password) {
	
	
	sendKeys(txtUserName,username, WaitStrategy.CLICKABLE, 10);
	sendKeys(txtPassword, password, WaitStrategy.CLICKABLE, 100);
	click(bttnLoginToSandbox, WaitStrategy.CLICKABLE, 10);
	
	return new Homepage();
	
}








}
