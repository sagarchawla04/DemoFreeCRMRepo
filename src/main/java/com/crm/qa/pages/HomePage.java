package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//font[contains(text(),'User: Naveen K')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement Contactslink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newcontactlink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement Dealslink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement Taskslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifycorrectusername() {
		return usernameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() {
		Contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		Dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		Taskslink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action= new Actions(driver);
		action.moveToElement(Contactslink).build().perform();
		newcontactlink.click();
	}
	
	
	
	
}
