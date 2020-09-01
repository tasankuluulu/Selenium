package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingAlerts {
	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement simpleAlertButton = driver.findElement(By.id("alert"));
		simpleAlertButton.click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		// handling simple Alert
		alert.accept();

		WebElement confirmAlert = driver.findElement(By.id("confirm"));
		confirmAlert.click();
		Thread.sleep(1000);
		String confirmAlertText = alert.getText();
		System.out.println(confirmAlertText);
		// handling confirmation Alert
		alert.dismiss();

		WebElement promptAlertButton = driver.findElement(By.id("prompt"));
		promptAlertButton.click();
		Thread.sleep(1000);
		alert.sendKeys("Syntax");
		alert.dismiss();

	}

}
