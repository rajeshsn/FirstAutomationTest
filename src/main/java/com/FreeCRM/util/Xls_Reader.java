package com.FreeCRM.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.FreeCRM.base.TestBase;

public class Xls_Reader extends TestBase {
	
	public String path;
	
	public FileInputStream fis =null;
	
	public FileOutputStream fileOut =null;
	
	private XSSFWorkbook workbook =null;
	
	private XSSFSheet sheet = null;
	
	private XSSFRow row = null;
	
	private XSSFCell cell =null;
	

	
	public Xls_Reader(String path) throws IOException{
		
		this.path =path;
		
		try{
			
			fis = new FileInputStream(path);
			
			workbook=new XSSFWorkbook(fis);
			
			
			
		}catch(FileNotFoundException e){
			System.out.println(e);}
		}
	


}

