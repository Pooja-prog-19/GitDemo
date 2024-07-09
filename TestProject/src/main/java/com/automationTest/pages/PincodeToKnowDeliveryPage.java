package com.automationTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.framework.exceptions.DriverNotInitializedException;
import com.framework.page.BasePage;
import com.framework.page.TestPage;

public class PincodeToKnowDeliveryPage extends BasePage implements TestPage {

	public PincodeToKnowDeliveryPage(WebDriver driver) throws DriverNotInitializedException {
		super(driver);
	}

	private Actions action;

	@FindBy(xpath = "//span[@class=\" right-align  edd-pincode-msg-change-address\"]")
	private WebElement actualText;

	@FindBy(xpath = "//span[@class=\"edd-pincode-msg-details edd-pincode-msg-details-pointer edd-pincode-msg-details-text-color\"]")
	private WebElement clickOnPincodeLink;

	@FindBy(xpath = "//button[@class=\"edd-pincode-modal-submit-btn\"]")
	private WebElement clickOnConfirmPincodeButton;

	@FindBy(xpath = "//input[@class=\"edd-pincode-modal-text\"]")
	private WebElement pincodeInput;

	public PincodeToKnowDeliveryPage clickToKnowDeliveryEnterPincodeLink(String pincode) {

		clickOnPincodeLink.click();
		pincodeInput.sendKeys(pincode);
		return this;
	}

	public PincodeToKnowDeliveryPage clickOnConfirmPincodeButton() {

		clickOnConfirmPincodeButton.click();
		return this;
	}

	public boolean isChangePincodeTextDisplayed(String expectedChangePincodeText) {
		wait.until(ExpectedConditions.visibilityOf(actualText));

		String actualChangePincodeText = actualText.getText();

		if (actualChangePincodeText.contains(expectedChangePincodeText)) {
			System.out.println("actual text of ChangePincodeText " + actualChangePincodeText + "Is matching with "
					+ expectedChangePincodeText);

			return true;
		}

		return false;

	}

}
