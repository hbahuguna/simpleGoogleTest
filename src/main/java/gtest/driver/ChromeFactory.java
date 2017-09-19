package gtest.driver;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import gtest.browser.Browser;

public class ChromeFactory implements WebDriverFactory {

	private static final String CHROMEDRIVER_PATH = "selenium/chromedriver";
	
	@Override
	public WebDriver getDriver(Browser browser) {
		if(browser.equals(Browser.chrome)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(BrowserType.CHROME);
			ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort()
				.usingDriverExecutable(new File(FileUtils.getUserDirectory(), CHROMEDRIVER_PATH)).build();
			return new ChromeDriver(service);
		}
		return null;
	}

}
