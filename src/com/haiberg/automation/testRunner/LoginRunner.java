package com.haiberg.automation.testRunner;

import org.junit.runner.RunWith;

import com.haiberg.automation.annotations.ExtendedCucumberRunner;
import com.haiberg.automation.testRunner.AbstractRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "Feature/UserLogin.feature", 
		glue={"com.haiberg.automation.stepDefinition"})


@RunWith(ExtendedCucumberRunner.class)
public class LoginRunner extends AbstractRunner{
	

}
