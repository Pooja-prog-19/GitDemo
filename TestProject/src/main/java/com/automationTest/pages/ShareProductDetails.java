package com.automationTest.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class ShareProductDetails extends BasePage implements TestPage {

	private Actions action;

	public ShareProductDetails(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		action = new Actions(driver);

	}

	@FindBy(xpath = "//div[@class=\"sprite-img prod-share-block\"]")
	private WebElement menuElement;

	public ShareProductDetails clickShareIcon() {
		wait.until(ExpectedConditions.visibilityOf(menuElement));
		action.moveToElement(menuElement).perform();
		return this;
	}

	public ShareProductDetails selectShareOption(String shareOptionTitle) {

		WebElement selectshareOption = driver
				.findElement(By.xpath("//div[@class=\"prod-share-tooltip\"]/a[@title='" + shareOptionTitle + "']"));
		wait.until(ExpectedConditions.visibilityOf(selectshareOption));
		action.click(selectshareOption);
		action.build().perform();
		return this;
	}

	public boolean isShareOptionDisplayed(String expectedTitleforShareOption) {
		String currentWindow = driver.getWindowHandle(); // getwindowhandle takes unique address of window(for one)
		Set<String> windows = driver.getWindowHandles(); // getwindowhandles takes multi address of windows
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(expectedTitleforShareOption)) {
				break;
			}

		}
		String actualTitle = driver.getTitle();
		System.out.println("ACTUALTITLE" + actualTitle);
		if (actualTitle.contains(expectedTitleforShareOption)) {
			return true;
		}
		return false;

	}
}
