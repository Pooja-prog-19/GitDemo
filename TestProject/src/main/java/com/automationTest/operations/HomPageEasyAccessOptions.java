package com.automationTest.operations;

import com.automationTest.pages.HomePageEasyAccessMenu;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class HomPageEasyAccessOptions implements IOperations {

	private HomePageEasyAccessMenu homePageEasyAccessMenu;

	public HomPageEasyAccessOptions() throws DriverNotInitializedException {
		homePageEasyAccessMenu = TestPageFactory.getPage(HomePageEasyAccessMenu.class);

	}

	public void openTheOptionNavigateToMainSections(String optionName) throws DriverNotInitializedException {

		homePageEasyAccessMenu.clickOnHomePageOptionIcon(optionName);

	}

	public boolean isSelectedSectionPageDisplayed(String expectedPage) {

		return homePageEasyAccessMenu.isSectedSectionPagePresent(expectedPage);
	}

	public void clickUpArrow() throws DriverNotInitializedException {

		homePageEasyAccessMenu.clickOnUpArrow();
	}

	public void isArrowDisplayed() throws DriverNotInitializedException {

		homePageEasyAccessMenu.isScrollupArrowDisplayed();
	}

}
