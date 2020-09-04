package com.syntax.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syntax.pages.OrangeHRMEmpListPage;
import com.syntax.pages.OrangeHRMLoginPage;
import com.syntax.pages.OrangeHRMMainPage;
import com.syntax.utils.BaseClass;

public class OrangeHRMLoginTest {

	OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
	OrangeHRMMainPage mainPage = new OrangeHRMMainPage();
	OrangeHRMEmpListPage empPage = new OrangeHRMEmpListPage();

	@BeforeMethod
	public void setUp() {
		BaseClass.setUp("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

//	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}

	@Test
	public void loginTest() {
		loginPage = new OrangeHRMLoginPage();
		loginPage.username.sendKeys("Admin");
		loginPage.password.sendKeys("admin123");
		loginPage.login.click();

		mainPage = new OrangeHRMMainPage();
		mainPage.PIM.click();

		mainPage.empList.click();

		String[] headers = { "Id", "First (& Middle) Name", "Last Name", "Job Title", "Employment Status", "Sub Unit",
				"Supervisor" };
		empPage = new OrangeHRMEmpListPage();
		int i = 1;
		for (String header : headers) {
			if (header.equals(empPage.headerList.get(i).getText())) {
				System.out.println(header + " test pass");
			} else {
				System.out.println(header + " test fail");
			}
			i++;

		}

//		for (int j = 1; j < empPage.ids.size(); j++) {
//			String id = empPage.ids.get(j).getText();
//			if (id.equals("0071")) {
//				empPage.checkBoxes.get(j).click();
//				break;
//			}
//		}
//
//		empPage.delete.click();
//		empPage.ok.click();

		int count = 0;
		for (WebElement element : empPage.empStatus) {
			if (element.getText().equals("Full-Time Permanent")) {
				count += 1;
			}
		}
		System.out.println(count);

//		empPage.headerList.get(3).click();

//		WebDriverWait wait = BaseClass.setWait();
//		wait.until(ExpectedConditions.elementToBeClickable(mainPage.addEmp));
//		mainPage.addEmp.click();

	}

}
