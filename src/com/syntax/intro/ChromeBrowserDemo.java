package com.syntax.intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDemo {

	public static void main(String[] args) {

		// 1. set a system property
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\talaf\\eclipse-workspace\\SeleniumJavaBatch7\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxtechs.com");
	}

}
