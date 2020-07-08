package com.salesforce.pages;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
//import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforce.utility.BrowserFactory;
import com.salesforce.utility.ConfigDataProvider;
import com.salesforce.utility.ExcelDataProvider;
import com.salesforce.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider edp;
	public ConfigDataProvider cdp;
	public String username, password;
	public ExtentReports report;
	public String projectpath;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		
		edp = new ExcelDataProvider();
		username = edp.getStringData("LoginSheet", 0, 0);
		password = edp.getStringData("LoginSheet", 0, 1);
		cdp = new ConfigDataProvider();
		
		/* code for extent report*/
		projectpath = System.getProperty("user.dir");
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(projectpath+"/Reports/Salesforce "+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup()
	{
		driver = BrowserFactory.startApplication(driver, cdp.getBrowser(), cdp.getURL());
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod //Used to run after every test case
	public void tearDownMethod(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			//Helper.captureScreenShot(driver);
			/* Add screenshot to the html report */
			try {
				logger.fail("Test failed....", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("Test Case Failed......");
			}
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			try {
				logger.pass("Test passed....", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Test Case Passed......");
			}
		} if(result.getStatus() == ITestResult.SKIP)
		{
			try {
				logger.skip("Test skipped....", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Test Case Skipped......");
			}
		}
		report.flush();
	}
}
