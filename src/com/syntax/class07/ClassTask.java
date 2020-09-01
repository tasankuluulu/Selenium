package com.syntax.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask {
	public static String url = "http://www.uitestpractice.com/Students/Contact";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("This is a Ajax link")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
		WebElement paragraph = driver.findElement(By.className("ContactUs"));
		String text = paragraph.getText();
		System.out.println(text);
	}
}
