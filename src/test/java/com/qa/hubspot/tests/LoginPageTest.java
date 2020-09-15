package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.utilities.Constants;


//@Listeners(TestAllureListener.class)
@Listeners(TestAllureListener.class)

public class LoginPageTest extends BaseTest {
	
	
	
	
	@Test(priority=2)
	public void loginPageTitleTest() {
		String title = loginpage.verifyLoginPageTitle();
		System.out.println("login page title is :"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"Login page title is not matched..");
		
		
	}
	
	@Test(priority=1)
	public void signuplinkTest() {
		boolean flag = loginpage.verifySignupLink();
		Assert.assertTrue(flag,"signup link is not present..");
	}
	
	@Test(priority=3)
	public void loginpageTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
		
		
		
		
	}


