package com.haiberg.automation.web;

import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.haiberg.automation.util.Config;
import com.haiberg.automation.web.Locator.ByType;

public class WebBrowser {
	
	private static WebDriver driver;
	
	
	public static void browserinit() throws Exception{
		
		String type;
		type=Config.getProperty("browserType");
		
		if(type.equals("chrome")){
			String driverpath=Config.getProperty("ChromeDriverPath");
			
			System.setProperty("webdriver.chrome.driver",driverpath);	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--lang=de");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if(type.equals("firefox")){
			driver = new FirefoxDriver();
			driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		else{
			
			System.out.println("No this browser!");
		}
	 
	}
	
	public static String captureScreenshot(String filename){
	
		String path=null;
		
		try { 
			
			String screeshotpath=Config.getProperty("ScreeshotPath");
			path=screeshotpath+filename+".png";
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile (srcFile,new File(path)); 
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		return path;
	}
	
	public static  WebDriver getbrowser(){
	
		return driver;
	
	}
	
	public static void loadUrl(String url){	
        try { 
        	driver.get(url);
			
		} catch (Exception e) { 
			
			System.out.println("Timeout");
		}
     
	   
	}
	

	
	public static void waitForReady(long a){
		
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void shutdown(){
		
		driver.quit();
	
	}
	
	public static void waitForReady(WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public static void waitForReady(By by){
		WebDriverWait wait=new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	
	public static void waitForReady() {
			// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	   
	   public static void doubleClick(){
	       	Actions ac= new Actions(driver);
	   
	       	ac.doubleClick().perform();
	       }
	   
	
        public static void closeBrowser(){
        	driver.close();
        }
        public static void scrollPage(WebElement toElement){
        	Actions ac= new Actions(driver);
        	ac.moveToElement(toElement).build().perform();
        	
        }
        
        public static void moveScroll(){
        	String js = "window.scrollTo(304,8)";
        	((JavascriptExecutor) driver).executeScript(js);
        }
        
        public static void moveScroll(String js){
        	((JavascriptExecutor) driver).executeScript(js);
        }
        
        
        public static void executeJS(String js){
        	((JavascriptExecutor) driver).executeScript(js);
        }
        
        public static Object executeJSToGetValue(String js, WebElement e){
        	return ((JavascriptExecutor) driver).executeScript(js,e);
        }
        
        public static Object executeJSToGetValue(String js){
        	if((js.indexOf("return ") == -1)){
        		js = "return "+js;
        	}
        	return ((JavascriptExecutor) driver).executeScript(js);
        }
        
        
        public static void clickMouse(){
        	Actions ac= new Actions(driver);
        	ac.click();
        	
        }
        
        public static void releasaeMouse(){
        	Actions ac= new Actions(driver);
        	ac.release();
        	
        }
        
        public static void keyUp(){
        	Actions ac= new Actions(driver);
        	ac.sendKeys(Keys.UP);
        	
        }
        public static void pageUp(){
        	Actions ac= new Actions(driver);
        	ac.sendKeys(Keys.PAGE_UP).perform();
        	
        }
        
        public static void pageDown(){
        	Actions ac= new Actions(driver);
        	ac.sendKeys(Keys.PAGE_DOWN).perform();
        	
        }
        
        public static void keyEnter(){
        	Actions ac= new Actions(driver);
        	ac.sendKeys(Keys.ENTER).perform();
        	
        }
        public static void refreshPage(){
        	driver.navigate().refresh();
        	
        }
        
        public static void holdOnElement(WebElement web){
        	Actions ac= new Actions(driver);
        	ac.clickAndHold(web);
        	
        }
        
        public static String getBrowserDateTime(){
        	Date date=new Date();
        	DateFormat format=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        	return format.format(date);
        	
        }
        
        
}