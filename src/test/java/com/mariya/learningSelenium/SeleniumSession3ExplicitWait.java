package com.mariya.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSession3ExplicitWait {
	
	WebDriver wd;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wait = new WebDriverWait(wd,10);
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		wd.manage().window().maximize();
	}
	
	@Test 
	public void validateBannerPresent() {
		WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact Us']")));
		contactUs.click();
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "Contact Us", "You are on wrong page");
		
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-name")));
		firstNameInput.sendKeys("Tony");
		
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-email")));
		emailInput.sendKeys("tony@email.com");
		
		WebElement enquiryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-enquiry")));
		enquiryInput.sendKeys("return policy enquiry request");
		
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("input[type='submit']"))));
		submitButton.click();
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "Contact Us", "You are on wrong page");
		
		WebElement textBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Your enquiry has been successfully sent to the store owner!']")));
		String getTextBanner = textBanner.getText();
		System.out.println(getTextBanner);
		Assert.assertEquals(getTextBanner, "Your enquiry has been successfully sent to the store owner!", "no text banner found");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
