package com.haiberg.automation.task;


import com.haiberg.automation.widget.LoginWidget;
import com.haiberg.automation.widget.WidgetUtils;

public class LoginTask {
	private static LoginWidget loginWidget = new LoginWidget();

	public void inputUsername(String username) throws Exception {
		WidgetUtils.clearField(loginWidget.getTextFieldUserName());
		WidgetUtils.setValue(loginWidget.getTextFieldUserName(), username);
		;

	}

	public void inputPassword(String password) throws Exception {
		WidgetUtils.setValue(loginWidget.getPasswordFieldpassword(), password);

	}

	public void clickLoginbutton() throws Exception {
		WidgetUtils.clickElememnt(loginWidget.getLoginbutton());
	}
	
	public void clickmandatorbutton() throws Exception {
		WidgetUtils.clickElememnt(loginWidget.getMandatorbutton());
	}
	
	public void clickmandator() throws Exception {
		WidgetUtils.clickElememnt(loginWidget.getMandator());
	}
	
	public void clickcontinuebutton() throws Exception {
		WidgetUtils.clickElememnt(loginWidget.getContinuebutton());
	}
	

}
