package gtest.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentComponent extends Component {

	private final WebElement image;
	private final FooterComponent footer;

	public ContentComponent(WebElement element, WebDriver driver) {
		super(element, driver);
		this.image = findElement(By.tagName("img"));
		this.footer = findComponent(By.id("footer"), FooterComponent.class);
	}
	
	public FooterComponent footer() {
		return footer;
	}
	
	public WebElement image() {
		return image;
	}

}
