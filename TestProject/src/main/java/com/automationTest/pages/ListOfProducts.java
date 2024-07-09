package com.automationTest.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class ListOfProducts extends BasePage implements TestPage {

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement searchTextInput;

	@FindAll(@FindBy(xpath = "//div[@class='preview']"))
	private List<WebElement> ListOfProducts;

	@FindAll(@FindBy(xpath = "//img[@class=\"rilrtl-lazy-img  rilrtl-lazy-img-loaded\"]"))
	private List<WebElement> listOfProducts;

	public ListOfProducts(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
	}

	public ListOfProducts searchProduct(String enterSearchText) {

		searchTextInput.sendKeys(enterSearchText);
		wait.until(ExpectedConditions.visibilityOf(searchTextInput));
		searchTextInput.sendKeys(Keys.ENTER);
		return this;
	}

	public List<String> getProductDetailsFromSearchProducts(int index) {
		List<String> productDetails = new ArrayList<>();
		WebElement brand = ListOfProducts.get(index).findElement(By.xpath("//div[@class='brand']"));
		productDetails.add(brand.getText());
		WebElement productType = ListOfProducts.get(index).findElement(By.xpath("//div[@class='nameCls']"));
		productDetails.add(productType.getText());
		return productDetails;
	}

	public ListOfProducts clickProduct() {

		WebElement products = listOfProducts.get(0);
		wait.until(ExpectedConditions.visibilityOf(products));
		products.click();

		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		return this;

	}

}
