package com.automationTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.MenuProductPageNavigations;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class MenuNavigations extends BaseTest {

	@Test()
	@Description("Test Description : To validate Main menu to submenu navigation page result")
	public void menuNaviagtion()
			throws DriverNotInitializedException, InterruptedException, InstantiationException, IllegalAccessException {
		String mainMenuName = "WOMEN";
		String subMenuName = "Sarees";

		MenuProductPageNavigations productNavigate = TestOperationFactory
				.getOperation(MenuProductPageNavigations.class);
		productNavigate.productPageNavigationMenu(mainMenuName, subMenuName);

		Assert.assertTrue(productNavigate.isResultDisplayedForSelectedMenu(subMenuName));
	}

}
