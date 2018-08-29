package com.FreeCRM.pages;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.FreeCRM.base.TestBase;
import com.FreeCRM.util.TestUtil;

public class HomePage extends TestBase {
	

	@FindBy(xpath="//*[contains(text(),'User: Rajesh Negi')]")
	
	WebElement userNameLable;
	

	@FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=contact']")
	
	WebElement contactsLink;
	
    @FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=prospect']")
	
	WebElement DealsLink;
	
    @FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=contact&amp']")
	
	WebElement newContactLink;
    
    
	public HomePage(){
		
		PageFactory.initElements(driver, this);;
	}
	
	
	
	public boolean validateUser(){
		
		return userNameLable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		
		contactsLink.click();
		
		return new ContactsPage();
		
		
	}
	
public DealsPage clickOnDealsLink(){
	DealsLink.click();
	
	return new DealsPage();
	
		
	}

public String VerifyhomePageTitle(){
	
	return driver.getTitle();
	
	
		
	}

public void clickOnNewContactLink(){
	
	Actions action =new Actions(driver);
	
	action.moveToElement(contactsLink).build().perform();
	
	newContactLink.click();
	
	

	
}

	

}
