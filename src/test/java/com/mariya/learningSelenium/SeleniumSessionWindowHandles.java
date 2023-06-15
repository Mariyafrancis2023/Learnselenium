package com.mariya.learningSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSessionWindowHandles {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://demoqa.com/browser-windows");
		wd.manage().window().maximize();
	}

	@Test
	public void validateWindowHandles() {
		String parentHandle = wd.getWindowHandle(); //get the window handles of parent tab/current or active window
		WebElement tabButton = wd.findElement(By.cssSelector("#tabButton"));
		tabButton.click();
		tabButton.click();
		Set<String> allWindowHandles = wd.getWindowHandles(); //get the window handles of all opened tabs
		List<String> allWindowList = new ArrayList<>(allWindowHandles); //create list to store window handles
		String thirdTab = allWindowList.get(2);
		wd.switchTo().window(thirdTab);
		WebElement childTabText = wd.findElement(By.id("sampleHeading"));
		System.out.println(childTabText.getText());
		wd.switchTo().window(parentHandle);
		System.out.println(wd.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
