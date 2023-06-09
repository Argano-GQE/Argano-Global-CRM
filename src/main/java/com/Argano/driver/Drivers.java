package com.Argano.driver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Argano.exception.InvalidBrowserExpection;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers {
	 
	public static WebDriver driver;
	public static WebDriver getDriver(String browsername) throws Exception {
		System.out.println("hello");
		
		
		if(browsername.equals("chrome")) {
			 
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		}
		else if(browsername.equals("edge")) {
			 
			 
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			
		}
		else if(browsername.equals("firefox")) { 
			 
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			throw new InvalidBrowserExpection("Please provide the valid browser name in LowerCase");
		}
		return driver;
	}
	public static void quit() {
		driver.quit();
	}
	public static void close() {
		driver.close();
	}
}
