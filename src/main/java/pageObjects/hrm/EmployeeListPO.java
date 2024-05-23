package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.BasePageUI;
import pageUIs.hrm.EmployeeListPUI;

public class EmployeeListPO extends BasePage{
	WebDriver driver;

	public EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}

	public AddEmployeePO clickToAddButton() {
		waitForElementClickable(driver, EmployeeListPUI.ADD_NEW_EMPLOYEE_BUTTON);
		clickToElement(driver, EmployeeListPUI.ADD_NEW_EMPLOYEE_BUTTON);	
		return PageGenerator.getAddEmployeePage(driver);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, EmployeeListPUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListPUI.SEARCH_BUTTON);
		waitForElementInvisible(driver, BasePageUI.LOADING_ICON);
	}

	
}