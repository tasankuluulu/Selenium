package com.syntax.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syntax.pages.HRMLoginPage;
import com.syntax.utils.BaseClass;

public class LoginTest {
	HRMLoginPage loginPage = new HRMLoginPage();

	@BeforeMethod
	public void setUp() {
		BaseClass.setUp("http://166.62.36.207/humanresources/symfony/web/index");

	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}

	@Test
	public void emptyPassword() throws InterruptedException {
		loginPage = new HRMLoginPage();
		loginPage.username.sendKeys("Admin");
		loginPage.login.click();
		Assert.assertEquals(loginPage.errorMsg.getText(), loginPage.expectedErrorMsg_1);
	}

	@Test
	public void empty() {
		loginPage = new HRMLoginPage();
		loginPage.login.click();
		Assert.assertEquals(loginPage.errorMsg.getText(), loginPage.expectedErrorMsg_2);
	}

	@Test
	public void invalidPassword() {
		loginPage = new HRMLoginPage();
		loginPage.username.sendKeys("Admin");
		loginPage.password.sendKeys("123");
		loginPage.login.click();
		Assert.assertEquals(loginPage.errorMsg.getText(), loginPage.expectedErrorMsg_3);

	}

}
