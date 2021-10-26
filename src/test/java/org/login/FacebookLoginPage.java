package org.login;

import org.dataread.Testing;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage extends BaseClass{
	
	
	public FacebookLoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	@FindBys({@FindBy(id="email"), @FindBy(xpath="//input[@type='text']")})
	private WebElement username;
	
	public WebElement getPassword() {
		return password;
	}
	@FindAll({@FindBy(id="pass"),@FindBy(name="pas")})
	private WebElement password;
	
	
	public WebElement getUsername() {
		return username;
	}

	
	
	
	
	
	
	
	
}
