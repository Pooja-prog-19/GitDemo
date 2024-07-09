package com.automationTest.operations;

import com.automationTest.pages.FilterPage;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class ApplyFilter implements IOperations {

	private FilterPage Filterpage;

	public ApplyFilter() throws DriverNotInitializedException {
		Filterpage = TestPageFactory.getPage(FilterPage.class);
	}

	public void selectFilter(String searchbyText, String gender, String brand, String brandoption)
			throws DriverNotInitializedException, InterruptedException {

		Filterpage.EnterSearchText(searchbyText).selectGender(gender).selectBrand(brand).selectBrandOption(brandoption);
	}

	public boolean isPageResultDisplayed(String firstExpectedText) {

		return Filterpage.isFilterDisplayed(firstExpectedText);

	}

	public boolean isBrandNameResultDisplayed(String brandName) {

		return Filterpage.isBrandNameSameForAllProduct(brandName);

	}

}
