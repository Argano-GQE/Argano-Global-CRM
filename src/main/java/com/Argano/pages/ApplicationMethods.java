package com.Argano.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.Argano.enums.JSAction;
import com.Argano.enums.WaitStrategy;
import com.Argano.reports.ExtentLogger;
import com.Argano.utlis.DynamicXpathUtlis;
import com.google.common.util.concurrent.Uninterruptibles;

public class ApplicationMethods extends BasePage{
	
	private final static String tabXpath = "//a[@title='%s']";
	private final  By bttnCreateNew = By.xpath("//div[text()='New']");
	
	private final By txtTabName = By.xpath("//*[@id=\"brandBand_1\"]//div/lst-breadcrumbs/div/div/span");
	

	
	protected  void clickNew()
	{
		click(bttnCreateNew, WaitStrategy.CLICKABLE, 10);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		
	}
	
	public  boolean  navigateToTab(String tabname) {
        String tabNewXpath = DynamicXpathUtlis.getXpath(tabXpath, tabname);
        jsOperation(JSAction.CLICK, By.xpath(tabNewXpath));
       Boolean isTabNameDisplayed = getText(txtTabName, 5).equalsIgnoreCase(tabname);
       if(isTabNameDisplayed)
       {
    	   ExtentLogger.info("Navigated to tab: "+ tabname);
       }
       else
    	   
       {
    	   ExtentLogger.fail(" Failure in Navigating to "+ tabname );
       }
        return isTabNameDisplayed;
        

    }
	protected final By txtSucessMsg = By.xpath("/html/body/div[6]/div/div/div");
	
	public String getSuccessMessage() {
		String sucessMsg;
		com.Argano.factory.ExplicitWaitFactory.performExplicitWait(txtSucessMsg, com.Argano.enums.WaitStrategy.VISIBLE, 10);
		sucessMsg = getText(txtSucessMsg, 50);
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		return sucessMsg;
	}
}
