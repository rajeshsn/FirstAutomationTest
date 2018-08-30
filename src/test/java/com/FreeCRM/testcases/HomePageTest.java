package com.FreeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.pages.HomePage;
import com.FreeCRM.pages.LoginPage;
import com.FreeCRM.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
   
	
	public HomePageTest(){
		
		super();
	}
	

	@BeforeMethod
	
	public void setup() throws InterruptedException{
		
		inialization();
		testUtil = new TestUtil();
		 
		loginpage =new LoginPage();
		
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		 
}

	@Test(priority=1)
	
	public void validateUserNameLabelTest(){
		
         TestUtil.switchToFrame();
		Assert.assertTrue(homepage.validateUser());
		
	}
	
	@Test(priority=2)
	
	public void VerifyHomePageTitleTest(){
		
        String homepagetitle=homepage.VerifyhomePageTitle();
		Assert.assertEquals(homepagetitle, "#1 Free CRM software in the cloud for sales and service", "title not matched");
		
	}
	
	@Test(priority=3)
	
	public void VerifyContactLinkTest(){
		TestUtil.switchToFrame();
		
        homepage.clickOnContactsLink();
         
     Assert.assertTrue(true);
		
	}
	
@Test(priority=4)
	
	public void VerifyDealsLinkTest(){
	TestUtil.switchToFrame();
		
        homepage.clickOnDealsLink();
         
     Assert.assertTrue(true);
		
	}
		
	
	
	@AfterMethod
	
	public void tearDown(){
		
		driver.quit();
	}
}