package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.AddEmployeePUI;

public class AddEmployeePO extends BasePage{
	WebDriver driver;

	public AddEmployeePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateLoginDetailButton() {
		waitForElementClickable(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_BUTTON);
		clickToElement(driver, AddEmployeePUI.CREATE_LOGIN_DETAIL_BUTTON);
	}

	
}