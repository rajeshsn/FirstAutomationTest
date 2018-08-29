package com.FreeCRM.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.pages.HomePage;
import com.FreeCRM.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	HomePage homepage;
	
	
	public LoginPageTest(){
		
		super();
	}
	
	
	@BeforeMethod
	
	public void setup(){
		
		inialization();
		
		 loginpage =new LoginPage();
		
	}
	
@Test(priority=1)
	
	public void validateLoginPageTitleTest(){
		
		String title =loginpage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	
@Test(priority=2)
	
	public void validateLoginPageLogoTest(){
		
	boolean flag=loginpage.validateFreeCrmLogo();
	
	Assert.assertTrue(flag);
		
		
	}
	
	
	@Test(priority=3)
	
	public void loginTest(){
		
	homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
			
		
	}
	
	@AfterMethod
	
	public void tearDown(){
		
		
		driver.quit();
	}

}
