package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HRMPimPage extends BaseClass {

	@FindBy(xpath = "//input[@name='chkLogin']")
	public WebElement loginDetailsCheckbox;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "btnSave")
	public WebElement save;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement FullName;
	
	@FindBy(id = "re_password")
	public WebElement confirmPassword;

	public HRMPimPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
