package com.qa.verizon.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.FeaturesPage;
import com.qa.verizon.pages.SmartPhonePage;
import com.qa.verizon.pages.VerizonMainPage;
import com.qa.verizon.utilities.Constants;


public class FeaturesPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	SmartPhonePage smartPhonePage;
	FeaturesPage featuresPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName =prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		verizonMainPage = new VerizonMainPage(driver);
		//smartPhonePage = verizonMainPage.clickSmarthPhone();
		//featuresPage = smartPhonePage.SelectPhone();	
		featuresPage = verizonMainPage.clickSmarthPhone().SelectPhone();
	}
	@Test(priority=1)
	public void verifyFeaturesPageTitle() {
		String title = featuresPage.getFeaturesPageTitle();
		System.out.println("features page title: " + title);
		Assert.assertEquals(title, Constants.FEATURES_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void selectPhoneFeatures() {
		featuresPage.SelectFeatures(prop.getProperty("zipcode"));
  
}
	@AfterTest
  public void tearDown() {
	  driver.quit();
  }
	
	
	
}
