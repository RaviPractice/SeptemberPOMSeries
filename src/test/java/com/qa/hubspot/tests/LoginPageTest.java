package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utilities.Constants;

public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		
		loginpage = new LoginPage(driver);
		
		
	}
		
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
		
		
	@AfterTest
	public void tearDown() {
		driver.quit();

			
		}
		
		
	}


