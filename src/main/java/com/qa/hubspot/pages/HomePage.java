package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	//1.ObjectRepo (OR) - By
	
		By Header = By.cssSelector("h1.dashboard-selector__title");
		By userAccount = By.cssSelector("span.account-name ");
		

		//2.create constructor of the class
		public HomePage(WebDriver driver) {
			this.driver = driver;
			
		}
		
		//3.page actions - methods
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public String verifyHomepageheader() {
			if(driver.findElement(Header).isDisplayed()) {
				return driver.findElement(Header).getText();
			}
			return null;
		}
		
		public String verifyLoggedUser() {
			if(driver.findElement(userAccount).isDisplayed()) {
				return driver.findElement(userAccount).getText();
			}
			return null;
		}
		

}
