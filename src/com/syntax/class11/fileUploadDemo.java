package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUploadDemo {
	public static String url = "https://the-internet.herokuapp.com/";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement fileUpload = driver.findElement(By.linkText("File Upload"));
		fileUpload.click();
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		chooseFile.sendKeys("C:\\Users\\talaf\\Desktop\\TCID004.xlsx");
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();
		
	}

}
