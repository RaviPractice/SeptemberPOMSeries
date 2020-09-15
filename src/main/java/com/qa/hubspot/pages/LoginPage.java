package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utilities.Constants;
import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.JavaScriptUtil;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	//1.ObjectRepo (OR) - By
	
	By Email = By.id("username");
	By Password = By.id("password");
	By LoginBtn = By.id("loginBtn");
	By SignUpLink = By.linkText("Sign up");
	
	
	//2.create constructor of the class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
		jsUtil = new JavaScriptUtil(this.driver);

	}
	//3.page actions - methods
	
	public String verifyLoginPageTitle() {
		return elementutil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean verifySignupLink() {
		return elementutil.doIsDisplayed(SignUpLink);
		
	}
	
	public HomePage doLogin(String username,String pswd) {
		
		elementutil.waitForElementToBeVisible(this.Email, 10);
		elementutil.doSendKeys(this.Email, username);
		elementutil.doSendKeys(this.Password, pswd);
		
		elementutil.waitForElementToBeVisible(this.LoginBtn, 10);
		elementutil.doClick(this.LoginBtn);

		
		return new HomePage(driver);
		
	}
	
	

}
