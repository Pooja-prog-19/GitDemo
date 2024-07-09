package com.automationTest.operations;

import java.util.List;
import com.automationTest.pages.SortByOnListOfProduct;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class SortByOnListOfProducts implements IOperations {

	private SortByOnListOfProduct sortByListOfProducts;

	public SortByOnListOfProducts() throws DriverNotInitializedException {
		sortByListOfProducts = TestPageFactory.getPage(SortByOnListOfProduct.class);

	}

	public void sortByListOfProdcutsOption(String textOfSortByOption)
			throws DriverNotInitializedException, InterruptedException {

		sortByListOfProducts.selectSortBy(textOfSortByOption);
	}

	public boolean isDropdownTextDisplayed(String expectedDropdownText) {
		return sortByListOfProducts.isSelectedDropdownValueDisplayed(expectedDropdownText);
	}

	public List<Integer> isListOfDiscounts() {
		return sortByListOfProducts.listOfDiscounts();
	}
}
