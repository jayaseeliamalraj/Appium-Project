package com.wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.management.relation.Role;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	
	public static com.wrapper.LaunchApp cL=new com.wrapper.LaunchApp();
	public static com.wrapper.KeyEvents event=new com.wrapper.KeyEvents();
	
	int i =0;
	
	String File ="MobileData.Properties";
	FileInputStream file;
	
	String inputValue = "";
	public String arrayValue[]={"Username","Password","ProductName","CVVNumber"};
	public static HashMap<String, String> testData=new HashMap<String,String>();

	public void ExcelRead() {
	try{
	file = new FileInputStream(File);
	Properties	prop = new Properties();
	prop.load(file);
	String FilePath=prop.getProperty("excelPath");
	
	FileInputStream fs = new FileInputStream(new File(FilePath));
	XSSFWorkbook wb = new XSSFWorkbook(fs);
	XSSFSheet sh =wb.getSheet("Batch");
	
	Iterator<Row> rowIterator= sh.rowIterator();
	
	while(rowIterator.hasNext())
	{
		Row row = rowIterator.next();
		 
		Iterator<Cell> cellIterator = row.cellIterator();
		
		Cell cell = cellIterator.next();
		
		if(row.getCell(1).getStringCellValue().equalsIgnoreCase("Y"))
		{
			i = cell.getRowIndex();
			System.out.println(i);
			
			XSSFSheet sh1 = wb.getSheet("TestData");
			Iterator<Row> rowIterator1 = sh1.rowIterator();
			
			
			while(rowIterator1.hasNext())
			{
				Row row1 = rowIterator1.next();
				
				Iterator<Cell> cellIterator1 = row1.cellIterator();
				
				Cell cell1 = cellIterator1.next();
				
				if(row.getCell(0).getStringCellValue().equalsIgnoreCase(row1.getCell(0).getStringCellValue()))
				{
	                  System.out.println("read second: "+row1.getCell(0).getStringCellValue());
	                  while(cellIterator1.hasNext()){
							for (String columnName : arrayValue) {
								inputValue=cellIterator1.next().getStringCellValue();
								System.out.println("ColumnName: "+columnName+" Input Value: " +inputValue);
								testData.put(columnName, inputValue);
								}
							}             
				}
				
			}
			cL.launchApp();
			for(int i=2;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().equalsIgnoreCase("END")){
					System.out.println("Batch Sheet: "+row.getCell(i).getStringCellValue());
					break;
				}else{
					System.out.println("Batch Sheet: "+row.getCell(i).getStringCellValue());
					event.event(row.getCell(i).getStringCellValue());
					
				}
			}
			
		}
	}
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
