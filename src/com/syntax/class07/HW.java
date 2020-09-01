package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	public static String url = "https://demoqa.com/browser-windows";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		String mainPageHandle = driver.getWindowHandle();
		System.out.println(mainPageHandle);
		driver.manage().window().maximize();
		driver.findElement(By.id("tabButton")).click();
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("messageWindowButton")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		it.next();
		System.out.println(driver.switchTo().window(it.next()).getWindowHandle());
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		System.out.println(driver.findElement(By.id("sampleHeading")).getText());

//		while(it.hasNext()) {
//			String childPageHandle = driver.getWindowHandle();
//			if(!childPageHandle.equals(mainPageHandle)) {
//				driver.switchTo().window(childPageHandle);
//				
//			}
//		}

//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement tab1 = driver.findElement(By.id("sampleHeading"));
//		System.out.println(driver.getWindowHandle());
//		System.out.println(tab1.getText());
	}
}
