package com.salesforce.mylearnings;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.FindBy;
//import org.testng.annotations.*;

public class windowHandle_Updated{

	public static String projectpath;
	public static WebDriver driver;
	public static int size;
	private static String parent, child;

	public static void main(String[] args) {
		initBrowser();
		openTabs();
		windowNames();
		System.out.println("Parent window id is..."+parent);
		System.out.println("Child window id is..."+child);
		intoParent(parent);
		intoChild(child);
		tearBrowser();
		
	}

	public static void initBrowser()
	{
		/* Initiating the driver*/
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/"); 
		driver.manage().window().maximize();
	}

	public static void openTabs()
	{
		driver.switchTo().frame("a077aa5e");
		System.out.println("********We are switching to the iframe*******");
		driver.findElement(By.xpath("html/body/a/img")).click();
	}

	public static void windowNames()
	{
		Set <String> st= driver.getWindowHandles();
		Iterator<String> it = st.iterator();
		parent =  it.next();
		child = it.next();
	}

	public static void intoParent(String parent) {
		//swtich to parent
		driver.switchTo().window(parent);
		String newValue = driver.findElement(By.xpath("//h2/font[text()='THIS IS A DEMO PAGE FOR TESTING']")).getText();
		Assert.assertEquals("THIS IS A DEMO PAGE FOR TESTING", newValue);
		System.out.println("Assertion in parent is passed.....");		
	}

	public static void intoChild(String child) {
		// switch to child
		driver.switchTo().window(child);
		String value = driver.findElement(By.xpath("//b[text()=' FREE!']")).getText();
		Assert.assertEquals("FREE!", value);
		System.out.println("Assertion in child is passed.....");
	}

	public static void tearBrowser() {
		System.out.println("Closing the browser........");
		driver.quit();
		
	}
}