package gtest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import gtest.pages.GooglePage;

public class GooglePageTest {

	@Test
	public void gTest() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort()
				.usingDriverExecutable(new File(FileUtils.getUserDirectory(), "selenium/chromedriver")).build();
		ChromeDriver driver = new ChromeDriver(service);
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
