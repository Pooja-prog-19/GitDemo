package com.framework.test;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.framework.base.Loggers;

import com.framework.base.SystemConfigurations;
import com.framework.base.initializeDriver;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.exceptions.NoDataAvailableInFile;


public class BaseTest {

	protected static final String LOGINDETAILS_FILENAME = "src/test/resource/testData/LoginData.json";
	public WebDriver driver = null;

	@BeforeSuite
	public void init() throws IOException, NoDataAvailableInFile {
		

	}

	@BeforeMethod
	public void beforeClass() throws InstantiationException, IllegalAccessException, DriverNotInitializedException {
		driver = initializeDriver.createFor(SystemConfigurations.getBrowserType());
		driver.get(SystemConfigurations.getApplicationUrl());
		Loggers.configureLog();
	}

	@AfterMethod
	public void afterClass() {
		initializeDriver.quitDriver();
		Loggers.getInfoLog("Driver Closed....");
	}
 @AfterSuite
 public void afterSuite()
 {
	Loggers.getInfoLog("Suite execution completed....");
 }

}
