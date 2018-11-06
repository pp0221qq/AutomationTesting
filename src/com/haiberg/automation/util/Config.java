package com.haiberg.automation.util;

import java.util.*;

import java.io.*;
public class Config {
public static String getProperty(String key) throws Exception{
	 
	Properties prop = new Properties(); 
    String path=System. getProperty ("user.dir")+"\\"+"config.properties";
	InputStream in = new BufferedInputStream (new FileInputStream(path));
	prop.load(in);
	String value = prop.getProperty(key);
    
	return value;
  }
}
