package com.syntax.class11;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassTask {
	public static String url = "https://www.ebay.com/";

	public static void main(String[] args) throws InterruptedException {
		// dropdown --> a menu with more than one options and in which we can

		// how to handle dropdowns
		// 1. select class --> if the tagname is select
		// 2. findElements()

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// 2. we need to find locator of dropdown --> select tag
		WebElement departments = driver.findElement(By.id("gh-cat"));
		Select depSelect = new Select(departments);

		// getOptions() --> returns all available options inside a list<webelement>
		List<WebElement> options = depSelect.getOptions();
		System.out.println(options.size());
		Iterator<WebElement> it = options.iterator();
		while (it.hasNext()) {
			WebElement option = it.next();
			System.out.println(option.getText());
		}
		Thread.sleep(2000);
		depSelect.selectByIndex(10);
		Thread.sleep(2000);
		// select by value
		depSelect.selectByValue("293"); // value of the value attribute
		Thread.sleep(2000);
		depSelect.selectByVisibleText("DVDs & Movies");
		Thread.sleep(2000);
		driver.quit();

	}

}
