package com.framework.page;
import org.openqa.selenium.support.PageFactory;
import com.framework.base.initializeDriver;
import com.framework.exceptions.DriverNotInitializedException;

public class TestPageFactory {

	public static <T extends TestPage> T getPage(Class<T> pageClass) throws DriverNotInitializedException {
		return PageFactory.initElements(initializeDriver.getDriver(), pageClass);
	}
}
