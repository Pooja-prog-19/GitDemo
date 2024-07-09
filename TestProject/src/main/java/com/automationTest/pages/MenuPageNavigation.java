package com.automationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class MenuPageNavigation extends BasePage implements TestPage {

	private Actions action;

	public MenuPageNavigation(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		action = new Actions(driver);
	}

	public MenuPageNavigation clickMainMenu(String mainMenuName) {
		WebElement menuElement = driver
				.findElement(By.xpath("//ul[@class='level-first false']/li/a[text()='" + mainMenuName + "']"));
		wait.until(ExpectedConditions.visibilityOf(menuElement));
		action.moveToElement(menuElement).perform();
		return this;
	}

	public MenuPageNavigation clickSubMenu(String subMenuName) {
		WebElement subMenuElement = driver.findElement(By.xpath("//a[text()='" + subMenuName + "']"));
		wait.until(ExpectedConditions.visibilityOf(subMenuElement));
		action.click(subMenuElement);
		action.build().perform();
		return this;
	}

	public boolean isResultDisplayedForSelectedMenu(String expectedTitle) {

		String actualTitle = driver.getTitle();
		if (actualTitle.contains(expectedTitle)) {
			return true;
		}
		return false;

	}

}
