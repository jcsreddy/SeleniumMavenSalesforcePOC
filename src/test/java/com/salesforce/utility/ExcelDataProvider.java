package com.salesforce.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	String projectpath;
	
	/* Constructor */
	public ExcelDataProvider()
	{
		projectpath = System.getProperty("user.dir");
		File src = new File(projectpath+"/TestData/LoginData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to find file..."+e.getMessage());
		}
	}
	
	/* Method Overloading */
	public String getStringData(String sheetName, int rowNum, int colNum)
	{
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
	}

	public double getNumericData(String sheetName, int rowNum, int colNum)
	{
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
	}
}
