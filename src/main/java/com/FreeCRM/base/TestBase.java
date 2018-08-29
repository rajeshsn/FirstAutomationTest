package com.FreeCRM.base;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.FreeCRM.util.WebEventListener;



public class TestBase {
	
 public static  WebDriver driver;
public static  Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
 
 public  TestBase(){
	 
	 prop = new Properties();
	 
	 try{
	 FileInputStream file = new FileInputStream("C:\\Users\\Rajesh\\Desktop\\Assignment\\Framework\\FreeCRMAutomationTest\\src\\main\\java\\com\\FreeCRM\\config\\config.properties");
	 prop.load(file);
	 
	 }catch(FileNotFoundException e){
		 
		 System.out.println(e);
		 
	 }catch(Exception e){
		 
		 System.out.println(e);	
		 }
		 
	 
 }
 
 public static void inialization(){
	 
	String browserName= prop.getProperty("browser");
	 
	 if(browserName.equals("chrome")){
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajesh\\Desktop\\Assignment\\chromedriver_win32\\chromedriver.exe");

driver=new ChromeDriver();

	 }else if (browserName.equals("firefox")){
		 
		 System.setProperty("webdriver.firefox.driver", "C:\\Users\\Rajesh\\Desktop\\Assignment\\geckodriver-v0.20.1-win32\\gecodriver.exe");

		 driver=new FirefoxDriver();
		 
	 }
	 
	 e_driver=new EventFiringWebDriver(driver);
	 //Now create object of EventListenerHandler to register it with EventFiringWebDriver
	 
	 eventListener=new WebEventListener();
	 
	 e_driver.register(eventListener);
	 
	 driver=e_driver;
	 
	
	 driver.manage().window().maximize();
	 
	 driver.manage().deleteAllCookies();
	 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

     driver.get(prop.getProperty("url"));

				 
	 
 }
 
 

}
