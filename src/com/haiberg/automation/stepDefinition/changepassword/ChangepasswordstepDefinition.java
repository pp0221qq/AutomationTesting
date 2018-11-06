package com.haiberg.automation.stepDefinition.changepassword;
import com.haiberg.automation.task.LoginTask;
import com.haiberg.automation.task.changepassword.ChangepasswordTask;
import com.haiberg.automation.testRunner.changepassword.ChangepasswordRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ChangepasswordstepDefinition {
	

	private ChangepasswordTask changepasswordtask = new ChangepasswordTask();
	private LoginTask logintask = new LoginTask();
	
	@Given("^user Login the Adassist \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_Login_the_Adassist(String username, String password) throws Throwable {
		ChangepasswordRunner.setUp();
	    logintask.inputUsername(username);
	    logintask.inputPassword(password);
	    logintask.clickLoginbutton();
	    logintask.clickmandatorbutton();
	    logintask.clickmandator();
	    logintask.clickcontinuebutton();

	}
	
	@Then("^user click setpassword button$")
	public void user_click_setpassword_button() throws Throwable {
		changepasswordtask.clicksetpasswordbutton();
	}
	@And("^user input original \"([^\"]*)\"$")
	public void user_input_original(String original) throws Throwable {
		changepasswordtask.inputoriginal(original);

	}
	
	@And("^user input new password \"([^\"]*)\"$")
	public void user_input_new_password(String newpassword) throws Throwable {
		changepasswordtask.inputnewpassword(newpassword);

	}
	
	@And("^user input confirm password \"([^\"]*)\"$")
	public void user_input_confirm_password(String confirmpassword) throws Throwable {
		changepasswordtask.inputconfirmpassword(confirmpassword);

	}
	
	@Then("^user click save button$")
	public void click_save_button() throws Throwable {
		changepasswordtask.clicksetsavebutton();

	}
	

}
