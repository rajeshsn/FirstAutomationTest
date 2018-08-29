package com.FreeCRM.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.FreeCRM.base.TestBase;

public class ExcelUtility extends TestBase {
	
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\Rajesh\\Desktop\\Assignment\\Framework\\FreeCRMAutomationTest\\Resources\\Crm_TestData.xlsx";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public Object[][] getTestData(String sheetName){
		
	FileInputStream file =null;
	
	try{
		
		file = new FileInputStream(TESTDATA_SHEET_PATH);
		
		
	}catch(FileNotFoundException e)
	
	{
		
		System.out.println(e);
	}
	
	try{
		workbook= new XSSFWorkbook(file);
	} catch(IOException e)
	
	{
		System.out.println(e);
	}catch(Exception e){
		
		System.out.println(e);
	}
	
	
	sheet= workbook.getSheet(sheetName);
	
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	System.out.println(sheet.getLastRowNum()+"-------"+sheet.getRow(0).getLastCellNum());
	
	for (int i=0;i<sheet.getLastRowNum();i++){
		
		for (int j=0;j<sheet.getRow(0).getLastCellNum();j++){
			
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			
			System.out.println(data[i][j]);
						
		}
	}
	
	return data;	
		
		
		
	}

}
