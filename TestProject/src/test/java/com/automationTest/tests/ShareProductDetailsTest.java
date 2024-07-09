package com.automationTest.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.OpenProductPage;
import com.automationTest.operations.ProductDetailsVerify;
import com.automationTest.operations.ShareProductDetailsPage;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class ShareProductDetailsTest extends BaseTest {

	@Test()
	@Description("Test Description : To validate search product and click on any one product to open the PDP page")
	public void SearchandClickOnProductWithShareProductDetails()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "Top";
		String title = "Pinterest";

		OpenProductPage openProductPage = TestOperationFactory.getOperation(OpenProductPage.class);
		openProductPage.openProduct(enterSearchText);

		List<String> productDetails = openProductPage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openProductPage.clickOnListProduct();

		ProductDetailsVerify productVerify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productVerify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		String expectedTitleforShareOption = "Pinterest";
		ShareProductDetailsPage shareDetails = TestOperationFactory.getOperation(ShareProductDetailsPage.class);
		shareDetails.clickOnshareOptionsIcon(title);

		Assert.assertTrue(shareDetails.isShareOptionDisplayed(expectedTitleforShareOption));

	}
}
