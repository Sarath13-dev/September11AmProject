package org.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends BaseClass{

	public static void main(String[] args) throws IOException {
		
		browserLaunch("https://www.facebook.com/");
		FacebookLoginPage a = new FacebookLoginPage();
		WebElement username = a.getUsername();
		username.sendKeys("ramsss");
		WebElement password = a.getPassword();
		password.sendKeys("1234");
	}
	
	
	
	
}
