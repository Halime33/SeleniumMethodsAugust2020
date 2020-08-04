package com.qa.verizon.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.utilities.Constants;
import com.qa.verizon.utilities.ElementUtil;

public class SmartPhonePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By IphoneMax = By.xpath("//a[@aria-label='Apple iPhone 11 Pro Max']");
	
	
	public SmartPhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	public String getSmartPhonePageTitle() {
		elementUtil.waitForTitlePresent(Constants.SMARTPHONE_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	
	}
	
	public FeaturesPage SelectPhone() {
		elementUtil.waitForElementPresent(IphoneMax);
		elementUtil.doClick(IphoneMax);
		
		return new FeaturesPage(driver);
	}

}
