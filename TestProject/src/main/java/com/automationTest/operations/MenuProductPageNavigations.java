package com.automationTest.operations;

import com.automationTest.pages.MenuPageNavigation;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class MenuProductPageNavigations implements IOperations {

	private MenuPageNavigation homePage;

	public MenuProductPageNavigations() throws DriverNotInitializedException {
		homePage = TestPageFactory.getPage(MenuPageNavigation.class);

	}

	public void productPageNavigationMenu(String mainMenuName, String subMenuName)
			throws DriverNotInitializedException, InterruptedException {

		homePage.clickMainMenu(mainMenuName).clickSubMenu(subMenuName);

	}

	public boolean isResultDisplayedForSelectedMenu(String expectedTitle) {
		return homePage.isResultDisplayedForSelectedMenu(expectedTitle);
	}

}
