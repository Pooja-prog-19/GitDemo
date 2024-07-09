package com.automationTest.tests;

import java.util.List;
import org.testng.annotations.Test;
import com.automationTest.operations.AddToCart;
import com.automationTest.operations.OpenProductPage;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class AddToCartTest extends BaseTest {

	@Test()
	@Description("Test Description : To validate search product and click on any one product to open the PDP page")
	public void SearchandClickOnProduct()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "Top";

		OpenProductPage openProductPage = TestOperationFactory.getOperation(OpenProductPage.class);
		openProductPage.openProduct(enterSearchText);
		List<String> productDetails = openProductPage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openProductPage.clickOnListProduct();

		AddToCart addToCartVerify = TestOperationFactory.getOperation(AddToCart.class);
		addToCartVerify.isAddToCartProductDisplayed(expectedBrandName, expectedProductName);

	}

}
