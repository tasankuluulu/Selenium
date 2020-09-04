package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class OrangeHRMMainPage extends BaseClass {

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement empList;
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement leave;

	public OrangeHRMMainPage() {
		PageFactory.initElements(driver, this);
	}

}
