package com.mariya.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumSession2 {
	
	WebDriver wd;
	
	@BeforeMethod
	public void setUp() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		wd.manage().window().maximize();
	}

	@Test
	public void checkIsButtonEnabled() {
		WebElement continueButton = wd.findElement(By.cssSelector("input[value='Continue']"));
		boolean isButtonEnabled = continueButton.isEnabled();
		System.out.println(isButtonEnabled);
		Assert.assertTrue(isButtonEnabled, "Continue button is not enabled");
	}
	
	@Test
	public void checkClearOption() {
		WebElement firstNameInput = wd.findElement(By.cssSelector("#input-firstname"));
		firstNameInput.sendKeys("abcd");
		firstNameInput.clear();
		WebElement lastNameInput = wd.findElement(By.cssSelector("#input-lastname"));
		lastNameInput.sendKeys("efghij");
		lastNameInput.clear();
	}
	
	@Test
	public void checkIsRadioButtonSelected() {
		WebElement radioButtonYes = wd.findElement(By.xpath("(//input[@type='radio'])[2]"));
		boolean isYesRadioButtonSelected = radioButtonYes.isSelected();
		System.out.println(isYesRadioButtonSelected);
		Assert.assertFalse(isYesRadioButtonSelected, "radio button Yes is selected");
	}
	
	@Test
	public void validateTextLabel() {
		WebElement getHeadingLabel = wd.findElement(By.tagName("h1"));
		String getHeadingText = getHeadingLabel.getText();
		System.out.println(getHeadingText);
		Assert.assertEquals(getHeadingText, "Register Account", "incorrect heading found");
		
		WebElement getSubscribeLabel = wd.findElement(By.xpath("//label[text()='Subscribe']"));
		String getSubscribeText = getSubscribeLabel.getText();
		System.out.println(getSubscribeText);
		Assert.assertEquals(getSubscribeText, "Subscribe", "incorrect text found");
	}
	
	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
