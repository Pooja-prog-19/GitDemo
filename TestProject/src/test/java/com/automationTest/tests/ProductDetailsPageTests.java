package com.automationTest.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.AddToCart;
import com.automationTest.operations.OpenProductPage;
import com.automationTest.operations.ProductDetailsVerify;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class ProductDetailsPageTests extends BaseTest {

	@Test(enabled=false)
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

		ProductDetailsVerify productVerify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productVerify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

	}

	@Test(enabled=false)
	@Description("Test Description : To validate search product and click on product to open the PDP page and then select color  of the product and verify it")
	public void verifyAddToCartFunctionality()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "FORT COLLINS blazers";

		OpenProductPage openproductpage = TestOperationFactory.getOperation(OpenProductPage.class);
		openproductpage.openProduct(enterSearchText);
		List<String> productDetails = openproductpage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openproductpage.clickOnListProduct();

		ProductDetailsVerify productverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productverify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		String color = "blue";
		productverify.selectcolorOfProduct(color);

		
		boolean isColorApplied = productverify.isAppliedColorProductisplayed(color);
		Assert.assertTrue(isColorApplied);

	}

	@Test(enabled=false)
	@Description("Test Description : To validate search product and click on any one product to open the PDP page and then select size of the product and add to cart")
	public void verifySelectingSizeOfTheProduct()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "FORT COLLINS blazers";

		OpenProductPage openproductpage = TestOperationFactory.getOperation(OpenProductPage.class);
		openproductpage.openProduct(enterSearchText);
		List<String> productDetails = openproductpage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openproductpage.clickOnListProduct();

		ProductDetailsVerify productverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productverify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		String size = "M";
		ProductDetailsVerify detailsverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		detailsverify.selectSizeOfProduct(size);
		detailsverify.addToCart();
		// detailsverify.goToCart();

	}

	@Test()
	@Description("Test Description : To validate search product and click on any one product to open the PDP page and then select size of the product and add to cart, Update the Quantity of the product")
	public void verifyProductQuantityupdate()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "FORT COLLINS blazers";

		OpenProductPage openproductpage = TestOperationFactory.getOperation(OpenProductPage.class);
		openproductpage.openProduct(enterSearchText);
		List<String> productDetails = openproductpage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openproductpage.clickOnListProduct();

		ProductDetailsVerify productverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productverify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		String size = "M";
		ProductDetailsVerify detailsverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		detailsverify.selectSizeOfProduct(size);
		detailsverify.addToCart();
		detailsverify.goToCart();

		AddToCart addToCartverify = TestOperationFactory.getOperation(AddToCart.class);
		addToCartverify.isAddToCartProductDisplayed(expectedBrandName, expectedProductName);

		detailsverify.selectProductQuantity(4);

	}

	@Test()
	@Description("Test Description : To validate search product and click on any one product to open the PDP page and then select size of the product and add to cart and apply the coupon on the product")
	public void verifyApplyCouponCode()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "FORT COLLINS blazers";

		OpenProductPage openproductpage = TestOperationFactory.getOperation(OpenProductPage.class);
		openproductpage.openProduct(enterSearchText);
		List<String> productDetails = openproductpage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openproductpage.clickOnListProduct();

		ProductDetailsVerify productverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productverify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		String size = "M";
		ProductDetailsVerify detailsverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		detailsverify.selectSizeOfProduct(size);
		detailsverify.addToCart();
		detailsverify.goToCart();

		AddToCart addToCartverify = TestOperationFactory.getOperation(AddToCart.class);
		addToCartverify.isAddToCartProductDisplayed(expectedBrandName, expectedProductName);

		detailsverify.applyCouponCode();

		String expectedAppliedCouponText = "You Save";
		Assert.assertTrue(detailsverify.isAppliedCouponResultDisplayed(expectedAppliedCouponText));
		detailsverify.proceedToShippingButton();

	}

	
	@Test(enabled=false)
	@Description("Test Description : To validate search product and click on any one product to open the PDP page and then select size of the product and add to cart")
	public void verifyDeleteProductFromCart()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "FORT COLLINS blazers";

		OpenProductPage openproductpage = TestOperationFactory.getOperation(OpenProductPage.class);
		openproductpage.openProduct(enterSearchText);
		List<String> productDetails = openproductpage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openproductpage.clickOnListProduct();

		ProductDetailsVerify productverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productverify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		String size = "M";
		ProductDetailsVerify detailsverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		detailsverify.selectSizeOfProduct(size);
		detailsverify.addToCart();
		detailsverify.goToCart();

		detailsverify.deleteProduct();

		String expectedDeletedProductDisplayed = "Your Shopping Bag is Empty!!";
		Assert.assertTrue(detailsverify.isDeletedResultDisplayed(expectedDeletedProductDisplayed));

	}

	@Test(enabled=false)
	@Description("Test Description : To validate search product and click on any one product to open the PDP page and then select size of the product and add to cart")
	public void verifySelectSizeErrorMessage()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String enterSearchText = "FORT COLLINS blazers";

		OpenProductPage openproductpage = TestOperationFactory.getOperation(OpenProductPage.class);
		openproductpage.openProduct(enterSearchText);
		List<String> productDetails = openproductpage.getProductDetailsFromList(0);// 45 products
		String expectedBrandName = productDetails.get(0);
		String expectedProductName = productDetails.get(1);

		openproductpage.clickOnListProduct();

		ProductDetailsVerify productverify = TestOperationFactory.getOperation(ProductDetailsVerify.class);
		productverify.isProductDetailsBrandAndProductDisplayed(expectedBrandName, expectedProductName);

		productverify.addToCart();

		String expectedMsg = "Please select a size";
		productverify.verifyErrorMessageForSelectSize();
		productverify.isSelectSizeMessageDisplayed(expectedMsg);

		Assert.assertTrue(productverify.isSelectSizeMessageDisplayed(expectedMsg));

	}
}
