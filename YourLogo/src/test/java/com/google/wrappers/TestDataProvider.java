package com.google.wrappers;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataProvider {
	public String[][] getData() throws IOException {
		String[][] resultData;
		FileInputStream fis = new FileInputStream("./TestData/GoogleSearch_TestData.xlsx");
		XSSFWorkbook virWB = new XSSFWorkbook(fis);
		XSSFSheet virWS = virWB.getSheetAt(0);
	
		int RowCnt = virWS.getLastRowNum();
		int ColCnt = virWS.getRow(0).getLastCellNum();
		
		resultData = new String[RowCnt][ColCnt];
		
		for (int i = 1; i<=RowCnt; i++) {
			XSSFRow virRow = virWS.getRow(i);
			for (int j = 0; j<ColCnt;j++) {
				resultData[i-1][j] = virRow.getCell(j).getStringCellValue();
			}
		}
		virWB.close();
		return resultData;
	}
}
