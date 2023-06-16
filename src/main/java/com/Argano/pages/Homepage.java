package com.Argano.pages;

import org.openqa.selenium.By;


import com.Argano.enums.JSAction; 
import com.Argano.utlis.DynamicXpathUtlis; 

public class Homepage extends BasePage {

	private final static String tabXpath = "//a[@title='%s']";

	public void navigateToTab(String tabname) {
		String tabNewXpath = DynamicXpathUtlis.getXpath(tabXpath, tabname);
		jsOperation(JSAction.CLICK, By.xpath(tabNewXpath), "Navigated to tab " + tabname);

	}
}
