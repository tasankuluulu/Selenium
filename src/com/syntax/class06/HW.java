package com.syntax.class06;

import java.awt.Window;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static String url = "http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000);
		alert.accept();

		driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
		Thread.sleep(1000);
		alert.sendKeys("Taalai");
		alert.accept();
		Thread.sleep(1000);

	}

}
