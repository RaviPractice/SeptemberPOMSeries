package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utilities.Constants;
import com.qa.hubspot.utilities.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	//1.ObjectRepo (OR) - By
	
		By Header = By.cssSelector("h1.dashboard-selector__title");
		By userAccount = By.cssSelector("span.account-name ");
		
		By ContactPrimary = By.id("nav-primary-contacts-branch");
		By ContactSecondary = By.id("nav-secondary-contacts");
		
		

		//2.create constructor of the class
		public HomePage(WebDriver driver) {
			this.driver = driver;
			elementutil = new ElementUtil(this.driver);
			
		}
		
		//3.page actions - methods
		
		public String verifyHomePageTitle() {
		 return elementutil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
			
		}
		
		public String verifyHomepageheader() {
			if(elementutil.doIsDisplayed(Header)) {
			return elementutil.doGetText(Header);
			}
			return null;
		}
		
		public String verifyLoggedUser() {
			if(elementutil.doIsDisplayed(userAccount)) {
				return elementutil.doGetText(userAccount);
				}
			
			return null;
		}
		
		public ContactsPage gotoContactsPage() {
			elementutil.waitForElementToBeVisible(this.ContactPrimary, 10);
			elementutil.doClick(ContactPrimary);
			
			elementutil.waitForElementToBeVisible(this.ContactSecondary,10);
			elementutil.doClick(ContactSecondary);
			
			
			return new ContactsPage(driver);
			
			
		}
		

}
