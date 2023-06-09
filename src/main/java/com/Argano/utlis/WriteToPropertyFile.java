package com.Argano.utlis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteToPropertyFile {
	public static void main(String[] args) throws IOException {
		WritePropertiesFile("place","India","D:\\Automation\\KESTE_CPQ_PFL\\src\\test\\resources\\config\\QuoteAndGLIDnumber.properties");
		
	}
	
	public static void WritePropertiesFile(String key, String data, String loc) throws IOException
	{
	Properties configProperty = new Properties();
	configProperty.setProperty(key, data);
	File file = new File(loc);
	FileOutputStream fileOut = new FileOutputStream(file,true);
	configProperty.store(fileOut, "updated the file with --> "+key);
	fileOut.close();
	}


}
