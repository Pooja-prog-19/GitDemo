package com.automationTest.operations;

import com.automationTest.pages.PincodeToKnowDeliveryPage;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class PincodeToKnowDeliveryDate implements IOperations {

	private PincodeToKnowDeliveryPage pincodeToKnowDelivery;

	public PincodeToKnowDeliveryDate() throws DriverNotInitializedException {
		pincodeToKnowDelivery = TestPageFactory.getPage(PincodeToKnowDeliveryPage.class);

	}

	public void enterPincode(String pincode) throws DriverNotInitializedException, InterruptedException {

		pincodeToKnowDelivery.clickToKnowDeliveryEnterPincodeLink(pincode).clickOnConfirmPincodeButton();
	}

	public boolean isChangePinCodeButtonDisplayed(String expectedChangePincodeText) {
		return pincodeToKnowDelivery.isChangePincodeTextDisplayed(expectedChangePincodeText);
	}

}
