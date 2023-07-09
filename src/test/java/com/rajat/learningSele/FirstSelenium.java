package com.rajat.learningSele;

import java.util.UUID;


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

public class FirstSelenium {
	WebDriver driver;
	WebDriverWait wait;
	String uuid = UUID.randomUUID().toString();
    String randomEmail = uuid + "@gmail.com";

	@BeforeMethod
	public void setUp() {
		// Basic Setup
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, 10);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}

	@Test (priority = 1)
	public void registerUser() {

		WebElement firstName = driver.findElement(By.cssSelector("#input-firstname"));
		wait.until(ExpectedConditions.visibilityOf(firstName));
		WebElement lastName = driver.findElement(By.cssSelector("#input-lastname"));
		wait.until(ExpectedConditions.visibilityOf(lastName));;
		WebElement email = driver.findElement(By.cssSelector("#input-email"));
		wait.until(ExpectedConditions.visibilityOf(email));
		WebElement telephone = driver.findElement(By.cssSelector("#input-telephone"));
		wait.until(ExpectedConditions.visibilityOf(telephone));
		WebElement password = driver.findElement(By.cssSelector("#input-password"));
		wait.until(ExpectedConditions.visibilityOf(password));
		WebElement passwordConfirmation = driver.findElement(By.cssSelector("#input-confirm"));
		wait.until(ExpectedConditions.visibilityOf(passwordConfirmation));
		WebElement subscribeNo = driver.findElement(By.cssSelector("input[value = '0'] "));
		wait.until(ExpectedConditions.visibilityOf(subscribeNo));
		WebElement agreePrivacyPolicy = driver.findElement(By.cssSelector("input[name='agree'] "));
		wait.until(ExpectedConditions.visibilityOf(agreePrivacyPolicy));
		WebElement continueClick = driver.findElement(By.cssSelector("input[value='Continue']  "));
		wait.until(ExpectedConditions.visibilityOf(continueClick));
		firstName.sendKeys("Rajat");
		lastName.sendKeys("Jain");
		email.sendKeys(randomEmail);
		telephone.sendKeys("1234567890");
		password.sendKeys("munnibadnam");
		passwordConfirmation.sendKeys("munnibadnam");
		wait.until(ExpectedConditions.elementToBeClickable(subscribeNo));
		subscribeNo.click();
		wait.until(ExpectedConditions.elementToBeClickable(agreePrivacyPolicy));
		agreePrivacyPolicy.click();
		wait.until(ExpectedConditions.elementToBeClickable(continueClick));
		continueClick.click();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!", "You are not on Correct Page");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test (priority = 2)
	public void loginUser() {
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Login']"));
		inputEmail.sendKeys(randomEmail);
		inputPassword.sendKeys("munnibadnam");
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "My Account", "You are not on Correct Page");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test (priority = 3)
	public void changePassword() {
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement inputEmail = driver.findElement(By.cssSelector("#input-email"));
		WebElement inputPassword = driver.findElement(By.cssSelector("#input-password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Login']"));
		inputEmail.sendKeys(randomEmail);
		inputPassword.sendKeys("munnibadnam");
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.submit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/account");
		WebElement changePasswordBtn = driver.findElement(By.cssSelector("#content>ul li:nth-of-type(2)>a"));
		changePasswordBtn.click();
		WebElement inputPassword1 = driver.findElement(By.cssSelector("#input-password"));
		WebElement inputPasswordConfirm = driver.findElement(By.cssSelector("#input-confirm"));
		WebElement continueBtn = driver.findElement(By.cssSelector("input[value='Continue']"));
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));

		inputPassword1.sendKeys("RadheRadhe");
		inputPasswordConfirm.sendKeys("RadheRadhe");
		//wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement passwordChangeConfirmationMessage = driver.findElement(By.cssSelector("input[value='Continue']"));
		boolean isPasswordChanged = passwordChangeConfirmationMessage.isDisplayed();
		Assert.assertTrue(isPasswordChanged);
	}

	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
