package gtest.driver;

import org.openqa.selenium.WebDriver;

import gtest.browser.Browser;

public interface WebDriverFactory {
	
	WebDriver getDriver(Browser browser);

}
