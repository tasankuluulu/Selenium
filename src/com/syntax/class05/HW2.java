package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {

	public static String url = "http://ebay.com";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement categories = driver.findElement(By.id("gh-cat"));
		Select select = new Select(categories);
		List<WebElement> categoriesList = select.getOptions();
		for (int i = 0; i < categoriesList.size(); i++) {
			System.out.println(categoriesList.get(i).getText());
		}

		select.selectByVisibleText("Computers/Tablets & Networking");
		driver.findElement(By.id("gh-btn")).click();

		String expectedText = "Computers, Tablets & Network Hardware";
		String actualText = driver.findElement(By.xpath("//span[@class='b-pageheader__text']")).getText();
		if (actualText.equals(expectedText)) {
			System.out.println("The text is correct");
		} else {
			System.err.println("The text is incorrect");
		}

	}

}
