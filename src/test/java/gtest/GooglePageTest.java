package gtest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gtest.driver.DriverTest;
import gtest.pages.GooglePage;

public class GooglePageTest {
	
	DriverTest test = new DriverTest();

	@Test
	public void gTest() {
		WebDriver driver = test.driver();
		try {
			driver.get("https://www.google.com/");
			GooglePage gPage = new GooglePage(driver);
			WebElement advertising = gPage.content().footer().advertising();
			advertising.click();
		} finally {
			driver.quit();
		}
	}
}
