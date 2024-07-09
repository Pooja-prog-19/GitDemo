package com.framework.base;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.framework.exceptions.DriverNotInitializedException;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class initializeDriver {

	public static Logger Log = Logger.getLogger(initializeDriver.class);
	private static WebDriver driver;
	
	private initializeDriver() {
		
	}
	public static WebDriver createFor(String browser) {

		if (driver == null) {
			switch (browser) {
			case "FireFox":
				
				driver = new FirefoxDriver();
				// Log.info("New Firefox driver instantiated....");
				Loggers.getInfoLog("New Firefox driver instantiated....");
				break;

			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
				// Log.info("New Chrome driver instantiated....");
				Loggers.getInfoLog("New Chrome driver instantiated....");
				break;
			case "IE":
				//WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				// Log.info("New IE driver instantiated....");
				Loggers.getInfoLog("New IE driver instantiated....");
				break;
			default:
				throw new IllegalArgumentException(
						String.format("%s browser is not valid please provide valid browserName", browser));
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Browser Screen maximized....");
		//driver.get(url);
		return driver;
	}
	
	public static WebDriver getDriver() throws DriverNotInitializedException {
		if (driver != null) {
			return driver;
		} else {
			throw new DriverNotInitializedException("WebDriver not initialized");
		}
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			resetDriver();
			Log.info("Driver shut down..Browser closed...");
		}
	}
	public static void resetDriver(){
		driver=null;
	}
}
