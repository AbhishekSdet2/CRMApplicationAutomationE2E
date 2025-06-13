package com.crm.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "(//span[text()='Contacts'])[2]")
    public WebElement Contacts;
	
	@FindBy(xpath = "//a[text()='Abhi kumar']//parent::td//preceding-sibling::td//input[@type='checkbox']")
    public WebElement contactPerson;
	
	@FindBy(xpath = "//div[text()='View']/parent::div")
    public WebElement viewDropdown;
	
	@FindBy(xpath = "//i[@class='refresh icon']")
    public WebElement refreshBtn;
	
	
	@FindBy(xpath = "//input[@name='first_name']")
	public WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@name='last_name']")
	public WebElement lastName;
	
	@FindBy(xpath = "//div[@name='company']//input")
	public WebElement companyName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	public WebElement emailid;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	public WebElement btnSave;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean ContactText() {
		boolean flag=false;
		if(Contacts.isDisplayed()) {
			flag=true;
		}
		return flag;
		
	}
	
	public void selectContactsByName(String name) throws InterruptedException {
		Thread.sleep(5000);
		refreshBtn.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	public void clickOnPlusIcon(String fname,String lname,String company,String email) throws InterruptedException {
		Thread.sleep(5000);
		txtFirstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(company);
		emailid.sendKeys(email);
		btnSave.click();
		Thread.sleep(5000);
	}

}
