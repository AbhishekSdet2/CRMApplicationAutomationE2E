package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath = "//input[@name='title']")
	public WebElement Title;
	
	@FindBy(xpath = "//div[@role='listbox' and @aria-expanded='true']")
	public WebElement lstassignedTo;
	
	@FindBy(xpath = "//div[@name='products']//input")
	public WebElement products;
	
	@FindBy(xpath = "//div[@name='company']//input")
	public WebElement company;
	
	@FindBy(xpath = "//div[@name='contacts']//input")
	public WebElement contacts;
	
	@FindBy(xpath = "//div[@role='option' and @aria-checked='true']//span[text()='Abhi kumar']")
	public WebElement valueselectAssignedTo;
	
	//@FindBy(xpath = "")
	//public WebElement closeDate;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createDealPage() {
	   Title.sendKeys("Big Million Deal");
	   lstassignedTo.click();
	   
	}

}
