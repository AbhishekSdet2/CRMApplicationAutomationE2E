package com.crm.qa.testCases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crm.qa.Pages.ContactsPage;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {
    HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	String sheetName="contacts";
	static ExtentReports report;
	static ExtentTest test;
	
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(properties.getProperty("username"),
				properties.getProperty("password"));
	}
	
	
	
	public void clickOnContactPage() throws InterruptedException {
		Thread.sleep(8000);
		homePage.clickOnContactLink();
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void validateContactsLabel() throws InterruptedException {
		homePage.clickOnContactLink();
		boolean flag=false;
		Thread.sleep(8000);
		flag=contactsPage.ContactText();
		Assert.assertEquals(flag, true);
	}
	
	@Test(dataProvider ="getTestData")
	public void enterDetailsContactForm(String firstname,String lastname,String company,String email) throws InterruptedException {
		homePage.clickOnNewContact();
		contactsPage.clickOnPlusIcon(firstname,lastname,company,email);
		homePage.clickOnContactLink();
	}
	
	@DataProvider
	public Object[][] getTestData() {
	Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
