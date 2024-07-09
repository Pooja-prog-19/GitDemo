package com.automationTest.operations;

import com.automationTest.pages.SigninWithGoogle;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.operation.IOperations;
import com.framework.page.TestPageFactory;

public class SignIn implements IOperations {
	private SigninWithGoogle signinWithGoogle;

	public SignIn() throws DriverNotInitializedException {
		signinWithGoogle = TestPageFactory.getPage(SigninWithGoogle.class);

	}

	public void signInGoogle() throws DriverNotInitializedException, InterruptedException {

		signinWithGoogle.clickSigninAjioLink().clickGoogleButton();
	}

	public boolean isResultDisplayed(String expectedTitle) {
		return signinWithGoogle.isSigninWithGoogleDisplayed(expectedTitle);
	}

}
