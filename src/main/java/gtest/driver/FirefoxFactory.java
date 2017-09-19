package gtest.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import gtest.browser.Browser;

public class FirefoxFactory implements WebDriverFactory {

	@Override
	public WebDriver getDriver(Browser browser) {
		if(browser.equals(Browser.firefox)) {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			return new FirefoxDriver(capabilities);
		}
		return null;
	}

}
