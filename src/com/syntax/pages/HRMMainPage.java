package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HRMMainPage extends BaseClass {
	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmpBtn;

	public HRMMainPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
