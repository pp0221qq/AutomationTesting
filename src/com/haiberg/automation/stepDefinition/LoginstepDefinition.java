package com.haiberg.automation.stepDefinition;
import com.haiberg.automation.task.LoginTask;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginstepDefinition {

	private LoginTask logintask = new LoginTask();

	@Given("^user input username \"([^\"]*)\"$")
	public void user_input_username(String username) throws Throwable {
		logintask.inputUsername(username);

	}

	@And("^user input password \"([^\"]*)\"$")
	public void user_input_password(String password) throws Throwable {
		logintask.inputPassword(password);

	}

	@And("^user click login button$")
	public void click_login_button() throws Throwable {
		logintask.clickLoginbutton();

	}
	
	@Then("^user click mandator button$")
	public void click_mandator_button() throws Throwable {
		logintask.clickmandatorbutton();

	}
	
	@And("^user click mandator$")
	public void click_mandator() throws Throwable {
		logintask.clickmandator();

	}
	
	@And("^user click continue button$")
	public void click_continue_button() throws Throwable {
		logintask.clickcontinuebutton();

	}


}
