package com.automationTest.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automationTest.operations.ApplyFilter;
import com.framework.dataProvider.DataSet;
import com.framework.dataProvider.GenericDataProvider;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class FilterTest extends BaseTest {

	@Test(dataProvider = "TEST", dataProviderClass = GenericDataProvider.class)
	@DataSet("ProductSearch")

	@Description("Test Description : To validate Search functionality by entring text in it and to apply filter on the search result page of the product category")
	public void filterFunctionality(String searchByText, String gender, String brand, String brandOption)
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		ApplyFilter applyFilter = TestOperationFactory.getOperation(ApplyFilter.class);
		applyFilter.selectFilter(searchByText, gender, brand, brandOption);
		Assert.assertTrue(applyFilter.isPageResultDisplayed(brandOption));
		Assert.assertTrue(applyFilter.isPageResultDisplayed(gender));
		Assert.assertTrue(applyFilter.isBrandNameResultDisplayed(brandOption));

	}

	@DataProvider(name = "testData")
	public Object[][] dataMethod() {

		return new Object[][] { { "Top", "Girls", "brands", "612 League" },
				{ "Top", "Girls", "brands", "Adidas Kids" } };
	}

}
