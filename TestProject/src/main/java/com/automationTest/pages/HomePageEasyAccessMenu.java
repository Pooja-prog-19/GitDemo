package com.automationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class HomePageEasyAccessMenu extends BasePage implements TestPage {

	public HomePageEasyAccessMenu(WebDriver driver) throws DriverNotInitializedException {
		super(driver);

	}

	@FindBy(xpath = "//div[@class=\"ic-floating\"]")
	private WebElement clickOnHomeOptionButton;

	@FindBy(xpath = "//div[@class=\"gotop ic-toparw\"]")
	private WebElement scrollUp;

	public HomePageEasyAccessMenu clickOnHomePageOptionIcon(String optionName) {

		clickOnHomeOptionButton.click();
		WebElement clickonOption = driver.findElement(
				By.xpath("//div[@class=\"btn-img-container\"]//a[@data-ga-event-label='" + optionName + "']"));
		wait.until(ExpectedConditions.visibilityOf(clickonOption));
		clickonOption.click();
		return this;

	}

	public boolean isSectedSectionPagePresent(String expectedPage) {

		String actualTitle = driver.getTitle();
		if (actualTitle.contains((expectedPage))) {
			System.out.println("Actual title is = " + actualTitle);
			System.out.println("expected title is=" + expectedPage);
			return true;
		}
		return false;
	}

	public HomePageEasyAccessMenu clickOnUpArrow() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		scrollUp.click();

		return this;
	}

	public boolean isScrollupArrowDisplayed() {

		Assert.assertEquals(true, scrollUp.isDisplayed());
		System.out.println("assert passed");
		return false;

	}
}
