package com.haiberg.automation.widget;

import java.io.IOException;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.haiberg.automation.web.Locator;
import com.haiberg.automation.web.WebBrowser;

public class WidgetUtils {

	public static WebElement getElement(WebDriver driver,Locator locator) throws IOException {
		WebDriverWait wait=new WebDriverWait(driver, 3000);
		WebElement e;
		try{
		switch (locator.getBy()) {
		case xpath:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getPosition())));
			e = driver.findElement(By.xpath(locator.getPosition()));
			break;
		case id:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator.getPosition())));
			e = driver.findElement(By.id(locator.getPosition()));
			break;
		case name:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator.getPosition())));
			e = driver.findElement(By.name(locator.getPosition()));
			break;
		case cssSelector:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator.getPosition())));
			e = driver.findElement(By.cssSelector(locator.getPosition()));
			break;
		case className:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator.getPosition())));
			e = driver.findElement(By.className(locator.getPosition()));
			break;
		case tagName:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator.getPosition())));
			e = driver.findElement(By.tagName(locator.getPosition()));
			break;
		case linkText:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator.getPosition())));
			e = driver.findElement(By.linkText(locator.getPosition()));
			break;
		case partialLinkText:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator.getPosition())));
			e = driver.findElement(By.partialLinkText(locator.getPosition()));
			break;
		default:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator.getPosition())));
			e = driver.findElement(By.id(locator.getPosition()));
		}
		return e;
		
	} catch (NoSuchElementException e1) {
		e1.printStackTrace();
		return null;
	}
	}

	public static WebElement getElement(Locator locator) {
		WebDriver driver = WebBrowser.getbrowser();
		try {
			
			return getElement(driver, locator);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<WebElement> getElements(Locator locator) throws IOException {
		List<WebElement> es;
		WebDriver driver = WebBrowser.getbrowser();
		WebDriverWait wait=new WebDriverWait(driver, 3000);
		switch (locator.getBy()) {
		case xpath:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getPosition())));
			es = driver.findElements(By.xpath(locator.getPosition()));			
			break;
		case id:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator.getPosition())));
			es = driver.findElements(By.id(locator.getPosition()));
			break;
		case name:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator.getPosition())));
			es = driver.findElements(By.name(locator.getPosition()));
			break;
		case cssSelector:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator.getPosition())));
			es = driver.findElements(By.cssSelector(locator.getPosition()));
			break;
		case className:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator.getPosition())));
			es = driver.findElements(By.className(locator.getPosition()));
			break;
		case tagName:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator.getPosition())));
			es = driver.findElements(By.tagName(locator.getPosition()));
			break;
		case linkText:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator.getPosition())));
			es = driver.findElements(By.linkText(locator.getPosition()));
			break;
		case partialLinkText:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator.getPosition())));
			es = driver.findElements(By.partialLinkText(locator.getPosition()));
			break;
		default:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator.getPosition())));
			es = driver.findElements(By.id(locator.getPosition()));
		}
		return es;
	}

	public static boolean itemReadonly(WebElement element) {
		if (element == null) {
			throw new IllegalArgumentException("Invalid element");
		}
		return element.getAttribute("class").indexOf("x-form-readonly") != -1;
	}

	public static boolean formReadonly(String selector) {
		return formReadonly(getElement(new Locator(selector)));
	}

	public static String getValuebyAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public static String getValuebyText(WebElement element) {
		return element.getText();

	}

	public static boolean checkFieldisEmptyWithText(WebElement element) {
		return element.getText().equals("") || element.getText().equals(" ");

	}

	public static boolean listEmpty(List<WebElement> elements) {
		return elements.size() == 0;

	}

	public static boolean formReadonly(WebElement element) {
		return element.getAttribute("class").indexOf("x-form-readonly") != -1;
	}

	public static boolean checkFieldisEmptyWithValue(WebElement element) {
		return element.getAttribute("value").isEmpty();

	}

	public static String getPlaceholderText(WebElement element) {
		return element.getAttribute("placeholder");

	}

	public static void clickElememnt(WebElement element) {
		element.click();

	}

	public static void doubleClick(WebElement element) {
		WebDriver driver = WebBrowser.getbrowser();
		Actions ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}
	
	public static List<String> getListValueByText(List<WebElement> elements) {
		List<String> list = new ArrayList<String>();
		for (WebElement element : elements) {
			list.add(element.getText());

		}
		return list;

	}
	
	public static List<String> getListValueByAttribute(List<WebElement> elements) {
		List<String> list = new ArrayList<String>();
		for (WebElement e : elements) {
			list.add(e.getAttribute("value"));

		}
		return list;

	}
	
	

	public static void setValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	

	

	public static boolean buttonDisabled(WebElement web) {
		return web.getAttribute("class").indexOf("x-btn-disabled") > -1;
	}

	public static boolean formInvalid(WebElement web) {
		return web.getAttribute("class").indexOf("x-form-invalid-field") > -1;
	}

	public static boolean checkboxChecked(WebElement e) {
		return e.getAttribute("class").indexOf("x-form-cb-checked") > -1;
	}

	public static boolean itemDisabled(WebElement e) {
		return e.getAttribute("class").indexOf("x-item-disabled") > -1;
	}

	public static boolean radioButtonDisabled(WebElement e) {
		return e.getAttribute("aria-readonly").equals("true");
	}

	public static boolean checkboxCheckedbyAria(WebElement e) {
		return e.getAttribute("aria-checked").equals("true");
	}

	public static void clearField(WebElement web) {
		web.clear();
	}

}
