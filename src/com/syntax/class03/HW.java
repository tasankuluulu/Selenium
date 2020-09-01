package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='btn_basic_example']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Proceed Next'])[1]")).click();
	}

}
