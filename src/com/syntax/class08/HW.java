package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {
	public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

	static void isEnabled(WebElement button) {
		if (button.isEnabled()) {
			System.out.println("The text box is enabled");
		} else {
			System.out.println("The text box is disabled");
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement checkBox = driver.findElement(By.xpath("//div[@id='checkbox']"));
		checkBox.click();
		WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
		removeButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		String text = driver.findElement(By.id("message")).getText();
		if (text.equals("It's gone!")) {
			System.out.println("The text is correct");
		} else {
			System.out.println("The text is not correct");
		}

		WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
		isEnabled(textBox);
		textBox.sendKeys("test message");
		WebElement disableButton = driver.findElement(By.xpath("//button[text()='Disable']"));
		disableButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		isEnabled(textBox);

	}
}
