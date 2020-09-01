package com.syntax.class10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {
	public static String url = "https://artoftesting.com/samplesiteforselenium";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		WebElement link = driver.findElement(By.linkText("This is a link"));
		link.click();
		Set<String> windowsID = driver.getWindowHandles();
		Iterator<String> it = windowsID.iterator();
		String mainPageID = it.next();
		String secondPageID = it.next();
		driver.switchTo().window(secondPageID);
		driver.close();
		driver.switchTo().window(mainPageID);
		WebElement textBox = driver.findElement(By.id("fname"));
		textBox.sendKeys("test");
		WebElement submit = driver.findElement(By.id("idOfButton"));
		submit.click();
		WebElement dblClickButton = driver.findElement(By.xpath("//button[@id='dblClkBtn']"));
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(dblClickButton));
		action.doubleClick(dblClickButton).perform();

//		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='gender']"));
		for (WebElement radioButton : radioButtons) {
			if (radioButton.getAttribute("value").equals("male") && radioButton.isDisplayed()) {
				radioButton.click();
			}

		}
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.getAttribute("class").equals("Automation")) {
				checkBox.click();
			}
		}
		WebElement dd = driver.findElement(By.id("testingDropdown"));
		Select select = new Select(dd);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			if (option.getAttribute("value").equals("Database")) {
				option.click();
			}
		}
		WebElement alertBoxButton = driver.findElement(By.xpath("//button[text()='Generate Alert Box']"));
		alertBoxButton.click();
		driver.switchTo().alert();

		alert.accept();
		System.out.println("1st alert handled");
		driver.switchTo().defaultContent();
		WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));
		confirmButton.click();
		driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		System.out.println("2nd alert handled");
		driver.navigate().refresh();
		WebElement draggable = driver.findElement(By.id("sourceImage"));
		WebElement droppable = driver.findElement(By.id("targetDiv"));
		action.dragAndDrop(draggable, droppable).perform();

	}

}
