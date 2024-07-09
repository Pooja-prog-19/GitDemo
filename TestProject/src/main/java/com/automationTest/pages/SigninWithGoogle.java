package com.automationTest.pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class SigninWithGoogle extends BasePage implements TestPage {

	private Actions action;

	@FindBy(xpath = "//span[@class=\"  login-form login-modal\"]")
	private WebElement signinAjioLink;

	@FindBy(xpath = "//div[@class=\"google-login\"]")
	private WebElement googleButton;

	public SigninWithGoogle(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
		action = new Actions(driver);

	}

	public SigninWithGoogle clickSigninAjioLink() {
		wait.until(ExpectedConditions.visibilityOf(signinAjioLink));
		signinAjioLink.click();
		return this;
	}

	public SigninWithGoogle clickGoogleButton() {
		wait.until(ExpectedConditions.visibilityOf(googleButton));
		googleButton.click();
		return this;
	}

	public boolean isSigninWithGoogleDisplayed(String expectedTitle) {
		String currentWindow = driver.getWindowHandle(); // getwindowhandle takes unique address of window(for one)
		Set<String> windows = driver.getWindowHandles(); // getwindowhandles takes multi address of windows
		for (String window : windows) {
			if (!window.equals(currentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.contains(expectedTitle)) {
			return true;
		}
		return false;

	}
}
