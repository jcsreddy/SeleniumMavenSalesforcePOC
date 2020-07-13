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

public class windowHandle_first{

	public static String projectpath;
	public static WebDriver driver;
	public static int size;
	public static String chromedriverpath, child_window;

	public static void main(String[] args) {
		setup();
	}
	public static void setup()
	{
		/* Initiating the driver*/
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/"); 
		driver.manage().window().maximize();
		
		driver.switchTo().frame("a077aa5e");
		System.out.println("********We are switching to the iframe*******");
		//@FindBy(xpath = "html/body/a/img") WebElement newLink;
		driver.findElement(By.xpath("html/body/a/img")).click();
		
		/* Actual code for handling windows or tabs*/
		Set <String> st= driver.getWindowHandles();
		Iterator<String> it = st.iterator();
		String parent =  it.next();
		String child = it.next();

		System.out.println("Parent id..."+parent);
		System.out.println("Child id..."+child);
		
		// switch to child
		driver.switchTo().window(child);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("We are in child window.....");
		//swtich to parent
		driver.switchTo().window(parent);
		System.out.println("Returned to parent");
		System.out.println("We are in parent window.....");

		// switch to child
		driver.switchTo().window(child);
		String value = driver.findElement(By.xpath("//b[text()=' FREE!']")).getText();
		System.out.println("We are in child window and the value is...."+value);
		Assert.assertEquals("FREE!", value);
		
		//swtich to parent
		driver.switchTo().window(parent);
		String newValue = driver.findElement(By.xpath("//h2/font[text()='THIS IS A DEMO PAGE FOR TESTING']")).getText();
		Assert.assertEquals("THIS IS A DEMO PAGE FOR TESTING", newValue);
		System.out.println("We are again in parent window.....");
		
		System.out.println("End of test....");
		
		driver.quit();

	}
}