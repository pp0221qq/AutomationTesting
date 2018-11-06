package com.haiberg.automation.task.changepassword;


import com.haiberg.automation.widget.WidgetUtils;
import com.haiberg.automation.widget.changepassword.ChangepasswordWidget;

public class ChangepasswordTask {
	private static ChangepasswordWidget changepasswordWidget = new ChangepasswordWidget();

	public void clicksetpasswordbutton() throws Exception {
		WidgetUtils.clickElememnt(changepasswordWidget.getSetpasswordbutton());
	}
	
	public void inputoriginal(String original) throws Exception {
		WidgetUtils.setValue(changepasswordWidget.getTextFieldOriginal(), original);

	}
	
	public void inputnewpassword(String newpassword) throws Exception {
		WidgetUtils.setValue(changepasswordWidget.getTextFieldNewpassword(),newpassword);
	}
	
	public void inputconfirmpassword(String confirmpassword) throws Exception {
		WidgetUtils.setValue(changepasswordWidget.getTextFieldConfirmpassword(),confirmpassword);
	}
	
	public void clicksetsavebutton() throws Exception {
		WidgetUtils.clickElememnt(changepasswordWidget.getSavabutton());
	}

}
