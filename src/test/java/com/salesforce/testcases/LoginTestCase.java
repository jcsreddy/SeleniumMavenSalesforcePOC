package com.salesforce.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.salesforce.pages.BaseClass;
import com.salesforce.pages.LoginPage;
import com.salesforce.utility.Helper;

public class LoginTestCase extends BaseClass {
	
	@Test(priority=1)
	public void loginAppl()
	{		
		logger = report.createTest("Login to Salesforce");
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		//username and password are coming from baseclass
		logger.info("Starting Application...");
		lp.loginToAppl(username, password);
		Helper.captureScreenShot(driver);
		logger.pass("Login Success");
		//System.out.println("End of test case.");
	}
}
