package com.automationTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.MainPageSearchBar;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class SearchBartext extends BaseTest {

	@Test
	@Description("Test Description : To validate Search functionality by entring text in it and to apply filter on the search result page of the product category")
	public void searchBarFunctionality()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String searchByText = "Top";
		MainPageSearchBar pageSearchBar = TestOperationFactory.getOperation(MainPageSearchBar.class);

		pageSearchBar.sarchTextBar(searchByText);

		Assert.assertTrue(pageSearchBar.isResultGetsDisplayed(searchByText));

	}
}
