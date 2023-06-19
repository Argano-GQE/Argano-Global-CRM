package com.Argano.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Argano.constants.FrameworkConstants;
import com.Argano.enums.ConfigProperties;

import com.Argano.utlis.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {

	}
@BeforeSuite
	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			//System.out.println(Objects.isNull(DriverManager.getDriver()));
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver(chromeOptions));
			} else if (browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions firefoxOptions = new FirefoxOptions(); 
				firefoxOptions.addPreference("dom.webnotifications.enabled",false)
				.addPreference("dom.webnotifications.enabled", false)
                .addPreference("geo.enabled", false)
                .addPreference("geo.provider.use_corelocation", false)
                .addPreference("geo.prompt.testing", false)
                .addPreference("geo.prompt.testing.allow", false);
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver(firefoxOptions));

			} else if (browser.equalsIgnoreCase("Internet Explorer")) {
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				ieOptions.addCommandSwitches("--disable-notifications");
				WebDriverManager.iedriver().setup();
				DriverManager.setDriver(new InternetExplorerDriver(ieOptions));

			} 
			
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getImplicitywaittime(),
					TimeUnit.SECONDS);
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}
@AfterSuite
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
