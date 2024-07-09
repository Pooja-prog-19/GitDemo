package com.automationTest.operations;

import java.util.List;
import com.automationTest.pages.ListOfProducts;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class OpenProductPage implements IOperations {

	private ListOfProducts listOfProduct;

	public OpenProductPage() throws DriverNotInitializedException {
		listOfProduct = TestPageFactory.getPage(ListOfProducts.class);

	}

	public void openProduct(String enterSearchText) throws DriverNotInitializedException, InterruptedException {

		listOfProduct = TestPageFactory.getPage(ListOfProducts.class).searchProduct(enterSearchText);
	}

	public List<String> getProductDetailsFromList(int index) {
		return listOfProduct.getProductDetailsFromSearchProducts(index);
	}

	public void clickOnListProduct() {
		listOfProduct.clickProduct();
	}

}
