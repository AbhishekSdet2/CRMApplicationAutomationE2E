package com.crm.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[text()='Abhi kumar']")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@href='/home']")
	WebElement homeIcon;

	@FindBy(xpath = "//a[@href='/calendar']")
	WebElement calender;

	@FindBy(xpath = "//a[@href='/companies']")
	WebElement companies;

	@FindBy(xpath = "//a[@href='/contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//a[@href='/deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[@href='/contacts']/following-sibling::button[@class='ui mini basic icon button']")
	public WebElement plusIcon;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactLink() throws InterruptedException {
		contactsLink.click();
		Thread.sleep(5000);
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public String validateUsername() {
		String userNamevalue = userNameLabel.getText();
		return userNamevalue;
	}
	
	public void clickOnNewContact() {
		Actions actions=new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		plusIcon.click();
		
	}

}
