package com.automationTest.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.OpenProductPage;
import com.automationTest.operations.SortByOnListOfProducts;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class SortByOnListOfProduct extends BaseTest {

	@Test()
	@Description("Test Description : To validate search product and click on any one product to open the PDP page")
	public void SearchandClickOnProductWithSortByFunctionality()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "Top";
		String textOfSortByOption = "Discount";
		String expectedDropdownText = "Discount";

		OpenProductPage openProductPage = TestOperationFactory.getOperation(OpenProductPage.class);
		openProductPage.openProduct(enterSearchText);

		SortByOnListOfProducts sortByListOfProducts = TestOperationFactory.getOperation(SortByOnListOfProducts.class);

		sortByListOfProducts.sortByListOfProdcutsOption(textOfSortByOption);
		List<Integer> filterDiscount = sortByListOfProducts.isListOfDiscounts();

		List<Integer> sortedFilterDiscount = new ArrayList<Integer>(filterDiscount);
		Collections.sort(sortedFilterDiscount, Collections.reverseOrder());

		Assert.assertTrue(sortByListOfProducts.isDropdownTextDisplayed(expectedDropdownText));
		Assert.assertTrue(filterDiscount.equals(sortedFilterDiscount));

	}
}
