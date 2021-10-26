package org.dataread;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebElement;

public class Testing1 extends Testing {

	public static void main(String[] args) throws IOException {
		
		Testing1 a = new Testing1();
		a.browserLaunch("https://adactinhotelapp.com/");
		WebElement txtUsername = a.locators("id", "username");
		String username = a.excelRead("D:\\GREENS\\TRAINNING\\Practice2.xlsx", "abcd", 0, 0);
		a.enterText(txtUsername, username);
		WebElement txtPassword = a.locators("id", "password");
		String password = a.excelRead("D:\\GREENS\\TRAINNING\\Practice2.xlsx", "abcd", 0, 1);
		a.enterText(txtPassword, password);
		WebElement btnLogin = a.locators("id", "login");
		a.buttonClick(btnLogin);
		WebElement location = a.locators("id", "location");
		String index = a.excelRead("D:\\GREENS\\TRAINNING\\Practice2.xlsx", "abcd", 0, 2);
		int parseInt = Integer.parseInt(index);
		a.selectionByIndex(location, parseInt);
		
	}
	
	
	
	
}