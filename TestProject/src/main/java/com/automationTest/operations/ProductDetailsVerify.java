package com.automationTest.operations;

import com.automationTest.pages.ProductDetailsPage;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class ProductDetailsVerify implements IOperations {
	private ProductDetailsPage productDetails;

	public ProductDetailsVerify() throws DriverNotInitializedException {

		productDetails = TestPageFactory.getPage(ProductDetailsPage.class);
	}

	public void isProductDetailsBrandAndProductDisplayed(String expectedBrandName, String expectedProductName) {

		productDetails.isProductDetailsDisplayed(expectedBrandName, expectedProductName);
	}

	public void selectcolorOfProduct(String color) {

		productDetails.selectColorOfTheProduct(color);
	}

	public boolean isAppliedColorProductisplayed(String expectedColor) {
		return productDetails.isColorOfProductDisplayed(expectedColor);
	}

	public void selectSizeOfProduct(String size) {

		productDetails.selectSize(size);
	}

	public void addToCart() {

		productDetails.clickOnAddToCart();
	}

	public void goToCart() {

		productDetails.clickOnGoToCart();
	}

	public void selectProductQuantity(int quantity) {
		productDetails.quantityOfProduct(quantity);
	}

	public void applyCouponCode() {

		productDetails.selectCouponCode();
	}

	public void proceedToShippingButton() {

		productDetails.proceedToShipping();
	}

	public boolean isAppliedCouponResultDisplayed(String expectedAppliedCouponText) {
		return productDetails.isCouponResultDisplayed(expectedAppliedCouponText);
	}

	public void deleteProduct() {
		productDetails.deleteProductFromCart();
	}

	public boolean isDeletedResultDisplayed(String expectedDeletedProductDisplayed) {
		return productDetails.isDeletedProductDisplayed(expectedDeletedProductDisplayed);
	}

	public void verifyErrorMessageForSelectSize() {
		productDetails.withoutSelectSizeShowsErrorMessage();
	}

	public boolean isSelectSizeMessageDisplayed(String expectedMsg) {
		return productDetails.isErrorMessageDispalyedForNotSelectingSize(expectedMsg);
	}

}
