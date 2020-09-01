package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.className("button")).click();
//		System.out.println(driver.getTitle());

		String actualTitle = driver.getTitle();
		String expectedTitle = "Web Orders";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("This is the right title");
		} else {
			System.err.println("This is wrong title");
		}

		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
