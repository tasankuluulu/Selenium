package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCSSAndXpath {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a#btn_basic_example")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text() = 'Simple Form Demo'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder^='Please enter']")).sendKeys("test mesaage");
		driver.findElement(By.cssSelector("button[onclick^='show']")).click();
		driver.findElement(By.cssSelector("input[id='sum1']")).sendKeys("25");
		driver.findElement(By.cssSelector("input#sum2")).sendKeys("32");
		driver.findElement(By.xpath("//button[text() ='Get Total']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
