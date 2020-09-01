package com.syntax.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassTask {

	public static String url = "https://www.facebook.com/r.php";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement monthDD = driver.findElement(By.id("month"));
		Select select = new Select(monthDD);
		List<WebElement> monthList = select.getOptions();
		Iterator<WebElement> it = monthList.iterator();
		while (it.hasNext()) {
			WebElement element = it.next();
			String text = element.getText();
			if (text.equals("Dec")) {
				System.out.println(true);
				break;

			}
		}

		WebElement dayDD = driver.findElement(By.id("day"));
		Select selectDay = new Select(dayDD);
		List<WebElement> dayList = selectDay.getOptions();
		Iterator<WebElement> it1 = dayList.iterator();
		while (it1.hasNext()) {
			WebElement element = it1.next();
			String text = element.getText();
			if (text.equals("12")) {
				System.out.println(true);
				break;
			}
		}
		
		WebElement yearDD = driver.findElement(By.id("year"));
		Select selectYear = new Select(yearDD);
		
	}

}
