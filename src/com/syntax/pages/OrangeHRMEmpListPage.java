package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class OrangeHRMEmpListPage extends BaseClass {

	@FindBy(id = "resultTable")
	public WebElement empList;

	@FindBy(xpath = "//table[@id='resultTable']/thead/tr/th")
	public List<WebElement> headerList;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]")
	public List<WebElement> ids;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[1]")
	public List<WebElement> checkBoxes;

	@FindBy(id = "btnDelete")
	public WebElement delete;
	
	@FindBy(id = "dialogDeleteBtn")
	public WebElement ok;
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[6]")
	public List<WebElement> empStatus;

	public OrangeHRMEmpListPage() {
		PageFactory.initElements(driver, this);
	}

}
