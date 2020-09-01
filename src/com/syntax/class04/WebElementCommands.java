package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {

	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		WebElement ageRadioBtn = driver.findElement(By.xpath("//input[@value = '0 - 5']"));
		boolean isDisplayed = ageRadioBtn.isDisplayed();
		boolean isEnabled = ageRadioBtn.isEnabled();
		System.out.println(isEnabled);
		System.out.println(isDisplayed);

		System.out.println("Before clicking " + ageRadioBtn.isSelected());
		ageRadioBtn.click();
		System.out.println("After clicking " + ageRadioBtn.isSelected());

	}

}
