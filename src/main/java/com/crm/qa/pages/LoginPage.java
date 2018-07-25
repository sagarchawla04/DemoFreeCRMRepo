package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory- OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignupButton;
	
	@FindBy(xpath="//img[contains(@alt,'free crm logo')]")
	WebElement CRMLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String ValidateLoginPagetitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateCRMImage() {
		return CRMLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pw);
		Thread.sleep(5000);
		LoginButton.click();
		
		return new HomePage();
	}
	
	


}
