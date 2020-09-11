package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

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
		
	}
	//3.page actions - methods
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignupLink() {
		return driver.findElement(SignUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username,String pswd) {
		driver.findElement(Email).sendKeys(username);
		driver.findElement(Password).sendKeys(pswd);
		driver.findElement(LoginBtn).click();
		return new HomePage(driver);
		
	}
	
	

}
