package com.automationTest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;
import com.framework.page.TestPageFactory;

public class FilterPage extends BasePage implements TestPage {

	private Actions action;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement searchTextInput;

	@FindAll(@FindBy(xpath = "//div[@class=\"fnl-plp-filtervisible\"]/div[@class=\"fnl-plp-afliter\"]"))
	private List<WebElement> filterTags;

	@FindAll(@FindBy(xpath = "//a[@class=\"rilrtl-products-list__link\"]//div[@class=\"brand\"]"))
	private List<WebElement> listOfBrands;

	public FilterPage(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		action = new Actions(driver);
	}

	public FilterPage EnterSearchText(String searchbyText) {

		searchTextInput.sendKeys(searchbyText);
		wait.until(ExpectedConditions.visibilityOf(searchTextInput));
		searchTextInput.sendKeys(Keys.ENTER);
		return this;

	}

	public FilterPage selectGender(String gender) {
		WebElement selectGenderCheckbox = driver.findElement(By.xpath("//label[@for='" + gender + "']"));
		wait.until(ExpectedConditions.visibilityOf(selectGenderCheckbox));
		selectGenderCheckbox.click();
		return this;
	}

	public FilterPage selectBrand(String brand) {
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement selectBrandCheckbox = driver
				.findElement(By.xpath("//div[@class='cat-facets ']//span[text()='" + brand + "']"));
		actions.moveToElement(selectBrandCheckbox);
		actions.perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOf(selectBrandCheckbox));
		selectBrandCheckbox.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;

	}

	public FilterPage selectBrandOption(String brandOption) {
		WebElement selectBrandName = driver.findElement(By.xpath("//label[@for='" + brandOption + "']"));
		wait.until(ExpectedConditions.visibilityOf(selectBrandName));
		selectBrandName.click();
		return this;

	}

	public boolean isFilterDisplayed(String firstExpectedText) {
		for (WebElement webElement : filterTags) {
			String actualText = webElement.getText();
			if (actualText.equals(firstExpectedText)) {
				return true;
			}
		}
		return false;
	}

	public boolean isBrandNameSameForAllProduct(String brandName) {
		for (WebElement brands : listOfBrands) {
			if (!brands.getText().contains(brandName)) {
				return false;
			}
		}
		return true;

	}

}
