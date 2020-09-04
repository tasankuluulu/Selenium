package com.syntax.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.syntax.pages.OrangeHRMLeavePage;
import com.syntax.pages.OrangeHRMLoginPage;
import com.syntax.pages.OrangeHRMMainPage;
import com.syntax.utils.BaseClass;

public class OrangeHRMLeavePageTest {
	OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage();
	OrangeHRMMainPage mainPage = new OrangeHRMMainPage();
	OrangeHRMLeavePage leavePage = new OrangeHRMLeavePage();

	@BeforeMethod
	public void setUp() {
		BaseClass.setUp("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Test
	public void leaveTest() {
		loginPage = new OrangeHRMLoginPage();
		mainPage = new OrangeHRMMainPage();
		leavePage = new OrangeHRMLeavePage();

		loginPage.username.sendKeys("Admin");
		loginPage.password.sendKeys("admin123");
		loginPage.login.click();

		mainPage.leave.click();
		leavePage.fromCal.click();

		Select monthDD = new Select(leavePage.fromMonth);
		monthDD.selectByVisibleText("Mar");

		Select yearDD = new Select(leavePage.fromYear);
		yearDD.selectByVisibleText("1984");

		for (WebElement day : leavePage.fromCalTable) {
			if (day.getText().equals("15")) {
				day.click();
			}
		}
	}

}
