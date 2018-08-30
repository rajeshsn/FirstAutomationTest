package com.FreeCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.FreeCRM.base.TestBase;

public class ContactsPage extends TestBase {
	
@FindBy(xpath="//*[contains(text(),'Contacts')]")
	
	WebElement contactsLable;
	
    
 @FindBy(name="first_name")
	
	WebElement firstName;
 
 @FindBy(xpath="//input[@select='title')]")
	
	WebElement title;

 @FindBy(name="surname")
	
 	WebElement surName;
    
 @FindBy(name="mobile")
	
 	WebElement mobile;
 
 @FindBy(name="email")
	
	WebElement email;

 @FindBy(xpath="//input[@type='submit' and @value='Save']")
	
	WebElement saveBtn;
   
   
	public ContactsPage(){
		
		PageFactory.initElements(driver, this);;
	}
	
	
	
	public boolean validateContactsLabel(){
		
		return contactsLable.isDisplayed();
		
	}
	
	public void createNewContact(String tit,String ftName,String ltname,String mobi,String mail){
		
		Select select = new Select(driver.findElement(By.name("title")));
		
		select.selectByValue(tit);
		
		firstName.sendKeys(ftName);
		surName.sendKeys(ltname);
		mobile.sendKeys(mobi);
		email.sendKeys(mail);
		
		saveBtn.click();
		
			
		
		
	}

}
