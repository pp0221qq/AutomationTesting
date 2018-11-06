package com.haiberg.automation.init;

import com.haiberg.automation.task.LoginTask;

public class Login {

	private static LoginTask loginTask=new LoginTask();
	
	public static void login(String username, String password){
		try {
			loginTask.inputUsername(username);
			loginTask.inputPassword(password);
			loginTask.clickLoginbutton();
			loginTask.clickmandatorbutton();
			loginTask.clickmandator();
			loginTask.clickcontinuebutton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
