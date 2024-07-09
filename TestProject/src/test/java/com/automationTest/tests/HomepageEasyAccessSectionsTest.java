package com.automationTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.HomPageEasyAccessOptions;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class HomepageEasyAccessSectionsTest extends BaseTest {

	@Test()
	@Description("Test Description : To validate on click of 3 dot option from home page right corner bottom , It gets clicked on easy access of the category wise selection of the page")
	public void homePageEasyAccessSections()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		String optionName = "Kids";

		HomPageEasyAccessOptions homePageEasyAccess = TestOperationFactory.getOperation(HomPageEasyAccessOptions.class);
		homePageEasyAccess.openTheOptionNavigateToMainSections(optionName);

		Assert.assertTrue(homePageEasyAccess.isSelectedSectionPageDisplayed(optionName));

	}

	@Test()
	@Description("Test Description : To validate on click of 3 dot option from home page right corner bottom , It gets clicked on easy access of the category wise selection of the page")
	public void upArrowToReachAttheStartOfPage()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {

		HomPageEasyAccessOptions homePageEasyAccess = TestOperationFactory.getOperation(HomPageEasyAccessOptions.class);
		homePageEasyAccess.clickUpArrow();

		homePageEasyAccess.isArrowDisplayed();

	}
}
