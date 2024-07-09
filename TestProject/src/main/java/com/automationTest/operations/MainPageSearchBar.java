package com.automationTest.operations;

import com.automationTest.pages.SearchBar;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class MainPageSearchBar implements IOperations {

	private SearchBar searchBar;

	public MainPageSearchBar() throws DriverNotInitializedException {
		searchBar = TestPageFactory.getPage(SearchBar.class);

	}

	public void sarchTextBar(String searchByText) throws DriverNotInitializedException, InterruptedException {

		searchBar.enterSearchText(searchByText).selectGender();
	}

	public boolean isResultGetsDisplayed(String expectedTitle) {

		return searchBar.isResultDisplayed(expectedTitle);

	}
}
