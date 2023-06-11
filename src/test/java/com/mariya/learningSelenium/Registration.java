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


public class Registration {

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
	public void validateAccountRegistration() {
		WebElement myAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));
		myAccountLink.click();
		
		WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Register']")));
		registerLink.click();
		
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "Register Account", "You are on wrong page");
		
		WebElement firstNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-firstname")));
		firstNameInput.sendKeys("Tom");
		
		WebElement lastNameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-lastname")));
		lastNameInput.sendKeys("Steve");
		
		WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		emailInput.sendKeys("stevetom2@email.com");
		
		WebElement numberInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-telephone")));
		numberInput.sendKeys("9876543210");
		
		WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		passwordInput.sendKeys("Tomsteve1");
		
		WebElement passwordConfirmInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-confirm")));
		passwordConfirmInput.sendKeys("Tomsteve1");
		
		WebElement privacyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
		privacyCheckbox.click();
		
		WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='Continue']")));
		continueButton.submit();
		
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "Your Account Has Been Created!", "You are on wrong page");
	
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Continue']")));
		continueBtn.click();
	}
	
	@Test
	public void validateLogin() {
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		emailInput.sendKeys("stevetom2@email.com");
		
		WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		passwordInput.sendKeys("Tomsteve1");
		
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
		loginButton.click();
		
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "My Account", "You are on wrong page");
		
		WebElement changePassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Change your password']")));
		changePassword.click();
		
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "Change Password", "You are on wrong page");
		
		WebElement newPasswordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		newPasswordInput.sendKeys("Tomsteve2");
		
		WebElement confirmNewPasswordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-confirm")));
		confirmNewPasswordInput.sendKeys("Tomsteve2");
		
		WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Continue']")));
		continueBtn.click();
		
		WebElement textBanner = wd.findElement(By.cssSelector("div.alert-success"));
		String getTextBanner = textBanner.getText();
		System.out.println(getTextBanner);
		Assert.assertEquals(getTextBanner,"Success: Your password has been successfully updated.", "no banner has been displayed");
	}
	
	@Test
	public void validateRelogin() {
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		emailInput.sendKeys("stevetom2@email.com");
		
		WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		passwordInput.sendKeys("Tomsteve2");
		
		WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
		continueButton.click();
		
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(), "My Account", "You are on wrong page");
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}
}
