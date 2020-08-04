package com.qa.verizon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	public static boolean highlightElement;
	
	
	public WebDriver init_driver(String browserName) {
		
	//	highlightElement = prop.getProperty("highlight").equals("yes") ? true : false;
		
		System.out.println("Browser name is: "+ browserName);
	
		 
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();	
				
		
		}	
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
		
		
		}
		else if(browserName.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}else {
			System.out.println("Browser name "+ browserName + "is not found, please pass the correct browser");	
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	public Properties init_properties() {
		
		prop = new Properties();
		
		String path = "/Users/halime/eclipse-workspace1/Verizon_POM/"
					+ "src/main/java/com/qa/verizon/config/config.properties"; //ondeki kisim public oldugu icin sildik
		              
		
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties...Please correct your config...");
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		return prop;
		
	}
}