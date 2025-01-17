package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static String location = "./resources";
	static FileInputStream fis;
	
	//To Return String Value
	public static String getString(int row,int col,String fileName,String SheetName) {
		
		String value = null;
		try {
			fis = new FileInputStream(location+"/"+fileName);
			System.out.println("<<<<<<< Excel FileFound >>>>>>>");
			try {
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet(SheetName);
				value = sheet.getRow(row).getCell(col).getStringCellValue();
				System.out.println("====== Data Fetched and returned successfully =====");
			} 
			catch (IOException e) {
				System.out.println("====== Failed to Fetch Data from Sheet ======");
				e.printStackTrace();
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("<<<<<<< Exce File not Found , Please Check File location >>>>>>>");
			e.printStackTrace();
		}
		
		return value;
	}
	
	//TO Return Integer value
	public static double getInt(int row,int col,String fileName,String SheetName) {
		double value = 0;
		try {
			fis = new FileInputStream(location+fileName);
			System.out.println("<<<<<<< Excel FileFound >>>>>>>");
			try {
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet(SheetName);
				value = sheet.getRow(row).getCell(col).getNumericCellValue();
				System.out.println("====== Data Fetched and returned successfully =====");
			} 
			catch (IOException e) {
				System.out.println("====== Failed to Fetch Data from Sheet ======");
				e.printStackTrace();
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("<<<<<<< Exce File not Found , Please Check File location >>>>>>>");
			e.printStackTrace();
		}
		
		return value;
	}
	
	//TO Get total rows in the sheet.
	public static int getRowCount(String fileName,String SheetName) {
		int value = 0;
		
		try {
			fis = new FileInputStream(location+fileName);
			System.out.println("<<<<<<< Excel FileFound >>>>>>>");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(SheetName);
			value = sheet.getLastRowNum()+1;
		}
		catch(Exception e) {
			System.out.println("<<<<<<< Excel File Not Found , Please Check File location>>>>>>>");
		}
		return value;
	}
	
	//To Insert String in the sheet.
	public static void putString(int row,int col,String fileName,String SheetName,String message) {
		try {
			fis = new FileInputStream(location+fileName);
			System.out.println("<<<<<<< Excel FileFound >>>>>>>");
			try {
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet(SheetName);
				XSSFCell cell = sheet.getRow(row).createCell(col);
				cell.setCellValue(message);
				
				FileOutputStream fos = new FileOutputStream(location+fileName);
				wb.write(fos);
				System.out.println("<<<<<< Data Inserted in excel Successfully >>>>>>");
				fos.close();
				wb.close();
				
			}
			catch(Exception e) {
				System.out.println("<<<<<< Failed to Insert data in excel sheet , Please Check .. >>>>>>");
				
			}
		}
		catch(Exception e) {
			System.out.println("<<<<<<< Excel File Not Found , Please Check File location>>>>>>>");
		}
	}
	

}
