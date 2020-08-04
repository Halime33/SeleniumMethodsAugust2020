package com.qa.verizon.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.CartPage;
import com.qa.verizon.pages.FeaturesPage;
import com.qa.verizon.pages.SmartPhonePage;
import com.qa.verizon.pages.VerizonMainPage;
import com.qa.verizon.utilities.Constants;


public class CartPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	SmartPhonePage smartPhonePage;
	FeaturesPage featuresPage;
	CartPage cartPage;
	
	@BeforeTest
	public void setUp() {
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName =prop.getProperty("browser");
	driver = basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	verizonMainPage = new VerizonMainPage(driver);
	featuresPage = verizonMainPage.clickSmarthPhone().SelectPhone();
	cartPage = featuresPage.SelectFeatures(prop.getProperty("zipcode"));
	
	}
	@Test(priority=1)
	public void verifyCartPageTitle() {
		String title = cartPage.getCartPageTitle();
		System.out.println("cart page title: " +title);
		Assert.assertEquals(title, Constants.CART_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifyCorrectPhone() {
		String PhoneName = cartPage.getPhoneType();
		System.out.println("in the cart phone name is: " + PhoneName);
		Assert.assertEquals(PhoneName, Constants.PHONE_NAME);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
		
	
		
	
}	
