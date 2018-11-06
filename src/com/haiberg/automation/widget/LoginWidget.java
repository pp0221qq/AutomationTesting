package com.haiberg.automation.widget;

import org.openqa.selenium.WebElement;

import com.haiberg.automation.web.Locator;
import com.haiberg.automation.web.Locator.ByType;

public class LoginWidget extends WidgetUtils{
	private static String username="username-inputEl";
	private static String password="textfield-1012-inputEl";
	private static String loginButton="button-1013";
	private static String mandatorbutton="mandator-trigger-picker";
	private static String mandator=".//*[@id='ext-element-7']";
	private static String continuebutton="#button-1024";
	
	public WebElement getTextFieldUserName() throws Exception {
		
		return getElement(new Locator(username));
	}
	
	
   public WebElement getPasswordFieldpassword() throws Exception {
		
		return getElement(new Locator(password));

   }

   public WebElement getLoginbutton() throws Exception {
	
	  return getElement(new Locator(loginButton, ByType.id));

   }
   public WebElement getMandatorbutton() throws Exception {
		
		  return getElement(new Locator(mandatorbutton, ByType.id));

   }
   
   public WebElement getMandator() throws Exception {
		
		  return getElement(new Locator(mandator, ByType.xpath));

   }
   
   public WebElement getContinuebutton() throws Exception {
		
		  return getElement(new Locator(continuebutton, ByType.cssSelector));

   }
   
}