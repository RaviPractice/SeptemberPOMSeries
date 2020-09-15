package com.qa.hubspot.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utilities.Constants;
import com.qa.hubspot.utilities.ExcelUtil;

public class ContactsPageTest extends BaseTest{
	
	HomePage homepage;
	ContactsPage contactspage;
	
	@BeforeClass
	public void ContactsPageSetup() {
	homepage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	contactspage = homepage.gotoContactsPage();
	
	}
	
	@Test(priority=2)
	public void verifyContactPageTitleTest() {
		String title = contactspage.getContactPageTitle();
		System.out.println("contacts page title is :"+title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE,"ContactPage Title is not matched..");
		
		
	}
	
	@Test(priority=1)
	public void VerifyContactspageHeader() {
		String header =  contactspage.getContactPageHeader();
		System.out.println("contacts page header is :"+header);
		Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER,"ContactPage header is not correct..");
		
		
	}
	@DataProvider
	public Object[][] createContact() {
		Object[][] data = ExcelUtil.getTestData(Constants.SHEET_NAME);
		return data;
		
	}
	
	
	@Test(priority=3,dataProvider = "createContact")
	public void createContactTest(String email,String firstname,String lastname,String jobtitle) {
		contactspage.createContact(email,firstname,lastname,jobtitle);
	}


}
