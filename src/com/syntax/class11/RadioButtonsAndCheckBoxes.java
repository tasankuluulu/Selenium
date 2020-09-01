package com.syntax.class11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsAndCheckBoxes {
	public static String url = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();

		// 1. find the locator of requested button and click on it
		// 2. use findElements() to save all options as List of webelements and
		// select requested

		WebElement femaleBtn = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
		System.out.println("Is female button selected - " + femaleBtn.isSelected());
		Thread.sleep(3000);
		femaleBtn.click();
		WebElement checkBtn = driver.findElement(By.id("buttoncheck"));
		checkBtn.click();

		WebElement msg = driver.findElement(By.cssSelector("p.radiobutton"));
		String msgText = msg.getText();
		if (msgText.contains("Female")) {
			System.out.println("Female button selection test PASS");
		} else {
			System.out.println("Female button selection test FAIL");
		}

		// 2nd way --> use findElements and save WebElements of all options into a List

		List<WebElement> genderBtns = driver.findElements(By.xpath("//input[@name='optradio']"));

		for (WebElement btn : genderBtns) {
			btn.click();
			checkBtn.click();
			msgText = msg.getText();
			String buttonText = btn.getAttribute("value");
			if(msgText.contains(btn.getAttribute("value"))) {
				System.out.println(buttonText + " selection test PASS");
			} else {
				System.out.println(buttonText + " selection FAIL");
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}

}
