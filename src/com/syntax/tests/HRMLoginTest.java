package com.syntax.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.HRMLoginPage;
import com.syntax.pages.HRMMainPage;
import com.syntax.pages.HRMPimPage;
import com.syntax.utils.BaseClass;

public class HRMLoginTest {
	HRMLoginPage loginPage = new HRMLoginPage();
	HRMMainPage mainPage = new HRMMainPage();
	HRMPimPage pimPage = new HRMPimPage();

	@BeforeMethod
	public void setUp() {
		BaseClass.setUp("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}
	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}
	@Test(dataProvider = "setData", groups = "smoke")
	public void loginTests(String firstName, String lastName, String userName, String password) {
		loginPage = new HRMLoginPage();
		mainPage = new HRMMainPage();
		pimPage = new HRMPimPage();

		loginPage.username.sendKeys("Admin");
		loginPage.password.sendKeys("Hum@nhrm123");
		loginPage.login.click();
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.PIM));
		mainPage.PIM.click();
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.addEmpBtn));
		mainPage.addEmpBtn.click();
		pimPage.firstName.sendKeys(firstName);
		pimPage.lastName.sendKeys(lastName);
		pimPage.loginDetailsCheckbox.click();
		pimPage.username.sendKeys(userName);
		pimPage.password.sendKeys(password);
		pimPage.confirmPassword.sendKeys(password);
		pimPage.save.click();

		String actualFullName = pimPage.FullName.getText();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile,
					new File("C:\\Users\\talaf\\eclipse-workspace\\Selenium\\Screenshots\\" + firstName + "Login.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(actualFullName, firstName + " " + lastName);

	}
	@DataProvider
	public String[][] setData() {
		String[][] data = { { "name1", "lastName1", "emp#1", "MNBlkj098)(*" },
				{ "name2", "lastName2", "emp#2", "MNBlkj098)(*" }, { "name3", "lastName3", "emp#3", "MNBlkj098)(*" },
				{ "name4", "lastName4", "emp#4", "MNBlkj098)(*" }, { "name5", "lastName5", "emp#5", "MNBlkj098)(*" }, };
		return data;
	}
}
