package com.salesforce.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshots, Alerts, Frames, Windows, Sync Issues, JavaScript Executor
	public static String projectpath;
	public static String captureScreenShot(WebDriver driver)
	{
		projectpath=System.getProperty("user.dir");
		String screenShotPath = projectpath+"/ScreenShots/Salesforce " + Helper.getCurrentDateTime() +".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			//FileHandler.copy(src, new File(projectpath+"/ScreenShots/Salesforce " + Helper.getCurrentDateTime() +".png"));
			FileHandler.copy(src, new File(screenShotPath));
			System.out.println("Screen shot captured...");
		} catch (IOException e) {
			System.out.println("Unable to capture screen shot...."+e.getMessage());
		}
		return screenShotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
}
