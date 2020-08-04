package com.qa.verizon.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.VerizonMainPage;
import com.qa.verizon.utilities.Constants;



public class VerizonMainPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	VerizonMainPage verizonMainPage;
	
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		verizonMainPage = new VerizonMainPage(driver);
	}
	
	 @Test(priority =1)
	 public void verifyVerizonHomePageTitleTest() {
		String title = verizonMainPage.getVerizonHomePageTitle();
		System.out.println("verizon homepage title: " + title);
		Assert.assertEquals(title, Constants.VERIZON_MAIN_PAGE_TITLE);
	}
	
	 @Test(priority =2)
	 public void  clickSmartPhoneTest() {
	 verizonMainPage.clickSmarthPhone();
		
	}
	
	 @AfterTest
	 public void tearDown() {
		driver.quit();
	}
	
}












