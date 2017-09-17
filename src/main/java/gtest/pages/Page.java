package gtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gtest.components.Component;

public class Page extends Component {

	private final WebElement head;
	private final Component body;

	public Page(WebDriver driver) {
		super(driver.findElement(By.tagName("html")), driver);
		this.head = findElement(By.tagName("head"));
		this.body = findComponent(By.tagName("body"), Component.class);
	}
	
	public WebElement head() {
		return head;
	}
	
	public Component body() {
		return body;
	}

}
