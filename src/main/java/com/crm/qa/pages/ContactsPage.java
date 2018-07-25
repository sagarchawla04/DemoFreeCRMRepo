package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Load From Company']//following::input[@value='Save']")
	WebElement saveButton;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	} 
	
	public boolean verifyContactslabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void SelectContactsByName(String contactname) {
			driver.findElement(By.xpath("//a[text()='"+contactname+"']//parent::td//preceding-sibling::td")).click();
			
	}
	
	public void createNewContact(String title, String fname, String lname, String companyname) {
		Select selecttitle= new Select(driver.findElement(By.name("title")));
		selecttitle.selectByVisibleText(title);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(companyname);
		saveButton.click();
		System.out.println("dsfdsfds");
	}
		
	
	
	
	
}
