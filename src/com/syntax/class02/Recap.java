package com.syntax.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recap {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equalsIgnoreCase("Facebook - Log In or Sign Up")) {
			System.out.println("The title is correct");
		} else {
			System.out.println("The title is wrong");
		}
		Thread.sleep(2000);
		driver.close();

	}
}
