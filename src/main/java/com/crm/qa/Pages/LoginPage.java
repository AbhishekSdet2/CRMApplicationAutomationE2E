package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@name='email']")
	WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
	WebElement passWord;
    @FindBy(xpath = "//div[text()='Login']")
    WebElement login;
	
    //Page Object Initialization
    public LoginPage() {
    	PageFactory.initElements(driver, this);
	}
    
    public String validatePageTitle() {
    	return driver.getTitle();
    }
    
    public HomePage login(String username,String password) {
    	userName.sendKeys(username);
    	passWord.sendKeys(password);
    	login.click();
    	return new HomePage();
    }
    
    
    
    
}
