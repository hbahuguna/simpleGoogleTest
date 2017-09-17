package gtest.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponent extends Component {
	
	private final WebElement advertising;

	public FooterComponent(WebElement element, WebDriver driver) {
		super(element, driver);
		this.advertising = findElement(By.cssSelector(".fbar #fsl a"));
	}
	
	public WebElement advertising() {
		return advertising;
	}

}
