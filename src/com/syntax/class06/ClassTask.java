package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask {
	public static String url = "http://166.62.36.207/syntaxpractice/bootstrap-iframe.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.switchTo().frame("FrameOne");
		Thread.sleep(1000);
		WebElement logo = driver.findElement(By.xpath("//img[@src='img/Syntax.png']"));
		System.out.println(logo.isDisplayed());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("FrameTwo");
		Thread.sleep(1000);
		WebElement buttom = driver.findElement(By.xpath("//a[@class='enroll-btn']"));
		System.out.println(buttom.isEnabled());
	}
}
