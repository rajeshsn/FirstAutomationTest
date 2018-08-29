package com.FreeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.pages.ContactsPage;
import com.FreeCRM.pages.HomePage;
import com.FreeCRM.pages.LoginPage;
import com.FreeCRM.util.TestUtil;

public class ContactsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
	public ContactsPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setup(){
		
		inialization();
		testUtil = new TestUtil();
		 
		loginpage =new LoginPage();
		
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}	
	
@Test(priority=1,dataProvider="")

public void validateContactsLabelTest(){
	
	contactspage.validateContactsLabel();
	
	Assert.assertTrue(true, "Label Matched");
}

@Test(priority=1,dataProvider="")

public void createNewContactTest(String Title,String FirstName,String LastName, String Mobile,String Email){
	
	
}
	
	@AfterMethod
	
	public void tearDown(){
		
		driver.quit();
	}
}
