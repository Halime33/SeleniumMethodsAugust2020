package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.utilities.ElementUtil;

public class FeaturesPage extends BasePage{

		
		WebDriver driver;
		ElementUtil elementUtil;
		
		By color = By.xpath("//div[@style='background-color: rgb(0, 73, 83);']");
		By size = By.xpath("//p[contains(text(), '512GB')]");
		By price = By.xpath("//span[text()='$1449.99']");
		By continuebtn = By.id("ATC-Btn");
		By zipcode = By.id("zipcode");
		By confirmLocation = By.xpath("//button[@type='submit']");
		By newCustomer = By.xpath("//button[@aria-label='New Customer']");
		
		public FeaturesPage(WebDriver driver) {
			this.driver=driver;
			elementUtil = new ElementUtil(driver);
		}
		
		public String getFeaturesPageTitle() {
			return elementUtil.doGetPageTitle();
		}
		
		public CartPage SelectFeatures(String zip) {
			elementUtil.waitForElementPresent(color);
			elementUtil.doClick(color);
			elementUtil.doClick(size);
			elementUtil.doClick(price);
			elementUtil.doClick(continuebtn);
			elementUtil.waitForElementPresent(zipcode);
			elementUtil.doSendKeys(zipcode, zip);
			elementUtil.doClick(confirmLocation);
			elementUtil.doClick(newCustomer);
			
			return new CartPage(driver);
		
	}

}
