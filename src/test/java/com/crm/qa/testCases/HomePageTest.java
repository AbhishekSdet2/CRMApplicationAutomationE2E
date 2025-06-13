package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.base.TestBase;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;
	public HomePageTest() {
		super();
		
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homepage=loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
			
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
	String title=homepage.verifyHomePageTitle();
	Assert.assertEquals(title, "Cogmento CRM","Home page title is not matching");
	}
	
	@Test(priority = 2)
	public void verifyUserName() {
		String name=homepage.validateUsername();
		Assert.assertEquals(name, "Abhi kumar");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

