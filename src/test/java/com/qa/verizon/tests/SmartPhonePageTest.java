package com.qa.verizon.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.SmartPhonePage;
import com.qa.verizon.pages.VerizonMainPage;
import com.qa.verizon.utilities.Constants;

public class SmartPhonePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	VerizonMainPage verizonMainPage;
	SmartPhonePage smartPhonePage;
	
	@BeforeTest
	public  void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		verizonMainPage =new VerizonMainPage(driver);
		smartPhonePage = verizonMainPage.clickSmarthPhone();
	}
	@Test(priority=1)
	public void verifySmartPhonePageTitle() {
		String title = smartPhonePage.getSmartPhonePageTitle();
		System.out.println("smartphone page title: " + title);
		Assert.assertEquals(title, Constants.SMARTPHONE_PAGE_TITLE);
	}
		
	@Test(priority=2)
	public void  SelectSmartPhone() {
	smartPhonePage.SelectPhone();
	
   }
	
	@AfterTest
	 public void tearDown() {
		driver.quit();
	}


}












