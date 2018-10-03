package com.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class XLUtilities implements IConstantValues {

	public String getCellData(String sFileName,String sSheetName, int iRow, int iCol) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(iRow);
		Cell cl = rw.getCell(iCol);
		return cl.getStringCellValue();
		
	}
	public String GetCellData(String sFileName,String sSheetName, int iRow, int iCol) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(iRow);
		Cell cl = rw.getCell(iCol);
		return cl.getStringCellValue();
		
	}
	public void putCellData(String sFileName,String sSheetName, int iRow, int iCol,String sData) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		try{
			Row rw = sh.getRow(iRow);
			Cell cl = rw.getCell(iCol);
			if (cl==null){
				cl=rw.createCell(iCol);
				cl.setCellValue(sData);
			}
			
			else{
				cl.setCellValue(sData);
			}
			
			FileOutputStream fileOut = new FileOutputStream(sFileName);
			 
				wb.write(fileOut);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//////////////New
	public int getCellValue(String sFileName,String sSheetName, int iRow, int iCol) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(iRow);
		Cell cl = rw.getCell(iCol);		
		return (int) cl.getNumericCellValue();
		
	}
	public int getRowNoinCSV(String sFileName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);
		int rowCount=sh.getLastRowNum();
		return rowCount;
		
	}
	public int getCellNoinCSV(String sFileName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int cellCount=0;
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);
		int rowCount=sh.getLastRowNum();
		for(int i=0;i<rowCount;i++){
			Row r=sh.getRow(i);
			cellCount=r.getLastCellNum();
		}
		
		return cellCount;
		
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		/*String fname= "C:\\NotBackedUp\\Login.xlsx";
		String shName= "Login";
		int row =1;
		int col=1;*/
		XLUtilities ul = new XLUtilities();
				int value= ul.getRowCount(EXCEL_PATH, "consignmentnumber");
				int columnCount = ul.getColumnCount(EXCEL_PATH, "consignmentnumber", 0);
		System.out.println(columnCount);
	}

	public int getRowCount(String sFileName, String sSheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		
		return sh.getLastRowNum();
		
	}
	public int getColumnCount(String sFileName, String sSheetName, int row) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		Row rw = sh.getRow(0);
		return rw.getLastCellNum();
		}
	
	public int getRowIndex(String sFileName,String sSheetName, String iRow) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int rowCount = getRowCount(sFileName, sSheetName);
		int i;
		System.out.println(rowCount+"rowCount");
		FileInputStream fis = new FileInputStream(sFileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sSheetName);
		for (i=1; i < rowCount+1; i++) {
			if(iRow.equalsIgnoreCase(sh.getRow(i).getCell(0).toString())) {
				break;
			}
		}
		return i;
	
		
/*		Row rw = sh.getRow(iRow);
		Cell cl = rw.getCell(iCol);
		return cl.getStringCellValue();*/
		
	}

}
