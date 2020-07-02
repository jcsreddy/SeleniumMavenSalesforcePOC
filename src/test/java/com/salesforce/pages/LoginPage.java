package com.salesforce.pages;
//import java.util.Base64;
//import java.util.Base64.Decoder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import com.salesforce.utility.Helper;

public class LoginPage {
	
	//private static WebElement element = null;
	WebDriver driver = null;
	
	/* Constructor */
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(name = "username") WebElement uname;
	@FindBy(name = "pw") WebElement upwd;
	@FindBy(name = "Login") WebElement ulogin;
	
	public void loginToAppl(String usernameFromAppl, String passwordFromAppl)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uname.sendKeys(usernameFromAppl);
		//password = Base64.getEncoder().encode(password);
		upwd.sendKeys(passwordFromAppl);
		ulogin.click();
		
	}

/*
	public void password(String passwordFromAppl)
	{
		//password = Base64.getEncoder().encode(password);
		upwd.sendKeys(passwordFromAppl);
	}		
	public void clicklogin()
	{
		//driver.findElement(clicklogin).click();
		ulogin.click();
	}	
	public static WebElement username(WebDriver driver) 
	{	
		element = driver.findElement(By.name("username"));
		return element;
	}	
	public static WebElement password(WebDriver driver) 
	{	
		element = driver.findElement(By.name("pw"));
		return element;		
	}
	public static WebElement clicklogin(WebDriver driver) 
	{	
		element = driver.findElement(By.name("Login"));
		return element;		
	}
	*/
}
