package com.test.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver = null;
  @BeforeClass
  public void beforeClass() {
	  driver = Driver.createFor("Chrome");
  }
	
  @Test
  public void test() {
	  driver.get("https://www.google.co.in");
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
