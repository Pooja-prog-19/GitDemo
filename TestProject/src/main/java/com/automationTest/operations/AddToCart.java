package com.automationTest.operations;

import com.automationTest.pages.ProductDetailsPage;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class AddToCart implements IOperations {
	private ProductDetailsPage productDetails;

	public AddToCart() throws DriverNotInitializedException {
		productDetails = TestPageFactory.getPage(ProductDetailsPage.class);
	}

	public void isAddToCartProductDisplayed(String expectedBrandName, String expectedProductName) {

		productDetails.verifyCartProduct(expectedBrandName, expectedProductName);
	}

}