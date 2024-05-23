package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.LoginPUI;

public class LoginPO extends BasePage{
	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	
}