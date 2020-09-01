package com.syntax.class11;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

//	@Test
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
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();
		String expectedAlertText = "Double Clicked !!";
		alert.accept();
		softAssertion.assertEquals(alertText, expectedAlertText);

		WebElement newTabBtn = driver.findElement(By.xpath("//a[contains(text(),'Visit uitest practice')]"));
		wait.until(ExpectedConditions.elementToBeClickable(newTabBtn));
		newTabBtn.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String mainPageHandle = it.next();
		String childPageHandle = it.next();
		driver.switchTo().window(childPageHandle);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(mainPageHandle);
		softAssertion.assertTrue(!driver.getWindowHandles().contains(childPageHandle));

		WebElement videoBtn = driver.findElement(By.linkText("Click here to watch videos on C#"));
		videoBtn.click();
		handles = driver.getWindowHandles();
		while (it.hasNext()) {
			childPageHandle = it.next();
			if (!mainPageHandle.equals(childPageHandle)) {
				driver.switchTo().window(childPageHandle);
				break;
			}
		}
		driver.switchTo().window(mainPageHandle);
		softAssertion.assertTrue(!driver.getWindowHandles().contains(childPageHandle));

		softAssertion.assertAll();

	}

//	@Test
	public void iframe() {
		driver.findElement(By.linkText("Controls")).click();
		WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("name")).sendKeys("TestName");
		String expectedIframeText = "TestName";
		String actualIframeText = driver
				.findElement(By.xpath("//label[contains(text(),'Enter your name')]/following-sibling::input"))
				.getText();
		driver.switchTo().defaultContent();

		Assert.assertEquals(actualIframeText, expectedIframeText);
	}

//	@Test
	public void widgets() {
		driver.findElement(By.linkText("Widgets")).click();
		driver.findElement(By.id("image_file")).sendKeys("C:\\Users\\cutte\\Desktop\\1.txt");
		WebElement upload = driver.findElement(By.xpath("//input[@value='Upload']"));
		upload.click();
		WebElement notification = driver.findElement(By.xpath("//p[contains(text(), 'File Successfully Uploaded')]"));
		String actualNotifText = notification.getText();
		String expectedNotifText = "File Successfully Uploaded";
		softAssertion.assertEquals(actualNotifText, expectedNotifText);

		WebElement imageDownload = driver.findElement(By.linkText("Download a image"));
		imageDownload.sendKeys("C:\\Users\\cutte\\Desktop\\Images\\021709017434.1.jpg");

		softAssertion.assertAll();
	}

	@Test
	public void form() throws InterruptedException {

		WebElement formLink = driver.findElement(By.linkText("Form"));
		formLink.click();

		driver.findElement(By.id("firstname")).sendKeys("Ivan");
		driver.findElement(By.id("lastname")).sendKeys("Ivanov");

		List<WebElement> elements = driver.findElements(By.xpath("//label[@class='radio-inline']"));
		for (WebElement element : elements) {
			if (element.getText().toLowerCase().equals("married")) {
				element.click();
				break;
			}
		}

		List<WebElement> checkboxes = driver.findElements(By.xpath("//label[@class='checkbox-inline']"));
		for (WebElement checkbox : checkboxes) {
			if (checkbox.getText().equalsIgnoreCase("reading")) {
				checkbox.click();
			}
		}

		WebElement countriesDD = driver.findElement(By.id("sel1"));
		Select select = new Select(countriesDD);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equalsIgnoreCase("Denmark")) {
				options.get(i).click();
			}
		}

		WebElement cal = driver.findElement(By.id("datepicker"));
		cal.click();

		Select monthDD = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		monthDD.selectByVisibleText("Oct");

		Select yearDD = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		yearDD.selectByVisibleText("1984");

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement date : dates) {
			if (date.getText().equals("15")) {
				date.click();
			}
		}

		WebElement phoneNumber = driver.findElement(By.id("phonenumber"));
		phoneNumber.sendKeys("9734201546");

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tasankuluulu");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("test@gmail.com");

		WebElement comment = driver.findElement(By.id("comment"));
		comment.sendKeys("bla bla bla");

		WebElement password = driver.findElement(By.id("pwd"));
		password.sendKeys("1234567");
		Thread.sleep(2000);

		WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-default ']"));
		submit.click();

	}

}
