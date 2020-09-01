package com.syntax.class10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class workingWithKeys {
	public static String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fdefault.aspx";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
		WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
		WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
		username.sendKeys("Tester", Keys.TAB);
		password.sendKeys("test", Keys.ENTER);
//		loginButton.click();
	}
}
