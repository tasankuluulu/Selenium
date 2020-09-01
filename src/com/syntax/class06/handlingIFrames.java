package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingIFrames {
	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("Batch 7");
		driver.switchTo().defaultContent();

		WebElement clickOnLinkText = driver.findElement(By.xpath("//h3[text()='click on the below link: ']"));
		String text = clickOnLinkText.getText();
		System.out.println(text);

		driver.switchTo().frame("iframe_a");
		textBox.clear();
		textBox.sendKeys("Syntax");
		driver.switchTo().defaultContent();

		WebElement iFrame = driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
		driver.switchTo().frame(iFrame);
		textBox.clear();
		textBox.sendKeys("Wassup");
	}
}
