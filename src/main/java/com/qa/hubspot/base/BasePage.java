package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.JavaScriptUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	public Properties prop;
	public ElementUtil elementutil;
	public JavaScriptUtil jsUtil;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
	/**
	 * this method is used to initilize webdriver with related browser
	 * @param browserName
	 * @return
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		}
		else {
			System.out.println("please eneter valid browser name :"+browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
		
		
	}
	
	/**
	 * this method is used to read the properties from config.properties file
	 * @return
	 */
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream(".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(fip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	/**
	 * this method is used to take the screeshot
	 */
	
	public String getScreenshot() {
	File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir")+ "/screenshot/" + System.currentTimeMillis() + ".png";
	File destination = new File(path);
	try {
		FileUtils.copyFile(src, destination);
		//FileHandler.copy(src, destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return path;
		
	}

	

}
