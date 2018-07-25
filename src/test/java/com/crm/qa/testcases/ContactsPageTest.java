package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	public String sheetname="contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage= new LoginPage();
		testutil= new TestUtil();
		contactspage= new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoFrame();
		contactspage=homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactspage.verifyContactslabel(), "Contacts label is missing from the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException {
		contactspage.SelectContactsByName("Cena Sharma");
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getContactsTestData() {
		Object[][] data=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=4, dataProvider="getContactsTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(title, firstname, lastname, company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
