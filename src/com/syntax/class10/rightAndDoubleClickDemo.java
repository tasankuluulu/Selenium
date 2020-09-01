package com.syntax.class10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class rightAndDoubleClickDemo {

	public static String url = "http://demo.guru99.com/test/simple_context_menu.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClickButton).perform();
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		action.click(edit).perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement doubleClickButton = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		action.doubleClick(doubleClickButton).perform();
		System.out.println(alert.getText());
		alert.accept();

	}

}
