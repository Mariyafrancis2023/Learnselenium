package com.mariya.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSession_iframes {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/frames");
		wd.manage().window().maximize();
	}

	@Test
	public void validateIframes() {
		wd.switchTo().frame("frame1"); // switching to iframe using id
		WebElement textOnIframe1 = wd.findElement(By.id("sampleHeading"));
		String getTextOnIframe1 = textOnIframe1.getText();
		System.out.println(getTextOnIframe1);
		wd.switchTo().defaultContent(); // switching back to main page
		System.out.println(wd.getTitle());
		
		wd.switchTo().frame("frame2"); // switching to next iframe using id
		WebElement textOnIframe2 = wd.findElement(By.id("sampleHeading"));
		String getTextOnIframe2 = textOnIframe2.getText();
		System.out.println(getTextOnIframe2);
		wd.switchTo().defaultContent(); // switching back to main page
		System.out.println(wd.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
