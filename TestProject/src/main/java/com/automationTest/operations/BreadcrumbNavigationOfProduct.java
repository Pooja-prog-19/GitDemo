package com.automationTest.operations;

import com.automationTest.pages.BreadCrumbNavigation;
import com.automationTest.pages.ListOfProducts;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class BreadcrumbNavigationOfProduct implements IOperations {

	private BreadCrumbNavigation breadCrumbNavigation;
	private ListOfProducts listOfProduct;

	public BreadcrumbNavigationOfProduct() throws DriverNotInitializedException {
		breadCrumbNavigation = TestPageFactory.getPage(BreadCrumbNavigation.class);
	}

	public void openProductAndNavigateToBreadcrumb(String homeLink)
			throws DriverNotInitializedException, InterruptedException {

		breadCrumbNavigation.clickOnHomeBreadcrumbNavigation(homeLink);
		listOfProduct = TestPageFactory.getPage(ListOfProducts.class);
	}

	public boolean isResultDisplayedforBreadcrumbNavigation(String expectedTitleforBreadcrumbNavigation) {

		return breadCrumbNavigation.isBreadCrumbNavigationDisplayed(expectedTitleforBreadcrumbNavigation);

	}

}
