package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HRMLoginPage extends BaseClass {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement login;
	
	@FindBy(id = "spanMessage")
	public WebElement errorMsg;
	
	public String expectedErrorMsg_1 = "Password cannot be empty";
	public String expectedErrorMsg_2 = "Username cannot be empty";
	public String expectedErrorMsg_3 = "Invalid credentials";

	public HRMLoginPage() {
		PageFactory.initElements(driver, this);
	}

}
