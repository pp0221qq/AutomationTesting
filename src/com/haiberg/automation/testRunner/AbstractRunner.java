package com.haiberg.automation.testRunner;

import org.junit.runner.RunWith;



//import com.haiberg.automation.annotations.AfterSuite;
import com.haiberg.automation.annotations.BeforeSuite;
import com.haiberg.automation.annotations.ExtendedCucumberRunner;
import com.haiberg.automation.util.Config;
import com.haiberg.automation.web.WebBrowser;

@RunWith(ExtendedCucumberRunner.class)
public abstract class AbstractRunner {
	
	//@BeforeSuite
    public static void setUp() throws Exception {
		WebBrowser.browserinit();
	    WebBrowser.loadUrl(Config.getProperty("CAM"));
    }
//	
//    @AfterSuite
//     public static void tearDown() {
//    	 WebBrowser.closeBrowser();
//     }
}
