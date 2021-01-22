package com.syntax.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/talaf/eclipse-workspace/Selenium/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public static WebDriverWait setWait() {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		return wait;
	}

}
