package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaUtils {

	private static String ExcelPath;
	private static String sheetName;
	private static String TCName;
	private static int rowNo;
	private static FileInputStream fis;
	static Properties properties = new Properties();

	JavaUtils() {
		try {
			properties.load(new FileInputStream(".resources/YourLogo.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getRowNo() {
		int rowNo = 0;
		try {
			XSSFWorkbook book = new XSSFWorkbook(FilesAccess());
			XSSFSheet sheet = book.getSheet(getSheetName());
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(getTCName())) {
					return i;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowNo;
	}

	@SuppressWarnings("resource")
	public static String getVal(String ColumnName) {
		XSSFWorkbook book;
		XSSFSheet sheet;
		Row row;
		Cell cell;
		String  val;
		try {
			book = new XSSFWorkbook(FilesAccess());
			sheet = book.getSheet(getSheetName());
			row = sheet.getRow(getRowNo());

			for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				if(sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
					val = row.getCell(i).getStringCellValue();
					return val;
				}
				
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static FileInputStream FilesAccess() {
		File file = new File(getExcelPath());
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return fis;
	}

	public static String getExcelPath() {
		ExcelPath = properties.getProperty("excelpath");
		return ExcelPath;
	}

	public static String getSheetName() {
		sheetName = properties.getProperty("excelsheetname");
		return sheetName;
	}

	public static String getTCName() {
		return TCName;
	}

	public static void setTCName(String tCName) {
		TCName = tCName;
	}

	/*public void setExcelData(String TCName) {
		setTCName(TCName);
		XSSFWorkbook book;
		XSSFSheet sheet;
		Row row;
		Cell cell;
		try {
			book = new XSSFWorkbook(FilesAccess());
			sheet = book.getSheet(getSheetName());
			row = sheet.getRow(getRowNo());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
