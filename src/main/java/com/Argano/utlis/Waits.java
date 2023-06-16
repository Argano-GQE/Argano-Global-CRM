package com.Argano.utlis;
 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import com.Argano.driver.DriverManager;
 

public class Waits {
public static void EWait(int i, String xpath) {
    	
    	long dr = i;
        WebDriverWait wait =new  WebDriverWait(DriverManager.getDriver(), dr);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    } 
    
    //------------------------- Implicit wait --------------------------------//
    
	@SuppressWarnings("deprecation")
	public static void IWait(int i) {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }
	
    //------------------------- Sleep ----------------------------------------//
	
    public static void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
