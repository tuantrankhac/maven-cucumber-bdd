
package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.BasePageUI;
import pageUIs.hrm.MyInfoPUI;

public class MyInfoPO extends BasePage{
	WebDriver driver;

	public MyInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePhotoImage() {
		waitForElementClickable(driver, MyInfoPUI.AVATAR_IMAGE);
		clickToElement(driver, MyInfoPUI.AVATAR_IMAGE);
		waitForElementInvisible(driver, BasePageUI.LOADING_ICON);
	}
	
	public void openTabAtSideBarByName(String tabname) {
		waitForElementClickable(driver, MyInfoPUI.TAB_LINK_AT_SIDEBAR, tabname);
		clickToElement(driver, MyInfoPUI.TAB_LINK_AT_SIDEBAR, tabname);
		waitForElementInvisible(driver, BasePageUI.LOADING_ICON);
	}

	
	
}
