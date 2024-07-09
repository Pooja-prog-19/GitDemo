package com.automationTest.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.OpenProductPage;
import com.automationTest.operations.PincodeToKnowDeliveryDate;
import com.automationTest.operations.ProductDetailsVerify;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class PincodeToKnowDeliveryTest extends BaseTest {

	@Test()
	@Description("Test Description : To validate search product and click on any one product to open the PDP page")
	public void SearchandClickOnProductToCheckProductDeliveryDate()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "Top";
		String size = "M";
		String pincode = "431003";
		String expectedChangePincodeText = "Change Pincode";

		OpenProductPage openProductPage = TestOperationFactory.getOperation(OpenProductPage.class);
		openProductPage.openProduct(enterSearchText);

		List<String> productDetails = openProductPage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openProductPage.clickOnListProduct();

		ProductDetailsVerify productVerify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productVerify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);
		productVerify.selectSizeOfProduct(size);

		PincodeToKnowDeliveryDate pincodeToKnowDeliveryDate = TestOperationFactory
				.getOperation(PincodeToKnowDeliveryDate.class);
		pincodeToKnowDeliveryDate.enterPincode(pincode);

		Assert.assertTrue(pincodeToKnowDeliveryDate.isChangePinCodeButtonDisplayed(expectedChangePincodeText));

	}
}
