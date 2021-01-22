package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class OrangeHRMLoginPage extends BaseClass {

	@FindBy(id = "txtUsername")
	public WebElement username;
	
	@FindBy(id = "txtPassword")
	public WebElement password;
	
	@FindBy(id = "btnLogin")
	public WebElement login;

	public OrangeHRMLoginPage() {
		PageFactory.initElements(driver, this);
	}

}
