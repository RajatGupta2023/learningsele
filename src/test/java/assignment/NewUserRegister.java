package assignment;

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

public class NewUserRegister {
	WebDriver driver;
	WebDriverWait wait;
	String uuid = UUID.randomUUID().toString();
	String randomEmail = uuid + "@gmail.com";

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Driver\\\\ChromeDriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void registerUser() {
		WebElement myAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));
		myAccount.click();
		WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Register']")));
		register.click();
		Assert.assertEquals(driver.getTitle(), "Register Account", "You are not on Register Account");
		WebElement firstName = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-firstname")));
		firstName.sendKeys("Rajat");
		WebElement lastName = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-lastname")));
		lastName.sendKeys("Jain");
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		email.sendKeys(randomEmail);
		WebElement telephone = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-telephone")));
		telephone.sendKeys("6476476478");
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		password.sendKeys("RamRam");
		WebElement passwordConfirmation = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-confirm")));
		passwordConfirmation.sendKeys("RamRam");
		WebElement polictBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='agree']")));
		polictBtn.click();
		WebElement continueBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Continue']")));
		continueBtn.submit();
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!", "You are not on correct page");
	}

	@Test(priority = 2)
	public void loginUser() {
		WebElement myAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));
		myAccount.click();
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));
		login.click();
		Assert.assertEquals(driver.getTitle(), "Account Login", "You are not on login page");
		WebElement inputEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		inputEmail.sendKeys(randomEmail);
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		password.sendKeys("RamRam");
		WebElement loginBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
		loginBtn.submit();
		Assert.assertEquals(driver.getTitle(), "My Account", "You are not on logged in page");

	}

	@Test(priority = 3)
	public void changePassword() {
		WebElement myAccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));
		myAccount.click();
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));
		login.click();
		Assert.assertEquals(driver.getTitle(), "Account Login", "You are not on login page");
		WebElement inputEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-email")));
		inputEmail.sendKeys(randomEmail);
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		password.sendKeys("RamRam");
		WebElement loginBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
		loginBtn.submit();
		Assert.assertEquals(driver.getTitle(), "My Account", "You are not on logged in page");
		WebElement changePasswordBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Change your password']")));
		changePasswordBtn.click();
		Assert.assertEquals(driver.getTitle(), "Change Password", "You are not on change password page");
		WebElement password1 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-password")));
		password1.sendKeys("RadheRadhe");
		WebElement passwordConfirmation = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#input-confirm")));
		passwordConfirmation.sendKeys("RadheRadhe");
		WebElement continueBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Continue']")));
		continueBtn.submit();
		WebElement passwordChangeConfirmationMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("#account-account>div:first-of-type")));
		String message = passwordChangeConfirmationMessage.getText();
		System.out.println(message);
		Assert.assertEquals(message, "Success: Your password has been successfully updated.");
//		boolean isMessageDislayed = passwordChangeConfirmationMessage.isDisplayed();
//		Assert.assertTrue(isMessageDislayed);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
