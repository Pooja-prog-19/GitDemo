package com.automationTest.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class SortByOnListOfProduct extends BasePage implements TestPage {

	public SortByOnListOfProduct(WebDriver driver) throws DriverNotInitializedException {
		super(driver);

	}

	@FindBy(xpath = "//div[@class=\"filter-dropdown\"]/select")
	private WebElement actualText;

	public List<Integer> listOfDiscounts() {

		List<Integer> discount = new ArrayList<Integer>();

		List<WebElement> listOfDiscounts = driver.findElements(By.xpath("//*[@class='discount']"));

		System.out.println(listOfDiscounts.get(0).getText());

		for (WebElement elementDiscount : listOfDiscounts) {

			String disCountText = elementDiscount.getText().replaceAll("\\s", "").replaceAll("\\D", "");
			discount.add(Integer.parseInt(disCountText));

		}

		System.out.println(discount);
		return discount;

	}

	public SortByOnListOfProduct selectSortBy(String textOfSortByOption) throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath("//div[@class=\"filter-dropdown\"]/select")));
		List<WebElement> list = select.getOptions();

		for (WebElement options : list)
			System.out.println(options.getText());
		select.selectByVisibleText(textOfSortByOption);
		Thread.sleep(5000);

		return this;

	}

	public boolean isSelectedDropdownValueDisplayed(String expectedDropdownText) {
		wait.until(ExpectedConditions.visibilityOf(actualText));

		String actualDropdownText = actualText.getText();

		if (actualDropdownText.contains(expectedDropdownText)) {
			System.out.println("ACTUAL  " + actualDropdownText + "EXPECTED  " + expectedDropdownText);

			return true;
		}

		return false;

	}

}
