package com.haiberg.automation.testRunner.changepassword;

import org.junit.runner.RunWith;

import com.haiberg.automation.annotations.ExtendedCucumberRunner;
import com.haiberg.automation.testRunner.AbstractRunner;
import com.haiberg.automation.util.Config;
import com.haiberg.automation.web.WebBrowser;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "Feature/Changepassword.feature", 
		glue={"com.haiberg.automation.stepDefinition.changepassword"})


@RunWith(ExtendedCucumberRunner.class)
public class ChangepasswordRunner extends AbstractRunner{
	 public static void setUp() throws Exception {
			WebBrowser.browserinit();
		    WebBrowser.loadUrl(Config.getProperty("adassist"));
	    }
	
	

}
