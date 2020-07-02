package com.salesforce.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	String projectpath;
	
	public ConfigDataProvider()
	{
		projectpath = System.getProperty("user.dir");
		File src = new File(projectpath+"/Config/logindata.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file..."+ e.getMessage());
		} 
	}

	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getURL()
	{
		return prop.getProperty("url");
	}
	
}
