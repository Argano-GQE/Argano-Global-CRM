package com.Argano.pages;

import org.openqa.selenium.By;

public class ContactPage {

	private final By Title = By.xpath("//button[@name='salutation']");
	private final String Title_Mr = "//span[contains(@title,'%s')]";
	private final By Title_text = By.xpath("//input[@name='Title']");

	private final By First_Name = By.xpath("//input[@name='firstName']");
	private final By Middle_Name = By.xpath("//input[@name='middleName']");
	private final By Last_Name = By.xpath("//input[@name='lastName']");
	private final By Suffix = By.xpath("//input[@name='suffix']");

	private final By Email = By.xpath("//input[@name='Email']");

	private final By Department_Textbox = By.xpath("//input[@name='Department]");

	private final By Lead_Source = By.xpath("//button[@aria-label='Lead Source, --None--']");
	private final String LEADSOURCETYPEVALUE = "//span[contains(@title,'%s')]";
	private final By Lead_Source_type = By.xpath("//button[@aria-label='Lead Source Type, --None--']");

	private final By Address = By
			.xpath("//legend[text()='Address']/following::lightning-lookup-address//div[1]//div[1]/div[1]/input");
	private final String Addressvalue = "//lightning-base-combobox-formatted-text[contains(@title,'%s')]";

	private final By Street = By.xpath("//textarea[@name='street']");
	private final By Cityname = By.xpath("//input[@name='city']");
	private final By Zip = By.xpath("//input[@name='postalCode']");

}
