package com.automationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;
import com.framework.page.TestPageFactory;

public class SearchBar extends BasePage implements TestPage {

	private Actions action;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement searchText;

	@FindBy(xpath = "//label[@for=\"Girls\"]")
	private WebElement selectCheckbox;

	public SearchBar(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		action = new Actions(driver);
	}

	public SearchBar enterSearchText(String searchByText) {
		searchText.sendKeys(searchByText);
		wait.until(ExpectedConditions.visibilityOf(searchText));
		searchText.sendKeys(Keys.ENTER);
		return this;
	}

	public SearchBar selectGender() {
		wait.until(ExpectedConditions.visibilityOf(selectCheckbox));
		selectCheckbox.click();
		return this;
	}

	public boolean isResultDisplayed(String expectedTitle) {

		String actualTitle = driver.getTitle();
		if (actualTitle.contains((expectedTitle))) {
			return true;
		}
		return false;
	}
}
