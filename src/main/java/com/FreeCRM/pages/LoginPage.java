package com.FreeCRM.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.FreeCRM.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@type='submit']")
	
	//@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/index.html']")
	
	WebElement loginPagelogo;
	
   @FindBy(xpath="//a[@href='https://www.freecrm.com/register/']")
	
	WebElement SignUpLink;
	
	
  public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public  String validateLoginPageTitle(){
		
		return driver.getTitle();
		
		}
	
	
public  boolean validateFreeCrmLogo(){
		
	return loginPagelogo.isDisplayed();
		
		}
	
	
public HomePage Login(String un, String pwd){
	username.sendKeys(un);
	password.sendKeys(pwd);
	
	//WebDriverWait wait2 = new WebDriverWait(driver, 20);
	//wait2.until(ExpectedConditions.elementToBeClickable(loginBtn));

	
	//Actions action = new Actions(driver);
	
	//action.moveToElement(loginBtn).build().perform();
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", loginBtn);
		
	//loginBtn.click();
	
	return new HomePage();
		
		}


public  SignUpPage clickOnSignUpLink(){

SignUpLink.click();

return new SignUpPage();
	
	}

		
	

}
