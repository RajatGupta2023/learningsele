package com.rajat.learningSele;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NaveenAutomation {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// Basic Setup
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();

	}

	 @Test
	    public void validateImageSlideShow() {
	        WebElement image1 = driver.findElement(By.cssSelector("div#slideshow0 >div>div.swiper-slide-duplicate-prev"));
	        wait.until(ExpectedConditions.visibilityOf(image1));
	        int initialPosition = image1.getLocation().getX();
	        System.out.println("Initial position: " + initialPosition);

	        // Perform actions that trigger the slideshow (e.g., wait, click, etc.)

	        WebElement image1AfterSlide = driver.findElement(By.cssSelector("div#slideshow0 >div>div.swiper-slide-duplicate-prev"));
	        int finalPosition = image1AfterSlide.getLocation().getX();
	        System.out.println("Final position: " + finalPosition);

	        // Check if the slideshow has moved (i.e., sliding occurred)
	        if (initialPosition != finalPosition) {
	            System.out.println("The slideshow is working.");
	        } else {
	            System.out.println("The slideshow is not working.");
	        }
	        driver.quit();
	    }
//	@Test
//	public void checkContactUs() {
//		WebElement contactUs = driver.findElement(By.xpath("//a[text() = 'Contact Us']"));
//		wait.until(ExpectedConditions.elementToBeClickable(contactUs));
//		contactUs.click();
//		WebElement name = driver.findElement(By.cssSelector("#input-name"));
//		wait.until(ExpectedConditions.visibilityOf(name));
//		name.sendKeys("Rajat Jain");
//		WebElement email = driver.findElement(By.cssSelector("#input-email"));
//		wait.until(ExpectedConditions.visibilityOf(email));
//		email.sendKeys("jainrajat@gmail.com");
//		WebElement inputEnquiry = driver.findElement(By.cssSelector("#input-enquiry"));
//		wait.until(ExpectedConditions.visibilityOf(inputEnquiry));
//		inputEnquiry.sendKeys("Sending an input Enquiry");
//		WebElement submit = driver.findElement(By.cssSelector("input[value ='Submit']"));
//		wait.until(ExpectedConditions.elementToBeClickable(submit));
//		submit.click();
//		WebElement confirmationMessage = driver.findElement(By.cssSelector("#content>p"));
//		boolean confirmationMessageIsDisplayed = confirmationMessage.isDisplayed();
//		Assert.assertTrue(confirmationMessageIsDisplayed);
//		
//	}
	 
	 
}
