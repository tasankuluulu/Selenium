package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW1 {

	public static String url = "https://www.facebook.com/r.php";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement firstName = driver.findElement(By.xpath("//input[@name = 'firstname']"));
		firstName.sendKeys("Ivan");

		WebElement lastName = driver.findElement(By.xpath("//input[@name = 'lastname']"));
		lastName.sendKeys("Ivanov");

		driver.findElement(By.id("u_0_s")).sendKeys("test@gmail.com");

		driver.findElement(By.id("u_0_v")).sendKeys("test@gmail.com");

		driver.findElement(By.id("password_step_input")).sendKeys("qwe123!@#");

		WebElement monthDD = driver.findElement(By.id("month"));

		Select selectMonth = new Select(monthDD);
		selectMonth.selectByValue("10");

		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByValue("15");

		WebElement yearDD = driver.findElement(By.id("year"));
		Select selectYear = new Select(yearDD);
		selectYear.selectByVisibleText("1984");

		driver.findElement(By.id("u_0_7")).click();

		driver.findElement(By.id("u_0_14")).click();

	}

}
