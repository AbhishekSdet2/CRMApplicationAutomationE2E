package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUTS=20;
	public static long IMPLICIT_WAIT=10;
	static Workbook workbook;
	static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH="C://Users//abhis//eclipse-workspace//CRMProjectNaveenAutomationLabs//CRMAutomation//src//main//java//com//crm//qa//TestData//FreeCRM.xlsx";


    public static Object[][] getTestData(String sheetName){
    	FileInputStream file=null;
    	try {
    	  file=new FileInputStream(TESTDATA_SHEET_PATH);
    	  try {
			workbook=WorkbookFactory.create(file);
		} 
    	  catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    	}
    	catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	sheet=workbook.getSheet(sheetName);
    	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
    	
    	
		return data;
    	
    }
}
