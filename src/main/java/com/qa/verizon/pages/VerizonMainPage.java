package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.utilities.Constants;
import com.qa.verizon.utilities.ElementUtil;

public class VerizonMainPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
//	By header = By.xpath("//a[@class='logoWhiteBg']");
	By phones = By.xpath("//button[contains(text(),'Phones list')]");
	By smartphone = By.id("thirdLevel00") ;

	public VerizonMainPage(WebDriver driver) {
		this.driver =driver;
		elementUtil =new ElementUtil(driver);
	}
	public String getVerizonHomePageTitle() {
		elementUtil.waitForTitlePresent(Constants.VERIZON_MAIN_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
//	public String getHomePageHeader() {
//	return elementUtil.doGetText(header);
//	}
	public SmartPhonePage clickSmarthPhone() {
		elementUtil.waitForElementPresent(phones);
		elementUtil.moveToElement(phones);
		elementUtil.waitForElementPresent(smartphone);
		elementUtil.doClick(smartphone);
		
		return new SmartPhonePage(driver);
	}
	






}
    
