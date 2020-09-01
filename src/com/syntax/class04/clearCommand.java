package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class clearCommand {

	public static String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fdefault.aspx";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		WebElement userNameTextBox = driver.findElement(By.xpath("//input[@type='text']"));
		userNameTextBox.sendKeys("Tester");

		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
		passwordTextBox.sendKeys("test");

		Thread.sleep(2000);

//		userNameTextBox.clear();
//		passwordTextBox.clear();

		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginButton.click();
		WebElement logo = driver.findElement(By.xpath("//h1[text() = 'Web Orders']"));

		if (logo.isDisplayed()) {
			String logoText = logo.getText();
			if (logoText.equals("Web Orders")) {
				System.out.println("This is the right logo");
			} else {
				System.out.println("This is the wrong logo");
			}
		}

	}

}
