package com.salesforce.mylearnings;

import java.util.List;
import javax.swing.text.TabExpander;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

public class handleTable {

	public static WebDriver driver;
	public static String baseUrl = "http://demo.guru99.com/test/web-table-element.php"; //"http://demo.guru99.com/test/write-xpath-table.html";
	public static String tableHeaderPath, tableColumnPath;
	static String company;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		tableHeaderPath = "//table[@class='dataTable']/thead/tr/th";
		tableColumnPath = "//table[@class='dataTable']/tbody/tr";
		
		List <WebElement> col = driver.findElements(By.xpath(tableHeaderPath));
		System.out.println("Number of columnn in the table are...."+col.size());
		
		List <WebElement> row = driver.findElements(By.xpath(tableColumnPath));
		System.out.println("Number of rows in the table are...."+row.size());
		
		/* Code to validate column headers in the table */
		
         company =  driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr/th[1]")).getText();
         Assert.assertEquals("Company", company);
         
         System.out.println("End of test....");
         
         driver.quit();

	}

}
