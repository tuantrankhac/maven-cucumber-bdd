package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGenerator;
import pageObjects.nopCom.PageGeneratorManager;
import pageUIs.hrm.BasePageUI;
import pageUIs.nopCom.UserBasePageUI;

public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
//		Alert alert = waitForAlertPresence(driver);
//		alert.accept();
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			System.out.println(id);
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}	
	}
	
	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(tabTitle)) {
				break;
			}
		}		
	}
	
	public void closeTabWithoutParent(WebDriver driver, String parentId) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			if(!id.equals(parentId)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentId);
		}
	}
	
	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	private WebElement getWebElement(WebDriver driver, String xpathLocator, String...params) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	private String getDynamicLocator(String xpathLocator, String... params) {
		return String.format(xpathLocator, (Object[])params);
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	
  	public void clickToElement(WebDriver driver, String xpathLocator, String... params) {
		getWebElement(driver, getDynamicLocator(xpathLocator, params)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		getWebElement(driver, xpathLocator).clear();
		getWebElement(driver, xpathLocator).sendKeys(textValue);
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue, String... params ) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		getWebElement(driver, xpathLocator).clear();
		getWebElement(driver, xpathLocator).sendKeys(textValue);
	}
	
	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	public String getElementText(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).getText();
	}
	
	public void selectDropdownByText(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));	
		select.selectByVisibleText(textItem);
	}
	
	public void selectDropdownByText(WebDriver driver, String xpathLocator, String textItem, String...params) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		Select select = new Select(getWebElement(driver, xpathLocator));	
		select.selectByVisibleText(textItem);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));	
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedItemDropdown(WebDriver driver, String xpathLocator) {
		select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedItemDropdown(WebDriver driver, String xpathLocator, String...params) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
		
	}
	
	public String getSelectedValueInDropdownByID(WebDriver driver, String dropdownID) {
		waitForElementClickable(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
		return getSelectedItemDropdown(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
	}
	
 	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(2);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
					sleepInSecond(2);
					item.click();
					break;
				}
			}	
	}
	
	public String getElementAttribute(WebDriver driver, String xpathLocator ,String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String xpathLocator ,String attributeName, String...params) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}
	
	public int getElementSize(WebDriver driver, String xpathLocator, String...params) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		return getListWebElement(driver, xpathLocator).size();
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		try {
			return getWebElement(driver, xpathLocator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... params) {
		try {
			return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String xpathLocator) {
		System.out.println("Start time = " + new Date().toString());
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, xpathLocator);
		overrideGlobalTimeout(driver, longTimeout);
		
		if(elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		}else if(elements.size() > 0 && !elements.get(0).isDisplayed()){
			System.out.println("Element in DOM but not visible on UI");
			System.out.println("End time = " + new Date().toString());
			return true;
		}else {
			System.out.println("Element in DOM and visible on UI");
			return false;
		}
	}
	
	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean isElementEnabled(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, String xpathLocator, String...params) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicLocator(xpathLocator, params))).perform();
	}
	
	public void hightlightElement(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
    	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
        sleepInSecond(3);
    }

    public void pressKeyToElement(WebDriver driver, String xpathLocator, Keys key){
    	action = new Actions(driver);
    	action.sendKeys(getWebElement(driver, xpathLocator), key).perform();
    }
    
    public void pressKeyToElement(WebDriver driver, String xpathLocator, Keys key, String...params){
    	action = new Actions(driver);
    	xpathLocator = getDynamicLocator(xpathLocator, params);
    	action.sendKeys(getWebElement(driver, xpathLocator), key).perform();
    }
    
    public void scrollToElementOnTopByJS(WebDriver driver, String xpathLocator) {
    	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String xpathLocator) {
    	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
    	jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String xpathLocator, String attributeName, String attributeValue) {
    	jsExecutor = (JavascriptExecutor) driver;
    	jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, xpathLocator));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
    	jsExecutor = (JavascriptExecutor) driver;
    	jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
    	jsExecutor = (JavascriptExecutor) driver;
    	jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, xpathLocator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String xpathLocator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, xpathLocator));
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        return (boolean) jsExecutor.executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getWebElement(driver, xpathLocator));
    }
	
    public boolean isJQueryAjaxLoadedSuccess(WebDriver driver) {
    	explicitWait = new WebDriverWait(driver, longTimeout);
    	jsExecutor = (JavascriptExecutor) driver;
    	ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		return explicitWait.until(jQueryLoad);
    }
    
 	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout* 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathLocator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(xpathLocator, params))));
	}
		
	
	

	
	
	//HRM - Menu
	public void openMenuPage(WebDriver driver, String menuName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
	}
	
	///SubMenu
	public void openSingleSubMenuPage(WebDriver driver, String menuName, String subMenuName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		
		waitForElementClickable(driver, BasePageUI.DYNAMIC_SINGLE_SUBMENU_PAGE, subMenuName);
		clickToElement(driver, BasePageUI.DYNAMIC_SINGLE_SUBMENU_PAGE, subMenuName);
	}
	
	public void openMultiSubMenuPage(WebDriver driver, String menuName, String subMenuName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MULTI_SUBMENU_PAGE, subMenuName);
		clickToElement(driver, BasePageUI.DYNAMIC_MULTI_SUBMENU_PAGE, subMenuName);
	}
	
	//ChildSubMenu
	public void openChildSubMenuPage(WebDriver driver, String menuName, String subMenuName, String childSubMenuName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MULTI_SUBMENU_PAGE, subMenuName);
		clickToElement(driver, BasePageUI.DYNAMIC_MULTI_SUBMENU_PAGE, subMenuName);
		
		waitForElementClickable(driver, BasePageUI.DYNAMIC_CHILDSUBMENU_PAGE, childSubMenuName);
		clickToElement(driver, BasePageUI.DYNAMIC_CHILDSUBMENU_PAGE, childSubMenuName);
	
	}
	
	//Textbox in Add Employee Form
	public void enterEmployeeTextboxByName(WebDriver driver, String nameTextbox, String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_NAME, nameTextbox);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_NAME, textValue, nameTextbox);
	}
	
	//Textbox in Login Form
	public void enterLoginTextboxByName(WebDriver driver, String nameTextbox, String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_LOGIN_TEXTBOX_BY_NAME, nameTextbox);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_LOGIN_TEXTBOX_BY_NAME, textValue, nameTextbox);
	}
		
	public DashboardPO loginToSystem(WebDriver driver, String userTextbox, String passwordTextbox, String userName, String password) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_LOGIN_TEXTBOX_BY_NAME, userTextbox);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_LOGIN_TEXTBOX_BY_NAME, userName, userTextbox);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_LOGIN_TEXTBOX_BY_NAME, password, passwordTextbox);
		clickToElement(driver, BasePageUI.LOGIN_BUTTON);
		return PageGenerator.getDashboardPage(driver);
	}
	
	//Create Login Details Textbox
	public void enterCreateLoginDetailsTextboxByText(WebDriver driver, String textValue, String textInput) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_CREATE_LOGIN_DETAIL_TEXTBOX_BY_TEXT, textValue);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_CREATE_LOGIN_DETAIL_TEXTBOX_BY_TEXT, textInput, textValue);
	}
	
	
	/**
	 * Get textbox value by name
	 * @param driver
	 * @param textboxName
	 * @return
	 */
	public String getTextboxValueByName(WebDriver driver, String textboxName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		return getElementAttribute(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_NAME, "value", textboxName);
	}
	
	//Radio button
	public void selectRadioButtonByValue(WebDriver driver, String value) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, value);
		clickToElement(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, value);
	}
	
	//Search textbox
	public void enterSeachTextboxByFieldName(WebDriver driver, String nameField, String value) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_SEARCH_TEXTBOX_BY_NAME, nameField);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_SEARCH_TEXTBOX_BY_NAME, value, nameField);
	}
	
	public String getValueInTableIDAtColumnNameAndRowIndex(WebDriver driver, String tableID, String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageUI.TABLE_HEADER_BY_ID_AND_NAME, tableID, headerName) + 1;
		waitForElementVisible(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
		
		return getElementText(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String xpathLocator) {
		if(!isElementSelected(driver, xpathLocator)) {
			getWebElement(driver, xpathLocator).click();
		}
	}
	
	public boolean isRadioButtonSelectedByValue(WebDriver driver, String value) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, value);
		return isElementSelected(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_VALUE, value);
	}
	
	
	
	public LoginPO logoutToSystem(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.USER_ICON);
		clickToElement(driver, BasePageUI.USER_ICON);
		
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
		clickToElement(driver, BasePageUI.LOGOUT_LINK);
		return PageGenerator.getLoginPage(driver);
	}
	
	public void uploadImage(WebDriver driver, String filePath) {
		getWebElement(driver, BasePageUI.UPLOAD_FILE).sendKeys(filePath);
	}
	
	public boolean isSuccessMessageDisplayed(WebDriver driver, String messageValue) {
		waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE, messageValue);
		return isElementDisplayed(driver, BasePageUI.SUCCESS_MESSAGE, messageValue);
	}
	
	public boolean isFieldEnabledByLabel(WebDriver driver, String label) {
		waitForElementVisible(driver, BasePageUI.ANY_FILED_BY_LABEL, label);
		return isElementEnabled(driver, BasePageUI.ANY_FILED_BY_LABEL, label);
	}
	
	public void clickToSaveButtonByFormName(WebDriver driver, String formName) {
		waitForElementClickable(driver, BasePageUI.SAVE_BUTTON_BY_FORM_NAME, formName);
		clickToElement(driver, BasePageUI.SAVE_BUTTON_BY_FORM_NAME, formName);
	}
	
	public void clickToRadioButtonByID(WebDriver driver, String radioButtonID) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_RADIO_BY_ID, radioButtonID);
		clickToElement(driver, UserBasePageUI.DYNAMIC_RADIO_BY_ID, radioButtonID);
	}
	
	public void selectDropdownByName(WebDriver driver, String dropdownName, String itemText) {
		selectDropdownByText(driver, UserBasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemText, dropdownName);
	}
	
	public void openHeaderPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_HEADER, pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_HEADER, pageName);
	}
	
	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
	}
	
	public void enterToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}
	
	public void clickToButtonByText(WebDriver driver,String buttonText) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	private Select select;
}