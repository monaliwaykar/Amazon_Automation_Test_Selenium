package com.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GetData {

	       XSSFWorkbook workbook;
	       XSSFSheet sheet;
	       XSSFRow row;
	       XSSFCell cell;
	       
	       public String searchValue()
	       {
	              String value = null;
	              try
	              {
	              CallExcelFile();
	              row  = sheet.getRow(1);
	              cell = row.getCell(0);
	              value = cell.getStringCellValue();
	              }
	              catch(Exception e)
	              {
	                     e.getMessage();
	              }
	              return value;
	              }
	       
	       public String SecondPhone()
	       {
	              String value = null;
	              try
	              {
	              CallExcelFile();
	              row  = sheet.getRow(1);
	              cell = row.getCell(1);
	              value = cell.getStringCellValue();
	       }
	              catch(Exception e)
	              {
	                  e.getMessage();
	              }
	              return value;
	       }
	       
	       
	       public void CallExcelFile() throws IOException
	       {
	    	      FileInputStream excelfile = new FileInputStream("C:\\Users\\XXXX\\workspace\\Amazon\\src\\Excel_Data\\GetInput.xlsx");
	              workbook = new XSSFWorkbook(excelfile);
	              sheet = workbook.getSheet("Sheet1");
	       }
}
