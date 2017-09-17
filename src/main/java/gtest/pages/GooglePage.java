package gtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gtest.components.ContentComponent;

public class GooglePage extends Page {

	private ContentComponent content;

	public GooglePage(WebDriver driver) {
		super(driver);
		this.content = findComponent(By.className("content"), ContentComponent.class);
	}
	
	public ContentComponent content() {
		return content;
	}

}
