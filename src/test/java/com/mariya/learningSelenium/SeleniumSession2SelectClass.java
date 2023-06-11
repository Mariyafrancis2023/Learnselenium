package com.mariya.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSession2SelectClass {

WebDriver wd;
	
	@BeforeMethod
	public void setUp() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=product/product&product_id=42");
//		wd.get("https://www.webroot.com/us/en/cart?key=206636B2-ACE5-4D15-B267-16EC7E08A593");
//		wd.findElement(By.id("onetrust-accept-btn-handler")).click();
		wd.manage().window().maximize();
	}
	
	@Test
	public void validateCountryFromDropDown() {
/*		WebElement selectCountry = wd.findElement(By.cssSelector("select[name='billing.country']"));
		Select sc = new Select(selectCountry);
		
		sc.selectByIndex(4);
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "United Kingdom", "United Kingdom is not selected");
		
		sc.selectByValue("DK");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Denmark", "Denmark is not selected");
		
		sc.selectByVisibleText("Italy");	
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Italy", "Italy is not selected");
*/
	
		WebElement selectColor = wd.findElement(By.cssSelector("#input-option217"));
		Select sc = new Select(selectColor);	
		sc.selectByIndex(4);
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Yellow (+$2.40)", "Yellow is not selected");
		sc.selectByValue("1");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Green (+$1.20)", "Green is not selected");
		sc.selectByVisibleText("Blue (+$3.60)");	
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "Blue (+$3.60)", "Blue is not selected");
	}
	
	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
