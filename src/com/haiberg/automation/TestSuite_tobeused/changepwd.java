package com.haiberg.automation.TestSuite_tobeused;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.haiberg.automation.testRunner.LoginRunner;
import com.haiberg.automation.testRunner.changepassword.ChangepasswordRunner;
@RunWith(Suite.class)
@Suite.SuiteClasses({
  LoginRunner.class,
  ChangepasswordRunner.class

})
public class changepwd {

}
