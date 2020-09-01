package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class usingXpath {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[starts-with(text(), 'Or')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(), 'Log')]")).click();
//		driver.findElement(By.xpath("//a[text()='Logout']")).click();
//		driver.quit();
	}

}
