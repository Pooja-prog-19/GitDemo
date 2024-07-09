package com.framework.dataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.ITestContext;
/**
 * @author Globant MTA Test Automation team [sagar.shinde,neha.batham,sparsh.gupta]
 *
 */
public interface ProvideData {

	Object[][] getData(ITestContext iTestContext, Method testMethod) throws IOException;
	

}
