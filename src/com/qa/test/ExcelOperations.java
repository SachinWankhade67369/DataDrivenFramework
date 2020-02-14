package com.qa.test;

import com.qa.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
	
		//Whenever we perform 
		//get TestData from excel.
				Xls_Reader reader = new Xls_Reader("D:\\Test WorkSpace\\DateDrivenFrameworkUsingExcelSheet\\src\\com\\qa\\testdata\\YahooUserAccountDetails.xlsx");
				
				
				if(!reader.isSheetExist("HomePageTestData")) {
					
					reader.addSheet("HomePageTestData");
					System.out.println("HomePageTestData sheet is created.");
				}
		
				//reader.addHyperLink(sheetName, screenShotColName, testCaseName, index, url, message);
				
				
				int rowCount=reader.getRowCount("RegAccountTestData");
				System.out.println("No of rows count present in RegAccountTestData >>"+rowCount);
				
				int colCount=reader.getColumnCount("RegAccountTestData");
				System.out.println("Total column count presents in RegAccountTestData >>"+colCount);
				
				System.out.println("Row number of Sachin >>"+reader.getCellRowNum("RegAccountTestData", "Firstname", "Sachin"));
	}

}
