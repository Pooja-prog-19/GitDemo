package com.automationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class BreadCrumbNavigation extends BasePage implements TestPage {

	public BreadCrumbNavigation(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
	}

	public BreadCrumbNavigation clickOnHomeBreadcrumbNavigation(String homeLink) {

		WebElement clickHomeLink = driver
				.findElement(By.xpath("//div[@class=\"  breadcrumb-section\"]/ul/li/a[text() ='" + homeLink + "']"));
		clickHomeLink.click();
		return this;

	}

	public boolean isBreadCrumbNavigationDisplayed(String expectedTitleforBreadcrumbNavigation) {

		String actualTitle = driver.getTitle();
		if (actualTitle.contains((expectedTitleforBreadcrumbNavigation))) {
			return true;
		}
		return false;
	}

}
