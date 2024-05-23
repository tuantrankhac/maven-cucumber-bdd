package pageObjects.nopCom;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCom.LoginPageUI;


public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isMessageInvalidPasswordDisplayed() {
		waitForElementVisible(driver, LoginPageUI.ERROR_LOGIN_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.ERROR_LOGIN_MESSAGE);
	}

	public void refreshPage() {
		refreshCurrentPage(driver);
	}

	public HomePageObject goToHomePage() {
		waitForElementClickable(driver, LoginPageUI.HOME_PAGE_LINK);
		clickToElement(driver, LoginPageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}