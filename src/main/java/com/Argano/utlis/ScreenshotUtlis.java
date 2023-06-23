package com.Argano.utlis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Argano.driver.DriverManager;
import com.google.common.util.concurrent.Uninterruptibles;

public final class ScreenshotUtlis {

private ScreenshotUtlis()
{
	
}
	public static String getBase64Image()
	{
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
