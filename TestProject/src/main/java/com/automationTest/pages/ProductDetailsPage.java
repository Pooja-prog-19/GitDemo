package com.automationTest.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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
import org.testng.asserts.SoftAssert;

import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;
import com.framework.page.TestPageFactory;

public class ProductDetailsPage extends BasePage implements TestPage {

	public ProductDetailsPage(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private Actions action;

	@FindBy(xpath = "//h2[@class=\"brand-name\"]")
	private WebElement productDetailsBrandNameverify;

	@FindBy(xpath = "//h1[@class=\"prod-name\"]")
	private WebElement productDetailsProductNameverify;

	@FindBy(xpath = "//div[@class=\"btn-gold\"]")
	private WebElement addtocart;

	@FindBy(xpath = "//div[@class=\"btn-cart \"]")
	private WebElement gotocart;

	@FindBy(xpath = "//div[@class=\"product-name\"]")
	private WebElement cartProductName;

	@FindBy(xpath = "//span[@class=\"ic-chevrondown\"]")
	private WebElement quantity;

	@FindBy(xpath = "//button[@class=\"increment button\"]")
	private WebElement incrementQuantity;

	@FindBy(xpath = "//button[@class=\"full-width-button\"]")
	private WebElement updateQuantitybutton;

	@FindBy(id = "FREESHIP")
	private WebElement selectCouponCode;

	@FindBy(xpath = "//button[@class=\"rilrtl-button button apply-button \"]")
	private WebElement clickOnApplyButton;

	@FindBy(xpath = "//div[@class=\"product-card navigation-product-card apply-coupon applied-product-card\"]")
	private WebElement actualText;

	@FindBy(xpath = "//button[@class=\"rilrtl-button button shipping-button\"]")
	private WebElement proceedToShipping;

	@FindBy(xpath = "//div[@class=\" empty-cart\"]/p[@class=\"empty-msg\"]")
	private WebElement actualTextAfterProductDeleted;

	@FindBy(xpath = "//p[@class=\"prod-color\"]")
	private WebElement actualColorText;

	@FindBy(xpath = "//div[@class=\"card-delete-button\"]//div[@class=\"delete-btn\"]")
	private WebElement deleteButtonOfPopup;

	@FindBy(xpath = "//span[@class=\"msg-content\"]")
	private WebElement actualSelectSizeText;

	@FindBy(xpath = "//div[@class=\"delete-btn\"]")
	private WebElement deleteButton;

	public ProductDetailsPage isProductDetailsDisplayed(String expectedBrandName, String expectedProductName) {
		SoftAssert softAssert = new SoftAssert();

		System.out.println(productDetailsBrandNameverify.getText());
		System.out.println(productDetailsProductNameverify.getText());

		softAssert.assertEquals(productDetailsBrandNameverify.getText().toLowerCase(), expectedBrandName.toLowerCase());
		softAssert.assertEquals(productDetailsProductNameverify.getText(), expectedProductName);
		softAssert.assertAll();

		return this;
	}

	public ProductDetailsPage selectColorOfTheProduct(String color) {
		WebElement produtColor = driver.findElement(By.xpath("//img[@title='" + color + "']"));
		wait.until(ExpectedConditions.visibilityOf(produtColor));
		produtColor.click();
		return this;
	}

	public boolean isColorOfProductDisplayed(String expectedColor) {
		String actualTextOfColor = actualColorText.getText();
		System.out.println("actual text of color" + actualTextOfColor);

		if (actualTextOfColor.toLowerCase().contains(expectedColor.toLowerCase())) {

			return true;
		}

		return false;

	}

	public ProductDetailsPage selectSize(String size) {
		WebElement productsize = driver.findElement(
				By.xpath("//div[@class=\"circle size-variant-item size-instock \"]/span[text()='" + size + "']"));
		wait.until(ExpectedConditions.visibilityOf(productsize));
		productsize.click();
		return this;
	}

	public ProductDetailsPage clickOnAddToCart() {
		wait.until(ExpectedConditions.visibilityOf(addtocart));
		addtocart.click();
		return this;
	}

	public ProductDetailsPage clickOnGoToCart() {
		wait.until(ExpectedConditions.visibilityOf(gotocart));
		gotocart.click();
		return this;
	}

	public ProductDetailsPage verifyCartProduct(String expectedBrandName, String expectedProductName) {
		wait.until(ExpectedConditions.visibilityOf(cartProductName));
		String actualProductName = cartProductName.getText();
		System.out.println("cart product name " + actualProductName);

		assertTrue(actualProductName.contains(expectedBrandName));
		assertTrue(actualProductName.contains(expectedProductName));

		return this;
	}

	public ProductDetailsPage quantityOfProduct(int Quantity) {
		wait.until(ExpectedConditions.visibilityOf(quantity));
		quantity.click();
		wait.until(ExpectedConditions.visibilityOf(incrementQuantity));

		for (int i = 0; i <= Quantity; i++) {
			incrementQuantity.click();
		}

		updateQuantitybutton.click();
		return this;
	}

	public ProductDetailsPage selectCouponCode() {

		Actions actions = new Actions(driver);
		actions.moveToElement(selectCouponCode);
		actions.perform();

		selectCouponCode.click();
		clickOnApplyButton.click();

		return this;

	}

	public boolean isCouponResultDisplayed(String expectedAppliedCouponText) {
		wait.until(ExpectedConditions.visibilityOf(actualText));
		String actualTextOfCouponApplied = actualText.getText();

		if (actualTextOfCouponApplied.contains(expectedAppliedCouponText)) {
			System.out.println("actual text of coupon" + actualTextOfCouponApplied);

			return true;
		}

		return false;

	}

	public ProductDetailsPage proceedToShipping() {
		wait.until(ExpectedConditions.visibilityOf(proceedToShipping));
		return this;
	}

	public ProductDetailsPage deleteProductFromCart() {
		wait.until(ExpectedConditions.visibilityOf(deleteButton));

		deleteButton.click();
		deleteButtonOfPopup.click();
		return this;

	}

	public boolean isDeletedProductDisplayed(String expectedDeletedProductDisplayed) {
		wait.until(ExpectedConditions.visibilityOf(actualTextAfterProductDeleted));
		String actualDeletedProductExist = actualTextAfterProductDeleted.getText();

		if (actualDeletedProductExist.contains(expectedDeletedProductDisplayed)) {
			System.out.println("actual text of coupon" + actualDeletedProductExist);

			return true;
		}

		return false;

	}

	public ProductDetailsPage withoutSelectSizeShowsErrorMessage() {

		wait.until(ExpectedConditions.visibilityOf(addtocart));
		addtocart.click();
		return this;
	}

	public boolean isErrorMessageDispalyedForNotSelectingSize(String expectedMsg) {
		wait.until(ExpectedConditions.visibilityOf(actualSelectSizeText));

		String actualSelectSizeTextMsg = actualSelectSizeText.getText();

		if (actualSelectSizeTextMsg.contains(expectedMsg)) {
			System.out.println("actual text of size - " + actualSelectSizeTextMsg);

			return true;
		}

		return false;

	}
}
