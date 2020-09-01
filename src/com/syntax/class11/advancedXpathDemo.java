package com.syntax.class11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class advancedXpathDemo {
	public static String url = "https://the-internet.herokuapp.com/";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		/** Advanced xpath is based on parent and child, sibling relationships
		 * 
		 * example: identifying the element by its following sibling
		 * //label[@id='nav-search-label']//following-sibling::input
		 * 
		 * example: identifying the element by its proceeding sibling
		 * //span[text()='& Orders']/preceding-sibling::span
		 * 
		 * example: using parent
		 * //span[text()='& Orders']/parent::a
		 * //input[@id='calFromDate']/parent::li
		 * 
		 * example: using ancestor
		 * //input[@id='calFromDate']/ancestor::form
		 * //input[@name='actionID']/parent::form/preceding-sibling::div/ancestor::div
		 * 
		 * //input[@id='calFromDate']/parent::li
		 * 
		 * example: using before sibling of the parent
		 * //span[text()='Username']/parent::div/preceding-sibling::div
		 * //input[@name='actionID']/parent::form/preceding-sibling::div
		 * 
		 * <li> --> list
		 * <ol> --> ordered list
		 * <ul> --> unordered list
		 * <div> --> division
		 * <img> --> image
		 * <p> --> paragraph
		 * <h> --> header
		 * <th> --> table header
		 */
		
	}

}
