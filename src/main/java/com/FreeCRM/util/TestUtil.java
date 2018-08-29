package com.FreeCRM.util;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.FreeCRM.base.TestBase;

public class TestUtil extends TestBase {



//*****************SWITCH TO FRAME METHOD*******************************//
	
     public static void switchToFrame(){
		
		driver.switchTo().frame("mainpanel");
	}
	
//*****************To Find All Broken Links*******************************//	
	
	public static void brokenLink() throws MalformedURLException, IOException{
		
//1.--Get the list of links and images
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		
		linkslist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Total Links are -->" +linkslist.size());
		
		ArrayList<WebElement> activeLinks= new ArrayList<WebElement>();
		
		
		
//2.Iterate linklist ---To exclude all the links which don't have href attribute
		
		for (int i=0;i<=activeLinks.size();i++){
			
			
if(linkslist.get(i).getAttribute("href") !=null && (! linkslist.get(i).getAttribute("href").contains("javascript") &&(! linkslist.get(i).getAttribute("href").contains("#")))) 
{
				
        activeLinks.add(linkslist.get(i));
				
				
			}
		}
		
//3. Get the size of active links
		
		System.out.println("Active Links are -->" +activeLinks.size());
		
		
		
//4. check the href url , with httpconnection api
		
		for(int j=0;j<=activeLinks.size();j++){
			
		HttpsURLConnection	connection=(HttpsURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		
		connection.connect();
		
		String message =connection.getResponseMessage();
		
		connection.disconnect();
		
		System.out.println(activeLinks.get(j).getAttribute("href")+" `	------>" +message);
		
		
		}
		
		
			
	}
	
	
	
//*****************To TAKE SCREENSHOT********************************************************//	
	
public static void takeScreenShot() throws IOException{
		
File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(file, new File("C:\\Users\\Rajesh\\Desktop\\Assignment\\Framework\\FreeCRMAutomationTest\\Screenshot"+"---"+System.currentTimeMillis()+".png"));

	}

}
