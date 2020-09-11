package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utilities.Constants;

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void verifyHomepageTitleTest() {
		String title = homepage.verifyHomePageTitle();
		System.out.println("home page title is :"+title);
		Assert.assertEquals(title,  Constants.HOME_PAGE_TITLE,"Homepage title is not matched..");	
		
	}
	
	@Test(priority=1)
	public void verifyHomepageHeaderTest() {
		String headertext = homepage.verifyHomepageheader();
		System.out.println("homepage header text is :"+headertext);
		Assert.assertEquals(headertext, Constants.HOME_PAGE_HEADER,"Homepage header is not displayed..");
	}
	
	@Test(priority=3,enabled=false)
	public void verifyLoggedInUserTest() {
		String usertext = homepage.verifyLoggedUser();
		System.out.println("Logged in User text is :"+usertext);
		Assert.assertEquals(usertext, Constants.LOGGEDIN_USER,"Logged in user is not matched..");
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();

			
		}

}
