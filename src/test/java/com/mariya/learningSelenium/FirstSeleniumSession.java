package com.mariya.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumSession {

		WebDriver wd;
		
	@BeforeMethod
	public void setUp() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		wd.manage().window().maximize();
	}
	
	@Test
	public void validateLogin() {	
		WebElement emailInput = wd.findElement(By.id("input-email"));
		WebElement passwordInput = wd.findElement(By.id("input-password"));
		WebElement loginButton = wd.findElement(By.cssSelector("input[value='Login']"));
		/*
		WebElement emailInput = wd.findElement(By.cssSelector("#input-email"));
		WebElement emailInput = wd.findElement(By.cssSelector("input[name='email']"));
		WebElement emailInput = wd.findElement(By.xpath("//input[@id='input-email']"));
		WebElement emailInput = wd.findElement(By.xpath("//input[contains(@name,'mail')]"));
		
		WebElement passwordInput = wd.findElement(By.cssSelector("#input-password"));
		WebElement passwordInput = wd.findElement(By.cssSelector("#input[name='password']"));	
		WebElement passwordInput = wd.findElement(By.xpath("//input[@id='input-password']"));
		WebElement passwordInput = wd.findElement(By.xpath("//input[starts-with(@name,'pass')]"));
		
		WebElement loginButton = wd.findElement(By.cssSelector("input.btn"));	
		WebElement loginButton = wd.findElement(By.xpath("//input[@value='Login']"));	
		*/
		
		emailInput.sendKeys("tony@email.com");
		passwordInput.sendKeys("Password1");
//		loginButton.click();
		loginButton.submit();
		
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "My Account", "wrong page");
	}
	
	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
