package com.syntax.class09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingPagination2 {
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/talaf/eclipse-workspace/SeleniumJavaBatch7/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();
		WebElement pim = driver.findElement(By.linkText("PIM"));
		pim.click();
		Thread.sleep(2000);
		WebElement addEmployee = driver.findElement(By.linkText("Add Employee"));
		addEmployee.click();
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("abu");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("abu");
		WebElement employeeID = driver.findElement(By.id("employeeId"));
		String empID = employeeID.getAttribute("value");

		WebElement save = driver.findElement(By.id("btnSave"));
		WebElement employeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
		employeeList.click();
		Thread.sleep(2000);
		WebElement sortByName = driver.findElement(By.xpath("//a[contains(text(), 'First ')]"));
		sortByName.click();
		Thread.sleep(2000);
		boolean flag = true;
		while (flag) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++) {
				String rowText = rows.get(i).getText();
				if (rowText.contains(empID)) {
					flag = false;
					WebElement checkBox = driver
							.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]"));
					checkBox.click();
					WebElement delete = driver.findElement(By.id("btnDelete"));
					delete.click();
					WebElement ok = driver.findElement(By.id("dialogDeleteBtn"));
					ok.click();
					System.out.println("The user deleted");
					break;
				}
			}
			WebElement next = driver.findElement(By.linkText("Next"));
			next.click();
		}

	}

}
