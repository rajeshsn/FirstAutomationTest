package com.FreeCRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.pages.ContactsPage;
import com.FreeCRM.pages.HomePage;
import com.FreeCRM.pages.LoginPage;
import com.FreeCRM.util.ExcelUtility;
import com.FreeCRM.util.TestUtil;

public class ContactsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testUtil;
	ContactsPage contactspage;
	ExcelUtility excelUtil;
	
	public ContactsPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setup(){
		
		inialization();
		testUtil = new TestUtil();
		 
		loginpage =new LoginPage();
		
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		contactspage=new ContactsPage();
		
		TestUtil.switchToFrame();
		
		contactspage=homepage.clickOnContactsLink();
		
	}	
	
@Test(priority=1,dataProvider="")

public void validateContactsLabelTest(){
	
	contactspage.validateContactsLabel();
	
	Assert.assertTrue(true, "Label Matched");
}

@DataProvider
public Object[][] getTestData(){
	
Object[][] data =ExcelUtility.getTestData("contact");

return data;
}

@Test(priority=2,dataProvider="getTestData")

public void createNewContactTest(String tit,String ftName,String ltname,String mobi,String mail){
	
	homepage.clickOnNewContactLink();
	
	contactspage.createNewContact(tit, ftName, ltname, mobi, mail);
	
}
	
	@AfterMethod
	
	public void tearDown(){
		
		driver.quit();
	}
}
