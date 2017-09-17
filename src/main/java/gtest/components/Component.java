package gtest.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Component {

	private final WebElement element;
	private final WebDriver driver;
	
	public Component(WebElement element, WebDriver driver) {
		this.element = element;
		this.driver = driver;
	}
	
	protected WebElement findElement(By by) {
		return element.findElement(by);
	}

	protected <T extends Component> T findComponent(By by, Class<T> componentClass) {
		T component = null;
		try {
			Constructor<T> constructor = componentClass.getConstructor(new Class[] { WebElement.class, WebDriver.class });
			component = constructor.newInstance(findElement(by), driver);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
		return component;
	}

}
