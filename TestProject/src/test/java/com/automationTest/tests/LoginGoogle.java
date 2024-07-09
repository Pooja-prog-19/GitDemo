package com.automationTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationTest.operations.SignIn;
import com.framework.operation.TestOperationFactory;
import com.framework.test.BaseTest;
import io.qameta.allure.Description;

public class LoginGoogle extends BaseTest {

	@Test()
	@Description("Test Description: To validate login with google functionality.")

	public void verifyLoginWithGoolge() throws Exception {

		String titlePresent = "Google accounts";

		SignIn signIn = TestOperationFactory.getOperation(SignIn.class);
		signIn.signInGoogle();

		Assert.assertTrue(signIn.isResultDisplayed(titlePresent));

	}
}
