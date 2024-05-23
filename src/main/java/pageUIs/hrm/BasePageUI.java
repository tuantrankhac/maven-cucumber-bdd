
package pageUIs.hrm;

public class BasePageUI {
	public static final String DYNAMIC_MENU_PAGE = "//nav[@aria-label='Sidepanel']//span[text()='%s']";
	public static final String DYNAMIC_SINGLE_SUBMENU_PAGE = "//nav[@aria-label='Topbar Menu']//a[text()='%s']";
	public static final String DYNAMIC_MULTI_SUBMENU_PAGE = "//nav[@aria-label='Topbar Menu']//span[text()='%s']";
	public static final String DYNAMIC_CHILDSUBMENU_PAGE = "//nav[@aria-label='Topbar Menu']//a[text()='%s'";
	
	public static final String DYNAMIC_TEXTBOX_BY_NAME = "//input[@name='%s']";
	public static final String DYNAMIC_LOGIN_TEXTBOX_BY_NAME = "//input[@name='%s']";
	public static final String DYNAMIC_CREATE_LOGIN_DETAIL_TEXTBOX_BY_TEXT = "//label[text()='%s']/parent::div/following-sibling::div/input";
	
	public static final String DYNAMIC_RADIO_BUTTON_BY_VALUE = "//label[text()='%s']";
	public static final String DYNAMIC_SEARCH_TEXTBOX_BY_NAME = "//label[text()='%s']/parent::div/following-sibling::div//input";
	public static final String DROPDOWN_BY_ID = "//input[@id='%s']";
	
	public static final String LOADING_ICON = "//div[@class='oxd-loading-spinner']";
	public static final String TABLE_HEADER_BY_ID_AND_NAME = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "//table[@id='%s']/tbody/tr[%s]/td[%s]";
	
	public static final String USER_ICON = "//i[contains(@class,'userdropdown-icon')]/parent::span";
	public static final String LOGOUT_LINK = "//a[@class='oxd-userdropdown-link' and text()='Logout']";
	
	public static final String LOGIN_BUTTON = "//form[@class='oxd-form']//button";
	public static final String UPLOAD_FILE = "//input[@type='file']";
	
	public static final String SUCCESS_MESSAGE = "//div[contains(@class,'toast-start')]//p[text()='%s']";
	public static final String ANY_FILED_BY_LABEL = "//label[contains(text(),'%s')]/parent::div/following-sibling::div//input";
	public static final String ANY_DROPDOWN_BY_LABEL = "//label[text()='%s']/parent::div/following-sibling::div/div";
	public static final String SAVE_BUTTON_BY_FORM_NAME = "//h6[text()='%s']/following-sibling::form//button[contains(string(),'Save')]";
	
}
