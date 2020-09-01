package com.syntax.class01;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		Thread.sleep(2000);
//		driver.navigate().to("http://facebook.com");
//		driver.navigate().back();
//		driver.navigate().forward();
//		
//		driver.quit();
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.close();
		// driver.manage().window().fullscreen();
	}

}
