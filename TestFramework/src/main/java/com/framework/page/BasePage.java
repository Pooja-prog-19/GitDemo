package com.framework.page;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.SystemConfigurations;
import com.framework.base.initializeDriver;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.TestPage;

public class BasePage implements TestPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public BasePage(WebDriver driver) throws DriverNotInitializedException {
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		wait = new WebDriverWait(driver, 10);

	}
	
	

}
