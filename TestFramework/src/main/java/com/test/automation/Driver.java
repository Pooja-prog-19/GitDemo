package com.test.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver createFor(String browser) {
		WebDriver driver = null;

		if (driver == null) {
				switch (browser) {
				case "FireFox":	
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;

				case "Chrome":		
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "IE":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;				
				default:
					throw new IllegalArgumentException(String.format("%s browser is not valid please provide valid browserName", browser));
				}

			}
		driver.manage().window().maximize();
		return driver;
	}

}
