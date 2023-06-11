package com.mariya.learningSelenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSession3ImplicitWait {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test 
	public void validateBannerPresent() {
		WebElement contactUs = wd.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUs.click();
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "Contact Us", "You are on wrong page");
		
		WebElement firstNameInput = wd.findElement(By.cssSelector("#input-name"));
		firstNameInput.sendKeys("Tony");
		
		WebElement emailInput = wd.findElement(By.cssSelector("#input-email"));
		emailInput.sendKeys("tony@email.com");
		
		WebElement enquiryInput = wd.findElement(By.cssSelector("#input-enquiry"));
		enquiryInput.sendKeys("return policy enquiry request");
		
		WebElement submitButton = wd.findElement(By.cssSelector("input[type='submit']"));
		submitButton.click();
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "Contact Us", "You are on wrong page");
		
		WebElement textBanner = wd.findElement(By.xpath("//p[text()='Your enquiry has been successfully sent to the store owner!']"));
		String getTextBanner = textBanner.getText();
		System.out.println(getTextBanner);
		Assert.assertEquals(getTextBanner, "Your enquiry has been successfully sent to the store owner!", "no text banner found");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
