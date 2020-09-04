package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class OrangeHRMLeavePage extends BaseClass {

	@FindBy(id = "calFromDate")
	public WebElement fromCal;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	public WebElement fromMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	public WebElement fromYear;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	public List<WebElement> fromCalTable;

	@FindBy(id = "menu_leave_viewLeaveList")
	public WebElement leaveList;

	public OrangeHRMLeavePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
