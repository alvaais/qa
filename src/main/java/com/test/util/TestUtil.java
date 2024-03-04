package com.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import com.test.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long IMPLICIT_WAIT_TIME =2000;
	public static long PAGE_LOAD_TIMEOUT =90;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\aisha\\eclipse-workspace\\qa\\src\\main\\java\\com\\test\\testdata\\dummyTestData.xlsx";
	
	;
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
	/*	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
		public static void getTestData(String sheetName) throws IOException
		{
			
		        //Create an object of File class to open xlsx file
		        File file =    new File(TESTDATA_SHEET_PATH);
		        //Create an object of FileInputStream class to read excel file
		        FileInputStream inputStream = new FileInputStream(file);

		        //creating workbook instance that refers to .xls file
		        XSSFWorkbook wb=new XSSFWorkbook(inputStream);

		        //creating a Sheet object
		        XSSFSheet sheet=wb.getSheet("sheetName");
		        
		        //get all rows in the sheet
		        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		        
		        //iterate over all the row to print the data present in each cell.
		        for(int i=0;i<=rowCount;i++){
		            
		            //get cell count in a row
		            int cellcount=sheet.getRow(i).getLastCellNum();
		            
		            //iterate over each cell to print its value
		            System.out.println("Row"+ i+" data is :");
		            
		            for(int j=0;j<cellcount;j++){
		                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
		            }
		            System.out.println();
		        }
				
		    }
		
} */
	
