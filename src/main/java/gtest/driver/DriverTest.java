package gtest.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.google.common.collect.ImmutableList;

import gtest.browser.Browser;

public class DriverTest {
	
	private final static Map<String, String> propertiesMap = new HashMap<>();
	private final WebDriver driver;
	
	static{
		Properties systemProperties = System.getProperties();
		for (String key : systemProperties.stringPropertyNames()) {
			propertiesMap.put(key, systemProperties.getProperty(key));
		}
	}
	
	public DriverTest() {
		this.driver = getDriverForBrowser(Browser.valueOf(propertiesMap.get("browser")));
	}
	
	public WebDriver driver() {
		return driver;
	}
	
	private WebDriver getDriverForBrowser(Browser browser) {
		ImmutableList<WebDriverFactory> webDriverFactories = ImmutableList.<WebDriverFactory> builder()
				.add(new ChromeFactory())
				.add(new FirefoxFactory())
				.build();
		for (WebDriverFactory driverFactory : webDriverFactories) {
			WebDriver driver = driverFactory.getDriver(browser);
			if (driver != null) return driver;
		}
		throw new IllegalStateException("WebDriver was not instantiated!");
	}

}
