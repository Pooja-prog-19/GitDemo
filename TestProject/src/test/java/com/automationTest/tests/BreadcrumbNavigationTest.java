package com.automationTest.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.BreadcrumbNavigationOfProduct;
import com.automationTest.operations.OpenProductPage;
import com.automationTest.operations.ProductDetailsVerify;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class BreadcrumbNavigationTest extends BaseTest {

	@Test()
	@Description("Test Description : To validate search product and click on any one product to open the PDP page")
	public void searchandClickOnProductWithBreadcrumbNavigation()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "Top";
		String homeLink = "Home";
		String expectedTitleforBreadcrumbNavigation = "Online Shopping for Women";

		OpenProductPage openProductPage = TestOperationFactory.getOperation(OpenProductPage.class);
		openProductPage.openProduct(enterSearchText);

		List<String> productDetails = openProductPage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openProductPage.clickOnListProduct();

		ProductDetailsVerify productVerify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productVerify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		BreadcrumbNavigationOfProduct breadCrumbNavigation = TestOperationFactory
				.getOperation(BreadcrumbNavigationOfProduct.class);
		breadCrumbNavigation.openProductAndNavigateToBreadcrumb(homeLink);

		Assert.assertTrue(
				breadCrumbNavigation.isResultDisplayedforBreadcrumbNavigation(expectedTitleforBreadcrumbNavigation));

	}
}
