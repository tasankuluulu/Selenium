package com.syntax.class11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW {
	public static WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://uitestpractice.com/Students/Index");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

//	@Test
	public void ajaxCall() {
		driver.findElement(By.xpath("//a[text()='AjaxCall']")).click();
		driver.findElement(By.xpath("//a[text()='This is a Ajax link']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement textBlock = driver.findElement(By.xpath(
				"//p[contains(text(), 'Selenium is a portable software testing framework for web applications')]"));
		wait.until(ExpectedConditions.visibilityOf(textBlock));
		Assert.assertTrue(textBlock.isDisplayed());
	}

	@Test
	public void controls() throws InterruptedException {
		driver.findElement(By.linkText("Controls")).click();
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		WebElement droppableText = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		String expectedText = "Dropped!";
		String actualText = droppableText.getText();
		softAssertion.assertEquals(actualText, expectedText);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@name='dblClick']"));
		wait.until(ExpectedConditions.elementToBeClickable(doubleClickBtn));
		action.doubleClick(doubleClickBtn).perform();
		Alert alert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		String expectedAlertText = "Double Clicked !!";
		alert.accept();
		softAssertion.assertEquals(alertText, expectedAlertText);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("name")).sendKeys("Taalaibek");
		Thread.sleep(2000);
		String expectedIframeText = "Taalaibek";
		String actualIframeText = driver.findElement(By.xpath("//label[contains(text(),'Enter your name:')]/following-sibling::input")).getText();
		driver.switchTo().defaultContent();

		softAssertion.assertEquals(actualIframeText, expectedIframeText);

		softAssertion.assertAll();

	}

}
