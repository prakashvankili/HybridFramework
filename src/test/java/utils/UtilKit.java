package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	public static FileInputStream fis ;
	
	public static HashMap<String, String> getTestDataFromExcel(String testcase){
		
		try {
			 fis = new FileInputStream("src\\test\\resources\\testdata\\excels\\Adactin Master Test Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook	wb = null;
		try {
				wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	XSSFSheet sheet=	wb.getSheet("com.adactin");
	ArrayList<Row> testcaserows =  getTestcaseRows(sheet,testcase);
	
	HashMap<String, String>  testdata =new HashMap<String, String>();
	for(int i=0;i<testcaserows.size();i++) 
	{
	int	cellcount =testcaserows.get(i).getLastCellNum();
	  for(int j=1;j<cellcount;j++) {
		 
		  testdata.put(testcaserows.get(0).getCell(j).getStringCellValue(), testcaserows.get(1).getCell(j).getStringCellValue());
		  
	}
		
	}
		return testdata;
		
	}

	private static 	ArrayList<Row> getTestcaseRows(XSSFSheet sheet, String testcase) {
		// TODO Auto-generated method stub
		
		ArrayList<Row>  allrows =	new ArrayList<Row>();
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			Row row =sheet.getRow(i);
			if(row!=null) {
				allrows.add(sheet.getRow(i));
				
			}}
		
			ArrayList<Row>  limitedrows =	new ArrayList<Row>();
			for(int i=0;i<allrows.size();i++) {
			String cellvalue =	allrows.get(i).getCell(0).getStringCellValue();
				if(cellvalue.equalsIgnoreCase(testcase))
				{
					limitedrows.add(allrows.get(i));
				}
			
		}
			System.out.println(limitedrows);
			return limitedrows;
	}
	

}
