package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
static WebDriver driver;
	
	public static void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		driver.get(url);
	}
	public static  WebElement locators(String locatorType, String value) {
		
		if(locatorType.equals("id")) {
			WebElement findElement = driver.findElement(By.id(value));
			return findElement;
		}
		else if(locatorType.equals("name")) {
			WebElement findElement = driver.findElement(By.name(value));
			return findElement;
		}
		else {
			WebElement findElement = driver.findElement(By.xpath(value));
			return findElement;
		}
	}
		
	
	public static void enterText(WebElement element, String text) {
		
		element.sendKeys(text);
			}
		
	public static void buttonClick(WebElement element) {
		element.click();
	}
		
	
	public static String gettingTitle() {
		String title = driver.getTitle();
		return title;
		
	}
	
	public static String gettingCurentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		
	}
	
	public static String gettingText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public static  String gettingAttribute(WebElement element,String attributename ) {
		String attribute = element.getAttribute(attributename);
		return attribute;
	}
	
	public static void selectionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectionByValue(WebElement element,String value ) {
		Select s = new Select(element);
		s.selectByValue(value);
		
	}
	//Base Class For Excel Read
	public static String excelRead(String path, String sheetName, int rowindex,
			int cellindex) throws IOException {
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowindex);
		Cell cell = row.getCell(cellindex);
		int cellType = cell.getCellType();
		if(cellType==1) {
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			String format = s.format(dateCellValue);
			return format;
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l =(long)numericCellValue;
			//to convert long into String
			String valueOf = String.valueOf(l);
			return valueOf;
		}
				
	}
	
	public void excelWrite(String path, String sheetName, int rowindex, 
			int cellindex, String value) throws IOException {
		
		File f = new File(path);
		FileOutputStream stream = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet(sheetName);
		Row createRow = createSheet.createRow(rowindex);
		Cell createCell = createRow.createCell(cellindex);
		createCell.setCellValue(value);	
		w.write(stream);
	}
	
	
	
	
	
}
