package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utilities.Constants;
import com.qa.hubspot.utilities.ElementUtil;

public class ContactsPage extends BasePage {
	
	private WebDriver driver;
	
	// OR - By locator
	
	By CreateContactPrimary = By.xpath("//span[text()='Create contact']");
	By ContactHeader = By.xpath("//span[text()='Contacts']");
	By Email = By.xpath("//input[@data-field='email']");
	By FirstName = By.xpath("//input[@data-field='firstname']");
	By Lastname = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By CreateContactSecondary = By.xpath("(//span[text()='Create contact'])[2]");
	
	By BackToContacts = By.xpath("(//*[text()='Contacts'])[2]");
	
	//Contacts page - constructor
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
		
	}
	
	// pageactions - methods
	
	public String getContactPageTitle() {
		return elementutil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
		
	}
	
	public String getContactPageHeader() {
		if(elementutil.doIsDisplayed(ContactHeader)) {
			return elementutil.doGetText(ContactHeader);
		}
		return null;
		
	}
	
	public void createContact(String email,String firstname,String lastname,String jobtitle) {
		
		elementutil.waitForElementToBeVisible(CreateContactPrimary, 10);
		elementutil.doClick(CreateContactPrimary);
		
		elementutil.waitForElementToBeVisible(this.Email, 5);
		elementutil.doSendKeys(this.Email,email);
		elementutil.doSendKeys(this.FirstName,firstname);
		elementutil.doSendKeys(this.Lastname,lastname);
		
		elementutil.waitForElementToBeVisible(this.jobTitle, 5);
		elementutil.doSendKeys(this.jobTitle,jobtitle);
		
		elementutil.waitForElementToBeVisible(this.CreateContactSecondary, 10);
		elementutil.doClick(this.CreateContactSecondary);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementutil.waitForElementToBeClickable(this.BackToContacts, 5);
		elementutil.doClick(BackToContacts);
		
		
		//elementutil.waitForElementToBeVisible(this.BackToContacts, 10);
		//elementutil.doClick(this.BackToContacts);
		
		
		
		

	}
	
	
	
	
	

}
