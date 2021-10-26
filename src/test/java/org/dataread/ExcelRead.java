package org.dataread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		
		File f = new File("D:\\GREENS\\morning30.xlsx");
		
		FileInputStream stream = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(stream);
		
		Sheet sheet = w.getSheet("Test");
		
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		
		for (int i = 0; i < physicalNumberOfRows; i++) {
			
			Row row = sheet.getRow(i);
			
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			
			for (int j = 0; j <physicalNumberOfCells; j++) {
				
				Cell cell = row.getCell(j);
				
				int cellType = cell.getCellType();
				
				if(cellType==1) {
					
					String stringCellValue = cell.getStringCellValue();
					
					System.out.println(stringCellValue);
				}
				
				else if(DateUtil.isCellDateFormatted(cell)) {
					
					Date dateCellValue = cell.getDateCellValue();
					
					System.out.println(dateCellValue);
					
					
					//to change the date format
					SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
					
					String format = s.format(dateCellValue);
					
					System.out.println(format);
					
				}
				
				else {
					
					double numericCellValue = cell.getNumericCellValue();
					
					//type casting
					long l = (long)numericCellValue;
					
					System.out.println(l);
					
					
				}
				
				
				
			}
		}
		
		
	}
	
}
