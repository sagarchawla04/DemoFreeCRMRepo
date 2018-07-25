package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil= new TestUtil();
		contactspage= new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitletest() {
		String title= homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		testutil.switchtoFrame();
		Assert.assertTrue(homepage.verifycorrectusername());
		
	}
	
	@Test(priority=3)
	public void verifycontactslinkTest() {
		testutil.switchtoFrame();
		contactspage= homepage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
