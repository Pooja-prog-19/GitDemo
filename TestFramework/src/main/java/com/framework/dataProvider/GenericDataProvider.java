package com.framework.dataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
/**
 * @author Globant MTA Test Automation team [sagar.shinde,neha.batham,sparsh.gupta]
 *
 */
public class GenericDataProvider {
	
	@DataProvider(name = "TEST", parallel = false)

	public  static Object[][] getData(ITestContext iTestContext, Method testMethod) throws IOException {

		ProvideData dataProvider= new DataProviderJsonImpl();
		return dataProvider.getData(iTestContext, testMethod);
		
	}
	
}
