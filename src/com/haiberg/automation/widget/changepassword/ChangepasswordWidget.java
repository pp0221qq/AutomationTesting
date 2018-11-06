package com.haiberg.automation.widget.changepassword;

import org.openqa.selenium.WebElement;

import com.haiberg.automation.web.Locator;
import com.haiberg.automation.web.Locator.ByType;
import com.haiberg.automation.widget.WidgetUtils;

public class ChangepasswordWidget extends WidgetUtils{
	private static String setpasswordbutton="setPasswordBtn";
	private static String original="changepasswordOldpassword-inputEl";
	private static String newpassword="changepasswordNewpassword-inputEl";
	private static String confirmpassword="changepasswordConfirmpassword-inputEl";
	private static String saveButton="changepasswordSaveButton";
	
   public WebElement getSetpasswordbutton() throws Exception {
		
		  return getElement(new Locator(setpasswordbutton, ByType.id));

   }
   
   public WebElement getTextFieldOriginal() throws Exception {
		
		return getElement(new Locator(original));
		
   }
   
   public WebElement getTextFieldNewpassword() throws Exception {
		
		return getElement(new Locator(newpassword));
		
   }
   
   public WebElement getTextFieldConfirmpassword() throws Exception {
		
		return getElement(new Locator(confirmpassword));
		
	}
   
   public WebElement getSavabutton() throws Exception {
		
		  return getElement(new Locator(saveButton, ByType.id));

   }
   
   
   
}