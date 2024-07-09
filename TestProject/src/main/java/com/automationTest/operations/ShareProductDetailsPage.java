package com.automationTest.operations;

import com.automationTest.pages.ShareProductDetails;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class ShareProductDetailsPage implements IOperations {

	private ShareProductDetails shareProductDetails;

	public ShareProductDetailsPage() throws DriverNotInitializedException {
		shareProductDetails = TestPageFactory.getPage(ShareProductDetails.class);

	}

	public void clickOnshareOptionsIcon(String title) throws DriverNotInitializedException, InterruptedException {

		shareProductDetails.clickShareIcon().selectShareOption(title);

	}

	public boolean isShareOptionDisplayed(String expectedTitleforShareOption) {
		return shareProductDetails.isShareOptionDisplayed(expectedTitleforShareOption);
	}

}
