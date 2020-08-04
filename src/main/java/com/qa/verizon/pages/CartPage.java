package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.utilities.ElementUtil;

public class CartPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By Iphone = By.xpath("//span[text()='iPhone® 11 Pro Max']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public String getCartPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public String getPhoneType() {
		return elementUtil.doGetText(Iphone);

}
}